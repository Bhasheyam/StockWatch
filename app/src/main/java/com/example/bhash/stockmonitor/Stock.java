package com.example.bhash.stockmonitor;

/**
 * Created by bhash on 25-07-2017.
 */

public class Stock {
    private String StockSys;
    private String CompanyName;
    private double Price;
    private double Pricechange;
    private double PercentageChange;
    double d;

    public void setPercentageChange(double percentageChange) {
        PercentageChange = percentageChange;
    }

    public void setPricechange(double pricechange) {
        Pricechange = pricechange;
    }

    public void setPrice(double price) {
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

    public double getPrice() {
        return Price;
    }

    public double getPricechange() {
        return Pricechange;
    }

    public double getPercentageChange() {
        return PercentageChange;
    }
    public String toString(){
        return StockSys+CompanyName+Price+Pricechange+PercentageChange;
    }

}
