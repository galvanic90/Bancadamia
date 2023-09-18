/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;
import com.tecnicas.control.Transaction;
import com.tecnicas.control.Validator;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author ricar
 */
public class CorrientAccount {
    private static int ID=0;
    private float balance=0;
    private float maxAmountPerTrans=500000;
    private float overdraft=50000;
    private float maxOverdraft=this.overdraft;
    private int maxTransactions=3;
    private int transactions=0;
    private final ArrayList<Register> registers = new ArrayList();

    public CorrientAccount() {
        addAccount();
    }
    
    public CorrientAccount(float balance) throws InstantiationException {
        
        if (Validator.isNoNegativo(balance)){
            this.balance = balance;
            addAccount();
        }
        
        throw new InstantiationException("Se intento inicializar una instancia con saldo negativo");
    }
    
    private static void addAccount() {
        ID +=1;
    }
    
    public static int getID() {
        return ID;
    }
    
    private boolean transaction(){
        if (maxTransactions>transactions){
            transactions+=1;
            return true;
        }else if (maxTransactions==transactions){
            return false;
            //Falta organizar lo del dia.
            //transactions=0;
        }
        return false;
    }
    
    public void deposit(float amount){
        
        Date date=new Date();
        if(Validator.isNoNegativo(amount)){
            if(transaction()){
                
                Register register = new Register(date, "medellín", Transaction.DEPOSIT, amount,this);
                this.saveRegister(register);
                
                if (maxOverdraft>overdraft){
                amount-=(maxOverdraft-overdraft);
                overdraft=maxOverdraft;
                }
                
                this.balance+=amount;
                
            }else{
                System.out.println("Se han cumplido con las transacciones por dia");
            }
        }else{
            System.out.println("El deposito no se pudo realizar");
        }
    }
    
    public void withdrawal(float amount){
        
       Date date=new Date();
       if (Validator.isAbove(this.maxAmountPerTrans, amount) && Validator.isNoNegativo(amount)){
           
           if (Validator.hasAmount(this.balance, amount)){
                if(transaction()){
                    Register register = new Register(date, "medellín", Transaction.WITHDRAWAL, amount,this);
                    this.saveRegister(register);
                    this.balance-=amount;
                }else{
                    System.out.println("Se han cumplido con las transacciones por dia");
                }
           } else if(Validator.hasAmount(this.balance+this.overdraft, amount)){
                if (transaction()){
                    Register register = new Register(date, "medellín", Transaction.WITHDRAWAL, amount,this);
                    this.saveRegister(register);
                    this.overdraft-=(amount-this.balance);
                    this.balance=0;
                    
                }else{
                    System.out.println("Se han cumplido con las transacciones por dia");
                }
             
           } else{
               System.out.println("No se cuenta con el saldo suficiente para hacer el retiro");
           }
       }else{
           System.out.println("Su retiro supera la cantidad maxima por transacción o introdujo un valor invalido");
       }
    }

    //Deberia ser privada porque esto se define dentro de los
    //metodos depositar y retirar
    private void saveRegister( Register register){
        this.registers.add(register);
    }
    
    //public ArrayList<Register> showRegisters(Date initialdate, Date finaldate){
    //    for (Register registro : registers) {
    //        registro.getDate().;
    //    }
    //} 
    
    public float getMaxOverdraft() {
        return maxOverdraft;
    }

    public int getTransactions() {
        return transactions;
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
    
    /*public Register getRegister(int id){
        
        //TODO implementar
        
        return new Register();
    }*/

    public void setMaxAmountPerTrans(float maxAmountPerTrans) {
        if(Validator.isNoNegativo(maxAmountPerTrans)){
            this.maxAmountPerTrans = maxAmountPerTrans;
        }
        throw new IllegalArgumentException("Se introdujo un valor negativo al metodo.");
    }

    public void setOverdraft(float overdraft) {
        if(Validator.isNoNegativo(overdraft)){
            this.overdraft = overdraft;
            
            if(overdraft>maxOverdraft){
                this.maxOverdraft=overdraft;
            }
        }
        throw new IllegalArgumentException("Se introdujo un valor negativo al metodo.");
    }

    public void setMaxTransactions(int maxTransactions) {
        if (Validator.isNoNegativo(maxTransactions)){
            this.maxTransactions = maxTransactions;
        }
        throw new IllegalArgumentException("Se introdujo un valor negativo al metodo.");
    }

    @Override
    public String toString() {
        return "CorrientAccount{" + "balance=" + balance + ", maxAmountPerTrans=" + maxAmountPerTrans + ", overdraft=" + overdraft + ", transactions=" + transactions + '}';
    }
    
    
    
}
