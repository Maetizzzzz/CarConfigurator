package com.example.carconfigurator.colour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Colour_Adapter extends RecyclerView.Adapter<Colour_Adapter.ColourViewHolder>{
    private ArrayList<Colour> colourArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class ColourViewHolder extends RecyclerView.ViewHolder{
        public ImageView colourImageView;
        public TextView colourTextView;

        public ColourViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            colourImageView = itemView.findViewById(R.id.colourImageView);
            colourTextView = itemView.findViewById(R.id.colourTextView);

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

    public Colour_Adapter(ArrayList<Colour> colourArrayList){
        this.colourArrayList = colourArrayList;
    }

    @NonNull
    @Override
    public ColourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.colour_item, parent, false);
        ColourViewHolder colourViewHolder = new ColourViewHolder(view, listener);
        return colourViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColourViewHolder holder, int position) {
        Colour currentColour = colourArrayList.get(position);

        holder.colourImageView.setImageResource(currentColour.getImage());
        holder.colourTextView.setText(currentColour.getColour());
    }

    @Override
    public int getItemCount() {
        return colourArrayList.size();
    }
}
