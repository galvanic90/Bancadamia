/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;
import com.tecnicas.control.Validator;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class CorrientAccount {
    private static int ID=0;
    private float balance=0;
    private float maxAmountPerTrans=500000;
    private float overdraft=50000;
    private final float MAXOVERDRAFT=this.overdraft;
    private int maxTransactions=3;
    private ArrayList<Register> registers = new ArrayList();

    public CorrientAccount() {
        addAccount();
    }
    
    public CorrientAccount(float balance) {
        this.balance = balance;
        addAccount();
    }
    
    private static void addAccount() {
        ID +=1;
    }
    
    public static int getID() {
        return ID;
    }
    
    public void deposit(float amount){
        if(Validator.isNoNegativo(amount)){
            if (MAXOVERDRAFT>overdraft){
                amount-=(MAXOVERDRAFT-overdraft);
                overdraft=MAXOVERDRAFT;
            }
            this.balance+=amount;
        }else{
            System.out.println("El deposito no se pudo realizar");
        }
    }
    
    public void withdrawal(float amount){
       if (Validator.isAbove(this.maxAmountPerTrans, amount) && Validator.isNoNegativo(amount)){
           if (Validator.hasAmount(this.balance, amount)){
               this.balance-=amount;
           } else if(Validator.hasAmount(this.balance+this.overdraft, amount)){
               this.overdraft-=(amount-this.balance);
               this.balance=0;
           } else{
               System.out.println("No se cuenta con el saldo suficiente para hacer el retiro");
           }
       }else{
           System.out.println("Su retiro supera la cantidad maxima por transacción o introdujo un valor invalido");
       }
    }

    private void saveRegister( String city){
        //TODO implementar
    }
    
    public float getBalance() {
        return balance;
    }

    public float getMaxAmountPerTrans() {
        return maxAmountPerTrans;
    }

    public float getOverdraft() {
        return overdraft;
    }

    public int getMaxTransactions() {
        return maxTransactions;
    }
    
    public ArrayList<Register> getRegisters() {
        return registers;
    }
    
    public Register getRegister(int id){
        
        //TODO implementar
        
        return new Register();
    }

    public void setMaxAmountPerTrans(float maxAmountPerTrans) {
        this.maxAmountPerTrans = maxAmountPerTrans;
    }

    public void setOverdraft(float overdraft) {
        this.overdraft = overdraft;
    }

    public void setMaxTransactions(int maxTransactions) {
        this.maxTransactions = maxTransactions;
    }

}
