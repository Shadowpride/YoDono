package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import uy.yodono.Entidades.Donantes;

public class ListaDonantes extends AppCompatActivity {

    Intent intent;
    Donantes donante_logueado;

    private DonantesViewModel donantesViewModel;

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

        donantesViewModel.getListaOtrosDonantes( donante_logueado.getCedula() ).observe(this, new Observer<List<Donantes>>() {
            @Override
            public void onChanged(List<Donantes> donantes) {
                adapter.setLista_donantes(donantes);
            }
        });
    }
}