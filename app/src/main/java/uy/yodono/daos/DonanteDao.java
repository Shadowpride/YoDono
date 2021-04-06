package uy.yodono.daos;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import uy.yodono.Entidades.Donantes;

//Representa la interface por la cual realizamos las interacciones con la BD
@Dao
public interface DonanteDao {

    @Insert
    void Agregar(Donantes donante);

    @Update
    void Modificar(Donantes donante);

    @Query("SELECT * FROM Donantes WHERE ci = :ci")
    Donantes buscarDonante(String ci);

    @Query("SELECT * FROM Donantes WHERE ci != :ci")
    LiveData<List<Donantes>> buscarDonantesNotLogged(String ci);

    @Query("SELECT * FROM Donantes")
    LiveData<List<Donantes>> getAllDonanantes();

    @Query("SELECT * FROM Donantes WHERE ci = :ci and passwd = :passwd")
    Donantes getDonante( String ci, String passwd );

}
