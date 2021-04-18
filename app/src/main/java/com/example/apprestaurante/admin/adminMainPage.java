package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityAdminBinding;
import com.example.apprestaurante.databinding.ActivityAdminMainPageBinding;

public class adminMainPage extends AppCompatActivity {

    ActivityAdminMainPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);
        binding = ActivityAdminMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Utils.TipoUsuario != "admin"){
            Intent isClient = new Intent(this, client.class);
            startActivity(isClient);
        }

        binding.createOrdersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createOrder = new Intent(getApplicationContext(), com.example.apprestaurante.admin.createOrder.class);
                startActivity(createOrder);
            }
        });

        binding.seeOrdersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userOrders = new Intent(getApplicationContext(), com.example.apprestaurante.admin.allOrders.class);
                startActivity(userOrders);
            }
        });

    }
}