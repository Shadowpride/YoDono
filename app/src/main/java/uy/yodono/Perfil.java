package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import uy.yodono.Entidades.Donantes;

public class Perfil extends AppCompatActivity {

    Donantes donante_logueado;
    TextView nombre;
    Button boton_perfil_editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        donante_logueado = (Donantes)bd.get("Donante");
        String nombre_donante = donante_logueado.getNombre();

        nombre = (TextView) findViewById(R.id.text_registro_nombre);
        nombre.setText( nombre_donante );

        boton_perfil_editar = (Button)findViewById(R.id.boton_perfil_editar);

        boton_perfil_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Perfil.this, PerfilEditar.class);
                startActivity(i);
            }
        });
    }
}
