package com.example.mylistviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    private String[] dataMenu = {"Nasi Goreng","Sate Ayam","Soto Ayam","Sate Kambing","Mie Ayam","Bakso"};
    private MenuMakananAdapter adapter;
    private String[] dataMenuMakanan;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<MenuMakanan> menumakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.latihanList);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,dataMenu);
        adapter = new MenuMakananAdapter(this);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        // intent listview item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MenuMakananActivity.class);
                intent.putExtra("POSISI", position);
                startActivity(intent);
            }
        });

    }



    private void prepare(){
        dataMenuMakanan = getResources().getStringArray(R.array.data_makanan);
        dataDescription = getResources().getStringArray(R.array.data_deskripsi_makanan);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        menumakanan = new ArrayList<>();

        for(int i = 0; i < dataMenuMakanan.length;i++){
            MenuMakanan mmakanan = new MenuMakanan();
            mmakanan.setPhoto(dataPhoto.getResourceId(i,-1));
            mmakanan.setName(dataMenuMakanan[i]);
            mmakanan.setDescription(dataDescription[i]);
            menumakanan.add(mmakanan);
        }
        adapter.setMenumakanan(menumakanan);
    }



}