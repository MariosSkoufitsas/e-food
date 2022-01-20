package com.example.e_shopp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsCoffee extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_coffee);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng coffee1 = new LatLng(40.642730, 22.930432);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coffee1, 10.2f));
        mMap.addMarker(new MarkerOptions().position(coffee1).title("Coffee Island"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee1));

        LatLng coffee2 = new LatLng(40.6020967400314, 22.969365932294803);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coffee2, 10.2f));
        mMap.addMarker(new MarkerOptions().position(coffee2).title("Coffee Lab"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee2));

        LatLng coffee3 = new LatLng(40.60069525812926, 22.95414188934142);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coffee3, 10.2f));
        mMap.addMarker(new MarkerOptions().position(coffee3).title("Mikel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee3));

        LatLng coffee4 = new LatLng(40.63423211413022, 22.939140485218857);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coffee4, 10.2f));
        mMap.addMarker(new MarkerOptions().position(coffee4).title("BaristART"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee4));

        LatLng coffee5 = new LatLng(40.60362163007629, 22.974937984658563);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coffee5, 10.2f));
        mMap.addMarker(new MarkerOptions().position(coffee5).title("Deseo Art Cafe"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee5));
    }
}