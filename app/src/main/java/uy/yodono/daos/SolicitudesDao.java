package uy.yodono.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import uy.yodono.Entidades.Solicitudes;

//Representa la interface por la cual realizamos las interacciones con la BD
@Dao
public interface SolicitudesDao {

    @Insert
    void agregar(Solicitudes solicitud);

    @Update
    void actualizar(Solicitudes solicitud);

    @Query("SELECT * FROM Solicitudes where cedula = :cedula")
    Solicitudes buscarSolicitudPorCI(int ci);


}
