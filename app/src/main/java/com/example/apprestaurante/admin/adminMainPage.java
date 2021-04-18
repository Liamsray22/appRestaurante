package com.example.apprestaurante.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.client;
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
                mostrarDialog();
            }
        });

    }

    private void mostrarDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_orders_design, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        LinearLayout allOrders = view.findViewById(R.id.allOrders);
        allOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userOrders = new Intent(getApplicationContext(), com.example.apprestaurante.admin.allOrders.class);
                startActivity(userOrders);
            }
        });

        LinearLayout clientOrders = view.findViewById(R.id.clientsOrders);
        clientOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allOrders = new Intent(getApplicationContext(), com.example.apprestaurante.admin.admin.class);
                startActivity(allOrders);
            }
        });

    }
}