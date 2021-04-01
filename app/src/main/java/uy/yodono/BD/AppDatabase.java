package uy.yodono.BD;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import uy.yodono.Entidades.Converters;
import uy.yodono.Entidades.Donantes;
import uy.yodono.Entidades.Solicitudes;
import uy.yodono.daos.DonanteDao;
import uy.yodono.daos.SolicitudesDao;


@Database(entities = {Donantes.class, Solicitudes.class}, version = 3)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "YoDono.db";
    private static volatile AppDatabase instance;

    public abstract DonanteDao getDonanteDao();
    public abstract SolicitudesDao getSolicitudesDao();

    // la DB es un singleton
    public static AppDatabase getInstance(Context context ) {
        if ( instance == null ) {
            instance = create( context );
        }
        return instance;
    }

    //private AppDatabase() {};

    private static AppDatabase create( final Context context ) {

        return Room.databaseBuilder( context, AppDatabase.class, DB_NAME ).allowMainThreadQueries().fallbackToDestructiveMigration().build();

    }

}
