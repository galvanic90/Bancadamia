/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;

import com.tecnicas.control.TypePerson;
import com.tecnicas.help.PersistenceHelper;
import java.util.ArrayList;
/**
 *
 * @author ricar
 */
public class Client extends Person {
    static int ID=0;
    public ArrayList<CorrientAccount> accounts=new ArrayList();
    static final String CORRIENT_ACCOUNT_FILE = "corrient-account.json";
    PersistenceHelper persistence = new PersistenceHelper();
    
    public Client(String fullName, TypePerson type) {
        super(fullName, type);
    }
    
    private void saveAccount( CorrientAccount account){
        this.accounts.add(account);
        persistence.save(accounts, CORRIENT_ACCOUNT_FILE);
    }
    
    /*public void loadAccounts(){
        this.accounts = persistence.load(CORRIENT_ACCOUNT_FILE), new TypeToken<ArrayList<CorrientAccount>>() {}.getType());
    }*/
    
    public static int getID() {
        return ID;
    }

    public static void addClient() {
        Client.ID = ID+1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client{");
        sb.append("accounts=").append(accounts);
        sb.append('}');
        return sb.toString();
    }
    
    
   
    
    

    
}
