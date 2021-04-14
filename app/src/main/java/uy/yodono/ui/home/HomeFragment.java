package uy.yodono.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import uy.yodono.DonantesAdapter;
import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;
import uy.yodono.R;
import uy.yodono.SolicitudesAdapter;
import uy.yodono.YoDonoViewModel;

public class HomeFragment extends Fragment {

    Intent intent;
    SolicitudesAdapter adapter;
    private YoDonoViewModel yoDonoViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.ListRecyclerViewSolicitudes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new SolicitudesAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        intent = getActivity().getIntent();


        yoDonoViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory
                        .getInstance(this.getActivity().getApplication()))
                .get(YoDonoViewModel.class);


        return view;

    }
}