package com.example.recyclerviewc.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recyclerviewc.model.Contact;

import java.util.List;

@Dao
public interface ContactFavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contact contact);

    @Query("SELECT * FROM contacts")
    LiveData<List<Contact>> getAllContacts();

    @Query("SELECT * FROM contacts WHERE id_contacts=:contactId")
    LiveData<Contact> getContact(String contactId);

    @Update
    void update(Contact contact);

    @Delete
    void delete(Contact contact);

}
