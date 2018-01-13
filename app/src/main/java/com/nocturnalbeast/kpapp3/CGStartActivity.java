package com.nocturnalbeast.kpapp3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import io.apptik.widget.multiselectspinner.ExpandableMultiSelectSpinner;
import io.apptik.widget.multiselectspinner.MultiSelectSpinner;

public class CGStartActivity extends AppCompatActivity {

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
                                Log.i("TAG", i + " : "+ all_courses.get(i));
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
                                Log.i("TAG", i + " : "+ skills.get(i));
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
                                Log.i("TAG", i + " : "+ interests.get(i));
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
                                Log.i("TAG", i + " : "+ project_field.get(i));
                            }
                        }

                    }
                })
                .setAllCheckedText(getResources().getString(R.string.all_select))
                .setAllUncheckedText(getResources().getString(R.string.none_select))
                .setSelectAll(false)
                .setMinSelectedItems(1);

    }

}