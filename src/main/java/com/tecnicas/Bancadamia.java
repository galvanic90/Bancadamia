package com.tecnicas;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import com.tecnicas.help.PersistenceHelper;
import com.tecnicas.model.Client;
import com.tecnicas.model.CorrientAccount;
import com.tecnicas.view.MainUserInterface;
import java.util.ArrayList;
/**
 *
 * @author ricar
 */
public class Bancadamia {
    
    public ArrayList<Client> clients= new ArrayList();
    static final String CLIENT_FILE = "clients.json";
    PersistenceHelper persistence = new PersistenceHelper();
    
    private void saveClient( Client client){
        this.clients.add(client);
        persistence.save(clients, CLIENT_FILE);
    }
    
    public static void main(String[] args) {
        MainUserInterface.mainUI();
        System.out.println("Se comprueba que ID este funcinando");
        System.out.println("La cantidad de instancias en la clase CorrientAccount es : "+CorrientAccount.getID());
        CorrientAccount primera= new CorrientAccount();
        System.out.println("\nSe comprueba que ID este funcinando despues de instanciar un objecto");
        System.out.println("La cantidad de instancias en la clase CorrientAccount es : "+CorrientAccount.getID());
        
        System.out.println("\nSe obtienen los datos iniciales de la instancia");
        System.out.println(primera);
       
        System.out.println("\nSe hace un deposito de 40000.");
        primera.deposit(40000);
        System.out.println(primera);
        
        System.out.println("\nSe hace un retiro que supere el balance, es decir se retira 60000");
        primera.withdrawal(60000);
        System.out.println(primera);
        
        System.out.println("\nSe hace un deposito de 40000 y se comprueba que overdraft se rellena y el restante va para balance");
        primera.deposit(40000);
        System.out.println(primera);
   
        
        System.out.println("\nCaso de hacer un retiro invalido: se intenta hacer un retiro de -40000.");
        System.out.println("\nEl mensaje que se lanza es: ");
        primera.withdrawal(-40000);
        System.out.println("Se vuelven a mostrar los datos de la instancia.");
        System.out.println(primera);
      
        
        System.out.println("\nCaso de hacer un deposito invalido: se intenta hacer un deposito de -40000.");
        System.out.println("\nEl mensaje que se lanza es: ");
        primera.deposit(-40000);
        System.out.println("Se vuelven a mostrar los datos de la instancia.");
        System.out.println(primera);
        
        System.out.println("\nCaso de hacer un retiro con saldo insuficiente. Se intenta retirar 500000 y se puede notar que esta cantidad supera el balance y el overdraft");
        System.out.println("\nEl mensaje que se lanza es: ");
        primera.withdrawal(500000);
        System.out.println("Se vuelven a mostrar los datos de la instancia.");
        System.out.println(primera);
        
        System.out.println("\nCaso de hacer un retiro que supera el monto maximo por transacción: se intenta retirar 600000");
        System.out.println("\nEl mensaje que se lanza es: ");
        primera.withdrawal(600000);
        System.out.println("Se vuelven a mostrar los datos de la instancia.");
        System.out.println(primera);
        
        System.out.println("\nNoten que transactions es 3 y la cantidad maxima de transaciones es 3. Por tanto la siguiente trasacción no deberia hacerse.");
        primera.deposit(40000);
        System.out.println(primera);
        
       
        System.out.println(primera.getRegisters());
         
    }
}
