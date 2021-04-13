package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;

public class SolicitudNueva extends AppCompatActivity {

    Button boton_solicitar_aceptar;

    private YoDonoViewModel yoDonoViewModel;

    DatePicker picker_fecha_limite;
    EditText text_hospital;
    EditText text_cantidad_donantes;
    EditText text_motivo;
    HorizontalNumberPicker number_cantidad_donantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_nueva);

        Donantes donante_logueado;

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        donante_logueado = (Donantes) bd.get( "Donante" );

        TextView miGrupoSanguineo = (TextView)findViewById(R.id.text_miGrupoSanguineo);
        miGrupoSanguineo.setText(donante_logueado.getGrupo_Sanguineo());

        number_cantidad_donantes = (HorizontalNumberPicker) findViewById(R.id.number_donantes);

        TextView miDepartamento = (TextView)findViewById(R.id.text_miDepartamento);
        miDepartamento.setText(donante_logueado.getDepartamento());


        yoDonoViewModel = new ViewModelProvider( this,
                ViewModelProvider.AndroidViewModelFactory
                        .getInstance(this.getApplication()))
                .get(YoDonoViewModel.class);


        boton_solicitar_aceptar = (Button)findViewById(R.id.boton_solicitar_aceptar);

        boton_solicitar_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_hospital = (EditText)findViewById(R.id.text_hospital);
                text_motivo = (EditText)findViewById(R.id.text_motivo);

                String hospital = text_hospital.getText().toString();
                Integer cantidad_int = number_cantidad_donantes.getValue();
                String cantidad = cantidad_int.toString();

                String motivo = text_motivo.getText().toString();

                String cedula = donante_logueado.getCedula();
                String nombre = donante_logueado.getNombre();
                String apellido = donante_logueado.getApellido();
                String departamento = donante_logueado.getDepartamento();
                String grupo_sanguineo = donante_logueado.getGrupo_Sanguineo();

                picker_fecha_limite = (DatePicker)findViewById(R.id.fecha_limite);
                Integer mes_i, dia_i, anio_i;
                String mes, dia, anio, fecha;
                mes_i = picker_fecha_limite.getMonth();
                mes = mes_i.toString();
                if ( mes_i < 10 ) { mes = '0' + mes; }
                dia_i = picker_fecha_limite.getDayOfMonth();
                dia = dia_i.toString();
                if ( dia_i < 10 ) { dia = '0' + dia; }
                anio_i = picker_fecha_limite.getYear();
                anio = anio_i.toString();

                fecha = anio + mes + dia;

                if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || fecha.isEmpty() || hospital.isEmpty() || cantidad.isEmpty() || motivo.isEmpty() )
                {
                    Toast.makeText(SolicitudNueva.this, "Debe completar todos los datos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Solicitudes nueva_solicitud = new Solicitudes( cedula, nombre, apellido, grupo_sanguineo, hospital, fecha, motivo, cantidad, departamento );

                    yoDonoViewModel.insert( nueva_solicitud );

                    Intent i = new Intent(SolicitudNueva.this, MainActivity.class);
                    i.putExtra("Donante", donante_logueado);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}