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

public class Model_Adapter extends RecyclerView.Adapter<Model_Adapter.ModelViewHolder>{
    private ArrayList<Model> modelArrayList;
    private Model_Adapter.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(Model_Adapter.OnItemClickListener listener){
        this.listener = listener;
    }

    public static class ModelViewHolder extends RecyclerView.ViewHolder{
        public ImageView modelImageView;
        public TextView modelTextView;

        public ModelViewHolder(@NonNull View itemView, final Model_Adapter.OnItemClickListener listener) {
            super(itemView);
            modelImageView = itemView.findViewById(R.id.modelImageView);
            modelTextView = itemView.findViewById(R.id.modelTextView);

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

    public Model_Adapter(ArrayList<Model> modelArrayList){
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public Model_Adapter.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item, parent, false);
        Model_Adapter.ModelViewHolder modelViewHolder = new ModelViewHolder(view, listener);
        return modelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Model_Adapter.ModelViewHolder holder, int position) {
        Model currentModel = modelArrayList.get(position);

        holder.modelImageView.setImageResource(currentModel.getImage());
        holder.modelTextView.setText(currentModel.getName());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
