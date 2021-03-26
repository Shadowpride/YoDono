package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SolicitudNueva extends AppCompatActivity {

    Button boton_solicitar_aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_nueva);

        boton_solicitar_aceptar = (Button)findViewById(R.id.boton_solicitar_aceptar);

        boton_solicitar_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SolicitudNueva.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}