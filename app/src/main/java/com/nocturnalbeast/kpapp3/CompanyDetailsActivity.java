package com.nocturnalbeast.kpapp3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class CompanyDetailsActivity extends AppCompatActivity implements OnMapReadyCallback{

    Bundle getData;
    String company_name,link;
    TextView company_name_view,company_deets_view;
    Button apt_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

        final Intent getIntentStuff = getIntent();
        getData = getIntentStuff.getExtras();
        company_name = getData.getString("company_name");
        company_name_view = (TextView)findViewById(R.id.company_name_tv);
        company_name_view.setText(company_name);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //setting for aptitude tests and button click.
        apt_button = (Button)findViewById(R.id.btn_aptitude);
        apt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (company_name.equals("Infosys"))
                    link = "http://drive.google.com";
                else if(company_name.equals("Wipro"))
                    link = "http://drive.google.com";
                else
                    link = "http://drive.google.com";
                Intent aptIntent = new Intent(Intent.ACTION_VIEW);
                aptIntent.setData(Uri.parse(link));
                startActivity(aptIntent);
            }
        });
        //setting company name and details
        company_deets_view = (TextView)findViewById(R.id.company_deets_tv);
        if (company_name.equals("Infosys"))
            company_deets_view.setText("blah blah");
        else if(company_name.equals("Wipro"))
            company_deets_view.setText("blah blah");
        else
            company_deets_view.setText("INVALID.");

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (company_name.equals("Infosys")) {
            LatLng bangalore = new LatLng(12.865551 , 77.657228);
            googleMap.addMarker(new MarkerOptions().position(bangalore)
                    .title("Bangalore Office"));

            LatLng hyderabad = new LatLng(17.436394   , 78.348016);
            googleMap.addMarker(new MarkerOptions().position(hyderabad)
                    .title("Hyderabad Office"));

            LatLng mangalore = new LatLng(12.904781 , 74.836354);
            googleMap.addMarker(new MarkerOptions().position(mangalore)
                    .title("Mangalore Office"));

            LatLng mysore = new LatLng(12.360039 , 76.592899);
            googleMap.addMarker(new MarkerOptions().position(mysore)
                    .title("Myosre Office"));

            LatLng kerala = new LatLng(8.533547 , 76.883487);
            googleMap.addMarker(new MarkerOptions().position(kerala)
                    .title("Kerala Office"));

            LatLng chennai = new LatLng(12.888226 , 80.227345);
            googleMap.addMarker(new MarkerOptions().position(chennai)
                    .title("Chennai Office"));
            googleMap.setMinZoomPreference(5.0f);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(bangalore));
        }

    }
}