/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import org.apache.fop.apps.FOPException;


/**
 *
 * @author pc
 */
class MainClass {
    
    public static void main(String[] args) throws IOException{
        Filiere filiere = new Filiere("GINF1", "test");
        
            Ecole ensat = new Ecole("ensat", "modules");
            ensat.addStudents("test");
            ensat.addNotes("notes");
            ensat.generer_xml_students();
            ensat.generer_xml_modules();
            ensat.generer_xml_notes();
//        User user = new User("R12");
//        try {
//            user.genereCarteEtu();
//        } catch (FOPException ex) {
//            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TransformerException ex) {
//            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
