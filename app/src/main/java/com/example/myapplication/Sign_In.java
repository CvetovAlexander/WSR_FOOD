package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Sign_In extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void sendRequest(View v){

        String login = ((TextView) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
        String password = ((TextView) findViewById(R.id.editTextPassword)).getText().toString();

        JSONObject json = new JSONObject();
        try {
            json.put("email", login);
            json.put("password", password);
        }catch (JSONException e){
            e.printStackTrace();
        }

        String url = "https://food.madskill.ru/auth/login";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, json,
                response -> startActivity(new Intent(this, Main.class)),
                error -> Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        );
        requestQueue.add(request);
    }

}