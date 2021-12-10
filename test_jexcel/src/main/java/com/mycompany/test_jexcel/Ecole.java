/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pc
 */
public class Ecole {
    private String nom;
    private String path;
    private ArrayList<Filiere> filieres;
    private ArrayList<Prof> profs;

    public Ecole(String nom, String path) {
        this.filieres = new ArrayList<>();
        this.nom = nom;
        this.path = path;
        filieres.add(new Filiere("AP1", path));
        filieres.add(new Filiere("AP2", path));
        filieres.add(new Filiere("GINF1", path));
        filieres.add(new Filiere("GINF2", path));
        filieres.add(new Filiere("GINF3", path));
        
        filieres.add(new Filiere("GINF1", path));
        filieres.add(new Filiere("GINF2", path));
        filieres.add(new Filiere("GINF3", path));
        
        filieres.add(new Filiere("GIL1", path));
        filieres.add(new Filiere("GIL2", path));
        filieres.add(new Filiere("GIL3", path));
        
        filieres.add(new Filiere("GSTR1", path));
        filieres.add(new Filiere("GSTR2", path));
        filieres.add(new Filiere("GSTR3", path));
        
        filieres.add(new Filiere("G3EI1", path));
        filieres.add(new Filiere("G3EI2", path));
        filieres.add(new Filiere("G3EI3", path));
        
        filieres.add(new Filiere("GSEA1", path));
        filieres.add(new Filiere("GSEA2", path));
        filieres.add(new Filiere("GSEA3", path));
        
    }
    
    public void addStudents(String path){
        for (Filiere filiere : filieres){
            filiere.ajouter_students(path);
        }
    }
    
    public void generer_xml_students(){
        for(Filiere filiere : filieres){
            filiere.generate_xml_students();
        }
    }
    
    public void generer_xml(String code){
        for(Filiere filiere : filieres){
            if (filiere.getCode().equals(code))
                filiere.generate_xml_students();
        }
    }
    
    public void generer_xml_modules(){
        for(Filiere filiere : filieres){
            filiere.generate_xml_modules();
        }
    }
    
    public void generer_xml_modules(String code){
        for(Filiere filiere : filieres){
            if (filiere.getCode().equals(code))
                filiere.generate_xml_modules();
        }
    }
    
    public void addNotes(String path){
        for (Filiere filiere : filieres){
            filiere.ajouter_notes(path);
        }
    }
    
    public void generer_xml_notes(){
        for(Filiere filiere : filieres){
                filiere.generate_xml_notes();
        }
    }
    
    public void addProf(String path){
         try{
             profs = new ArrayList<>();
            FileInputStream fis = new FileInputStream(new File("C://ExcelTest/" + path + ".xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator < Row >  rowIterator = spreadsheet.iterator();
             Row row = (XSSFRow) rowIterator.next();

            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                  profs.add(new Prof(row));
            }
            fis.close();
        }catch(FileNotFoundException e){
            System.out.println("error");
        }catch(IOException e){
               System.out.println("error");
        }
    }
   
}
