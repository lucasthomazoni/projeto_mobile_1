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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.grupodois.conversaoapp.R.layout.activity_inicial;

public class ActivityInicial extends AppCompatActivity {

    private Button btnOK;
    private RadioButton radioButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_inicial);

        Button btnOK = (Button) findViewById(R.id.button);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupMoedas);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) findViewById(selectedId);

                if (radioButton != null) {
//                    String myUrl = "https://api.fixer.io/latest?base=" + radioButton.getTag().toString();
//                    funcaoTeste(myUrl);
//                    Log.i("request", myUrl);
                    startActivity(new Intent(ActivityInicial.this, TelaDois.class));
                } else {
                    Toast.makeText(ActivityInicial.this, "Escolha uma moeda para começar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

//    private void requisicaoHttp(String url) {
//
//        final TextView responserino = (TextView) findViewById(R.id.responserino);
//
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        responserino.setText("Response:");
//                        Log.i("response", "mds do ceu berg");
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("error", error.toString());
//                    }
//                });
//    }

//    private void funcaoTeste(String myUrl){
//
//        String url = myUrl;
//
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.show();
//
//        StringRequest strReq = new StringRequest(Request.Method.GET,
//                url, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Log.d("response", response.toString());
//                pDialog.hide();
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d("error", "Error: " + error.getMessage());
//                pDialog.hide();
//            }
//        }){
//            /**
//             * Passing some request headers
//             * */
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("Content-Type", "application/json");
//                return headers;
//            }
//        };
//    }

}
