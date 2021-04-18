package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Relaciones.SolicitudConDonantes;
import uy.yodono.Entidades.Solicitudes;

public class SolicitudIndividual extends AppCompatActivity {

    private TextView text_id;
    private TextView text_fecha;
    private TextView text_departamento;
    private TextView text_grupo;
    private TextView text_donantes_requeridos;
    private TextView text_hospital;
    private TextView text_motivo;
    private Button boton_participar;
    private Solicitudes solicitud;
    private Donantes donante_logueado;
    private YoDonoViewModel yoDonoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_individual);

        yoDonoViewModel = new ViewModelProvider( this,
                ViewModelProvider.AndroidViewModelFactory
                        .getInstance(this.getApplication()))
                .get(YoDonoViewModel.class);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        solicitud =  (Solicitudes) bundle.get("Solicitud");
        donante_logueado = (Donantes) bundle.get("Donante");

        text_id = (TextView)findViewById(R.id.SolicitudIndividualID);
        text_id.setText( "# " + solicitud.getId() );

        text_fecha = (TextView)findViewById(R.id.SolicitudIndividualFechaLim);
        text_fecha.setText( solicitud.getFecha_limite());

        text_departamento = (TextView)findViewById(R.id.SolicitudIndividualDepartamento);
        text_departamento.setText( solicitud.getDepartamento());

        text_grupo = (TextView)findViewById(R.id.SolicitudIndividualGrupo);
        text_grupo.setText( solicitud.getGrupo_sanguineo());

        text_donantes_requeridos = (TextView)findViewById(R.id.SolicitudIndividualDonantesReq);
        text_donantes_requeridos.setText( solicitud.getCantidad_donantes());

        text_hospital = (TextView)findViewById(R.id.SolicitudIndividualHospital);
        text_hospital.setText( solicitud.getHospital());

        boton_participar = (Button)findViewById(R.id.BotonParticiparSolicitud);

        if ( ! puedeParticipar( solicitud.getId() ) )
        {
            deshabilitarBotonParticipar();
        }

        boton_participar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yoDonoViewModel.agregarDonacion(
                        new SolicitudConDonantes(
                                solicitud.getId(),
                                donante_logueado.getCedula()));

                deshabilitarBotonParticipar();
        }});
    }

    private void deshabilitarBotonParticipar() {
        boton_participar.setEnabled( false );
        boton_participar.setText( "Ya participa" );
        boton_participar.setBackgroundColor(Color.LTGRAY );
    }

    private Boolean puedeParticipar( Integer id ) {

        List<SolicitudConDonantes> solicitudConDonantes = yoDonoViewModel.getDonaciones( id );

        Integer cantidad_donantes_necesarios = Integer.parseInt( solicitud.getCantidad_donantes() );
        String cedula_donante = donante_logueado.getCedula();

        Integer contador = 0;
        Boolean ya_participa = false;

        for ( SolicitudConDonantes donacion : solicitudConDonantes )
        {
            Log.v("DONACION", donacion.id + " -- " + donacion.cedula );
            contador += 1;
            if ( donacion.cedula.compareTo( cedula_donante ) == 0 )
            {
                Log.v( "DONACION", "Siii");
                ya_participa = true;
            }
        }
        if ( ya_participa )
        {
            return false;
        }
        else if ( contador < cantidad_donantes_necesarios )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}