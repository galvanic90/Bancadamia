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
        static final wellcome = """
  ____          _   _  _____          _____          __  __ _____          
 |  _ \   /\   | \ | |/ ____|   /\   |  __ \   /\   |  \/  |_   _|   /\    
 | |_) | /  \  |  \| | |       /  \  | |  | | /  \  | \  / | | |    /  \   
 |  _ < / /\ \ | . ` | |      / /\ \ | |  | |/ /\ \ | |\/| | | |   / /\ \  
 | |_) / ____ \| |\  | |____ / ____ \| |__| / ____ \| |  | |_| |_ / ____ \ 
 |____/_/    \_\_| \_|\_____/_/    \_\_____/_/    \_\_|  |_|_____/_/    \_\                                                                                                                                                   
""";

        
        System.out.println("Hello World!");
        System.out.println(CorrientAccount.getID());
        CorrientAccount primera= new CorrientAccount();
        System.out.println(CorrientAccount.getID());
        CorrientAccount segunda= new CorrientAccount(1000000000);
        System.out.println(CorrientAccount.getID());
        System.out.println(primera.getBalance());
        System.out.println(segunda.getBalance());
        System.out.println(primera.getOverdraft());
        System.out.println(segunda.getOverdraft());
    }
}
