package com.nocturnalbeast.kpapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.ArrayList;

public class CGRecommendActivity extends AppCompatActivity {

    ArrayList<String> selected_skills;
    ArrayList<String> selected_project_field;
    ArrayList<String> selected_interests;
    ArrayList<String> selected_all_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgrecommend);

        Bundle getData;
        final Intent getIntentStuff = getIntent();
        getData = getIntentStuff.getExtras();
        selected_skills = getData.getStringArrayList("selected_skills");
        selected_project_field = getData.getStringArrayList("selected_project_field");
        selected_interests = getData.getStringArrayList("selected_interests");
        selected_all_courses = getData.getStringArrayList("selected_all_courses");

        String joined = TextUtils.join(", ", selected_all_courses);

    }
}
