package uy.yodono.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import uy.yodono.Entidades.Relaciones.SolicitudConDonantes;

@Dao
public interface SolicitudConDonantesDao {

    @Insert( onConflict = OnConflictStrategy.IGNORE )
    void agregar(SolicitudConDonantes donacion );

    @Transaction
    @Query( "SELECT * FROM SolicitudConDonantes")
    List<SolicitudConDonantes> getDonaciones();

    @Transaction
    @Query( "SELECT SCD.id, SCD.cedula FROM SolicitudConDonantes SCD WHERE SCD.id = :id")
    List<SolicitudConDonantes> getDonaciones( Integer id );
}

