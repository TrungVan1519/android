package com.example.googlemap_p3_custom_ggmap;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Restaurant;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent i = this.getIntent();
        final Restaurant restaurant = (Restaurant) i.getSerializableExtra("Restaurant_Obj");
        if (restaurant != null){
            // Add a marker in Sydney and move the camera
            LatLng location = new LatLng(restaurant.getViDo(), restaurant.getKinhDo());
            Marker marker = mMap.addMarker(new MarkerOptions().position(location).title(restaurant.getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 18));
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View view = LayoutInflater.from(MapsActivity.this).inflate(R.layout.template_custom_google_map, null);
                    ImageView imgCustomRestaurant = view.findViewById(R.id.imgCustomRestaurant);
                    imgCustomRestaurant.setImageResource(restaurant.getIdImage());
                    TextView txtCustomNameRestaurant = view.findViewById(R.id.txtCustomNameRestaurant);
                    txtCustomNameRestaurant.setText(restaurant.getName().toString());
                    TextView txtToaDo = view.findViewById(R.id.txtToaDo);
                    txtToaDo.setText("Vi do: " + restaurant.getViDo() + "\nKinh do: " + restaurant.getKinhDo());

                    return view;
                }
            });
        }
    }
}
