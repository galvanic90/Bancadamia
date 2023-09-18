/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicas.model;

import com.tecnicas.control.TypePerson;

/**
 *
 * @author ricar
 */
public class Person {
    private String fullName;
    private TypePerson type;

    public Person(String fullName, TypePerson type) {
        this.fullName = fullName;
        this.type = type;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public TypePerson getType() {
        return type;
    }

    public void setType(TypePerson type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("fullName=").append(fullName);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

  
    
    
}
