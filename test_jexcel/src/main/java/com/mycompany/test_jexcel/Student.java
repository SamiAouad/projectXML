/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.util.Date;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author pc
 */
public class Student {
    private String cne;
    private String nom;
    private String prenom;
     private String email;
     private String phone;
   private Date date;
   private String classe;

    public Student(Row row) {
        this.cne = row.getCell(0).getStringCellValue();
        this.nom =row.getCell(1).getStringCellValue();
        this.prenom = row.getCell(2).getStringCellValue();
        this.email = row.getCell(4).getStringCellValue();
        this.classe = row.getCell(5).getStringCellValue();
        this.phone = row.getCell(6).getStringCellValue();
        this.date = row.getCell(3).getDateCellValue();
    }

    public String getCne() {
        return cne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDate() {
        return date;
    }

    public String getClasse() {
        return classe;
    }

    
    
}
