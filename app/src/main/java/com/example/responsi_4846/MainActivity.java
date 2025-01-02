package com.example.responsi_4846;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ContactAdapter(new ArrayList<>(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddContactActivity.class));
        });

        loadContacts();
    }

    private void loadContacts() {
        new Thread(() -> {
            List<Contact> contacts = db.contactDao().getAllContacts();
            runOnUiThread(() -> adapter.updateData(contacts));
        }).start();
    }
}
