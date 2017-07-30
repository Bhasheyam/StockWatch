package com.example.bhash.stockmonitor;

/**
 * Created by bhash on 25-07-2017.
 */

public class Stock {
    private String StockSys;
    private String CompanyName;
    private String Price;
    private String Pricechange;
    private String PercentageChange;
    double d;

    public void setPercentageChange(String percentageChange) {
        PercentageChange = percentageChange;
    }

    public void setPricechange(String pricechange) {
        Pricechange = pricechange;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setStockSys(String stockSys) {
        StockSys = stockSys;
    }


    public String getStockSys() {
        return StockSys;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getPrice() {
        return Price;
    }

    public String getPricechange() {
        return Pricechange;
    }

    public String getPercentageChange() {
        return PercentageChange;
    }
    public String toString(){
        return StockSys+CompanyName+Price+Pricechange+PercentageChange;
    }

}
