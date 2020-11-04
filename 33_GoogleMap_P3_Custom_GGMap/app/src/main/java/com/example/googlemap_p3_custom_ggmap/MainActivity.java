package com.example.googlemap_p3_custom_ggmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.RestaurantAdapter;
import com.example.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        // RecyclerView khong co su kien ItemClick nen su kien nay ta phai tu tao trong RestaurantAdapter
        //      vi the ma trong day khong con ham setEvents() nua
    }

    RecyclerView restaurantList;
    private void setControls() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Cloud Nine Restaurant", R.drawable.cloud_nine_restaurant, 21.033153, 105.854012));
        restaurants.add(new Restaurant("Frencg Grill Restaurant", R.drawable.french_grill_restaurant, 21.007761, 105.782475));
        restaurants.add(new Restaurant("Gia Ngu Restaurant", R.drawable.gia_ngu_restaurant, 21.009545, 105.783161));

        RestaurantAdapter adapter = new RestaurantAdapter(this,
                R.layout.template_item_recyclerview, restaurants);

        restaurantList = this.findViewById(R.id.listRestaurant);
        restaurantList.setAdapter(adapter);
        restaurantList.setLayoutManager(new LinearLayoutManager(this));
    }
}
