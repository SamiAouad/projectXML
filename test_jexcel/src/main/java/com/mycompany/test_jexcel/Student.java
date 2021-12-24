/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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
    private int phone;
   private LocalDate dateNaiss;   
   private LocalDate dateInscription;
   private String classe;
   private String image;
   private ArrayList<Note> notes;

    public Student(Row row) {
        this.notes = new ArrayList<>();
        this.cne = row.getCell(0).getStringCellValue();
        this.nom =row.getCell(1).getStringCellValue();
        this.prenom = row.getCell(2).getStringCellValue();
        this.dateNaiss = row.getCell(3).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.email = row.getCell(4).getStringCellValue();
        this.classe = row.getCell(5).getStringCellValue();
        this.phone = (int)row.getCell(6).getNumericCellValue();
         this.dateInscription = row.getCell(7).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       this.image = "images/" + this.cne + ".jpg";
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

    public int getPhone() {
        return phone;
    }

   

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    
   

    public String getClasse() {
        return classe;
    }

    public String getImage() {
        return image;
    }
    
    public boolean sansNotes(){
        return notes.isEmpty();
    }

   public void ajouterNotes(Note note){
       if (note.getCne().equals(cne)){
           this.notes.add(note);
       }
   }

    public ArrayList<Note> getNotes() {
        return notes;
    }
   
   

}
