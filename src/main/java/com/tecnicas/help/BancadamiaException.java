/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.help;

/**
 *
 * @author xaraxx
 */
public class BancadamiaException extends RuntimeException {
    
    public BancadamiaException(String msg){
        super(msg);
    }
    
    public BancadamiaException(String message, Throwable cause){
        super(message, cause);
    }
    
}