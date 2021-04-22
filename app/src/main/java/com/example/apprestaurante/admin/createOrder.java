package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Dialogs;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.ClientMainPage;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityCreateOrderBinding;
import com.example.apprestaurante.databinding.ActivitySaleBinding;

public class createOrder extends AppCompatActivity {

    ActivityCreateOrderBinding binding;
    SQLiteDatabase db;
    String name, price, desc;
    Dialogs dialogs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialogs = new Dialogs(this);

        if(Utils.getInstance().getTipoUsuario() != "admin"){
            Intent isClient = new Intent(this, ClientMainPage.class);
            startActivity(isClient);
        }

        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();

        binding.placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.nameEdt.getText().toString();
                price = binding.priceEdt.getText().toString();
                desc = binding.descEdt.getText().toString();
                try {
                    int random = (int)(Math.random()*9);
                    int[] imgs = {R.mipmap.comida1, R.mipmap.comida2, R.mipmap.comida3,
                            R.mipmap.comida4, R.mipmap.comida5, R.mipmap.comida6,
                            R.mipmap.comida7, R.mipmap.comida8, R.mipmap.comida9,
                            R.mipmap.comida10};
                    con.CrearOrden(db, name, price, desc, imgs[random]);
                    Intent client = new Intent(getApplicationContext(), com.example.apprestaurante.client.client.class);
                    startActivity(client);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
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