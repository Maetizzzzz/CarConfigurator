package com.example.carconfigurator.testSpinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerItem> {
    public SpinnerAdapter(@NonNull Context context, ArrayList<SpinnerItem> spinnerList) {
        super(context, 0, spinnerList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row_layout,parent,false
            );
        }
        Button informationButton = convertView.findViewById(R.id.informationButton);
        TextView textViewName = convertView.findViewById(R.id.rowText);

        SpinnerItem currentItem = getItem(position);

        if(currentItem != null) {
            textViewName.setText(currentItem.getTestName());
        }
        return convertView;
    }
}
