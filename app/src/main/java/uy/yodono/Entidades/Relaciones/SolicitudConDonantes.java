package uy.yodono.Entidades.Relaciones;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;

@Entity( primaryKeys = { "id", "cedula" })
public class SolicitudConDonantes {
    @NonNull public Integer id;
    @NonNull public String cedula;

    public SolicitudConDonantes( Integer id, String cedula ) {
        this.id = id;
        this.cedula = cedula;
    }
}
