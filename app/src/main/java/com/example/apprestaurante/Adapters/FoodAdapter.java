package com.example.apprestaurante.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.viewHolder>{

    ArrayList<FoodModel> list;
    Context context;

    public FoodAdapter(ArrayList<FoodModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_design, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final FoodModel model = list.get(position);
        holder.FoodImage.setImageBitmap(model.getImage());
        holder.FoodName.setText(model.getName());
        holder.FoodPrice.setText(model.getPrice());
        holder.FoodDesc.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sale = new Intent(context, com.example.apprestaurante.client.sale.class);
                sale.putExtra("image", model.getImage());
                sale.putExtra("name", model.getName());
                sale.putExtra("price", model.getPrice());
                sale.putExtra("desc", model.getDescription());
                context.startActivity(sale);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView FoodImage;
        TextView FoodName, FoodPrice, FoodDesc;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            FoodName = itemView.findViewById(R.id.FoodNametxt);
            FoodPrice = itemView.findViewById(R.id.FoodPricetxt);
            FoodDesc = itemView.findViewById(R.id.FoodDesctxt);
            FoodImage = itemView.findViewById(R.id.FoodImage);
        }
    }
}
