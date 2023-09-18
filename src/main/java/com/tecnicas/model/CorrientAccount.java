/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;
import com.google.gson.reflect.TypeToken;
import com.tecnicas.control.Transaction;
import com.tecnicas.control.Validator;
import com.tecnicas.help.PersistenceHelper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricar
 */
public class CorrientAccount {
    
    private static int ID=0;
    private int id;
    private float balance=0;
    private float maxAmountPerTrans=500000;
    private float overdraft=50000;
    private float maxOverdraft=this.overdraft;
    private int maxTransactions=3;
    private int transactions=0;
    private ArrayList<Register> registers = new ArrayList();
    static final String TRANSACTION_REGISTER_FILE = "transaction-register.json";
    
    PersistenceHelper persistence = new PersistenceHelper();
    
    public ArrayList registerTransactionOp(ArrayList<Register> registers){
        return this.registers = registers;
    }
            
    public CorrientAccount() {
        addAccount();
        this.id=ID;
    }
    
    public CorrientAccount(float balance) throws InstantiationException {
        
        if (Validator.isNoNegativo(balance)){
            addAccount();
            this.balance = balance;
            this.id=ID;
        }else{
            throw new InstantiationException("Se intento inicializar una instancia con saldo negativo");
        }
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
    
    private String dateToString(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        
        return formattedDate;
    }
    
    public void deposit(float amount){
        
        String date = dateToString();
        
        if(Validator.isNoNegativo(amount)){
            if(transaction()){
                
                Register register = new Register(date, "medellín", Transaction.DEPOSIT, amount,this.id);
                System.out.println(register);
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
        
       String date = dateToString();
       if (Validator.isAbove(this.maxAmountPerTrans, amount) && Validator.isNoNegativo(amount)){
           
           if (Validator.hasAmount(this.balance, amount)){
                if(transaction()){
                    Register register = new Register(date, "medellín", Transaction.WITHDRAWAL, amount,this.id);
                    this.saveRegister(register);
                    this.balance-=amount;
                }else{
                    System.out.println("Se han cumplido con las transacciones por dia");
                }
           } else if(Validator.hasAmount(this.balance+this.overdraft, amount)){
                if (transaction()){
                    Register register = new Register(date, "medellín", Transaction.WITHDRAWAL, amount,this.id);
                    System.out.println(register);
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
        persistence.save(registers, TRANSACTION_REGISTER_FILE);
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
        registers = loadTransactionsRegistered();
        return registers;
    }
    
        
    public ArrayList<Register> loadTransactionsRegistered(){
        return registers = persistence.load(TRANSACTION_REGISTER_FILE, new TypeToken<ArrayList<Register>>() {}.getType());
    }
    
    /*public Register getRegister(int id){
        
        //TODO implementar
        
        return new Register();
    }*/

    public void setMaxAmountPerTrans(float maxAmountPerTrans) {
        if(Validator.isNoNegativo(maxAmountPerTrans)){
            this.maxAmountPerTrans = maxAmountPerTrans;
        }else{
            throw new IllegalArgumentException("Se introdujo un valor negativo al metodo.");
        }
        
    }

    public void setOverdraft(float overdraft) {
        if(Validator.isNoNegativo(overdraft)){
            this.overdraft = overdraft;
            
            if(overdraft>maxOverdraft){
                this.maxOverdraft=overdraft;
            }
        }else{
            throw new IllegalArgumentException("Se introdujo un valor negativo al metodo.");
        }
        
    }

    public void setMaxTransactions(int maxTransactions) {
        if (Validator.isNoNegativo(maxTransactions)){
            this.maxTransactions = maxTransactions;
        }else{
            throw new IllegalArgumentException("Se introdujo un valor negativo al metodo.");
        }
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CorrientAccount{");
        sb.append("balance=").append(Float.toString(balance));
        sb.append(", maxAmountPerTrans=").append(Float.toString(maxAmountPerTrans));
        sb.append(", overdraft=").append(Float.toString(overdraft));
        sb.append(", maxOverdraft=").append(Float.toString(maxOverdraft));
        sb.append(", maxTransactions=").append(Integer.toString(maxTransactions));
        sb.append(", transactions=").append(Integer.toString(transactions));
        sb.append(", registers=").append(registers);
        sb.append('}');
        return sb.toString();
    }


    
    
}
