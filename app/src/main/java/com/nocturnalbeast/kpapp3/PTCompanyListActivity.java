package com.nocturnalbeast.kpapp3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PTCompanyListActivity extends AppCompatActivity {

    TextView ptcl_greet;
    ListView ptcl_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptcompany_list);

        ptcl_greet = (TextView)findViewById(R.id.ptcl_greet);
        ptcl_list = (ListView)findViewById(R.id.ptcl_list);

        String field;
        List<String> clist = null;
        String[] companies;
        Bundle getData;
        final Intent getIntentStuff = getIntent();
        getData = getIntentStuff.getExtras();
        field = getData.getString("field");
        ptcl_greet.setText("The top five companies in " + field.toLowerCase() + " are:");

        if (field.equals(getString(R.string.field_accounts))) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.accounting_companies)));
        }
        else if (field.equals(getString(R.string.field_teach))) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.teaching_companies)));
        }
        else if (field.equals(getString(R.string.field_literature))) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.literature_companies)));
        }
        else if (field.equals(getString(R.string.field_it))) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.it_companies)));
        }
        else if (field.equals(getString(R.string.field_farming))) {
            clist = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.farming_companies)));
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, clist){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);
                TextView ListItemShow = (TextView) view.findViewById(android.R.id.text1);
                ListItemShow.setTextColor(getResources().getColor(R.color.colorText1));
                return view;
            }
        };

        ptcl_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String company_name = (String) adapter.getItem(position);
                Bundle sendData = new Bundle();
                sendData.putString("company_name",company_name);
                Intent SwitchToAA = new Intent(getApplicationContext(),CompanyDetailsActivity.class);
                SwitchToAA.putExtras(sendData);
                startActivity(SwitchToAA);
            }
        });

        ptcl_list.setAdapter(adapter);
    }
}
