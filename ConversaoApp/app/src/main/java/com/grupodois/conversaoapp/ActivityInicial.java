package com.grupodois.conversaoapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.grupodois.conversaoapp.R.layout.activity_inicial;

public class ActivityInicial extends AppCompatActivity {

    private Button btnOK;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_inicial);

        Button btnOK = (Button) findViewById(R.id.button);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupMoedas);
        requestQueue = Volley.newRequestQueue(this);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                final JSONObject object  = new  JSONObject();

                if (radioButton != null) {
                    String myUrl = "https://api.fixer.io/latest?base=" + radioButton.getTag().toString();
                    Log.i("request", myUrl);
                    requisicaoHttp(myUrl);
                    startActivity(new Intent(ActivityInicial.this, TelaDois.class));
                } else {
                    Toast.makeText(ActivityInicial.this, "Escolha uma moeda para começar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void requisicaoHttp(final String url){
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Carregando...");
        pDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>( ) {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    String base = response.getString("base");
                    String date = response.getString("date");
                    Log.i("base", base);
                    Log.i("data", date);
                    Log.i("array", response.getString("rates").getClass().toString());
                    pDialog.hide();
                } catch (JSONException e) {
                    e.printStackTrace( );
                    pDialog.hide();
                }

            }
        }, new Response.ErrorListener( ) {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }

}
