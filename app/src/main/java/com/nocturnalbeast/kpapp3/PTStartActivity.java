package com.nocturnalbeast.kpapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class PTStartActivity extends AppCompatActivity {

    Button btn_farming, btn_teaching, btn_accounts, btn_literature, btn_it;
    Intent SwitchToAA;
    Bundle sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptstart);

        btn_accounts = (Button) findViewById(R.id.btn_accounts);
        btn_farming = (Button) findViewById(R.id.btn_farming);
        btn_it = (Button) findViewById(R.id.btn_it);
        btn_literature = (Button) findViewById(R.id.btn_literature);
        btn_teaching = (Button) findViewById(R.id.btn_teaching);

        SwitchToAA = new Intent(getApplicationContext(),PTCompanyListActivity.class);
        sendData = new Bundle();

        btn_accounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData.putString("field",getString(R.string.field_accounts));
                SwitchToAA.putExtras(sendData);
                startActivity(SwitchToAA);
            }
        });

        btn_teaching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData.putString("field",getString(R.string.field_teach));
                SwitchToAA.putExtras(sendData);
                startActivity(SwitchToAA);
            }
        });

        btn_literature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData.putString("field",getString(R.string.field_literature));
                SwitchToAA.putExtras(sendData);
                startActivity(SwitchToAA);
            }
        });

        btn_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData.putString("field",getString(R.string.field_it));
                SwitchToAA.putExtras(sendData);
                startActivity(SwitchToAA);
            }
        });

        btn_farming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData.putString("field",getString(R.string.field_farming));
                SwitchToAA.putExtras(sendData);
                startActivity(SwitchToAA);
            }
        });
    }
}
