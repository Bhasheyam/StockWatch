package com.example.bhash.stockmonitor;

import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by bhash on 27-07-2017.
 */

public class SymbolList extends AsyncTask<String,Void,String> {

    public Context reference;

    public SymbolList(Context c)
    {
        reference=c;
    }
    protected String doInBackground(String... params) {

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
