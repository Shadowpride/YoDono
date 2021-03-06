package uy.yodono.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import uy.yodono.Entidades.Solicitudes;

//Representa la interface por la cual realizamos las interacciones con la BD
@Dao
public interface SolicitudesDao {

    @Insert
    void Agregar(Solicitudes solicitud);

    @Update
    void Actualizar(Solicitudes solicitud);

    @Query("SELECT * FROM Solicitudes where cedula = :cedula")
    LiveData<List<Solicitudes>> getSolicitudDeDonante(String cedula);

    @Query("SELECT * FROM Solicitudes")
    LiveData<List<Solicitudes>> getAllSolicitudes();

    @Query("SELECT * FROM  Solicitudes WHERE cedula != :cedula")
    LiveData<List<Solicitudes>> getSolicitudesNotLogueado( String cedula );

}
