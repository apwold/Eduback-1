package com.example.anna.eduback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddLearningGoal extends AppCompatActivity {

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    EditText addLearningGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_learning_goal);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width*.8), (int) (height*.5));

        addLearningGoal = (EditText) findViewById(R.id.addLGEditText);
        String newLG = addLearningGoal.toString();
        addLG(newLG);


    }

    private void addLG(String lg) {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        List<String> nyttLG = new ArrayList<>();
        nyttLG.add("Ingen forståelse");
        nyttLG.add("Delvis forståelse");
        nyttLG.add("Full forståelse");

        listHash.put(listDataHeader.get(listDataHeader.size()), nyttLG);

    }
}
