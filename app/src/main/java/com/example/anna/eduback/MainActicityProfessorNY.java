package com.example.anna.eduback;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActicityProfessorNY extends AppCompatActivity implements AdapterView.OnItemClickListener{

    List<String> fagliste = new ArrayList<String>();
    public static TextView fagData;

    public void setFagliste(ArrayList<String> fagliste) {
        this.fagliste = fagliste;
        fagliste.add("Matematikk1");
        fagliste.add("Objektorientert Programmering");
        fagliste.add("Diskret Matematikk");
    }

    ListView FagListView;
    Button AddFagButton;
    EditText InsertFagEditText;
    String fagkode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_professor);

        FagListView = (ListView) findViewById(R.id.FagListView);
        AddFagButton = (Button) findViewById(R.id.AddFagButton);
        fagData = (TextView) findViewById(R.id.fagJsonItem);
        InsertFagEditText = (EditText) findViewById(R.id.InsertFag);

        //Lage en view for hvordan hver linje i lista skal se ut. Typ lite bilde helt til venstre, kun tekst osv.
        //Simple list item 1 er kun tekst, nr 2 er med bilde. her kan man lage hva man vil.
        ArrayAdapter<String> FagAdapter;
        FagAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, fagliste);

        FagListView.setAdapter(FagAdapter);
        FagListView.setOnItemClickListener(this);
        fagkode = InsertFagEditText.getText().toString();
        AddFagButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new JSONTask().execute("http://www.ime.ntnu.no/api/course/" +fagkode);
            }
        }

        );

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // System.out.println(liste[position]);

        Intent moveToDetailIntent=new Intent(getBaseContext(),Fag.class);
        moveToDetailIntent.putExtra("Fag",fagliste.get(position));
        startActivity(moveToDetailIntent);
    }
}
