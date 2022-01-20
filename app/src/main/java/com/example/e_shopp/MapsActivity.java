package com.example.e_shopp;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng grill1 = new LatLng(40.642915, 22.941871);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(grill1, 10.2f));
        mMap.addMarker(new MarkerOptions().position(grill1).title("Asterix Γυράδικο"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(grill1));

        LatLng grill2 = new LatLng(40.634322, 22.942160);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(grill2, 10.2f));
        mMap.addMarker(new MarkerOptions().position(grill2).title("Τ' αδέλφια"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(grill2));

        LatLng grill3 = new LatLng(40.631448, 22.952435);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(grill3, 10.2f));
        mMap.addMarker(new MarkerOptions().position(grill3).title("Χρήστος Γυράδικο"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(grill3));

        LatLng grill4 = new LatLng(40.608779, 22.979342);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(grill4, 10.2f));
        mMap.addMarker(new MarkerOptions().position(grill4).title("Τα Γοριλάκια"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(grill4));

        LatLng grill5 = new LatLng(40.621777, 22.956243);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(grill5, 10.2f));
        mMap.addMarker(new MarkerOptions().position(grill5).title("Τηγανιές & Σχάρες"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(grill5));
    }
}