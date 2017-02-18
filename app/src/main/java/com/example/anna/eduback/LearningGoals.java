package com.example.anna.eduback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearningGoals extends AppCompatActivity implements View.OnClickListener{

    Button addLG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_goals);
        System.out.println("Denne siden er for å legge inn og vise læringsmål");

        addLG = (Button) findViewById(R.id.baddLG);
        addLG.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
