package com.example.daar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class vue22Activity extends AppCompatActivity {

    float x1,x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue22);
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
                        Intent i = new Intent(vue22Activity.this, vue2Activity.class);
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