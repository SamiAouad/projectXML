/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import com.sun.tools.javac.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;


/**
 *
 * @author pc
 */
public class XMLParser {
    File file;
    FileInputStream fis;
    static XSSFRow row;
    

    public XMLParser() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(new File("C://ExcelTest/test.xlsx"));
      
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator < Row >  rowIterator = spreadsheet.iterator();
      
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator < Cell >  cellIterator = row.cellIterator();

            while ( cellIterator.hasNext()) {
               Cell cell = cellIterator.next();
               System.out.println(cell.getNumericCellValue());
           }
           System.out.println();
        }
        fis.close();
    }
}
