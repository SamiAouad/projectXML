/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.io.IOException;


/**
 *
 * @author pc
 */
class MainClass {
    
    public static void main(String[] args) throws IOException{
        Filiere store = new Filiere("GINF1", "test");
        store.to_xml();
        
    }
    
}
