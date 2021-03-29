package uy.yodono.Entidades;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;
//Creamos la clase Pedidos que va a representar la relacion entre Donantes y Solicitudes
public class Pedidos {


    //Realizamos una relacion de 1 a N entre Donantes y solicitudes
    @Embedded public Donantes donante;
    @Relation(
            parentColumn = "ci",
            entityColumn = "Ci_Don"
    )
    //Creamos una lista de Donantes
    public List<Donantes> Participantes;

}
