package uy.yodono;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;
import uy.yodono.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private AppBarConfiguration mAppBarConfiguration;

    Donantes donante_logueado;
    TextView bienvenida;

    private YoDonoViewModel yoDonoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, SolicitudNueva.class);
               i.putExtra( "Donante", donante_logueado );
               startActivity(i);
            }
        });


        if ( savedInstanceState == null )
        {
            //getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,
            navigationView.setCheckedItem(R.id.nav_solicitud);
        }


        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        donante_logueado = (Donantes)bd.get("Donante");
        String nombre_donante = donante_logueado.getNombre();

        // obtengo el view correspondiente a nav_header_main.xml
        View headerLayout = navigationView.getHeaderView(0);

        // seteo nombre de donante en menú
        bienvenida = (TextView) headerLayout.findViewById(R.id.textView);
        bienvenida.setText( bienvenida.getText() + " " + nombre_donante );


        yoDonoViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory
                        .getInstance(this.getApplication()))
                .get(YoDonoViewModel.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;

        switch ( item.getItemId() )
        {
            case R.id.nav_solicitud:
                i = new Intent(MainActivity.this, SolicitudNueva.class);
                i.putExtra( "Donante", donante_logueado);
                startActivity(i);
                break;

            case R.id.nav_perfil:
                i = new Intent(MainActivity.this, Perfil.class);
                startActivity(i);
                break;

            case R.id.nav_buscar_donante:
                i = new Intent(MainActivity.this, ListaDonantes.class);
                i.putExtra( "Donante", donante_logueado );
                startActivity(i);
                break;
            case R.id.nav_centros:
                getSupportFragmentManager().beginTransaction().replace(R.id.ContentMain,new MapaCentros()).commit();
                break;
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.ContentMain,new HomeFragment()).commit();
                break;
            case R.id.nav_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.ContentMain,new Info()).commit();
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if ( drawer.isDrawerOpen(GravityCompat.START ))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}