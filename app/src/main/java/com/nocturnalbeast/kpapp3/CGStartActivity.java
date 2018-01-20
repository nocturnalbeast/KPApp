package com.nocturnalbeast.kpapp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import io.apptik.widget.multiselectspinner.ExpandableMultiSelectSpinner;
import io.apptik.widget.multiselectspinner.MultiSelectSpinner;

public class CGStartActivity extends AppCompatActivity {

    ArrayList<String> selected_skills;
    ArrayList<String> selected_project_field;
    ArrayList<String> selected_interests;
    ArrayList<String> selected_all_courses;

    Bundle sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgstart);

        final ArrayList<String> skills = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.skills)));
        final ArrayList<String> project_field = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.project_field)));
        final ArrayList<String> interests = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.interests)));
        final ArrayList<String> ug_courses = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.ug_courses)));
        final ArrayList<String> gpg_courses = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.gpg_courses)));
        final ArrayList<String> all_courses = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.all_courses)));

        selected_skills = new ArrayList<>();
        selected_project_field = new ArrayList<>();
        selected_interests = new ArrayList<>();
        selected_all_courses = new ArrayList<>();

        Button btn_findjob = (Button)findViewById(R.id.btn_findjob);

        ExpandableMultiSelectSpinner qual_spinner = (ExpandableMultiSelectSpinner) findViewById(R.id.qual_spinner);
        LinkedHashMap<String, List<String>> qualifications =  new LinkedHashMap<>();

        qualifications.put(getResources().getString(R.string.ug_string), ug_courses);
        qualifications.put(getResources().getString(R.string.gpg_string), gpg_courses);
        qual_spinner.setItems(qualifications)


                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {
                        // your operation with code...
                        for(int i=0; i<selected.length; i++) {
                            if(selected[i]) {
                                Log.i("TAG",all_courses.get(i));
                                selected_all_courses.add(all_courses.get(i));
                            }
                        }

                    }
                })

                .setAllCheckedText(getResources().getString(R.string.all_select))
                .setAllUncheckedText(getResources().getString(R.string.none_select))
                .setMinSelectedItems(1)
                .setMaxSelectedItems(1)
                // .setSelectAll(true)
        ;

        MultiSelectSpinner skills_spinner = (MultiSelectSpinner) findViewById(R.id.skills_spinner);
        ArrayAdapter<String> adapt_skills = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_multiple_choice, skills);

        skills_spinner
                .setListAdapter(adapt_skills)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {
                        // your operation with code...
                        for(int i=0; i<selected.length; i++) {
                            if(selected[i]) {
                                Log.i("TAG",skills.get(i));
                                selected_skills.add(skills.get(i));
                            }
                        }

                    }
                })
                .setAllCheckedText(getResources().getString(R.string.all_select))
                .setAllUncheckedText(getResources().getString(R.string.none_select))
                .setSelectAll(false)
                .setMinSelectedItems(1);

        MultiSelectSpinner interests_spinner = (MultiSelectSpinner) findViewById(R.id.intrests_spinner);
        ArrayAdapter<String> adapt_interests = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_multiple_choice, interests);

        interests_spinner
                .setListAdapter(adapt_interests)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {
                        // your operation with code...
                        for(int i=0; i<selected.length; i++) {
                            if(selected[i]) {
                                Log.i("TAG",interests.get(i));
                                selected_interests.add(interests.get(i));
                            }
                        }

                    }
                })
                .setAllCheckedText(getResources().getString(R.string.all_select))
                .setAllUncheckedText(getResources().getString(R.string.none_select))
                .setSelectAll(false)
                .setMinSelectedItems(1);

        MultiSelectSpinner project_field_spinner = (MultiSelectSpinner) findViewById(R.id.project_field_spinner);
        ArrayAdapter<String> adapt_pf = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_multiple_choice, project_field);

        project_field_spinner
                .setListAdapter(adapt_pf)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {
                        // your operation with code...
                        for(int i=0; i<selected.length; i++) {
                            if(selected[i]) {
                                Log.i("TAG",project_field.get(i));
                                selected_project_field.add(project_field.get(i));
                            }
                        }

                    }
                })
                .setAllCheckedText(getResources().getString(R.string.all_select))
                .setAllUncheckedText(getResources().getString(R.string.none_select))
                .setSelectAll(false)
                .setMinSelectedItems(1);


        btn_findjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData = new Bundle();
                sendData.putStringArrayList("selected_skills",selected_skills);
                sendData.putStringArrayList("selected_project_field",selected_project_field);
                sendData.putStringArrayList("selected_interests",selected_interests);
                sendData.putStringArrayList("selected_all_courses",selected_all_courses);
                Intent switchToRecommend = new Intent(getApplicationContext(),CGRecommendActivity.class);
                switchToRecommend.putExtras(sendData);
                startActivity(switchToRecommend);            }
        });
    }



}