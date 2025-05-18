package com.example.EcoSort;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Añadir marcadores de puntos de reciclaje (ejemplo)
        LatLng punto1 = new LatLng(19.4326, -99.1332); // Ejemplo: CDMX
        mMap.addMarker(new MarkerOptions()
                .position(punto1)
                .title("Punto de Reciclaje Centro"));

        LatLng punto2 = new LatLng(19.4350, -99.1400);
        mMap.addMarker(new MarkerOptions()
                .position(punto2)
                .title("Punto de Reciclaje Norte"));

        // Mover cámara al primer punto
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(punto1, 15));
    }
}