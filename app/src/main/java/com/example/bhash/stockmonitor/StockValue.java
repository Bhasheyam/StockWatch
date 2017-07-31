package com.example.bhash.stockmonitor;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;
import java.util.HashMap;

/**
 * Created by bhash on 29-07-2017.
 */

public class StockValue extends AsyncTask<String,Void,String> {
    public StockViewer reference;
    private final String stocknameurl="http://finance.google.com/finance/info";
       public HashMap<String,String> parsedata=new HashMap<>();
    private String res="no";
    public String dec;

    public boolean resultcheck=false;
    public Stock stock=new Stock();
    private static final String TAG = "StockValue";

    public StockValue(StockViewer c)
    {
        reference=c;
    }

    @Override
    protected String doInBackground(String... params) {
        dec=params[2];
        Log.d(TAG, "doInBackground: came to value "+params[0]+params[1]);
        Uri.Builder Stocksearch=Uri.parse(stocknameurl).buildUpon();
        Stocksearch.appendQueryParameter("client","ig");
        Stocksearch.appendQueryParameter("q",params[0]);
        String updated=Stocksearch.build().toString();
        StringBuilder jsonline=new StringBuilder();
        try{
            URL value=new URL(updated);
            HttpURLConnection connect=(HttpURLConnection)value.openConnection();
           connect.setRequestMethod("GET");
            InputStream read=connect.getInputStream();
            BufferedReader readit=new BufferedReader(new InputStreamReader(read));
            String emptyline;
            while((emptyline=readit.readLine())!=null){
                jsonline.append(emptyline).append('\n');
            }

        }
        catch (Exception e){
            e.getStackTrace();
        }
        String to=jsonline.substring(4).toString();
        Log.d(TAG, "doInBackground: "+to);
        Log.d(TAG, "doInBackground: "+params[1]);
        ExtractJson(to,params[1]);

        return res;
    }
    public void ExtractJson(String s,String s1){
        try{
            if(s.equals("httpserver.cc: Response Code 400")){
                res="yes";

            }
            else {
                Log.d(TAG, "ExtractJson: "+s1);

                JSONArray Result =new JSONArray(s);
                if (Result.length() == 0) {
                    resultcheck=true;
                } else {

                        JSONObject loopdata=(JSONObject)Result.get(0);
                    stock.setStockSys(loopdata.getString("t"));
                    stock.setPrice(loopdata.getString("l"));
                    stock.setPricechange(loopdata.getString("c"));
                    stock.setPercentageChange(loopdata.getString("cp"));
                    Log.d(TAG, "ExtractJson: "+loopdata.getString("t"));
                    stock.setCompanyName(s1);

                    }
                }
            } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }



    @Override
    protected void onPostExecute(String s) {
        if(res.equals("yes")){
            reference.Nostock();
        }else {
            reference.updateTask2(stock,dec);
        }

    }

}
