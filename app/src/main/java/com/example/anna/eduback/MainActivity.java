package com.example.anna.eduback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button testButton;
    Button LGButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testButton = (Button)findViewById(R.id.button);
        LGButton = (Button) findViewById(R.id.LGButton);

        LGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLG = new Intent(getApplicationContext(),LearningGoals.class);
                startActivity(goToLG);
            }
        });

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTheOtherActivity = new Intent(getApplicationContext(), MainActicityProfessorNY.class);
                startActivity(goToTheOtherActivity);
            }
        });
        


    }
}
