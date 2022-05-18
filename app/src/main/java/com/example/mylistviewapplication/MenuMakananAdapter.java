package com.example.mylistviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuMakananAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MenuMakanan> menumakanan = new ArrayList<>();

    public void setMenumakanan(ArrayList<MenuMakanan> menumakanan){
        this.menumakanan = menumakanan;
    }

    public  MenuMakananAdapter (Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return menumakanan.size();
    }

    @Override
    public Object getItem(int i) {
        return menumakanan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if(itemView ==  null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_menumakanan,viewGroup,false);

        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        MenuMakanan mm = (MenuMakanan) getItem(i);
        viewHolder.bind(mm);
        return itemView;
    }
}

class ViewHolder{
    private TextView txtName;
    private TextView txtDescription;
    private CircleImageView imgPhoto;
    ViewHolder(View view){
        txtName = view.findViewById(R.id.txt_name);
        txtDescription = view.findViewById(R.id.txt_deskripsi);
        imgPhoto = view.findViewById(R.id.img_photo);
    }

    void bind(MenuMakanan mm){
        txtName.setText(mm.getName());
        txtDescription.setText(mm.getDescription());
        imgPhoto.setImageResource(mm.getPhoto());

    }

}


