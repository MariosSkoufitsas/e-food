package com.example.e_shopp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsPizza extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_pizza);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng pizza1 = new LatLng(40.668356985973276, 22.90923905792156);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pizza1, 10.2f));
        mMap.addMarker(new MarkerOptions().position(pizza1).title("Raffaele Pizza"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pizza1));

        LatLng pizza2 = new LatLng(40.62766262514976, 22.947358299597838);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pizza2, 10.2f));
        mMap.addMarker(new MarkerOptions().position(pizza2).title("Domino’s Pizza"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pizza2));

        LatLng pizza3 = new LatLng(40.622259371790065, 22.960660433425353);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pizza3, 10.2f));
        mMap.addMarker(new MarkerOptions().position(pizza3).title("Home Pizza"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pizza3));

        LatLng pizza4 = new LatLng(40.634237816230126, 22.952798225225425);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pizza4, 10.2f));
        mMap.addMarker(new MarkerOptions().position(pizza4).title("Pizza Chris"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pizza4));

        LatLng pizza5 = new LatLng(40.636173679501816, 22.952739636890342);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pizza5, 10.2f));
        mMap.addMarker(new MarkerOptions().position(pizza5).title("Pizza Romea"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pizza5));
    }
}