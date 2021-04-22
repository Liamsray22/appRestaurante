package com.example.apprestaurante.client;

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
import com.example.apprestaurante.admin.admin;
import com.example.apprestaurante.admin.adminMainPage;
import com.example.apprestaurante.databinding.ActivitySaleBinding;

public class sale extends AppCompatActivity {

    ActivitySaleBinding binding;
    SQLiteDatabase db;
    int image, id;
    String name, price, desc;
    Dialogs dialogs;
    int cantidad = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialogs = new Dialogs(this);
        cantidad = 1;

        if(Utils.getInstance().getTipoUsuario() != "client"){
            Intent isAdmin = new Intent(this, adminMainPage.class);
            startActivity(isAdmin);
        }
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();

        image= getIntent().getIntExtra("image", 0);
        price = getIntent().getStringExtra("price");
        name = getIntent().getStringExtra("name");
        desc = getIntent().getStringExtra("desc");

        binding.FoodNameSale.setText(name);
        binding.FoodDescSale.setText(desc);
        binding.FoodPriceSale.setText(price);
        binding.FoodImageSale.setImageResource(image);
        id = Utils.getInstance().getIdUsuario();
        int precio = Integer.parseInt(binding.FoodPriceSale.getText().toString());
        binding.aumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad = Integer.parseInt(binding.cantidad.getText().toString());
                cantidad++;
                int total = cantidad * precio;
                binding.cantidad.setText(String.format("%d", cantidad));
                binding.FoodPriceSale.setText(String.format("%d", total));
            }
        });

        binding.decrecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = Integer.parseInt(binding.cantidad.getText().toString());
                if(cantidad > 1){
                    cantidad--;
                }
                int total = cantidad * precio;
                binding.cantidad.setText(String.format("%d", cantidad));
                binding.FoodPriceSale.setText(String.format("%d", total));

            }
        });

        binding.goBak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.OrderSaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    for(int i = 0; i < cantidad; i++) {
                        con.OrdenarComida(db, name, price, desc, image, id);
                    }
                    Intent admin = new Intent(getApplicationContext(), com.example.apprestaurante.admin.admin.class);
                    startActivity(admin);
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