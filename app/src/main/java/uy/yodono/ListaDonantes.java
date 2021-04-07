package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uy.yodono.BD.AppDatabase;
import uy.yodono.Entidades.Donantes;
import uy.yodono.daos.DonanteDao;

public class ListaDonantes extends AppCompatActivity {

    Intent intent;
    Donantes donante_logueado;

    private DonantesViewModel donantesViewModel;

    List<ListElementListaDonantes> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_donantes);

        intent = getIntent();
        Bundle bd = intent.getExtras();
        donante_logueado = (Donantes) bd.get("Donante");

        RecyclerView recyclerView = findViewById(R.id.ListRecyclerViewBuscarDonantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        DonantesAdapter adapter = new DonantesAdapter();
        recyclerView.setAdapter(adapter);

        donantesViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory
                        .getInstance(this.getApplication()))
                .get(DonantesViewModel.class);

        donantesViewModel.getListaOtrosDonantes( donante_logueado.getCi() ).observe(this, new Observer<List<Donantes>>() {
            @Override
            public void onChanged(List<Donantes> donantes) {
                adapter.setLista_donantes(donantes);
            }
        });
    }
}