package com.example.apprestaurante.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

import com.example.apprestaurante.ActivityLogin;
import com.example.apprestaurante.R;

public class Dialogs {

    Context context;
    LayoutInflater inflater;

    public Dialogs(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void dialogBack () {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Seguro que quiere salir de la app?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, ActivityLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                context.startActivity(intent);

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setIcon(R.drawable.ic_delete).setTitle("Salir");
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void mostrarDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = this.inflater;
        View view = inflater.inflate(R.layout.dialog_orders_design, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        LinearLayout allOrders = view.findViewById(R.id.allOrders);
        allOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userOrders = new Intent(context, com.example.apprestaurante.admin.allOrders.class);
                context.startActivity(userOrders);
            }
        });

        LinearLayout clientOrders = view.findViewById(R.id.clientsOrders);
        clientOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allOrders = new Intent(context, com.example.apprestaurante.admin.admin.class);
                context.startActivity(allOrders);
            }
        });

    }
}
