package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroPaso_1 extends AppCompatActivity {

    Button boton_registro_siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paso_1);

        boton_registro_siguiente = (Button)findViewById(R.id.boton_registro_siguiente);

        boton_registro_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroPaso_1.this, RegistroPaso_2.class);
                startActivity(i);
            }
        });
    }
}