package com.tecnicas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import com.tecnicas.model.CorrientAccount;

/**
 *
 * @author ricar
 */
public class Bancadamia {
    
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        System.out.println("Se comprueba que ID este funcinando");
        System.out.println(CorrientAccount.getID());
        CorrientAccount primera= new CorrientAccount();
        System.out.println("Se comprueba que ID este funcinando despues de instanciar un objecto");
        System.out.println(CorrientAccount.getID());
        System.out.println("Se obtienen los datos iniciales de la instancia");
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        System.out.println("Se hace un deposito");
        primera.deposit(40000);
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        System.out.println("Se hace un retiro que supere el balance");
        primera.withdrawal(60000);
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        System.out.println("Se comprueba que overdraft se rellena y el restante va para balance");
        primera.deposit(40000);
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        System.out.println("Caso de hacer un retiro invalido");
        primera.withdrawal(-40000);
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        System.out.println("Caso de hacer un deposito invalido");
        primera.deposit(-40000);
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        System.out.println("Caso de hacer un retiro con saldo insuficiente");
        primera.withdrawal(500000);
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        System.out.println("Caso de hacer un retiro que supera el monto maximo por transacción");
        primera.withdrawal(600000);
        System.out.println(primera.getBalance());
        System.out.println(primera.getOverdraft());
        
        
                
        
    }
}
