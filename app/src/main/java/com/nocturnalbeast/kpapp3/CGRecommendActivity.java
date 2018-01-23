package com.nocturnalbeast.kpapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CGRecommendActivity extends AppCompatActivity {

    ArrayList<String> selected_skills;
    ArrayList<String> selected_project_field;
    ArrayList<String> selected_interests;
    ArrayList<String> selected_all_courses;

    TextView all_courses_tv,project_field_tv,skills_tv,interests_tv,final_job_tv;

    Double rank_it,rank_farming,rank_accounting,rank_teaching,rank_literature;

    Button btn_finalcg;

    Bundle sendData;

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

        all_courses_tv = (TextView)findViewById(R.id.all_courses_tv);
        project_field_tv = (TextView)findViewById(R.id.project_field_tv);
        skills_tv = (TextView)findViewById(R.id.skills_tv);
        interests_tv = (TextView)findViewById(R.id.interests_tv);
        final_job_tv = (TextView)findViewById(R.id.final_job_tv);

        rank_teaching=0.0;
        rank_literature=0.0;
        rank_it=0.0;
        rank_farming=0.0;
        rank_accounting=0.0;

        all_courses_tv.setText("You've chosen " + selected_all_courses.get(0) + " as your educational qualification.");
        project_field_tv.setText("The project(s) you've done have been in the fields of " + TextUtils.join(", ", selected_project_field) + ".");
        skills_tv.setText("You've listed your skills as " + TextUtils.join(", ", selected_skills) + ".");
        interests_tv.setText("And you've listed your interests as " + TextUtils.join(", ", selected_interests) + ".");

        sendData = new Bundle();

        btn_finalcg = (Button)findViewById(R.id.btn_findtrainloc);

        btn_finalcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchToTrainDeets = new Intent(getApplicationContext(),CGFinalActivity.class);
                switchToTrainDeets.putExtras(sendData);
                startActivity(switchToTrainDeets);
            }
        });

        jobFinder();

        if (rank_it>=rank_teaching&&rank_it>=rank_accounting&&rank_it>=rank_farming&&rank_it>=rank_literature) {
            final_job_tv.setText("You're suited to be an IT professional.");
            sendData.putString("job","IT Professional");
        }

        if (rank_literature>=rank_it&&rank_literature>=rank_accounting&&rank_literature>=rank_farming&&rank_literature>=rank_teaching) {
            final_job_tv.setText("You're suited to be a literary person.");
            sendData.putString("job","Literary Agent");
        }

        if (rank_teaching>=rank_it&&rank_teaching>=rank_accounting&&rank_teaching>=rank_farming&&rank_teaching>=rank_literature) {
            final_job_tv.setText("You're suited to be a teacher.");
            sendData.putString("job","Teacher");
        }

        if (rank_accounting>=rank_teaching&&rank_accounting>=rank_it&&rank_accounting>=rank_farming&&rank_accounting>=rank_literature) {
            final_job_tv.setText("You're suited to be an accountant/businessman.");
            sendData.putString("job","Accountant/Businessman");
        }

        if (rank_farming>=rank_teaching&&rank_farming>=rank_accounting&&rank_farming>=rank_it&&rank_farming>=rank_literature) {
            final_job_tv.setText("You're suited to be a farmer.");
            sendData.putString("job","Farmer");
        }


    }

    public void jobFinder(){
        if (selected_all_courses.get(0).equals("B.Tech"))
            rank_it = 1.0;
        else if (selected_all_courses.get(0).equals("B.Com"))
            rank_accounting = 1.0;
        else if (selected_all_courses.get(0).equals("BBA"))
            rank_accounting = 1.0;
        else if (selected_all_courses.get(0).equals("BCA"))
            rank_it = 1.0;
        else if (selected_all_courses.get(0).equals("BA(Eng.)"))
            rank_literature = 1.0;
        else if (selected_all_courses.get(0).equals("B.Ed"))
            rank_teaching = 1.0;
        else if (selected_all_courses.get(0).equals("M.Tech"))
            rank_it = 1.5;
        else if (selected_all_courses.get(0).equals("M.Com"))
            rank_accounting = 1.5;
        else if (selected_all_courses.get(0).equals("MBA"))
            rank_accounting = 1.5;
        else if (selected_all_courses.get(0).equals("MCA"))
            rank_it = 1.5;
        else if (selected_all_courses.get(0).equals("MA(Eng.)"))
            rank_literature = 1.5;
        else if (selected_all_courses.get(0).equals("M.Ed"))
            rank_teaching = 1.5;
        else if (selected_all_courses.get(0).equals("B.Sc(Farming)"))
            rank_farming = 1.0;
        else if (selected_all_courses.get(0).equals("M.Sc(Farming)"))
            rank_farming = 1.5;

        if (selected_project_field.contains("Hardware & IoT"))
            rank_it += 0.5;
        if (selected_project_field.contains("Web Application"))
            rank_it += 0.5;
        if (selected_project_field.contains("Mobile Application Development"))
            rank_it += 0.5;
        if (selected_project_field.contains("Cyber Security & Privacy"))
            rank_it += 0.5;
        if (selected_project_field.contains("Mass Auditing"))
            rank_accounting += 0.5;
        if (selected_project_field.contains("Mass Survey"))
            rank_teaching += 0.5;
        if (selected_project_field.contains("Literary Review"))
            rank_literature += 0.5;
        if (selected_project_field.contains("Enviromental Analysis"))
            rank_farming += 0.5;
        if (selected_project_field.contains("Soil Profiling"))
            rank_farming += 0.5;

        if (selected_interests.contains("Reading & Writing"))
            rank_literature += 0.7;
        if (selected_interests.contains("Gaming"))
            rank_it += 0.7;
        if (selected_interests.contains("Technology"))
            rank_it += 0.7;
        if (selected_interests.contains("Internet of Things"))
            rank_it += 0.7;
        if (selected_interests.contains("Nature & Environmental Protection"))
            rank_farming += 0.7;
        if (selected_interests.contains("Maths & Problem Solving"))
            rank_accounting += 0.7;
        if (selected_interests.contains("Learning & Education"))
            rank_teaching += 0.7;
    }
}
