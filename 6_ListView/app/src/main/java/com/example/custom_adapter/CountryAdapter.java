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

import com.example.listview.R;
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
        holder.txtCountry = convertView.findViewById(R.id.txtCountryName);
        holder.txtCountry.setText(countries.get(position).toString());
        holder.imgCountry = convertView.findViewById(R.id.imgCountry);
        holder.imgCountry.setImageResource(countries.get(position).getIdImage());

        convertView.setTag(holder);

        return convertView;
    }

    public class ViewHolder {
        TextView txtCountry;
        ImageView imgCountry;
    }
}
