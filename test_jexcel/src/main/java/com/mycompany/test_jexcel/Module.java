/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author pc
 */
public class Module {
    private String codeModule;
    private String moduleName;
    private String cne;
    private String elementName1;    
    private String elementName2;
    private String dept_attachement;
    private String codeFiliere;

    public Module(Row row) {
        this.codeModule = row.getCell(0).getStringCellValue();
        this.moduleName = row.getCell(1).getStringCellValue();
        this.elementName1 =row.getCell(2).getStringCellValue();
        this.elementName2 = row.getCell(3).getStringCellValue();
        this.dept_attachement = row.getCell(4).getStringCellValue();
        this.codeFiliere = row.getCell(5).getStringCellValue();
        this.cne = row.getCell(6).getStringCellValue();       
    }

    public String getCodeModule() {
        return codeModule;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getNomProf() {
        return cne;
    }

    public String getElementName1() {
        return elementName1;
    }

    public String getElementName2() {
        return elementName2;
    }

    public String getDept_attachement() {
        return dept_attachement;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }
    
    
   
    
    
}
