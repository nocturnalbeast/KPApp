package com.nocturnalbeast.kpapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CGFinalActivity extends AppCompatActivity implements OnMapReadyCallback {

    String field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgfinal);

        ListView joblist = (ListView)findViewById(R.id.joblist);
        TextView title = (TextView)findViewById(R.id.job_tv) ;
        TextView deets = (TextView)findViewById(R.id.job_deets_tv) ;

        List<String> clist = null;
        Bundle getData;
        final Intent getIntentStuff = getIntent();
        getData = getIntentStuff.getExtras();
        field = getData.getString("job");

        title.setText(field);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (field.equals("Accountant/Businessman")) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.jobs_accounting)));
            deets.setText(getResources().getString(R.string.job_desc_accounting));
        }
        else if (field.equals("Farmer")) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.jobs_farming)));
            deets.setText(getResources().getString(R.string.job_desc_farming));
        }
        else if (field.equals("IT Professional")) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.jobs_it)));
            deets.setText(getResources().getString(R.string.job_desc_it));
        }
        else if (field.equals("Literary Agent")) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.jobs_literature)));
            deets.setText(getResources().getString(R.string.job_desc_literature));
        }
        else if (field.equals("Teacher")) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.jobs_teaching)));
            deets.setText(getResources().getString(R.string.job_desc_teaching));
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, clist){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);
                TextView ListItemShow = (TextView) view.findViewById(android.R.id.text1);
                ListItemShow.setTextColor(getResources().getColor(R.color.colorText1));
                return view;
            }
        };

        joblist.setAdapter(adapter);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (field.equals("Accountant/Businessman")) {
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
        if (field.equals("Farmer")) {
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
        if (field.equals("Teacher")) {
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
        if (field.equals("Literary Agent")) {
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
        if (field.equals("IT Professional")) {
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
