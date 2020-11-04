package com.example.custom_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.model.Item;
import com.example.spinner.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Item> {

    private Context context;
    private int resource;
    private List<Item> items;

    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(this.getContext()).inflate(resource,
                                                                parent, false);

        TextView txtCity = convertView.findViewById(R.id.txtCity);
        txtCity.setText(items.get(position).toString());
        ImageView imgCountry = convertView.findViewById(R.id.imgCountry);
        imgCountry.setImageResource(items.get(position).getIdImage());

        return convertView;
    }
}
