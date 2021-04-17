package com.example.apprestaurante.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{

    ArrayList<OrderModel> list;
    Context context;

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
        holder.FoodOrderNo.setText(model.getOrderNo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView FoodImageAdmin;
        TextView FoodNameAdmin, FoodPriceAdmin, FoodOrderNo;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            FoodNameAdmin = itemView.findViewById(R.id.FoodNametxtAdmin);
            FoodPriceAdmin = itemView.findViewById(R.id.FoodPricetxtAdmin);
            FoodOrderNo = itemView.findViewById(R.id.FoodOrderNotxt);
            FoodImageAdmin = itemView.findViewById(R.id.FoodImageAdmin);
        }
    }
}
