package com.example.recyclerviewc.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.recyclerviewc.model.Contact;
import com.example.recyclerviewc.model.repository.FContactRepository;

import java.util.List;

public class FContactViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private LiveData<List<Contact>> mAllFContacts;
    private FContactRepository mRepository;

    public FContactViewModel(@NonNull Application application) {
        super(application);
        mRepository = new FContactRepository(application);
        //favoriteDao = favoriteDB.contactFavoriteDao();
//        mAllFContacts= mRepository.getAllContacs();
    }

    public LiveData<List<Contact>> getmAllFContacts(){
        return mRepository.getAllContacs();
    }
    public void insert(Contact contact){
        mRepository.insert(contact);
    }
}
