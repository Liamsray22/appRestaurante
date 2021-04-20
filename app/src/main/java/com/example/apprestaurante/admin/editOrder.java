package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.ClientMainPage;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityEditOrderBinding;
import com.example.apprestaurante.databinding.ActivitySaleBinding;

public class editOrder extends AppCompatActivity {

    ActivityEditOrderBinding binding;
    SQLiteDatabase db;
    int image, id;
    String price, name, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Utils.getInstance().getTipoUsuario() != "admin"){
            Intent isClient = new Intent(this, ClientMainPage.class);
            startActivity(isClient);
        }
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();
        image= getIntent().getIntExtra("image", 0);
        price = getIntent().getStringExtra("price");
        name = getIntent().getStringExtra("name");
        desc = getIntent().getStringExtra("desc");
        id = getIntent().getIntExtra("id", 0);

        binding.EditdescEdt.setText(desc);
        binding.EditnameEdt.setText(name);
        binding.EditpriceEdt.setText(price);
        binding.EditIdtxt.setText(String.format("%d", id));
        binding.EditOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.EditarComidas(db,
                        id,
                        binding.EditnameEdt.getText().toString(),
                        binding.EditpriceEdt.getText().toString(),
                        binding.EditdescEdt.getText().toString(),
                        image);
                Toast.makeText(getApplicationContext(), "Comida editada", Toast.LENGTH_LONG).show();
                Intent goBack = new Intent(getApplicationContext(), adminMainPage.class);
                startActivity(goBack);
            }
        });
    }
}