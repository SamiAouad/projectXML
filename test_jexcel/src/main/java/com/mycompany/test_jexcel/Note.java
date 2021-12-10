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
class Note {
    private String cne;
    private String codeModule;
    private double note1;    
    private double note2;

    public Note(Row row) {
        this.cne = row.getCell(0).getStringCellValue();
        this.codeModule =row.getCell(1).getStringCellValue();
        this.note1 = row.getCell(2).getNumericCellValue();
        this.note2 = row.getCell(3).getNumericCellValue();
    }

    public String getCne() {
        return cne;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public double getNote1() {
        return note1;
    }

    public double getNote2() {
        return note2;
    }
    
}
