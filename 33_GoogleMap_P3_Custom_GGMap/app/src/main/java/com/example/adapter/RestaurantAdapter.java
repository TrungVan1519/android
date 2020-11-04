package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googlemap_p3_custom_ggmap.MapsActivity;
import com.example.googlemap_p3_custom_ggmap.R;
import com.example.imterface.ItemClickListener;
import com.example.model.Restaurant;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private Context context;
    private int resource;
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(Context context, int resource, List<Restaurant> resutaurantList) {
        this.context = context;
        this.resource = resource;
        this.restaurantList = resutaurantList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(resource, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameRestaurant.setText(restaurantList.get(position).getName());
        holder.imgRestaurant.setImageResource(restaurantList.get(position).getIdImage());

        // Day la su kien ItemClick do ta tu tao
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick){
                    Toast.makeText(context,
                            "Info: "
                                    + "\n" + restaurantList.get(position).getName()
                                    + "\n" + restaurantList.get(position).getIdImage(),
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(context, MapsActivity.class);
                    i.putExtra("Restaurant_Obj", restaurantList.get(position));
                    context.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView txtNameRestaurant;
        ImageView imgRestaurant;
        private ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameRestaurant = itemView.findViewById(R.id.txtNameRestaurant);
            imgRestaurant = itemView.findViewById(R.id.imgRestaurant);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}
