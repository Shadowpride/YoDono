package uy.yodono.Entidades.Relaciones;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;

public class SolicitudesDonantesCrossRef {

    @Embedded public Solicitudes solicitud;
    @Relation(
            parentColumn = "id",
            entity = Donantes.class,
            entityColumn = "cedula",
            associateBy = @Junction( SolicitudConDonantes.class)
    )
    public List<Solicitudes> solicitudesList;
}
