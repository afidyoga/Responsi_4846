package com.example.responsi_4846;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(Contact contact);

    @Query("SELECT * FROM contact")
    List<Contact> getAllContacts();
}
