package com.example.agileapes;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * This class contains the database holder which serves as the main access point for the underlying connection to the app's persisted, relational data
 */

@Database(entities = {Qanda.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = AppDatabase.class.getName();

    private static AppDatabase INSTANCE;

    public abstract QandaDao qandaDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")
                           /*
                           We were unable to implement background threads due to time constraints so we were required
                           to use the allowMainThreadQueries method.
                            */
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}

/* Title: AppDatabase source code
   Author: Ajay Saini
   Availability: https://github.com/ajaysaini-sgvu/room-persistence-sample/blob/master/app/src/main/java/com/nagarro/persistence/database/AppDatabase.java */