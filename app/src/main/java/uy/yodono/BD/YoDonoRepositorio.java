package uy.yodono.BD;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import uy.yodono.Entidades.Donantes;
import uy.yodono.daos.DonanteDao;

public class YoDonoRepositorio {

    private uy.yodono.daos.DonanteDao donanteDao;
    private LiveData<List<Donantes>> listaDonantes;

    public YoDonoRepositorio(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        donanteDao = database.getDonanteDao();

        listaDonantes = donanteDao.getAllDonanantes();
    }

    public void insert(Donantes donante) {
        new InsertDonanteAsyncTask(donanteDao).execute(donante);
    }

    public void update(Donantes donante) {
        new UpdateDonanteAsyncTask(donanteDao).execute(donante);
    }

    public Donantes buscarDonante( String cedula ) {
        return donanteDao.buscarDonante( cedula );
    }

    public Donantes buscarDonante( String cedula, String contrasena ) {
        return donanteDao.buscarDonante( cedula );
    }

    public LiveData<List<Donantes>> getListaOtrosDonantes(String cedula) {
        return donanteDao.buscarDonantesNotLogged( cedula );
    }

    public LiveData<List<Donantes>> getAllDonantes() {
        return listaDonantes;
    }

    private static class InsertDonanteAsyncTask extends AsyncTask<Donantes, Void, Void> {
        private DonanteDao donanteDao;

        private InsertDonanteAsyncTask( DonanteDao donanteDao ) {
            this.donanteDao = donanteDao;
        }

        @Override
        protected Void doInBackground(Donantes... donantes) {
            donanteDao.Agregar(donantes[0]);
            return null;
        }
    }

    private static class UpdateDonanteAsyncTask extends AsyncTask<Donantes, Void, Void> {
        private DonanteDao donanteDao;

        private UpdateDonanteAsyncTask( DonanteDao donanteDao ) {
            this.donanteDao = donanteDao;
        }

        @Override
        protected Void doInBackground(Donantes... donantes) {
            donanteDao.Modificar(donantes[0]);
            return null;
        }
    }

}