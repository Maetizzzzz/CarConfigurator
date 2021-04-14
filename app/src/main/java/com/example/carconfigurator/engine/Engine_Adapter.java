package com.example.carconfigurator.engine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Engine_Adapter extends RecyclerView.Adapter<Engine_Adapter.EngineViewHolder>{
    private ArrayList<Engine> engineArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class EngineViewHolder extends RecyclerView.ViewHolder{
        public ImageView engineImageView;
        public TextView engineTextView;

        public EngineViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            engineImageView = itemView.findViewById(R.id.engineImageView);
            engineTextView = itemView.findViewById(R.id.engineTextView);

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

    public Engine_Adapter(ArrayList<Engine> engineArrayList){
        this.engineArrayList = engineArrayList;
    }

    @NonNull
    @Override
    public EngineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.engine_item, parent, false);
        EngineViewHolder engineViewHolder = new EngineViewHolder(view, listener);
        return engineViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EngineViewHolder holder, int position) {
        Engine currentEngine = engineArrayList.get(position);

        holder.engineImageView.setImageResource(currentEngine.getImage());
        holder.engineTextView.setText(currentEngine.getName());
    }

    @Override
    public int getItemCount() {
        return engineArrayList.size();
    }
}
