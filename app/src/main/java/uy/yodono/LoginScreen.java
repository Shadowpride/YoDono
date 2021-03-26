package uy.yodono;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class LoginScreen extends AppCompatActivity {

    Button boton_iniciar_sesion;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        boton_iniciar_sesion = (Button)findViewById(R.id.boton_inicio_sesion);
        //EditText cedula = (EditText) findViewById(R.id.text_login_cedula);
        //EditText contrasena = (EditText) findViewById(R.id.text_login_contrasena);

        boton_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Credenciales", cedula.getText().toString());
                //Log.d("Credenciales", contrasena.getText().toString());
                Intent i = new Intent(LoginScreen.this, MainActivity.class);
                startActivity(i);
            }
        });
    };
}
