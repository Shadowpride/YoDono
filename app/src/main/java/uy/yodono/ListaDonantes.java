package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import uy.yodono.Entidades.Donantes;

public class ListaDonantes extends AppCompatActivity {

    Intent intent;
    Donantes donante_logueado;

    private Spinner spinner_departamentos, spinner_grupos_sanguineos;
    DonantesAdapter adapter;

    private YoDonoViewModel yoDonoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_donantes);


        spinner_departamentos = (Spinner) findViewById(R.id.spinner_departamentos);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_departamentos = ArrayAdapter.createFromResource(this,
                R.array.array_departamentos, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_departamentos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_departamentos.setAdapter(adapter_departamentos);

        spinner_grupos_sanguineos = (Spinner) findViewById(R.id.spinner_grupo_sanguineos);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_grupos_sanguineos = ArrayAdapter.createFromResource(this,
                R.array.array_grupos_sanguineos, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_grupos_sanguineos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_grupos_sanguineos.setAdapter(adapter_grupos_sanguineos);

        spinner_departamentos.setOnItemSelectedListener(new MyOnItemSelectedListener());
        spinner_grupos_sanguineos.setOnItemSelectedListener(new MyOnItemSelectedListener());


        intent = getIntent();
        Bundle bd = intent.getExtras();
        donante_logueado = (Donantes) bd.get("Donante");

        RecyclerView recyclerView = findViewById(R.id.ListRecyclerViewBuscarDonantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new DonantesAdapter();
        recyclerView.setAdapter(adapter);

        yoDonoViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory
                        .getInstance(this.getApplication()))
                .get(YoDonoViewModel.class);

        actualizar_lista_donantes();
    }

    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            actualizar_lista_donantes();
        }
    }

    public void actualizar_lista_donantes() {

        yoDonoViewModel.getDonantesPorFiltros( spinner_departamentos.getSelectedItem().toString(), spinner_grupos_sanguineos.getSelectedItem().toString(), donante_logueado.getCedula() ).observe(this, new Observer<List<Donantes>>() {
            @Override
            public void onChanged(List<Donantes> donantes) {
                adapter.setLista_donantes(donantes);
            }
        });
    }
}