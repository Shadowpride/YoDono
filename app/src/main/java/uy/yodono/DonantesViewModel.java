package uy.yodono;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import uy.yodono.BD.YoDonoRepositorio;
import uy.yodono.Entidades.Donantes;

public class DonantesViewModel extends AndroidViewModel {

    private YoDonoRepositorio repositorio;
    private LiveData<List<Donantes>> lista_donantes;

    public DonantesViewModel(@NonNull Application application) {
        super(application);
        repositorio = new YoDonoRepositorio(application);
        lista_donantes = repositorio.getAllDonantes();
    }

    public void insert( Donantes donante ) {
        repositorio.insert(donante);
    }

    public void update( Donantes donante ) {
        repositorio.insert(donante);
    }

    public LiveData<List<Donantes>> getLista_donantes() {
        return lista_donantes;
    }
}
