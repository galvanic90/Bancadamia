/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;

import java.util.Date;

/**
 *
 * @author ricar
 */
public class Register {
    private static int trasanctionId = 0;
    private Date transactionDate; 
    private String city;
    private String transactionType;
    private float amount;
    private CorrientAccount account;

    public Register(Date transactionDate, String city, String transactionType, float amount, CorrientAccount account) {
        this.transactionDate = transactionDate;
        this.city = city;
        this.transactionType = transactionType;
        this.amount = amount;
        this.account = account;
    }

    public static int getTrasanctionId() {
        return trasanctionId;
    }

    private static void setTrasanctionId(int trasanctionId) {
        Register.trasanctionId += 1;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public CorrientAccount getAccount() {
        return account;
    }

    public void setAccount(CorrientAccount account) {
        this.account = account;
    }
    
}
