package com.example.carconfigurator.brand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Configured_Car_Adapter extends RecyclerView.Adapter<Configured_Car_Adapter.ConfiguredCarViewHolder> {
    private ArrayList<ConfiguratedCar> configuredCarArrayList;
    private Configured_Car_Adapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(Configured_Car_Adapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ConfiguredCarViewHolder extends RecyclerView.ViewHolder {
        public ImageView configuredCarImageView;
        public TextView configuredCarTextView;

        public ConfiguredCarViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            configuredCarImageView = itemView.findViewById(R.id.configuredCarImageView);
            configuredCarTextView = itemView.findViewById(R.id.configuredCarTextView);

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

    public Configured_Car_Adapter(ArrayList<ConfiguratedCar> configuredCarArrayList) {
        this.configuredCarArrayList = configuredCarArrayList;
    }

    @NonNull
    @Override
    public Configured_Car_Adapter.ConfiguredCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.configured_car_item, parent, false);
        ConfiguredCarViewHolder  configuredCarViewHolder = new ConfiguredCarViewHolder(view, listener);
        return configuredCarViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Configured_Car_Adapter.ConfiguredCarViewHolder holder, int position) {
        ConfiguratedCar currentConfiguratedCar = configuredCarArrayList.get(position);

        holder.configuredCarImageView.setImageResource(currentConfiguratedCar.getBrand().getImage());
        holder.configuredCarTextView.setText(currentConfiguratedCar.getName());
    }

    @Override
    public int getItemCount() {
        return configuredCarArrayList.size();
    }
}
