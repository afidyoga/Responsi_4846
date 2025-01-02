package com.example.responsi_4846;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact")  // Menandai kelas ini sebagai entitas dalam Room
public class Contact {

    @PrimaryKey(autoGenerate = true) // Menandakan id sebagai primary key yang otomatis di-generate
    private int id;

    private String name;
    private String phone;

    // Constructor
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getter dan Setter
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
}
