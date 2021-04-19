package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.apprestaurante.ActivityRegistro;
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
import com.example.apprestaurante.databinding.ActivityRegistroBinding;

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
        Cursor c = con.traerTodoOrdenes(db);
        if(c!=null) {
            do {
                FoodList.add(new FoodModel(c.getInt(0),c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
            }
            while (c.moveToNext());
        }
        FoodAdapter adapter = new FoodAdapter(FoodList, this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent logout = new Intent(getApplicationContext(), ActivityRegistro.class);
                startActivity(logout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}