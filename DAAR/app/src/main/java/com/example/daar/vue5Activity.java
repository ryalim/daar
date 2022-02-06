package com.example.daar;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vue5Activity extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    ArrayList ListResult = new ArrayList();
    Map<String,List<String>> produitcollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    private Button ButtonVue0;
    private Button ButtonVue54;
    float x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue5);
        ButtonVue0 = findViewById(R.id.accueil);
        ButtonVue54 = findViewById(R.id.panier);
        createGroupList();
        createCollection();
        expandableListView= findViewById(R.id.list5);
        expandableListAdapter = new MyExpandableListAdapter(this, groupList, produitcollection);
        expandableListView.setAdapter(expandableListAdapter);
        try {
            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                int lastExpandedPosition = -1;

                @Override
                public void onGroupExpand(int i) {
                    if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                        expandableListView.collapseGroup(lastExpandedPosition);
                    }
                    lastExpandedPosition = i;
                }
            });
            expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                    String selected = expandableListAdapter.getChild(i, i1).toString();

                    if (!(ListResult.contains(selected))) {
                        ListResult.add(selected);
                        Toast.makeText(getApplicationContext(), "Article sélectionné ! ", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Déjà sélectionné ! ", Toast.LENGTH_LONG).show();
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            displayExceptionMessage();
        }

        ButtonVue0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue5Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ButtonVue54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue5Activity.this, vue54Activity.class);
                intent.putStringArrayListExtra("liste",ListResult);
                startActivity(intent);

            }
        });

    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                if(x1 > x2){
                    Intent i = new Intent(vue5Activity.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    private void createCollection() {
        String[] produits_poissons = {"Filet Bar de ligne\t\t\t\t\t\t7€","Bar de ligne portion\t\t\t\t\t\t10€"
                ,"Aile de raie\t\t\t\t\t\t10€","Lieu jaune de ligne\t\t\t\t\t\t12€"
                ,"Filet Julienne\t\t\t\t\t\t19€","Bar de ligne\t\t\t\t\t\t30€"
        };
        String[] produits_coquillages = {"Moules de pêche\t\t\t\t\t\t7€","Bouquets cuits\t\t\t\t\t\t8€"
                ,"Huitres N°2 St Vaast\t\t\t\t\t\t9.5€","Huitres N°2 OR St Vaast\t\t\t\t\t\t12€"
                ,"Huitres N°3 St Vaast\t\t\t\t\t\t19€","Huitres N°3 OR St Vaast\t\t\t\t\t\t24€"
                ,"Huitres N°4 St Vaast\t\t\t\t\t\t38€","Huitres N°4 OR St Vaast\t\t\t\t\t\t48€"
        };
        String [] produits_crustaces = {"Araignées\t\t\t\t\t\t7€"
        };
        String [] produits_promotions = { "Moules de pêche\t\t\t\t\t\t7€"
        };
        produitcollection = new HashMap<String, List<String>>();
        for(String group: groupList) {
            if (group.equals("Poissons")) {
                loadChild(produits_poissons);
            } else if (group.equals("Coquillages")) {
                loadChild(produits_coquillages);
            } else if (group.equals("Crustacés")) {
                loadChild(produits_crustaces);
            } else
                loadChild(produits_promotions);
            produitcollection.put(group,childList);


        }
    }

    private void loadChild(String[] produitmodels) {
        childList = new ArrayList<>();
        for(String model : produitmodels){
            childList.add(model);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Poissons");
        groupList.add("Coquillages");
        groupList.add("Crustacés");
        groupList.add("Promotions");

    }
    public void displayExceptionMessage()
    {
        Toast.makeText(this, "Votre requête est actuellement indisponible, veuillez réessayer ultérieurement", Toast.LENGTH_LONG).show();
    }
}