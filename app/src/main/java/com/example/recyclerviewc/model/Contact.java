package com.example.recyclerviewc.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id_contacts")
    private int id;

    @ColumnInfo(name = "name_contacts")
    private String name;

    @ColumnInfo(name = "phone_contacts")
    private String phone;

    @ColumnInfo(name = "image_contacts")
    private int image;

    public Contact() {
    }

    @Ignore
    public Contact(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
