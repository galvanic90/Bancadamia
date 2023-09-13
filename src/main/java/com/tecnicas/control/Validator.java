/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.control;

/**
 * Administra las validaciones del sistema. 
 * @author Ricardo Contreras
 * @version 1.0
 */
public abstract class Validator {
    
    
    /**
    *Analiza si una cantidad es negativa.
    *@param amount cantidad a la cual se hace el analisis.
    *@return booleano.
    */
    public static boolean isNoNegativo(float amount){
        return amount >= 0;
    }
    
    
    
    
}
