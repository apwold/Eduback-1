package com.example.anna.eduback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddLearningGoal extends AppCompatActivity implements View.OnClickListener{

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    EditText addLearningGoal;
    Button submitButton;
    String newLG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_learning_goal);

        Button submitButton = (Button) findViewById(R.id.bsubmit);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width*.8), (int) (height*.5));

        addLearningGoal = (EditText) findViewById(R.id.addLGEditText);
        newLG = addLearningGoal.toString();

        submitButton.setOnClickListener(this);

    }

    /*private void addLG(String lg) {
        listDataHeader = new ArrayList<>(); //LearningGoals.listDataHeader
        listHash = new HashMap<>();
        List<String> nyttLG = new ArrayList<>();
        nyttLG.add("Ingen forståelse");
        nyttLG.add("Delvis forståelse");
        nyttLG.add("Full forståelse");
        listHash.put(listDataHeader.get(listDataHeader.size()), nyttLG);

    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bsubmit:
            Intent tilbake = new Intent(getApplicationContext(), LearningGoals.class);
                tilbake.putExtra("NewLG", newLG);
            startActivity(tilbake);
        }
    }
}
