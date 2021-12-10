/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author pc
 */
class MainClass {
    
    public static void main(String[] args) throws IOException{
//        Filiere filiere = new Filiere("GINF1", "test");
//        filiere.to_xml();
            Ecole ensat = new Ecole("ensat", "modules");
            ensat.addStudents("test");
            ensat.addNotes("notes");
            ensat.generer_xml_students();
    }
    
}
