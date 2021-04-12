package com.example.carconfigurator.inProgress;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Brand_Adapter extends RecyclerView.Adapter<Brand_Adapter.BrandViewHolder> {
    private ArrayList<Brand> brandArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class BrandViewHolder extends RecyclerView.ViewHolder {
        public ImageView brandImageView;
        public TextView brandTextView;

        public BrandViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            brandImageView = itemView.findViewById(R.id.brandImageView);
            brandTextView = itemView.findViewById(R.id.brandTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public Brand_Adapter(ArrayList<Brand> brandArrayList) {
        this.brandArrayList = brandArrayList;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_item, parent, false);
        BrandViewHolder brandViewHolder = new BrandViewHolder(view, listener);
        return brandViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        Brand currentBrand = brandArrayList.get(position);

        holder.brandImageView.setImageResource(currentBrand.getImage());
        holder.brandTextView.setText(currentBrand.getName());
    }

    @Override
    public int getItemCount() {
        return brandArrayList.size();
    }
}
