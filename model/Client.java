/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.TypePerson;
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
        return "Client{" + "accounts=" + accounts + '}';
    }
    
    

    
}
