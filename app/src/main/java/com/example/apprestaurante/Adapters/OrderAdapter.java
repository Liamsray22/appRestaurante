package com.example.apprestaurante.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.admin.adminMainPage;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{

    ArrayList<OrderModel> list;
    Context context;
    SQLiteDatabase db;


    public OrderAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_design, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModel model = list.get(position);
        holder.FoodImageAdmin.setImageResource(model.getOrderImage());
        holder.FoodNameAdmin.setText(model.getItemName());
        holder.FoodPriceAdmin.setText(model.getPrice());
        int rand = (int)(Math.random()*(999999-100000+1)+100000);
        holder.FoodOrderNo.setText(String.format("%d", rand));
        if(Utils.getInstance().getTipoUsuario()!="admin") {
            holder.FoodbtnDispatch.setVisibility(View.INVISIBLE);
        }

        holder.FoodbtnDispatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar(model.getIdUser());
            }
        });

    }
    public void Eliminar(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Seguro que quiere despachar esta orden?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database con = new Database(context, "Foods",null,1);
                db = con.getWritableDatabase();
                con.DespacharComidas(db, id);
                Intent goBack = new Intent(context, adminMainPage.class);
                context.startActivity(goBack);

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setTitle("Despachar Orden");
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView FoodImageAdmin;
        TextView FoodNameAdmin, FoodPriceAdmin, FoodOrderNo;
        Button FoodbtnDispatch;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            FoodNameAdmin = itemView.findViewById(R.id.FoodNametxtAdmin);
            FoodPriceAdmin = itemView.findViewById(R.id.FoodPricetxtAdmin);
            FoodOrderNo = itemView.findViewById(R.id.FoodOrderNotxt);
            FoodImageAdmin = itemView.findViewById(R.id.FoodImageAdmin);
            FoodbtnDispatch = itemView.findViewById(R.id.btnDispatch);
        }
    }
}
