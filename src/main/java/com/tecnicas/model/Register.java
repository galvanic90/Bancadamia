/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;

import com.tecnicas.control.Transaction;
import java.util.Date;

/**
 *
 * @author ricar
 */
public class Register {
    private static int transactionId = 0;
    private Date date; 
    private String city;
    private Transaction type;
    private float amount;
    private CorrientAccount account;

    public Register(Date date, String city, Transaction type, float amount, CorrientAccount account) {
        this.date = date;
        this.city = city;
        this.type = type;
        this.amount = amount;
        this.account = account;
    }
    
    private static void addTransactionId(){
        Register.transactionId += 1; 
    }
    
    public static int getTransactionId() {
        return transactionId;
    }

    public Date getDate() {
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

    public CorrientAccount getAccount() {
        return account;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Register{");
        sb.append("transactionId").append(transactionId);
        sb.append(", date=").append(date);
        sb.append(", city=").append(city);
        sb.append(", type=").append(type);
        sb.append(", amount=").append(amount);
        sb.append(", account=").append(account);
        sb.append('}');
        return  sb.toString();
    }

    
    
}
