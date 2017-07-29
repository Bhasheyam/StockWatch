package com.example.bhash.stockmonitor;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by bhash on 25-07-2017.
 */

public class StockViewholder extends RecyclerView.ViewHolder {
    public TextView t1;
    public TextView t2;
    public   TextView p1;
    public TextView p2;
    public TextView p3;
    public TextView p4;
    public StockViewholder(View itemView) {
        super(itemView);
        t1=(TextView)itemView.findViewById(R.id.t1);
        t2=(TextView)itemView.findViewById(R.id.t2);
        p1=(TextView)itemView.findViewById(R.id.p1);
        p2=(TextView)itemView.findViewById(R.id.p2);
        p3=(TextView)itemView.findViewById(R.id.p3);
        p4=(TextView)itemView.findViewById(R.id.p4);



    }
}
