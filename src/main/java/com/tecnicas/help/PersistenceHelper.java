/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.help;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author xaraxx
 */
public class PersistenceHelper {
    Gson gson = new Gson();
    
     public void save(Object item, String fileName){ 
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(item, writer);
        } catch (IOException ex) {
            Logger.getLogger(PersistenceHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
