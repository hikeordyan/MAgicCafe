
package model;

import java.util.Date;


public class Report {
    
    private int day;
    private double money;

    public Report(int day, double money) {
        this.day = day;
        this.money = money;
    }

    public Report() {
    }

    public int getData() {
        return day;
    }

    public void setData(int data) {
        this.day = data;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return day+" - "+money; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
