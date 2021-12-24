/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import static com.mycompany.test_jexcel.MyFileUtilities.formatXML;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.TransformerException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author pc
 */
public class Filiere {
   private String code;
   private  ArrayList<Student> students_list;   
   private  ArrayList<Module> modules_list;
   private ArrayList<Note> notes_list;


    public Filiere(String code, String path) {
        this.students_list = new ArrayList<>();
        this.code = code;
        try{
            modules_list = new ArrayList<>();
            FileInputStream fis = new FileInputStream(new File("C://ExcelTest/" + path + ".xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator < Row >  rowIterator = spreadsheet.iterator();
             Row row = (XSSFRow) rowIterator.next();

            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                if (row.getCell(5).getStringCellValue().equals(code))
                    modules_list.add(new Module(row));
            }
            fis.close();
        }
        catch(FileNotFoundException e){
            System.out.println("error");
        }catch(IOException e){
               System.out.println("error");
        }
    }
    
    public void ajouter_students(String path)  {
        try{
             students_list = new ArrayList<>();
            FileInputStream fis = new FileInputStream(new File("C://ExcelTest/" + path + ".xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator < Row >  rowIterator = spreadsheet.iterator();
             Row row = (XSSFRow) rowIterator.next();

            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                if (row.getCell(5).getStringCellValue().equals(code))
                    students_list.add(new Student(row));
            }
            fis.close();
        }catch(FileNotFoundException e){
            System.out.println("error");
        }catch(IOException e){
               System.out.println("error");
        }
    }
    
     public void ajouter_notes(String path)  {
        try{
             notes_list = new ArrayList<>();
            FileInputStream fis = new FileInputStream(new File("C://ExcelTest/" + path + ".xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator < Row >  rowIterator = spreadsheet.iterator();
             Row row = (XSSFRow) rowIterator.next();

            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                for (Module module: modules_list){
                    if (row.getCell(1).getStringCellValue().equals(module.getCodeModule())){
                         notes_list.add(new Note(row));
                    }
                }
                for (Student student : this.students_list){
                    student.ajouterNotes(new Note(row));
                }
            }
            fis.close();
        }catch(FileNotFoundException e){
            System.out.println("error");
        }catch(IOException e){
               System.out.println("error");
        }
    }
    public void generate_xml_students(){
        try{
            StringWriter stringWriter = new StringWriter();
            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter =  xMLOutputFactory.createXMLStreamWriter(stringWriter);
            xMLStreamWriter.writeStartDocument("utf-8", "1.0");
            xMLStreamWriter.writeStartElement("students");
                for (Student p : students_list){
                    xMLStreamWriter.writeStartElement("student");
                        xMLStreamWriter.writeAttribute("CNE", "" + p.getCne());
                        //================================
                        StringTokenizer st = new StringTokenizer(p.getNom());
                        while (st.hasMoreTokens()) {
                            xMLStreamWriter.writeStartElement("nom");
                                xMLStreamWriter.writeCharacters(st.nextToken());
                            xMLStreamWriter.writeEndElement();
                        }
                        //================================
                       st = new StringTokenizer(p.getPrenom());
                        while (st.hasMoreTokens()) {
                            xMLStreamWriter.writeStartElement("prenom");
                                xMLStreamWriter.writeCharacters(st.nextToken());
                            xMLStreamWriter.writeEndElement();
                        }
                        //=======================================
                        xMLStreamWriter.writeStartElement("dateDeNaiss");
                            xMLStreamWriter.writeStartElement("year");
                                xMLStreamWriter.writeCharacters("" + p.getDateNaiss().getYear());
                            xMLStreamWriter.writeEndElement();
                            
                            xMLStreamWriter.writeStartElement("month");
                                xMLStreamWriter.writeCharacters("" + p.getDateNaiss().getMonthValue());
                            xMLStreamWriter.writeEndElement();
                            
                            xMLStreamWriter.writeStartElement("day");
                                xMLStreamWriter.writeCharacters("" + p.getDateNaiss().getDayOfMonth());
                            xMLStreamWriter.writeEndElement();
                        xMLStreamWriter.writeEndElement();
                        //======================================
                        xMLStreamWriter.writeStartElement("email");
                            xMLStreamWriter.writeCharacters(p.getEmail());
                        xMLStreamWriter.writeEndElement();
                        //======================================
                        xMLStreamWriter.writeStartElement("classeName");
                            xMLStreamWriter.writeCharacters(p.getClasse());
                        xMLStreamWriter.writeEndElement();
                        //======================================
                        xMLStreamWriter.writeStartElement("phone");
                            xMLStreamWriter.writeCharacters("0" + p.getPhone());
                        xMLStreamWriter.writeEndElement();
                        //=======================
                        xMLStreamWriter.writeStartElement("image");
                            xMLStreamWriter.writeCharacters(p.getImage());
                        xMLStreamWriter.writeEndElement();
                        //=======================
                        xMLStreamWriter.writeStartElement("dateInscription");
                            xMLStreamWriter.writeStartElement("year");
                                xMLStreamWriter.writeCharacters("" + p.getDateInscription().getYear());
                            xMLStreamWriter.writeEndElement();
                            
                            xMLStreamWriter.writeStartElement("month");
                                xMLStreamWriter.writeCharacters("" + p.getDateInscription().getMonthValue());
                            xMLStreamWriter.writeEndElement();
                            
                            xMLStreamWriter.writeStartElement("day");
                                xMLStreamWriter.writeCharacters("" + p.getDateInscription().getDayOfMonth());
                            xMLStreamWriter.writeEndElement();
                        xMLStreamWriter.writeEndElement();
                        //======================================
                      xMLStreamWriter.writeEndElement();
                }
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();
            
            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            stringWriter.close();
            
            Files.createDirectories(Paths.get("students"));
            
            FileWriter file = new FileWriter("students/" + "students_" + this.code + ".xml");
            xmlString = formatXML(xmlString);
            file.write(xmlString);
            file.close();
        }
        catch(XMLStreamException e){
            System.out.println("Exception not supported yet");
        }
        catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
        catch(TransformerException e){
            System.out.println("error");
        }
    }
    
    public void generate_xml_modules(){
        try{
            StringWriter stringWriter = new StringWriter();
            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter =  xMLOutputFactory.createXMLStreamWriter(stringWriter);
            xMLStreamWriter.writeStartDocument("utf-8", "1.0");
            xMLStreamWriter.writeStartElement("modules");
                for (Module p : modules_list){
                    xMLStreamWriter.writeStartElement("module");
                        xMLStreamWriter.writeAttribute("codeModule", "" + p.getCodeModule());
                        xMLStreamWriter.writeAttribute("codeFiliere", "" + p.getCodeFiliere());
                        //================================
                        xMLStreamWriter.writeStartElement("moduleName");
                            xMLStreamWriter.writeCharacters(p.getModuleName());
                        xMLStreamWriter.writeEndElement();
                        //================================
                        xMLStreamWriter.writeStartElement("element1");
                            xMLStreamWriter.writeCharacters(p.getElementName1());
                        xMLStreamWriter.writeEndElement();
                        //=======================================
                        xMLStreamWriter.writeStartElement("element2");
                            xMLStreamWriter.writeCharacters(p.getElementName2());
                        xMLStreamWriter.writeEndElement();
                        //======================================
                        xMLStreamWriter.writeStartElement("prof");
                            xMLStreamWriter.writeCharacters(p.getNomProf());
                        xMLStreamWriter.writeEndElement();
                        //======================================
                        xMLStreamWriter.writeStartElement("dept");
                            xMLStreamWriter.writeCharacters(p.getDept_attachement());
                        xMLStreamWriter.writeEndElement();
                        //======================================
                        
                      xMLStreamWriter.writeEndElement();
                }
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();
            
            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            stringWriter.close();
            
            Files.createDirectories(Paths.get("modules"));
            
            FileWriter file = new FileWriter("modules/" + "module_" + this.code + ".xml");
            xmlString = formatXML(xmlString);
            file.write(xmlString);
            file.close();
        }
        catch(XMLStreamException e){
            System.out.println("Exception not supported yet");
        }
        catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
        catch(TransformerException e){
            System.out.println("error");
        }
    }
    
    public void generate_xml_notes(){
        try{
            StringWriter stringWriter = new StringWriter();
            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter =  xMLOutputFactory.createXMLStreamWriter(stringWriter);
            xMLStreamWriter.writeStartDocument("utf-8", "1.0");
            xMLStreamWriter.writeStartElement("notes");
                for (Student student : students_list){
                    if (student.sansNotes()){
                        continue;
                    }
                     xMLStreamWriter.writeStartElement("student");
                     xMLStreamWriter.writeAttribute("cne", student.getCne());
                    for (Note note : student.getNotes()){
                                xMLStreamWriter.writeStartElement("module");
                                    xMLStreamWriter.writeAttribute("codeModule", note.getCodeModule());
                                    xMLStreamWriter.writeStartElement("note1");
                                        xMLStreamWriter.writeCharacters("" + note.getNote1());
                                     xMLStreamWriter.writeEndElement();
                                     
                                     xMLStreamWriter.writeStartElement("note2");
                                        xMLStreamWriter.writeCharacters("" + note.getNote2());
                                     xMLStreamWriter.writeEndElement();
                                xMLStreamWriter.writeEndElement();
                    }
                      xMLStreamWriter.writeEndElement();
                }
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();
            
            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            stringWriter.close();
            
            Files.createDirectories(Paths.get("notes"));
            
            FileWriter file = new FileWriter("notes/" + "notes_" + this.code + ".xml");
            xmlString = formatXML(xmlString);
            file.write(xmlString);
            file.close();
        }
        catch(XMLStreamException e){
            System.out.println("Exception not supported yet");
        }
        catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
        catch(TransformerException e){
            System.out.println("error");
        }
    }


    public String getCode() {
        return code;
    }
    
    
}
