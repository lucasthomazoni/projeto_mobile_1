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

    private TextView textDiferenca;

    private TextView textConvertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dois);

        android.app.ActionBar actionBar = getActionBar();

        Button btnComparar = (Button) findViewById(R.id.btnComparar);
        textResultado = (TextView) findViewById(R.id.textResultado);
        textDiferenca = (TextView) findViewById(R.id.textDiferenca);
        textConvertido = (TextView) findViewById(R.id.textConvertido);
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
                taxa = ((CurrencyRates) this.getApplication()).getUSD();
                break;
            case "Euro":
                taxa = ((CurrencyRates) this.getApplication()).getEUR();
                break;
            case "Libra Esterlina":
                taxa = ((CurrencyRates) this.getApplication()).getGBP();
                break;
            case "Iene":
                taxa = ((CurrencyRates) this.getApplication()).getJPY();
                break;
            case "Reais":
                taxa = ((CurrencyRates) this.getApplication()).getBRL();
                break;

            default:
        }


//EAE MEN VEJA SE VC CONSEGUE RESOLVER ISSO AQUI EM BAIXO!!!!!
//ASSIM, ACRESCENTEI DUAS VARIÁVEIS,
//UMA COM O VALOR DA MOEDA COMPARADA CONVERTIDO PARA A MOEDA BASE
//E UMA COM A DIFERENÇA DE PREÇOS.
//MAS HÁ UM PROBLEMA, EU NÃO SEI COMO MOSTRAR O VALOR DAS VARIÁVEIS NO TEXTVIEW
//SEM SER DO JEITO QUE EU COLOQUEI.
//O PROBLEMA É QUE DO JEITO QUE EU COLOQUEI ELE NÃO GUARDA AS STRINGS, MAS SIM TEXTO SOLTO.
//
//VÊ SE TU SABE E ME DE UM TOQUE. FLWW.


        Double resultado = moedaBase * taxa;
        Double mCompConvParaBase = moedaComparar / taxa;
        Double diferenca = mCompConvParaBase - moedaBase;

        if (resultado < moedaComparar){
            textResultado.setText(getText(R.string.moeda_compensa_base));
            textConvertido.setText(getText(R.string.moeda_comparada_convertido_para_moeda_base, mCompConvParaBase.toString()));
            textDiferenca.setText(getText(R.string.diferenca, diferenca.toString()));
        }else if(resultado > moedaComparar){
            textResultado.setText(getText(R.string.moeda_compensa_comparar));
            textConvertido.setText(getText(R.string.moeda_comparada_convertido_para_moeda_base, mCompConvParaBase.toString()));
            textDiferenca.setText(getText(R.string.diferenca, diferenca.toString()));
        }else {
            textResultado.setText(getText(R.string.moeda_valores_iguais));
            textConvertido.setText(getText(R.string.moeda_comparada_convertido_para_moeda_base, mCompConvParaBase.toString()));
        }
    };

}
