package com.grupodois.conversaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.grupodois.conversaoapp.R.layout.activity_inicial;

public class ActivityInicial extends AppCompatActivity {

    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_inicial);

        Button btnOK = (Button) findViewById(R.id.button);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityInicial.this, TelaDois.class));
            }
        });

    }
}