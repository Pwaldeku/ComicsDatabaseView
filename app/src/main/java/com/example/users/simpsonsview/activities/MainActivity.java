package com.example.users.simpsonsview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.view.Menu;
//import android.view.MenuInflater;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.users.simpsonsview.R;
import com.example.users.simpsonsview.model.Simpson;
import com.example.users.simpsonsview.adapter.RvAdapter;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String URL_JSON = "https://thesimpsonsquoteapi.glitch.me/quotes?count=5";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<Simpson> lstSimpson = new ArrayList<>();
    private RecyclerView myrv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myrv = findViewById(R.id.rv);
        jsoncall();




    }

    public void jsoncall() {


        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {

                    //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                    try {

                        jsonObject = response.getJSONObject(i);
                        Simpson simpson = new Simpson();

                        simpson.setQuote(jsonObject.getString("quote"));
                        simpson.setCharacter(jsonObject.getString("character"));
                        simpson.setImage(jsonObject.getString("image"));

                        //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                        lstSimpson.add(simpson);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                Toast.makeText(MainActivity.this,"Size of Liste "+String.valueOf(lstSimpson.size()),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,lstSimpson.get(1).toString(),Toast.LENGTH_SHORT).show();

                setRvadapter(lstSimpson);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(ArrayRequest);
    }



    public void setRvadapter (List<Simpson> lst) {

        RvAdapter myAdapter = new RvAdapter(this,lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);




    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }*/
}
