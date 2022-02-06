package com.example.daar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class vue2Activity extends AppCompatActivity {

    private Button ButtonVue20;
    private Button ButtonVue21;
    private Button ButtonVue22;
    private Button ButtonVue23;
    private Button ButtonVue1;
    float x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue2);

        ButtonVue20 = findViewById(R.id.delabrise);
        ButtonVue21 = findViewById(R.id.Saphir);
        ButtonVue22 = findViewById(R.id.gastmicher);
        ButtonVue23 = findViewById(R.id.aquilon);
        ButtonVue1 = findViewById(R.id.Contact);

        ButtonVue20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue2Activity.this, vue20Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue2Activity.this, vue21Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue2Activity.this, vue22Activity.class);
                startActivity(intent);
            }
        });

        ButtonVue23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue2Activity.this, vue23Activity.class);
                startActivity(intent);
            }
        });
        ButtonVue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vue2Activity.this, vue1Activity.class);
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
                        Intent i = new Intent(vue2Activity.this, MainActivity.class);
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
