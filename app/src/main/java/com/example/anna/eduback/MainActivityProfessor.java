package com.example.anna.eduback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityProfessor extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<String> fagliste = new ArrayList<String>();

    public void setFagliste(ArrayList<String> fagliste) {
        this.fagliste = fagliste;
        fagliste.add("Matematikk1");
        fagliste.add("Objektorientert Programmering");
        fagliste.add("Diskret Matematikk");
    }

    ListView FagListView;
    Button AddFagButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_professor);

       FagListView = (ListView) findViewById(R.id.FagListView);
        AddFagButton = (Button) findViewById(R.id.AddFagButton);

        //Lage en view for hvordan hver linje i lista skal se ut. Typ lite bilde helt til venstre, kun tekst osv.
        //Simple list item 1 er kun tekst, nr 2 er med bilde. her kan man lage hva man vil.
        ArrayAdapter<String> FagAdapter;
        FagAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, fagliste);

        FagListView.setAdapter(FagAdapter);

        FagListView.setOnItemClickListener(this);

        AddFagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fag nyttFag= new Fag();
                fagliste.add(nyttFag.fagNavn);
                //HER VIL VI SØKE OPP FAG I NTNU DATABASEN ???
                //SIKRE AT DET ER ORDENTLIGE FAG SOM BLIR LAGT INN

            }
        }
        );


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent moveToDetailIntent = new Intent(getBaseContext(), Fagside.class);
        moveToDetailIntent.putExtra("Fag", fagliste.get(position));
        startActivity(moveToDetailIntent);

    }
}
