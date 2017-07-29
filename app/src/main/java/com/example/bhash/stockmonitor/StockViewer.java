package com.example.bhash.stockmonitor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class StockViewer extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

private RecyclerView r1;
    private ArrayList<Stock> maindata;
    private Stockviewhandler adapter;
    private SwipeRefreshLayout s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_viewer);
        r1=(RecyclerView)findViewById(R.id.R1);
        maindata=new ArrayList<Stock>();
        adapter=new Stockviewhandler(maindata,this);
        r1.setLayoutManager(new LinearLayoutManager(this));
        s1=(SwipeRefreshLayout)findViewById(R.id.s1);
        r1.setAdapter(adapter);
        /*Stock s=new Stock();
        s.setCompanyName("hello");
        maindata.add(s);
        Stock s1=new Stock();
        s1.setCompanyName("hello");
        maindata.add(s1);
        adapter.notifyDataSetChanged();*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater f=getMenuInflater();
        f.inflate(R.menu.addmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:
             if(isConnected()) {

                 AlertDialog.Builder userinput = new AlertDialog.Builder(this);
                 final EditText ed=(EditText)new EditText(this);
                 ed.setInputType(InputType.TYPE_CLASS_TEXT);
                 ed.setGravity(Gravity.CENTER_HORIZONTAL);
                 userinput.setView(ed);
                 userinput.setTitle("Stock Selection");
                 userinput.setMessage("Please eneter a Stock Symbol");
                 userinput.setPositiveButton("Ok",new DialogInterface.OnClickListener(){

                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         ArrayList<>


                     }
                 });
                 userinput.setPositiveButton("Close",new DialogInterface.OnClickListener(){

                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         //Do nothing
                     }
                 });
             }
                else{
                 AlertDialog.Builder userinput = new AlertDialog.Builder(this);
                 userinput.setMessage("No Network Connection");
                 userinput.setMessage("Stock Cannot be added without Internet Connection");
                 userinput.setPositiveButton("close",new DialogInterface.OnClickListener(){

                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }
                 });
                 AlertDialog d=userinput.create();
                 d.show();

             }

        }
        return super.onOptionsItemSelected(item);
    }
    public  boolean isConnected()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        final int i=r1.getChildLayoutPosition(v);
        AlertDialog.Builder deleteit=new AlertDialog.Builder(this);
        deleteit.setMessage("Do you want to Delete the Stock?");
        deleteit.setTitle("Delete");
        deleteit.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                maindata.remove(i);
                adapter.notifyDataSetChanged();
            }

        });
        deleteit.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog deletealret=deleteit.create();
        deletealret.show();

        return true;
    }
}
