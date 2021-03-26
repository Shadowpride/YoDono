package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PerfilEditar extends AppCompatActivity {

    Button boton_perfil_aplicar;
    Button boton_perfil_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_editar);

        boton_perfil_aplicar = (Button)findViewById(R.id.boton_perfil_aplicar);

        boton_perfil_aplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilEditar.this, Perfil.class);
                startActivity(i);
            }
        });
        boton_perfil_cancelar = (Button)findViewById(R.id.boton_perfil_cancelar);

        boton_perfil_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilEditar.this, Perfil.class);
                startActivity(i);
            }
        });
    }
}