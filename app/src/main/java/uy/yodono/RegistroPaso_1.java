package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uy.yodono.BD.AppDatabase;
import uy.yodono.Entidades.Donantes;
import uy.yodono.daos.DonanteDao;

public class RegistroPaso_1 extends AppCompatActivity {

    Button boton_registro_siguiente;
    EditText text_cedula;
    EditText text_contrasena;
    EditText text_contrasena_confirmacion;


    private DonantesViewModel donantesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paso_1);

        donantesViewModel = new ViewModelProvider( this,
                ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication()))
                .get(DonantesViewModel.class);


        boton_registro_siguiente = (Button)findViewById(R.id.boton_registro_siguiente);
        text_cedula = (EditText)findViewById(R.id.text_registro_cedula);
        text_contrasena = (EditText)findViewById(R.id.text_registro_contrasena);
        text_contrasena_confirmacion = (EditText)findViewById(R.id.text_registro_contrasena_confirmacion);


        boton_registro_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cedula = text_cedula.getText().toString();
                String contrasena = text_contrasena.getText().toString();
                String contrasena_confirmacion = text_contrasena_confirmacion.getText().toString();


                if ( !cedula.isEmpty() && !contrasena.isEmpty() && contrasena.equals(contrasena_confirmacion) )
                {
                    Donantes donante = donantesViewModel.buscarDonante( cedula );
                    if ( donante != null )
                    {
                        Toast.makeText(RegistroPaso_1.this, "Usuario ya registrado.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Intent i = new Intent(RegistroPaso_1.this, RegistroPaso_2.class);
                        i.putExtra("Cedula", cedula);
                        i.putExtra("Contrasena", contrasena);
                        startActivity(i);
                        finish();
                    }
                }
                else
                {
                    Toast.makeText( RegistroPaso_1.this, "Datos incorrectos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}