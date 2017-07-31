package com.example.bhash.stockmonitor;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.ArrayList;

/**
 * Created by bhash on 25-07-2017.
 */

public class Stockviewhandler extends RecyclerView.Adapter<StockViewholder>{
    public ArrayList<Stock> viewdata;
    public StockViewer ref;
    private static final String TAG = "Stockviewhandler";
    public Stockviewhandler(ArrayList<Stock> data,StockViewer s){
        viewdata=data;
        ref=s;
    }

    @Override
    public StockViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Came");
        View stockitem= LayoutInflater.from(parent.getContext()).inflate(R.layout.stockcards,parent,false);
        stockitem.setOnLongClickListener(ref);
        stockitem.setOnClickListener(ref);
        return new StockViewholder(stockitem);
    }

    @Override
    public void onBindViewHolder(StockViewholder holder, int position) {
        Stock temp=viewdata.get(position);
        String temps=temp.getPricechange().substring(0,1);
        if(temps.equals("+")){
            holder.setTheme1();
        }else if (temps.equals("-")){
            holder.setTheme2();
        }else{
            holder.setTheme3();
        }
        holder.t1.setText(temp.getStockSys());
        holder.t2.setText(temp.getCompanyName());
        holder.p1.setText(temp.getPrice());
        holder.p3.setText(temp.getPricechange());
        holder.p4.setText("("+temp.getPercentageChange()+")");
        Log.d(TAG, "onBindViewHolder: Came and setup the Recycle view");


    }

    @Override
    public int getItemCount() {
        return viewdata.size();
    }
}
