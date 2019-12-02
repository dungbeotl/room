package com.example.recyclerviewc.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.recyclerviewc.model.Contact;
import com.example.recyclerviewc.model.dao.ContactFavoriteDao;
import com.example.recyclerviewc.model.dao.FavoriteRoomDatabase;

import java.util.List;

public class FContactRepository {
    private ContactFavoriteDao contactFavoriteDao;
    private LiveData<List<Contact>> mAllContacts;

    public FContactRepository(Application application){
        FavoriteRoomDatabase db = FavoriteRoomDatabase.getInstance(application);
        contactFavoriteDao =db.contactFavoriteDao();
//        mAllContacts = contactFavoriteDao.getAllContacts();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
   public LiveData<List<Contact>> getAllContacs() {
        return contactFavoriteDao.getAllContacts();
    }
    public void insert (Contact contact) {
        new insertAsyncTask(contactFavoriteDao).execute(contact);
    }
    private static class insertAsyncTask extends AsyncTask<Contact, Void, Void> {

        private ContactFavoriteDao mAsyncTaskDao;

        insertAsyncTask(ContactFavoriteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contact... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
