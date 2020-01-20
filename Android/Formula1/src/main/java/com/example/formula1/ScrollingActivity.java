package com.example.formula1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class ScrollingActivity extends AppCompatActivity {

    String data;
    ProgressDialog p;
    List<String> values = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = rd.read()) != -1) {
            sb.append((char) c);
        }
        return sb.toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);


        JSONObject json = null;
        try {
            json = new FetchData().execute().get();
            //  json.getString("series");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JSONObject json1 = null;
        String jsonstring = "a";
        String jsonpoints = "a";
        List<String>  names = new ArrayList<String>();
        List<String>  points = new ArrayList<String>();
        try {
            json1 = (JSONObject)(json.getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists").get(0));
            JSONArray jsonr = json1.getJSONArray("DriverStandings");

            for(int i = 0; i<20; i++)
            {
                JSONObject json0 = (JSONObject)(jsonr.get(i));
                jsonstring = json0.getJSONObject("Driver").getString("familyName");
                points.add(jsonstring);
            }

            for(int j = 0; j<20; j++)
            {
                JSONObject json0 = (JSONObject)(jsonr.get(j));
                jsonpoints = json0.getString("points");
                names.add(jsonpoints);
            }


        } catch (final JSONException e) {
            e.printStackTrace();
        }
        ListView lv = (ListView) findViewById(R.id.standings);

        for(int i = 0; i<8; i++)
        {
            values.add("");
        }

        for(int i = 0; i<names.size(); i++)
        {
            values.add(points.get(i)+": "+names.get(i));
        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);

        lv.setAdapter(adapter);


/*
String json1 = null;

    try{
          json1 = json.getString("series");
        }
          catch (final JSONException e) {
            e.printStackTrace();
        }
         TextView tv = (TextView)findViewById(R.id.standingstext);
          tv.setText(json1);

    }
*/
    }

        private class FetchData extends AsyncTask<String, String, JSONObject> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                /*p = new ProgressDialog(ScrollingActivity.this);
                p.setMessage("Loading...");
                p.setIndeterminate(false);
                p.setCancelable(false);
                p.show();*/
            }

            public JSONObject readJsonUrl(String url) throws IOException, JSONException {
                InputStream is = new URL(url).openStream();
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                    String jsonText = readAll(br);
                    JSONObject json = new JSONObject(jsonText);
                    return json;
                } finally {
                    is.close();
                }

            }

            @Override
            protected JSONObject doInBackground(String... strings) {
                try {
                    JSONObject json = readJsonUrl("https://ergast.com/api/f1/current/driverStandings.json");
                    return json;
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(JSONObject json) {
                   // p.hide();

            }
        }



}