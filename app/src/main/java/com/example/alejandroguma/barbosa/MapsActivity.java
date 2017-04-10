package com.example.alejandroguma.barbosa;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Bundle extras;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        extras= getIntent().getExtras();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("Barbosa");
        b1=(Button)findViewById(R.id.bUhoteles);
        b2=(Button)findViewById(R.id.bUbares);
        b3=(Button)findViewById(R.id.bUrest);
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

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            // Add a marker in Sydney and move the camera
            LatLng barbosa4 = new LatLng(6.438767, -75.332949);
       mMap.addMarker(new MarkerOptions().position(barbosa4).title("Barbosa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barbosa4,18));
         /*   LatLng barbosa2 = new LatLng(6.419437, -75.366962);
        mMap.addMarker(new MarkerOptions().position(barbosa2).title("Finca hotel Los Arcos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa2));
            LatLng barbosa3 = new LatLng(6.459392, -75.338015);
        mMap.addMarker(new MarkerOptions().position(barbosa3).title("Finca hotel la Guadalupana"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa3));*/
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
                LatLng barbosa1 = new LatLng(6.437275, -75.331542);
                mMap.addMarker(new MarkerOptions().position(barbosa1).title("Hotel Central Park"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barbosa1,13));
                LatLng barbosa2 = new LatLng(6.419437, -75.366962);
                mMap.addMarker(new MarkerOptions().position(barbosa2).title("Finca hotel Los Arcos"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa2));
                LatLng barbosa3 = new LatLng(6.459392, -75.338015);
                mMap.addMarker(new MarkerOptions().position(barbosa3).title("Finca hotel la Guadalupana"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa3));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
                LatLng barbosa1 = new LatLng(6.438694, -75.333174);
                mMap.addMarker(new MarkerOptions().position(barbosa1).title("Sinners Bar"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barbosa1,16));
                LatLng barbosa2 = new LatLng(6.439088, -75.331075);
                mMap.addMarker(new MarkerOptions().position(barbosa2).title("Sitio Disco Bar"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa2));
                LatLng barbosa3 = new LatLng(6.435775, -75.329619);
                mMap.addMarker(new MarkerOptions().position(barbosa3).title("Genesis Discoteca"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa3));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
                LatLng barbosa1 = new LatLng(6.437929, -75.330958);
                mMap.addMarker(new MarkerOptions().position(barbosa1).title("Carusso"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barbosa1,16));
                LatLng barbosa2 = new LatLng(6.436584, -75.328842);
                mMap.addMarker(new MarkerOptions().position(barbosa2).title("Capriccho pizzeria"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa2));
                LatLng barbosa3 = new LatLng(6.437540, -75.332433);
                mMap.addMarker(new MarkerOptions().position(barbosa3).title("El muelle"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(barbosa3));
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(MapsActivity.this,drawerMainActivity.class);
        intent.putExtra("username",extras.getString("username"));
        intent.putExtra("email",extras.getString("email"));
        startActivity(intent);
        finish();
    }
}
