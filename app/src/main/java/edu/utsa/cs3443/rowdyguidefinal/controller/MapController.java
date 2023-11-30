/**
 * @author Meira Sullum
 */
package edu.utsa.cs3443.rowdyguidefinal.controller;
//
//import android.app.Activity;
//
//import androidx.annotation.NonNull;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.CameraPosition;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.LatLngBounds;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//public class MapController implements OnMapReadyCallback {
//    private Activity activity;
//    private GoogleMap myMap;
//    private SupportMapFragment mapFragment;
//    public MapController(OnMapReadyCallback activity, GoogleMap myMap, SupportMapFragment mapFragment) {
//        this.activity = activity;
//        this.mapFragment = mapFragment;
//        this.myMap = myMap;
//    }
//
//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//
//        // restricts where our camera can go / creates our camera's boundaries
//        LatLngBounds restrictedBounds = new LatLngBounds(
//                new LatLng(29.578295, -98.630265),
//                new LatLng(29.586667, -98.611938)
//        );
//
//        // puts our boundaries on our google map
//        googleMap.setLatLngBoundsForCameraTarget(restrictedBounds);
//
//        // creates a location pinpoint of 'ourself'
//        LatLng sydney = new LatLng(29.584545, -98.616714);
//
//        // zooms in and positions the camera
//        float zoomLevel = 16.0f;
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//                .target(sydney)
//                .zoom(zoomLevel)
//                .build();
//
//        // actually sets the camera position on the map
//        myMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//
//        myMap.addMarker(new MarkerOptions().position(sydney).title("UTSA"));
//        MarkerOptions options = new MarkerOptions().position(sydney).title("UTSA");
//        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
//        myMap.addMarker(options);
//
//
//        // zoom in and out on the map
//        googleMap.getUiSettings().setZoomControlsEnabled(true);
//
//    }
//}
