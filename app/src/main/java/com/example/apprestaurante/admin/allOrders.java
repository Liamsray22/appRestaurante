package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.apprestaurante.Adapters.AllOrdersAdapter;
import com.example.apprestaurante.Adapters.OrderAdapter;
import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityAdminBinding;
import com.example.apprestaurante.databinding.ActivityAllOrdersBinding;

import java.util.ArrayList;

public class allOrders extends AppCompatActivity {

    ActivityAllOrdersBinding binding;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Utils.TipoUsuario != "admin"){
            Intent isClient = new Intent(this, client.class);
            startActivity(isClient);
        }
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();
        ArrayList<FoodModel> FoodList = new ArrayList<>();
        Cursor c = con.traerTodoOrdenes(db);
        if(c!=null) {
            do {
                FoodList.add(new FoodModel(c.getInt(0),c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
            }
            while (c.moveToNext());
        }
        AllOrdersAdapter adapter = new AllOrdersAdapter(FoodList, this);
        binding.allOrdersRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.allOrdersRecycler.setLayoutManager(layoutManager);    }
}