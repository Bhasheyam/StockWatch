package com.example.bhash.stockmonitor;

import android.support.v7.widget.RecyclerView;
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
    public Stockviewhandler(ArrayList<Stock> data,StockViewer s){
        viewdata=data;
        ref=s;
    }

    @Override
    public StockViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View stockitem= LayoutInflater.from(parent.getContext()).inflate(R.layout.stockcards,parent,false);
        stockitem.setOnLongClickListener(ref);
        stockitem.setOnClickListener(ref);
        return new StockViewholder(stockitem);
    }

    @Override
    public void onBindViewHolder(StockViewholder holder, int position) {
        Stock temp=viewdata.get(position);
        holder.t1.setText(temp.getStockSys());
        holder.t2.setText(temp.getCompanyName());
        holder.p1.setText(Double.toString(temp.getPrice()));
        holder.p3.setText(Double.toString(temp.getPricechange()));
        holder.p4.setText(Double.toString(temp.getPercentageChange()));


    }

    @Override
    public int getItemCount() {
        return viewdata.size();
    }
}
