package uy.yodono;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import uy.yodono.BD.YoDonoRepositorio;
import uy.yodono.Entidades.DonanteConSolicitudes;
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

    public Donantes buscarDonante( String cedula ) {
        return repositorio.buscarDonante( cedula );
    }

    public Donantes buscarDonante( String cedula, String contrasena ) {
        return repositorio.buscarDonante( cedula );
    }

    public LiveData<List<Donantes>> getListaOtrosDonantes( String cedula ) {
        return repositorio.getListaOtrosDonantes( cedula );
    }

    public LiveData<List<DonanteConSolicitudes>> getSolicitudesDonante(String cedula ) {
        return repositorio.getSolicitudesDonante( cedula );
    }

    public LiveData<List<Donantes>> getLista_donantes() {
        return lista_donantes;
    }
}
