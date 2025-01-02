package com.example.responsi_4846;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    private EditText edtName, edtPhone;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String phone = edtPhone.getText().toString();

            if (!name.isEmpty() && !phone.isEmpty()) {
                saveContact(name, phone);
            }
        });
    }

    private void saveContact(String name, String phone) {
        Contact contact = new Contact(name, phone);
        new Thread(() -> {
            AppDatabase.getInstance(this).contactDao().insertContact(contact);
            runOnUiThread(() -> {
                Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            });
        }).start();
    }
}
