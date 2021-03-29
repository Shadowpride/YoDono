package uy.yodono.daos;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import uy.yodono.Entidades.Donantes;

//Representa la interface por la cual realizamos las interacciones con la BD
@Dao
public interface DonanteDao {

    @Insert
    void agregar(Donantes donante);

    @Update
    void Modificar(Donantes donante);

    @Query("SELECT * FROM Donantes WHERE ci = :ci")
    Donantes buscarDon(String ci);

}
