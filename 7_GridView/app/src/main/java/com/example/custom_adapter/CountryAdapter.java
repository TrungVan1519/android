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

import com.example.gridview.R;
import com.example.model.Country;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    private Context context;
    private int resource;
    private List<Country> countries;

    public CountryAdapter(@NonNull Context context, int resource, @NonNull List<Country> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.countries = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        ViewHolder holder = new ViewHolder();
        holder.imgCountry = convertView.findViewById(R.id.imgCountry);
        holder.imgCountry.setImageResource(countries.get(position).getIdImage());
        holder.txtCountry = convertView.findViewById(R.id.txtCountry);
        holder.txtCountry.setText(countries.get(position).toString());

        convertView.setTag(holder);

        return convertView;
    }

    public class ViewHolder {
        ImageView imgCountry;
        TextView txtCountry;
    }
}
