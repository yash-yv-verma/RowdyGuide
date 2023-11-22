package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.utsa.cs3443.rowdyguidefinal.controller.NavigationController;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // create map frag
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        // Set Home selected

        bottomNavigationView.setSelectedItemId(R.id.navigation_map);
        NavigationController<MapActivity> navigationController = new NavigationController<>(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            navigationController.onNavigationItemSelected(item); //call here
            return true;
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        myMap = googleMap;

        // restricts where our camera can go / creates our camera's boundaries
        LatLngBounds restrictedBounds = new LatLngBounds(
                new LatLng(29.578295, -98.630265),
                new LatLng(29.586667, -98.611938)
        );

        // puts our boundaries on our google map
        googleMap.setLatLngBoundsForCameraTarget(restrictedBounds);

        // creates a location pinpoint of 'ourself'
        LatLng sydney = new LatLng(29.584545, -98.616714);

        // zooms in and positions the camera
        float zoomLevel = 16.0f;
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(sydney)
                .zoom(zoomLevel)
                .build();

        // actually sets the camera position on the map
        myMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        myMap.addMarker(new MarkerOptions().position(sydney).title("UTSA"));
        MarkerOptions options = new MarkerOptions().position(sydney).title("UTSA");
        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        myMap.addMarker(options);


        // zoom in and out on the map
        googleMap.getUiSettings().setZoomControlsEnabled(true);

    }
}