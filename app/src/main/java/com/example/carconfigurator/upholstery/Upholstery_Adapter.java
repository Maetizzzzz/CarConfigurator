package com.example.carconfigurator.upholstery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Upholstery_Adapter extends RecyclerView.Adapter<Upholstery_Adapter.UpholsteryViewHolder>{
    private ArrayList<Upholstery> upholsteryArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class UpholsteryViewHolder extends RecyclerView.ViewHolder{
        public ImageView upholsteryImageView;
        public TextView upholsteryTextView;

        public UpholsteryViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            upholsteryImageView = itemView.findViewById(R.id.upholsteryImageView);
            upholsteryTextView = itemView.findViewById(R.id.upholsteryTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public Upholstery_Adapter(ArrayList<Upholstery> upholsteryArrayList){
        this.upholsteryArrayList = upholsteryArrayList;
    }

    @NonNull
    @Override
    public UpholsteryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upholstery_item, parent, false);
        UpholsteryViewHolder upholsteryViewHolder = new UpholsteryViewHolder(view, listener);
        return upholsteryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpholsteryViewHolder holder, int position) {
        Upholstery currentUpholstery = upholsteryArrayList.get(position);

        holder.upholsteryImageView.setImageResource(currentUpholstery.getImage());
        holder.upholsteryTextView.setText(currentUpholstery.getName());
    }

    @Override
    public int getItemCount() {
        return upholsteryArrayList.size();
    }
}
