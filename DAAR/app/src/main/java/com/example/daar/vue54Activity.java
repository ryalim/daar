package com.example.daar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class vue54Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Button ButtonVue5;
    float x1,x2;
    ArrayList<String> ListVue54;
    ArrayList<Integer> ListPrice = new ArrayList<>();
    ArrayList<Integer> countList = new ArrayList<>(Collections.nCopies(10, 0)); //Limite de 10 dans le panier

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue54);

        ButtonVue5 = findViewById(R.id.accueil2);

        ListView shopList = findViewById(R.id.list54);
        ListView priceList = findViewById(R.id.prix);
        TextView total = (TextView) findViewById(R.id.total);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.Lieux, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter3);
        spinner.setOnItemSelectedListener(this);

        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                ListVue54 = extras.getStringArrayList("liste");


                for (int i = 0; i < ListVue54.size(); i++) {
                    String line = ListVue54.get(i);
                    String[] newline = line.split("\t\t\t\t\t\t");
                    String line2 = newline[1];
                    String[] newline2 = line2.split("€");

                    ListPrice.add(i, Integer.parseInt(newline2[0]));
                }

                ArrayAdapter<String> adapter;
                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, ListVue54);
                shopList.setAdapter(adapter);

                ArrayAdapter<Integer> adapter2;
                adapter2 = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, ListPrice);
                priceList.setAdapter(adapter2);
                int sum = 0;
                for (int j = 0; j < ListPrice.size(); j++) {
                    sum = sum + ListPrice.get(j);
                }
                total.setText(String.valueOf(sum));


                shopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Integer value = countList.get(i); // get value

                        value = value + 1; // increment value
                        countList.set(i, value);

                        ListPrice.set(i, (ListPrice.get(i) + ListPrice.get(i)));
                        adapter2.notifyDataSetChanged();
                        int sum2 = 0;
                        for (int j = 0; j < ListPrice.size(); j++) {
                            sum2 = sum2 + ListPrice.get(j);
                        }
                        total.setText(String.valueOf(sum2));
                    }
                });


            }

            ButtonVue5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(vue54Activity.this, vue5Activity.class);
                    startActivity(intent);
                }
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
            displayExceptionMessage();
        }
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                if(x1 > x2){
                    Intent i = new Intent(vue54Activity.this, vue5Activity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void displayExceptionMessage()
    {
        Toast.makeText(this, "Votre requête est actuellement indisponible, veuillez réessayer ultérieurement", Toast.LENGTH_LONG).show();
    }

    public void paiement(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Paiement");
            alert.setMessage("Envoyer votre commande à Thibault?");
            alert.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(vue54Activity.this, "Commande envoyée!", Toast.LENGTH_LONG).show();
                }
            });
            alert.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(vue54Activity.this, "Commande annulée!", Toast.LENGTH_LONG).show();

                }
            });
            alert.create().show();
    }
}
