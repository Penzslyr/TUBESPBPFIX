package com.example.tubespbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class InputActivity extends AppCompatActivity {
    private EditText nama, nik, alamat, nomor;
    private MaterialButton btnSubmit;
    private UserPref userPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userPreferences = new UserPref(InputActivity.this);
        setContentView(R.layout.activity_input);
        nama =findViewById(R.id.nama);
        nik = findViewById(R.id.nik);
        alamat = findViewById(R.id.alamat);
        nomor = findViewById(R.id.nomor);
        btnSubmit = findViewById(R.id.btnSubmit);
        checkFilled();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    userPreferences.setData(nama.getText().toString().trim(), nik.getText().toString().trim(), alamat.getText().toString().trim(), nomor.getText().toString().trim());
                    checkFilled();
                }
            }
        });
    }
    private boolean validateForm(){
        if(nama.getText().toString().trim().isEmpty() || nik.getText().toString().trim().isEmpty() || alamat.getText().toString().trim().isEmpty() || nomor.getText().toString().trim().isEmpty()){
            Toast.makeText(InputActivity.this, "Harap isi semua field",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void checkFilled(){
//        akan cek login terlebih dahulu dari shared preferences
        if(userPreferences.checkFilled()){
            startActivity(new Intent(InputActivity.this, MainActivity.class));
            finish();
        }
    }
}