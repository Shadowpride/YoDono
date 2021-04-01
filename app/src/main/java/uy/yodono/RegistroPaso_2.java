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
import uy.yodono.daos.DonanteDao;

public class RegistroPaso_2 extends AppCompatActivity {

    // variables DB
    DonanteDao db;
    AppDatabase dataBase;
    EditText text_nombre;
    EditText text_apellido;
    EditText text_email;
    EditText text_telefono;

    Button boton_registro_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paso_2);

        boton_registro_enviar = (Button)findViewById(R.id.boton_registro_enviar);

        // obtengo instancia de DB
        dataBase = AppDatabase.getInstance( RegistroPaso_2.this );
        db = dataBase.getDonanteDao();

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




        boton_registro_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                Bundle bd = intent.getExtras();
                if(bd == null)
                {
                    Toast.makeText(RegistroPaso_2.this, "Debe completar todos los datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    String cedula = (String) bd.get("Cedula");
                    String contrasena = (String) bd.get("Contrasena");
                    Log.v("login",cedula);
                    Log.v("login",contrasena);

                    text_nombre = (EditText)findViewById(R.id.text_registro_nombre);
                    text_apellido = (EditText)findViewById(R.id.text_registro_apellido);
                    text_email = (EditText)findViewById(R.id.text_registro_email);
                    text_telefono = (EditText)findViewById(R.id.text_registro_telefono);

                    String nombre = text_nombre.getText().toString();
                    String apellido = text_apellido.getText().toString();
                    String email = text_email.getText().toString();
                    String telefono = text_telefono.getText().toString();
                    String departamento = spinner_departamentos.getSelectedItem().toString();
                    String grupo_sanguineo = spinner_grupos_sanguineos.getSelectedItem().toString();


                    if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty() )
                    {
                        Toast.makeText(RegistroPaso_2.this, "Debe completar todos los datos", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Donantes don_registrar = new Donantes(cedula, contrasena, email, nombre, apellido, telefono, departamento, grupo_sanguineo);

                        db.Agregar(don_registrar);
                        Log.v("login", "exito");
                        Intent i = new Intent(RegistroPaso_2.this, MainActivity.class);
                        i.putExtra("Donante", don_registrar);
                        startActivity(i);
                        finish();
                    }
                }


            }
        });
    }


}