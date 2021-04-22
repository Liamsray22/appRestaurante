package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.apprestaurante.Adapters.AllOrdersAdapter;
import com.example.apprestaurante.Adapters.OrderAdapter;
import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Dialogs;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.ClientMainPage;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityAdminBinding;
import com.example.apprestaurante.databinding.ActivityAllOrdersBinding;

import java.sql.Blob;
import java.util.ArrayList;

public class allOrders extends AppCompatActivity {

    ActivityAllOrdersBinding binding;
    SQLiteDatabase db;
    Dialogs dialogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialogs = new Dialogs(this);

        if(Utils.getInstance().getTipoUsuario() != "admin"){
            Intent isClient = new Intent(this, ClientMainPage.class);
            startActivity(isClient);
        }
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();
        ArrayList<FoodModel> FoodList = new ArrayList<>();
        Cursor c = con.traerTodoOrdenes(db);
        if(c!=null) {
            do {
                byte [] imgBytes = c.getBlob(4);
                if(imgBytes != null) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
                    FoodList.add(new FoodModel(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), bitmap));
                }
                }
            while (c.moveToNext());
        }
        AllOrdersAdapter adapter = new AllOrdersAdapter(FoodList, this);
        binding.allOrdersRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.allOrdersRecycler.setLayoutManager(layoutManager);    }
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
                dialogs.dialogBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}