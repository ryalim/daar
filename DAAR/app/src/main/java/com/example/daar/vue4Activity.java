package com.example.daar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class vue4Activity extends AppCompatActivity {

    private Button ButtonVue40;
    private Button ButtonVue41;
    private Button ButtonVue42;
    private Button ButtonVue43;
    private Button ButtonVue44;
    private Button ButtonVue45;
    float x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue4);

        ButtonVue40 = findViewById(R.id.homard);
        ButtonVue41 = findViewById(R.id.stjacques);
        ButtonVue42 = findViewById(R.id.bar);
        ButtonVue43 = findViewById(R.id.tourteau);
        ButtonVue44 = findViewById(R.id.Recette1);
        ButtonVue45 = findViewById(R.id.Recette2);

        ButtonVue40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue4Activity.this, vue40Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue4Activity.this, vue41Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue4Activity.this, vue42Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue4Activity.this, vue43Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue4Activity.this, vue44Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue4Activity.this, vue44Activity.class);
                startActivity(intent);
            }
        });

    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        try {
            switch (touchEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x1 = touchEvent.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = touchEvent.getX();
                    if (x1 > x2) {
                        Intent i = new Intent(vue4Activity.this, MainActivity.class);
                        startActivity(i);
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            displayExceptionMessage();
        }
        return false;
    }


    public void displayExceptionMessage()
    {
        Toast.makeText(this, "Votre requête est actuellement indisponible, veuillez réessayer ultérieurement", Toast.LENGTH_LONG).show();
    }
}
