package com.grupodois.conversaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TelaQuatro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quatro);

        TextView textBase = (TextView) findViewById(R.id.cotacao_em);
        TextView textValorDolar = (TextView) findViewById(R.id.textValorDolar);
        TextView textValorEuro = (TextView) findViewById(R.id.textValorEuro);
        TextView textValorLibra = (TextView) findViewById(R.id.textValorLibra);
        TextView textValorIene = (TextView) findViewById(R.id.textValorIene);
        TextView textValorReal = (TextView) findViewById(R.id.textValorReal);

        Double valorDolar = ((CurrencyRates) this.getApplication()).getUSD();
        Double valorEuro = ((CurrencyRates) this.getApplication()).getEUR();
        Double valorLibra = ((CurrencyRates) this.getApplication()).getGBP();
        Double valorIene = ((CurrencyRates) this.getApplication()).getJPY();
        Double valorReal = ((CurrencyRates) this.getApplication()).getBRL();
        String base = ((CurrencyRates) this.getApplication()).getBase();

        textBase.setText(getString(R.string.cotacao_em, base));
        textValorDolar.setText(getString(R.string.valor_dolar, valorDolar.toString()));
        textValorEuro.setText(getString(R.string.valor_euro, valorEuro.toString()));
        textValorIene.setText(getString(R.string.valor_iene, valorIene.toString()));
        textValorLibra.setText(getString(R.string.valor_libra_esterlina, valorLibra.toString()));
        textValorReal.setText(getString(R.string.valor_reais, valorReal.toString()));

        android.app.ActionBar actionBar = getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_comparacao){
            startActivity(new Intent(this, TelaDois.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }else if (id == R.id.action_moedas){

        }else if (id == R.id.action_sobre){
            startActivity(new Intent(this, TelaTres.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
