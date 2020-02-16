package com.example.admin_rakshak;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class viewInMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView Desc;
    private Button btnMakePublic,btnRedirect;
    private ChildEventListener mChildEventListener;
    private DatabaseReference mUsers;
    Marker marker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_in_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager( )
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ChildEventListener mChildEventListener;
        mUsers = FirebaseDatabase.getInstance().getReference().child("Test");
        mUsers.push().setValue(marker);

        Desc = ( TextView) findViewById(R.id.textview_setDesc);
        btnMakePublic = (Button) findViewById(R.id.button_makePublic);
        btnRedirect = (Button) findViewById(R.id.button_redirect);
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

        double lat = getIntent().getDoubleExtra("latitude",0.00);
        double lng = getIntent().getDoubleExtra("longitude",0.00);
        String type = getIntent().getExtras().getString("type",null);
        String desc = getIntent().getExtras().getString("desc",null);
        long contact = getIntent().getLongExtra("contact",0);
        final boolean status = getIntent().getBooleanExtra("status",false);
        final boolean makePublicStatus = getIntent().getBooleanExtra("makePublicStatus",false);



        LatLng location = new LatLng(lat,lng);
        mMap.addMarker(new MarkerOptions().position(location).title(type+" Contact:"+contact));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,10));

        Desc.setText(desc);

        btnMakePublic.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                if(makePublicStatus == false){

                }9/,
            }
        });


    }
}
