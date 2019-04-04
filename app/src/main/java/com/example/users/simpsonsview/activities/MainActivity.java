package com.example.users.simpsonsview.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.users.simpsonsview.R;
import com.example.users.simpsonsview.model.Simpson;
import com.example.users.simpsonsview.adapter.RvAdapter;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String URL_JSON = "https://thesimpsonsquoteapi.glitch.me/quotes?count=15";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<Simpson> lstSimpson = new ArrayList<>();
    private RecyclerView myrv ;
    EditText searchInput;
    CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Hide acton Bar
        getSupportActionBar().hide();



        //init
        searchInput = findViewById(R.id.SearchInput);
        myrv = findViewById(R.id.rv);

        jsoncall();

        searchInput.setBackgroundResource(R.drawable.search_input_style);




    }

    public void jsoncall() {
            ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    JSONObject jsonObject = null;


                    for (int i = 0; i < response.length(); i++) {

                        //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                        try {

                            jsonObject = response.getJSONObject(i);
                            Simpson simpson = new Simpson();

                            simpson.setQuote(jsonObject.getString("quote"));
                            simpson.setCharacter(jsonObject.getString("character"));
                            simpson.setImage(jsonObject.getString("image"));

                            //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                            lstSimpson.add(simpson);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }


                    Toast.makeText(MainActivity.this, "Size of Liste " + String.valueOf(lstSimpson.size()), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, lstSimpson.get(1).toString(), Toast.LENGTH_SHORT).show();

                    setRvadapter(lstSimpson);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                    try {
                        Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
                        if (cacheEntry == null) {
                            cacheEntry = new Cache.Entry();
                        }
                        final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
                        final long cacheExpired = 24 * 60 * 60 * 1000; // in 24 hours this cache entry expires completely
                        long now = System.currentTimeMillis();
                        final long softExpire = now + cacheHitButRefreshed;
                        final long ttl = now + cacheExpired;
                        cacheEntry.data = response.data;
                        cacheEntry.softTtl = softExpire;
                        cacheEntry.ttl = ttl;
                        String headerValue;
                        headerValue = response.headers.get("Date");
                        if (headerValue != null) {
                            cacheEntry.serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
                        }
                        headerValue = response.headers.get("Last-Modified");
                        if (headerValue != null) {
                            cacheEntry.lastModified = HttpHeaderParser.parseDateAsEpoch(headerValue);
                        }
                        cacheEntry.responseHeaders = response.headers;
                        final String jsonString = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers));
                        return Response.success(new JSONArray(jsonString), cacheEntry);
                    } catch (UnsupportedEncodingException | JSONException e) {
                        return Response.error(new ParseError(e));
                    }
                }

                @Override
                protected void deliverResponse(JSONArray response) {
                    super.deliverResponse(response);
                }

                @Override
                public void deliverError(VolleyError error) {
                    super.deliverError(error);
                }

                @Override
                protected VolleyError parseNetworkError(VolleyError volleyError) {
                    return super.parseNetworkError(volleyError);
                }
            };






            requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(ArrayRequest);
        }



    public void setRvadapter (List<Simpson> lst) {

        final RvAdapter myAdapter = new RvAdapter(this,lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);

 searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                myAdapter.getFilter().filter(s);
                search = s;


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }*/
}
