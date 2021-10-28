package com.example.tangoroute.persistence;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.tangoroute.utils.LocationConverter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {WonderEntity.class}, version = 1, exportSchema = false)
@TypeConverters({LocationConverter.class})
public abstract class WonderDatabase extends RoomDatabase {

    public static final String DATABASE = WonderEntity.WONDERS + ".db";

    public abstract WonderDAO wonderDAO();

    private static volatile WonderDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static WonderDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WonderDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WonderDatabase.class, DATABASE)
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

     private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    databaseWriteExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            WonderDAO dao = INSTANCE.wonderDAO();
                        }
                    });
                }
            };
}
