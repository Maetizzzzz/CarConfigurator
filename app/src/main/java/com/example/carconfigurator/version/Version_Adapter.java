package com.example.carconfigurator.version;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Version_Adapter extends RecyclerView.Adapter<Version_Adapter.VersionViewHolder>{
    private ArrayList<Version> versionArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class VersionViewHolder extends RecyclerView.ViewHolder{
        public ImageView versionImageView;
        public TextView versionTextView;

        public VersionViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            versionImageView = itemView.findViewById(R.id.versionImageView);
            versionTextView = itemView.findViewById(R.id.versionTextView);

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

    public Version_Adapter(ArrayList<Version> versionArrayList){
        this.versionArrayList = versionArrayList;
    }

    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.version_item, parent, false);
        VersionViewHolder versionViewHolder = new VersionViewHolder(view, listener);
        return versionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder holder, int position) {
        Version currentVersion = versionArrayList.get(position);

        holder.versionImageView.setImageResource(currentVersion.getImage());
        holder.versionTextView.setText(currentVersion.getName());
    }

    @Override
    public int getItemCount() {
        return versionArrayList.size();
    }
}
