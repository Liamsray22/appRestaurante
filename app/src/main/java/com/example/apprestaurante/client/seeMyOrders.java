package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.apprestaurante.Adapters.OrderAdapter;
import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Dialogs;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.admin.adminMainPage;
import com.example.apprestaurante.databinding.ActivitySeeMyOrdersBinding;

import java.util.ArrayList;

public class seeMyOrders extends AppCompatActivity {

    ActivitySeeMyOrdersBinding binding;
    SQLiteDatabase db;
    Dialogs dialogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeeMyOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialogs = new Dialogs(this);

        if(Utils.getInstance().getTipoUsuario() != "client"){
            Intent isAdmin = new Intent(this, adminMainPage.class);
            startActivity(isAdmin);
        }
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();
        ArrayList<OrderModel> OrderList = new ArrayList<>();
        Cursor c = con.traerMisComidas(db);
        if(c!=null) {
            do {
                OrderList.add(new OrderModel(c.getString(1), c.getString(2), c.getString(3), c.getInt(4), c.getInt(5)));
            }
            while (c.moveToNext());
        }
        OrderAdapter adapter = new OrderAdapter(OrderList, this);
        binding.myOrdersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.myOrdersRecyclerView.setLayoutManager(layoutManager);
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
                dialogs.dialogBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}