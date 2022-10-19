package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText findName;
    EditText findCountry;
    Button findButton;
    static List<Universidad> universidades = new ArrayList<Universidad>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findName = (EditText) findViewById(R.id.findName);
        findCountry = (EditText) findViewById(R.id.findCountry);
        findButton = (Button) findViewById(R.id.findButton);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeerApi();
            }
        });
    }

    private void LeerApi(){
        Editable country = findCountry.getText();
        Editable name = findName.getText();

        String url = "http://universities.hipolabs.com/search?country=" + country + "&name=" + name;
        StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length() -1; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Universidad universidad = new Universidad(jsonObject.getString("country"), jsonObject.getString("web_pages"), jsonObject.getString("name"));
                        universidades.add(universidad);
                    }

                    Intent myIntent = new Intent(MainActivity.this, Listado.class);
                    MainActivity.this.startActivity(myIntent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(getRequest);
    }
}