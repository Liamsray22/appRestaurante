package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.apprestaurante.Adapters.FoodAdapter;
import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.admin.admin;
import com.example.apprestaurante.admin.adminMainPage;
import com.example.apprestaurante.databinding.ActivityClientBinding;
import com.example.apprestaurante.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class client extends AppCompatActivity {

    ActivityClientBinding binding;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Utils.TipoUsuario != "client"){
            Intent isAdmin = new Intent(this, adminMainPage.class);
            startActivity(isAdmin);
        }
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();

        ArrayList<FoodModel> FoodList = new ArrayList<>();
//        Cursor c = con.traerTodoOrdenes(db);
//        if(c!=null) {
//            do {
//                FoodList.add(new FoodModel(c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
//            }
//            while (c.moveToNext());
//        }
        FoodList.add(new FoodModel(1,"Comida", "20", "No se comia", R.drawable.ic_launcher_background));
//        FoodList.add(new FoodModel("Food", "20", "No se caslk", R.mipmap.ic_launcher_round));
//        FoodList.add(new FoodModel("Nose", "20", "sdjkfhskdf", R.drawable.ic_launcher_background));
//        FoodList.add(new FoodModel("Algo", "20", "cackokjsdh", R.drawable.ic_launcher_background));
//        FoodList.add(new FoodModel("Pupa", "20", "Con el", R.mipmap.ic_launcher_round));

        FoodAdapter adapter = new FoodAdapter(FoodList, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
}