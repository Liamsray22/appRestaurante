package com.example.apprestaurante.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.R;

import java.util.ArrayList;

public class AllOrdersAdapter extends RecyclerView.Adapter<AllOrdersAdapter.viewHolder>{

    ArrayList<FoodModel> list;
    Context context;

    public AllOrdersAdapter(ArrayList<FoodModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AllOrdersAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_orders_design, parent, false);
        return new AllOrdersAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllOrdersAdapter.viewHolder holder, int position) {
        final FoodModel model = list.get(position);
        holder.FoodImageAllOrders.setImageResource(model.getImage());
        holder.FoodNameAllOrders.setText(model.getName());
        holder.FoodPriceAllOrders.setText(model.getPrice());
        holder.FoodDescAllOrders.setText(model.getDescription());

        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editar(model);
            }
        });

        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Deleting", Toast.LENGTH_LONG).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editar(model);
            }
        });

    }

    public void Editar(FoodModel model) {
        Intent edit = new Intent(context, com.example.apprestaurante.admin.editOrder.class);
        edit.putExtra("image", model.getImage());
        edit.putExtra("name", model.getName());
        edit.putExtra("price", model.getPrice());
        edit.putExtra("desc", model.getDescription());
        context.startActivity(edit);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView FoodImageAllOrders, editar, eliminar;
        TextView FoodNameAllOrders, FoodPriceAllOrders, FoodDescAllOrders;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            FoodNameAllOrders = itemView.findViewById(R.id.FoodNametxtAllOrders);
            FoodPriceAllOrders = itemView.findViewById(R.id.FoodPricetxtAllOrders);
            FoodDescAllOrders = itemView.findViewById(R.id.FoodDesctxtAllOrders);
            FoodImageAllOrders = itemView.findViewById(R.id.FoodImageAllOrders);
            editar = itemView.findViewById(R.id.editarBtn);
            eliminar = itemView.findViewById(R.id.eliminarBtn);
        }
    }
}
