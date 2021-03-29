package uy.yodono.BD;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import uy.yodono.Entidades.Converters;
import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;
import uy.yodono.daos.DonanteDao;
import uy.yodono.daos.SolicitudesDao;


@Database(entities = {Donantes.class, Solicitudes.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract DonanteDao donanteDao();
    public abstract SolicitudesDao solicitudesDao();


}
