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

import java.io.File;


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
                    link = "https://drive.google.com/drive/folders/1EE3Yur8I79Kb82DwRlGwG__3z36sN0l_";
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
            //company_deets_view.setText(getResources().getString(R.string.co_details_infosys));
            company_deets_view.setText("\n" +
                    "Established in 1981, Infosys is a NYSE listed global consulting and IT services company with more than 198,000 employees. From a capital of US$250, we have grown to become a US$10.5 billion (LTM Q2 FY18 revenues) company with a market capitalization of approximately US$33.5 billion.\n" +
                    "\n" +
                    "In our journey of over 35 years, we have catalyzed some of the major changes that have led to India's emergence as the global destination for software services talent. We pioneered the Global Delivery Model and became the first IT company from India to be listed on NASDAQ. Our employee stock options program created some of India's first salaried millionaires.\n\n Phone: +91 80 2852 0261");
        else if(company_name.equals("Wipro"))
            company_deets_view.setText("Wipro Limited (NYSE: WIT, BSE: 507685, NSE: WIPRO) is a leading global information technology, consulting and business process services company. We harness the power of cognitive computing, hyper-automation, robotics, cloud, analytics and emerging technologies to help our clients adapt to the digital world and make them successful. A company recognized globally for its comprehensive portfolio of services, strong commitment to sustainability and good corporate citizenship, we have over 160,000 dedicated employees serving clients across six continents. Together, we discover ideas and connect the dots to build a better and a bold new future.\n\nPhone: Ph: +91 (80) 28440011");
        else if(company_name.equals("TCS"))
            company_deets_view.setText("Tata Consultancy Services Limited (TCS) is an Indian multinational information technology (IT) service, consulting and business solutions company Headquartered in Mumbai, Maharashtra. It is a subsidiary of the Tata Group and operates in 46 countries.\n\nPhone: +91 95 26 979013" +
                    "\n" +
                    "\nTCS Limited was founded in 1968 by division of Tata Sons Limited. Its early contracts included punched card services to sister company TISCO (now Tata Steel), working on an Inter-Branch Reconciliation System for the Central Bank of India, and providing bureau services to Unit Trust of India.");
        else if(company_name.equals("UST Global"))
            company_deets_view.setText("UST Global® is a leading provider of end-to-end IT services and solutions for Global 1000 companies. We use a client-centric Global Engagement Model that combines local, senior, on-site resources with the cost, scale, and quality advantages of off-shore operations.\n" +
                    "\nThis client-centric focus forms the basis for how we, as a company, operate and serve our clients. Commitment to long-term client success empowers every associate to provide value and flexibility beyond the contract.\n\nPhone: +91 85 89 088891");
        else if(company_name.equals("Accenture"))
            company_deets_view.setText("Accenture solves our clients' toughest challenges by providing unmatched services in strategy, consulting, digital, technology and operations. We partner with more than three-quarters of the Fortune Global 500, driving innovation to improve the way the world works and lives. With expertise across more than 40 industries and all business functions, we deliver transformational outcomes for a demanding new digital world.\n\nPhone: 00 1 312-842-5012");
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
        if (company_name.equals("Wipro")) {
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
        if (company_name.equals("UST Global")) {
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
        if (company_name.equals("TCS")) {
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