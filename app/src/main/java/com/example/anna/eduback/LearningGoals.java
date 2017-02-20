package com.example.anna.eduback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LearningGoals extends AppCompatActivity implements View.OnClickListener{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader = new ArrayList<>();
    private HashMap<String, List<String>> listHash = new HashMap<>();
    Button addLG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_goals);

        listView = (ExpandableListView) findViewById(R.id.expLV);
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        addLG = (Button) findViewById(R.id.baddLG);
        addLG.setOnClickListener(this);

        String newLG = (String) getIntent().getExtras().get("NewLG");
        addLGoal(newLG);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.baddLG:
                Intent addLearningGoal = new Intent(getApplicationContext(), AddLearningGoal.class);
                startActivity(addLearningGoal);
        }
    }

    private void addLGoal(String newLG) { //Fra addLearningGoal-klasse
        listDataHeader.add(newLG);
        List<String> nyttlaringsmal = new ArrayList<>();
        nyttlaringsmal.add("Ingen forståelse");
        nyttlaringsmal.add("Delvis forståelse");
        nyttlaringsmal.add("Full forståelse");
        listHash.put(listDataHeader.get(listDataHeader.size()), nyttlaringsmal);
    }
}