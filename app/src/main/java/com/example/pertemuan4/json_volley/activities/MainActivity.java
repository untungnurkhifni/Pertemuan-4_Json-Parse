package com.example.pertemuan4.json_volley.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.pertemuan4.json_volley.R;
import com.example.pertemuan4.json_volley.adapter.recyclerView;
import com.example.pertemuan4.json_volley.model.imdb_ind_film;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private String URL_JSON = "https://kelompok2.netlify.com/imdb_film.json";
    private JsonArrayRequest ArrayReq;
    private RequestQueue reqQueue;
    private List<imdb_ind_film> firstLst;
    private RecyclerView myRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstLst = new ArrayList<>();
        myRV=findViewById(R.id.RVCuy);
        jsonReq();

    }


    public void jsonReq()
    {
        ArrayReq = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObj = null;
                for (int i = 0; i < response.length(); i++) {

                    try {
                       jsonObj=response.getJSONObject(i);
                       imdb_ind_film imdb_anyar =new imdb_ind_film();
                       imdb_anyar.setJudul(jsonObj.getString("judul"));
                       imdb_anyar.setKategori(jsonObj.getString("kategori"));
                       imdb_anyar.setDeskripsi(jsonObj.getString("deskripsi"));
                       imdb_anyar.setRate(jsonObj.getString("rate"));
                       imdb_anyar.setSutradara(jsonObj.getString("sutradara"));
                       imdb_anyar.setImage_url(jsonObj.getString("img"));
                       firstLst.add(imdb_anyar);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
                setupRV(firstLst);

            }
            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){

                }
            });
            reqQueue = Volley.newRequestQueue(MainActivity.this);
            reqQueue.add(ArrayReq);

        }

    private void setupRV(List<imdb_ind_film> firstLst) {

        recyclerView myadapter = new recyclerView(this,firstLst);
        myRV.setLayoutManager(new LinearLayoutManager(this));
        myRV.setAdapter(myadapter);
    }
}

