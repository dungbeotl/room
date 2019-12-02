package com.example.recyclerviewc.model.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.recyclerviewc.R;
import com.example.recyclerviewc.model.Contact;

@Database(entities = Contact.class,version = 1,exportSchema = false)
public abstract class FavoriteRoomDatabase extends RoomDatabase {

    public abstract ContactFavoriteDao contactFavoriteDao();

    private static volatile FavoriteRoomDatabase instance;

    public static FavoriteRoomDatabase getInstance(final Context context){
        if(instance == null){
            synchronized (FavoriteRoomDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            FavoriteRoomDatabase.class,"contacts_database"
                            ).fallbackToDestructiveMigration()
                            .addCallback(sCallback)
                            .build();
                }
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback sCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new FavoriteDbAsyncTask(instance).execute();
        }
    };
    private static class FavoriteDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private ContactFavoriteDao contactFavoriteDao;
        private FavoriteDbAsyncTask(FavoriteRoomDatabase db){
            contactFavoriteDao = db.contactFavoriteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
         //   contactFavoriteDao.insert(new Contact("Dung","123123123", R.drawable.usertwo));
            return null;
        }
    }

}
