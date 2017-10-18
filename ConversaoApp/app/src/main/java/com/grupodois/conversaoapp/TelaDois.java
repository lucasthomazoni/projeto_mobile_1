package com.grupodois.conversaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TelaDois extends AppCompatActivity {

    private String[] moedas = new String[]{"Dólar", "Euro", "Iene", "Libra Esterlina", "Reais"};

    private Spinner spinnerMoedas;

    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dois);

        android.app.ActionBar actionBar = getActionBar();

        Button btnComparar = (Button) findViewById(R.id.btnComparar);
        textResultado = (TextView) findViewById(R.id.textResultado);
        final EditText moedaBase = (EditText) findViewById(R.id.edtValorBase);
        final EditText moedaComparada = (EditText) findViewById(R.id.edtValorComparar);

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

        btnComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("spinner", spinnerMoedas.getSelectedItem().toString());
               compararMoedas( Double.valueOf(moedaBase.getText().toString()) , Double.valueOf(moedaComparada.getText().toString()), spinnerMoedas.getSelectedItem().toString());
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_comparacao){

        }else if (id == R.id.action_moedas){
            startActivity(new Intent(this, TelaQuatro.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }else if (id == R.id.action_sobre){
            startActivity(new Intent(this, TelaTres.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void compararMoedas(Double moedaBase, Double moedaComparar, String base_taxa){
        Double taxa = null;
        switch (base_taxa){
            case "Dólar":
                Log.i("entrou", "usd");
                taxa = ((CurrencyRates) this.getApplication()).getUSD();
                break;
            case "Euro":
                Log.i("entrou", "eur");
                taxa = ((CurrencyRates) this.getApplication()).getEUR();
                break;
            case "Libra Esterlina":
                Log.i("entrou", "gbp");
                taxa = ((CurrencyRates) this.getApplication()).getGBP();
                break;
            case "Iene":
                Log.i("entrou", "jpy");
                taxa = ((CurrencyRates) this.getApplication()).getJPY();
                break;
            case "Reais":
                Log.i("entrou", "brl");
                taxa = ((CurrencyRates) this.getApplication()).getBRL();
                break;

            default:
                Log.i("error", "deu pau fdp");
        }

        Double resultado = moedaBase * taxa;

        if (resultado < moedaComparar){
            textResultado.setText(getText(R.string.moeda_compensa_base));
        }else if(resultado > moedaComparar){
            textResultado.setText(getText(R.string.moeda_compensa_comparar));
        }
    };

}
