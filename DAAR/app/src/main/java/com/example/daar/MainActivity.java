package com.example.daar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ButtonVue1;
    private Button ButtonVue2;
    private Button ButtonVue3;
    private Button ButtonVue4;
    private Button ButtonVue5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue0);

        ButtonVue1 = findViewById(R.id.Contact);
        ButtonVue2 = findViewById(R.id.Bateaux);
        ButtonVue3 = findViewById(R.id.Restaurents);
        ButtonVue4 = findViewById(R.id.Recettes);
        ButtonVue5 = findViewById(R.id.Produits);


        ButtonVue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, vue1Activity.class);
                startActivity(intent);
            }
        });


        ButtonVue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, vue2Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, vue3Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, vue4Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, vue5Activity.class);
                startActivity(intent);
            }
        });
    }

}