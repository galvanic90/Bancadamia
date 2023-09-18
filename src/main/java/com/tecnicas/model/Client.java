/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.model;

import com.tecnicas.control.TypePerson;
import java.util.ArrayList;
/**
 *
 * @author ricar
 */
public class Client extends Person {
    static int ID=0;
    public ArrayList<CorrientAccount> accounts;

    public Client(String fullName, TypePerson type) {
        super(fullName, type);
    }

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
