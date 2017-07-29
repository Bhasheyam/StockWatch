package com.example.bhash.stockmonitor;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

/**
 * Created by bhash on 29-07-2017.
 */

public class StockValue extends AsyncTask<String,Void,String> {
    public Context reference;
    private final String stocknameurl="http://finance.google.com/finance/info";


    public StockValue(Context c)
    {
        reference=c;
    }

    @Override
    protected String doInBackground(String... params) {
        Uri.Builder Stocksearch=Uri.parse(stocknameurl).buildUpon();
        Stocksearch.appendQueryParameter("client","info");
        Stocksearch.appendQueryParameter("q",params[0]);


        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

}
