package com.grupodois.conversaoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaDois extends AppCompatActivity {

    private String[] moedas = new String[]{"Dólar", "Euro", "Pesos Chilenos", "Iene"};

    private Spinner spinnerMoedas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dois);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moedas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerMoedas = (Spinner) findViewById(R.id.spinnerMoedas);
        spinnerMoedas.setAdapter(adapter);

        spinnerMoedas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
