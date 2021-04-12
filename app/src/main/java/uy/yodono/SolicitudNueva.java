package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;

public class SolicitudNueva extends AppCompatActivity {

    Button boton_solicitar_aceptar;

    private YoDonoViewModel yoDonoViewModel;

    EditText text_fecha_limite;
    EditText text_hospital;
    EditText text_cantidad_donantes;
    EditText text_motivo;

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

                text_fecha_limite = (EditText)findViewById(R.id.text_fecha_limite);
                text_hospital = (EditText)findViewById(R.id.text_hospital);
                text_cantidad_donantes = (EditText)findViewById(R.id.text_donantes);
                text_motivo = (EditText)findViewById(R.id.text_motivo);

                String fecha = text_fecha_limite.getText().toString();
                String hospital = text_hospital.getText().toString();
                String cantidad = text_cantidad_donantes.getText().toString();
                String motivo = text_motivo.getText().toString();

                String cedula = donante_logueado.getCedula();
                String nombre = donante_logueado.getNombre();
                String apellido = donante_logueado.getApellido();
                String departamento = donante_logueado.getDepartamento();
                String grupo_sanguineo = donante_logueado.getGrupo_Sanguineo();

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