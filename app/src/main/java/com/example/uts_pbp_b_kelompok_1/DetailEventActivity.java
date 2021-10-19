package com.example.uts_pbp_b_kelompok_1;

//import static com.mapbox.core.constants.Constants.PRECISION_6;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineCap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineJoin;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineWidth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.uts_pbp_b_kelompok_1.databinding.ActivityDetailEventBinding;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
//import com.mapbox.api.directions.v5.DirectionsCriteria;
//import com.mapbox.api.directions.v5.MapboxDirections;
//import com.mapbox.api.directions.v5.models.DirectionsResponse;
//import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.LocationComponentOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.utils.BitmapUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import timber.log.Timber;

public class DetailEventActivity extends AppCompatActivity implements OnMapReadyCallback, PermissionsListener {

    Event event;
    ActivityDetailEventBinding binding;

    private PermissionsManager permissionsManager;
    private MapboxMap mapboxMap;
    private MapView mapView;
    private Point origin;
    private Point destination;
    private LatLng point;

//    private MapboxDirections client;
    private static final String ROUTE_LAYER_ID = "route-layer-id";
    private static final String ROUTE_SOURCE_ID = "route-source-id";
    private static final String ICON_LAYER_ID = "icon-layer-id";
    private static final String ICON_SOURCE_ID = "icon-source-id";
    private static final String RED_PIN_ICON_ID = "red-pin-icon-id";
//    private DirectionsRoute currentRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_event);

        mapView = findViewById(R.id.mapView);
        mapView.getMapAsync(this);
//
//        Ambil Data Intent
        String strEvent = getIntent().getStringExtra("detailEvent");
        Gson gson = new Gson();
        event = gson.fromJson(strEvent, Event.class);

//        Inisialisasi objek dan variable ke data binding
        binding.setEvent(event);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        MaterialButton btnPesanTiket = findViewById(R.id.btnPesanTiket);
        btnPesanTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(DetailEventActivity.this, OrderActivity.class);;
                //startActivity(intent);
                Intent DetailEvent = new Intent(DetailEventActivity.this, OrderActivity.class);
                Gson gson = new Gson();
                String strEvent = gson.toJson(event);

//                Menyisipkan data json string ke intent
                DetailEvent.putExtra("detailEvent", strEvent);
                startActivity(DetailEvent);
            }
        });
    }


    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {
                    enableLocationComponent(style);
                }
            });
        } else {
            Toast.makeText(this, R.string.user_location_permission_not_granted, Toast.LENGTH_LONG).show();
            finish();
        }

    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        DetailEventActivity.this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {

                enableLocationComponent(style);
                //origin = Point.fromLngLat(point.getLongitude(), point.getLatitude());
                //destination = Point.fromLngLat(getVenueLongitude(),getVenueLatitude());
                //initSource(style);
                //initLayer(style);

                //getRoute(mapboxMap, origin, destination);
            }
        });

    }

    /*private void initSource(Style style) {
        style.addSource(new GeoJsonSource(ROUTE_SOURCE_ID));

        GeoJsonSource iconGeoJsonSource = new GeoJsonSource(ICON_SOURCE_ID, FeatureCollection.fromFeatures(new Feature[] {
                Feature.fromGeometry(Point.fromLngLat(origin.longitude(), origin.latitude())),
                Feature.fromGeometry(Point.fromLngLat(destination.longitude(), destination.latitude()))}));
        style.addSource(iconGeoJsonSource);
    }

    private void initLayer(Style style){
        LineLayer routeLayer = new LineLayer(ROUTE_LAYER_ID, ROUTE_SOURCE_ID);

        routeLayer.setProperties(
                lineCap(Property.LINE_CAP_ROUND),
                lineJoin(Property.LINE_JOIN_ROUND),
                lineWidth(5f),
                lineColor(Color.parseColor("#009688")));

        style.addLayer(routeLayer);

// Add the red marker icon image to the map
        style.addImage(RED_PIN_ICON_ID, BitmapUtils.getBitmapFromDrawable(
                getResources().getDrawable(R.drawable.red_marker)));

// Add the red marker icon SymbolLayer to the map
        style.addLayer(new SymbolLayer(ICON_LAYER_ID, ICON_SOURCE_ID).withProperties(
                iconImage(RED_PIN_ICON_ID),
                iconIgnorePlacement(true),
                iconAllowOverlap(true),
                iconOffset(new Float[] {0f, -9f})));
    }

    private void getRoute(MapboxMap mapboxMap, Point origin, Point destination){
        client = MapboxDirections.builder()
                .origin(origin)
                .destination(destination)
                .overview(DirectionsCriteria.OVERVIEW_FULL)
                .profile(DirectionsCriteria.PROFILE_DRIVING)
                .accessToken(getString(R.string.mapbox_access_token))
                .build();

        client.enqueueCall(new Callback<DirectionsResponse>() {
            @Override
            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                Timber.d("Response code: " + response.code());
                if (response.body() == null) {
                    Timber.e("No routes found, make sure you set the right user and access token.");
                    return;
                } else if (response.body().routes().size() < 1) {
                    Timber.e("No routes found");
                    return;
                }

                currentRoute = response.body().routes().get(0);

                if (mapboxMap != null) {
                    mapboxMap.getStyle(new Style.OnStyleLoaded() {
                        @Override
                        public void onStyleLoaded(@NonNull Style style) {
                            GeoJsonSource source = style.getSourceAs(ROUTE_SOURCE_ID);

                            if (source != null) {
                                source.setGeoJson(LineString.fromPolyline(currentRoute.geometry(), PRECISION_6));
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<DirectionsResponse> call, Throwable t) {
                Timber.e("Error: " + t.getMessage());
                Toast.makeText(DetailEventActivity.this, "Error: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double getVenueLatitude() {
        if(event.getVenueEvent().toString().equals("Graha Saba Buana")){
            return 110.8063;
        }else if(event.getVenueEvent().toString().equals("GOR Sriwedari")){
            return 110.8118;
        }else if(event.getVenueEvent().toString().equals("GOR Sritex Arena")) {
            return 110.8150;
        }else if(event.getVenueEvent().toString().equals("Balai Kota Surakarta")){
            return 110.8293;
        }else return 0;
    }

    private double getVenueLongitude() {
        if(event.getVenueEvent().toString().equals("Graha Saba Buana")){
            return 7.5447;
        }else if(event.getVenueEvent().toString().equals("GOR Sriwedari")){
            return 7.5682;
        }else if(event.getVenueEvent().toString().equals("GOR Sritex Arena")) {
            return 7.5710;
        }else if(event.getVenueEvent().toString().equals("Balai Kota Surakarta")){
            return 7.5695;
        }else return 0;
    } */

    @SuppressWarnings( {"MissingPermission"})
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {

        if (PermissionsManager.areLocationPermissionsGranted(this)) {


            LocationComponentOptions customLocationComponentOptions = LocationComponentOptions.builder(this)
                    .pulseEnabled(true)
                    .build();


            LocationComponent locationComponent = mapboxMap.getLocationComponent();


            locationComponent.activateLocationComponent(
                    LocationComponentActivationOptions.builder(this, loadedMapStyle)
                            .locationComponentOptions(customLocationComponentOptions)
                            .build());


            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);


            locationComponent.setRenderMode(RenderMode.NORMAL);
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    @Override
    @SuppressWarnings( {"MissingPermission"})
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


}
