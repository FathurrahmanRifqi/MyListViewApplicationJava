package com.example.mylistviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuMakananActivity extends AppCompatActivity {
    TextView tName,tDeskripsi;
    ImageView image;
    int posisi;
    int defaultValue = 0;
    private String[] dataMenuMakanan;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<MenuMakanan> menumakanan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makanan);

        tName = findViewById(R.id.textName);
        image = findViewById(R.id.gambar);
        tDeskripsi = findViewById(R.id.textDeskripsi);

        Intent intent = getIntent();
        posisi = intent.getIntExtra("POSISI",defaultValue);
        dataMenuMakanan = getResources().getStringArray(R.array.data_makanan);
        dataDescription = getResources().getStringArray(R.array.data_deskripsi_makanan);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        tName.setText(dataMenuMakanan[posisi]);
        tDeskripsi.setText(dataDescription[posisi]);
        tDeskripsi.setMovementMethod(new ScrollingMovementMethod());
        image.setImageResource(dataPhoto.getResourceId(posisi, -1));
    }
}