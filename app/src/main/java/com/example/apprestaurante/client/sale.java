package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.R;
import com.example.apprestaurante.admin.admin;
import com.example.apprestaurante.databinding.ActivitySaleBinding;

public class sale extends AppCompatActivity {

    ActivitySaleBinding binding;
    SQLiteDatabase db;
    int image;
    String name, price, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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

        binding.OrderSaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    con.OrdenarComida(db, name, price, desc, image);
                    Intent admin = new Intent(getApplicationContext(), com.example.apprestaurante.admin.admin.class);
                    startActivity(admin);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}