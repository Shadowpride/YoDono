package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import uy.yodono.BD.AppDatabase;
import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;
import uy.yodono.daos.DonanteDao;
import uy.yodono.daos.SolicitudesDao;

public class SolicitudNueva extends AppCompatActivity {

    Button boton_solicitar_aceptar;

    SolicitudesDao db;
    AppDatabase dataBase;

    EditText text_ci;
    EditText text_nombre;
    EditText text_apellido;
    EditText text_email;
    EditText text_edad;
    EditText text_fecha_limite;
    EditText text_hospital;
    EditText text_cantidad_donantes;
    EditText text_motivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_nueva);

        Spinner spinner_departamentos = (Spinner) findViewById(R.id.spinner_departamentos);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_departamentos = ArrayAdapter.createFromResource(this,
                R.array.array_departamentos, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_departamentos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_departamentos.setAdapter(adapter_departamentos);

        Spinner spinner_grupos_sanguineos = (Spinner) findViewById(R.id.spinner_grupo_sanguineos);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_grupos_sanguineos = ArrayAdapter.createFromResource(this,
                R.array.array_grupos_sanguineos, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_grupos_sanguineos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_grupos_sanguineos.setAdapter(adapter_grupos_sanguineos);


        dataBase = AppDatabase.getInstance( SolicitudNueva.this );
        db = dataBase.getSolicitudesDao();

        boton_solicitar_aceptar = (Button)findViewById(R.id.boton_solicitar_aceptar);

        boton_solicitar_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_ci = (EditText)findViewById(R.id.text_registro_cedula);
                text_nombre = (EditText)findViewById(R.id.text_registro_nombre);
                text_apellido = (EditText)findViewById(R.id.text_registro_apellido);
                text_email = (EditText)findViewById(R.id.text_registro_email);
                text_edad = (EditText)findViewById(R.id.text_edad);
                text_fecha_limite = (EditText)findViewById(R.id.text_fecha_limite);
                text_hospital = (EditText)findViewById(R.id.text_hospital);
                text_cantidad_donantes = (EditText)findViewById(R.id.text_donantes);
                text_motivo = (EditText)findViewById(R.id.text_motivo);

                String cedula = text_ci.getText().toString();
                String nombre = text_nombre.getText().toString();
                String apellido = text_apellido.getText().toString();
                String email = text_email.getText().toString();
                String edad = text_edad.getText().toString();
                String fecha = text_fecha_limite.getText().toString();
                String hospital = text_hospital.getText().toString();
                String cantidad = text_cantidad_donantes.getText().toString();
                String motivo = text_motivo.getText().toString();
                String departamento = spinner_departamentos.getSelectedItem().toString();
                String grupo_sanguineo = spinner_grupos_sanguineos.getSelectedItem().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || cedula.isEmpty() || edad.isEmpty() || fecha.isEmpty() || hospital.isEmpty() || cantidad.isEmpty() || motivo.isEmpty() )
                {
                    Toast.makeText(SolicitudNueva.this, "Debe completar todos los datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    Solicitudes sol_registrar = new Solicitudes(cedula, email, nombre, apellido, edad, departamento, grupo_sanguineo, fecha, hospital ,cantidad, motivo);
                    db.agregar(sol_registrar);
                    Intent i = new Intent(SolicitudNueva.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }
}