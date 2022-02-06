package com.example.daar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class vue3Activity extends AppCompatActivity {

    private Button ButtonVue30;
    private Button ButtonVue31;
    private Button ButtonVue32;
    private Button ButtonVue33;
    private Button ButtonVue34;
    private Button ButtonVue1;
    float x1,x2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue3);

        ButtonVue30 = findViewById(R.id.bistrotsdesgascons);
        ButtonVue31 = findViewById(R.id.lesfousdelile);
        ButtonVue32 = findViewById(R.id.bistrotlandais);
        ButtonVue33 = findViewById(R.id.villa93);
        ButtonVue34 = findViewById(R.id.bistrotdusommelier);
        ButtonVue1 = findViewById(R.id.partenaire);

        ButtonVue30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue3Activity.this, vue30Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue3Activity.this, vue31Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue3Activity.this, vue32Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue3Activity.this, vue33Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue3Activity.this, vue34Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue3Activity.this, vue1Activity.class);
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
                        Intent i = new Intent(vue3Activity.this, MainActivity.class);
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
