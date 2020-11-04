package com.example.custom_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.City;
import com.example.recycleview.R;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCityName;
        private ImageView imgCity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCityName = itemView.findViewById(R.id.txtNameCity);
            imgCity = itemView.findViewById(R.id.imgCity);
        }
    }

    private Context context;
    private int resource;
    private List<City> cities;

    public CityAdapter(Context context, int resource, List<City> cities) {
        this.context = context;
        this.resource = resource;
        this.cities = cities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View convertView = layoutInflater.inflate(resource, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCityName.setText(cities.get(position).toString());
        holder.imgCity.setImageResource(cities.get(position).getIdImage());
    }


    @Override
    public int getItemCount() {
        return cities.size();
    }
}
