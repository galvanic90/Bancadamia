/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;

import com.tecnicas.control.Transaction;

/**
 *
 * @author ricar
 */
public class Register {
    private static int transactionId = 0;
    private String date; 
    private String city;
    private Transaction type;
    private float amount;
    private int accountId;

    public Register(String date, String city, Transaction type, float amount, int accountId) {
        this.date = date;
        this.city = city;
        this.type = type;
        this.amount = amount;
        this.accountId = accountId;
    }
    
    private static void addTransactionId(){
        Register.transactionId += 1; 
    }
    
    public static int getTransactionId() {
        return transactionId;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public Transaction getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public int getAccountID() {
        return accountId;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Register{");
        sb.append("transactionId=").append(Integer.toString(transactionId));
        sb.append(", date=").append(date);
        sb.append(", city=").append(city);
        sb.append(", type=").append(type);
        sb.append(", amount=").append(Float.toString(amount));
        sb.append(", accountId=").append(accountId);
        sb.append("}");
        return  sb.toString();
    }

    
    
}
