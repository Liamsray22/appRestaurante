package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.apprestaurante.Adapters.FoodAdapter;
import com.example.apprestaurante.Adapters.OrderAdapter;
import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.databinding.ActivityAdminBinding;
import com.example.apprestaurante.databinding.ActivityClientBinding;

import java.util.ArrayList;

public class admin extends AppCompatActivity {

    ActivityAdminBinding binding;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();
        ArrayList<OrderModel> OrderList = new ArrayList<>();
        Cursor c = con.traerTodo(db);
        if(c!=null) {
            do {
                OrderList.add(new OrderModel(c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
            }
            while (c.moveToNext());
        }
        OrderAdapter adapter = new OrderAdapter(OrderList, this);
        binding.adminRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.adminRecyclerView.setLayoutManager(layoutManager);
    }
}