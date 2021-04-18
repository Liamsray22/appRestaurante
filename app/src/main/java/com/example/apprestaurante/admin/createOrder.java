package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.R;
import com.example.apprestaurante.databinding.ActivityCreateOrderBinding;
import com.example.apprestaurante.databinding.ActivitySaleBinding;

public class createOrder extends AppCompatActivity {

    ActivityCreateOrderBinding binding;
    SQLiteDatabase db;
    String name, price, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();

        binding.placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.nameEdt.getText().toString();
                price = binding.priceEdt.getText().toString();
                desc = binding.descEdt.getText().toString();
                try {
                    con.CrearOrden(db, name, price, desc, R.mipmap.ic_launcher_round);
                    Intent client = new Intent(getApplicationContext(), com.example.apprestaurante.client.client.class);
                    startActivity(client);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}