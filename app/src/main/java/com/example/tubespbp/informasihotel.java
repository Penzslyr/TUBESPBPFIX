package com.example.tubespbp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class informasihotel extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;
    private TextView textView3;

    private DataPengguna dataPengguna;
    private DataHotel dataHotel;
    private UserPref userPref;
    private TextView nama;
    private TextView nik;
    private TextView alamat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informasihotel);
        userPref = new UserPref(this);
        nama = findViewById(R.id.nama);
        nik = findViewById(R.id.nik);
        alamat = findViewById(R.id.alamat);
        textView = findViewById(R.id.namahotel);
        textView2 = findViewById(R.id.nokamar);
        textView3 = findViewById(R.id.total);
        dataPengguna = userPref.getUserData();

        nama.setText(dataPengguna.getNama());
        nik.setText(dataPengguna.getNIK());
        alamat.setText(dataPengguna.getAlamat());
        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("nama") && getIntent().hasExtra("nokamar") && getIntent().hasExtra("total")){
            String namahotel = getIntent().getStringExtra("nama");
            String nokamar = getIntent().getStringExtra("nokamar");
            String total = getIntent().getStringExtra("total");
            setDataActivity(namahotel,nokamar,total);
        }
    }

    private void setDataActivity(String namahotel, String nokamar, String total){

        textView.setText(namahotel);
        textView2.setText(nokamar);
        textView3.setText(total);
    }
}
