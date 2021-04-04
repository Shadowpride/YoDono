package uy.yodono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ListaDonantes extends AppCompatActivity {

    List<ListElementListaDonantes> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_donantes);
        init();
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElementListaDonantes("Juan Carlos Perez","B+","Montevideo"));
        elements.add(new ListElementListaDonantes("Maria Rodriguez","O+","Rocha"));
        elements.add(new ListElementListaDonantes("Carlos Ramirez","B+","Canelones"));
        elements.add(new ListElementListaDonantes("Juan Carlos Perez","B+","Montevideo"));
        elements.add(new ListElementListaDonantes("Maria Rodriguez","O+","Rocha"));
        elements.add(new ListElementListaDonantes("Carlos Ramirez","B+","Canelones"));
        elements.add(new ListElementListaDonantes("Juan Carlos Perez","B+","Montevideo"));
        elements.add(new ListElementListaDonantes("Carlos Ramirez","B+","Canelones"));
        elements.add(new ListElementListaDonantes("Juan Carlos Perez","B+","Montevideo"));
        elements.add(new ListElementListaDonantes("Maria Rodriguez","O+","Rocha"));
        elements.add(new ListElementListaDonantes("Carlos Ramirez","B+","Canelones"));
        elements.add(new ListElementListaDonantes("Juan Carlos Perez","B+","Montevideo"));


        ListAdapterDonantes listAdapterDonantes = new ListAdapterDonantes(elements,ListaDonantes.this);
        RecyclerView recyclerView = findViewById(R.id.ListRecyclerViewBuscarDonantes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(ListaDonantes.this, 2));
        recyclerView.setAdapter(listAdapterDonantes);

    }

}