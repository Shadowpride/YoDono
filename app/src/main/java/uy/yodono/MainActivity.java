package uy.yodono;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import uy.yodono.BD.AppDatabase;
import uy.yodono.Entidades.Donantes;
import uy.yodono.daos.DonanteDao;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private AppBarConfiguration mAppBarConfiguration;

    Donantes donante_logueado;
    Button cerrar_sesion;
    TextView bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //    public void onClick(View view) {
        //       Intent i = new Intent(MainActivity.this, SolicitudNueva.class);
        //       startActivity(i);
        //    }
        //});


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

        //// Passing each menu ID as a set of Ids because each
        //// menu should be considered as top level destinations.
        //mAppBarConfiguration = new AppBarConfiguration.Builder(
        //        R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
        //        .setDrawerLayout(drawer)
        //        .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);

        //cerrar_sesion = (Button)findViewById(R.id.boton_cerrar_sesion);

        //cerrar_sesion.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent i = new Intent(MainActivity.this, Welcome.class);
        //        startActivity(i);
        //        finish();
        //    }
        //});
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
                startActivity(i);
                break;

            case R.id.nav_buscar_donante:
                i = new Intent(MainActivity.this, ListaDonantes.class);
                startActivity(i);
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