/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author pc
 */
public class Prof {
    private String cne;
    private String firstName;
    private String lastName;
    private String dept_Attachement; 
    private String phone; 
    private String email;
    private ArrayList<Module> modules;
    
    public Prof(Row row) {
        this.modules = new ArrayList<>();
        this.cne = row.getCell(0).getStringCellValue();
        this.firstName =row.getCell(1).getStringCellValue();
        this.lastName = row.getCell(2).getStringCellValue();
        this.dept_Attachement = row.getCell(3).getStringCellValue();
        this.email = row.getCell(4).getStringCellValue();
        this.phone = row.getCell(5).getStringCellValue();
    }
    
    private void ajouterModule(Module module){
        modules.add(module);
    }
}
