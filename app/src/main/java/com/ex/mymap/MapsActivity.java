package com.ex.mymap;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng Dhaka = new LatLng(23.787045070377665, 90.37733818771376);
    LatLng Khulna = new LatLng(22.903727317373423, 89.50477607210102);
    LatLng Rangpur = new LatLng(25.75451805118553, 89.23911570439257);
    LatLng Chittagong = new LatLng(22.33933127994083, 91.7698405869498);
    LatLng Sylhet = new LatLng(24.89213966011182, 91.9038695096547);
    private ArrayList<LatLng> locationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationArrayList = new ArrayList<>();
        locationArrayList.add(Dhaka);
        locationArrayList.add(Khulna);
        locationArrayList.add(Rangpur);
        locationArrayList.add(Chittagong);
        locationArrayList.add(Sylhet);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (int i = 0; i < locationArrayList.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Users Location"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
        }


    }
}
