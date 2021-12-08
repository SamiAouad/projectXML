/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import static com.mycompany.test_jexcel.XMLParser.row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
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
   private   ArrayList<Student> liste;

    public Filiere(String code, String path) throws FileNotFoundException, IOException {
        this.code = code;
        liste = new ArrayList<>();
         FileInputStream fis = new FileInputStream(new File("C://ExcelTest/" + path + ".xlsx"));
      
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator < Row >  rowIterator = spreadsheet.iterator();
         row = (XSSFRow) rowIterator.next();
      
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            if (row.getCell(5).getStringCellValue().equals(code))
                liste.add(new Student(row));
        }
        fis.close();
    }
    
    public void to_xml(){
        try{
            StringWriter stringWriter = new StringWriter();
            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter =  xMLOutputFactory.createXMLStreamWriter(stringWriter);
            xMLStreamWriter.writeStartDocument("utf-8", "1.0");
            xMLStreamWriter.writeStartElement("students");
                for (Student p : liste){
                    xMLStreamWriter.writeStartElement("student");
                        xMLStreamWriter.writeAttribute("CNE", "" + p.getCne());
                        //================================
                        xMLStreamWriter.writeStartElement("nom");
                            xMLStreamWriter.writeCharacters(p.getNom());
                        xMLStreamWriter.writeEndElement();
                        //================================
                        xMLStreamWriter.writeStartElement("prenom");
                            xMLStreamWriter.writeCharacters(p.getPrenom());
                        xMLStreamWriter.writeEndElement();
                        //=======================================
                        xMLStreamWriter.writeStartElement("dateDeNaiss");
                            xMLStreamWriter.writeStartElement("year");
                                xMLStreamWriter.writeCharacters("" + p.getDate().getYear());
                            xMLStreamWriter.writeEndElement();
                            
                            xMLStreamWriter.writeStartElement("month");
                                xMLStreamWriter.writeCharacters("" + p.getDate().getMonth());
                            xMLStreamWriter.writeEndElement();
                            
                            xMLStreamWriter.writeStartElement("day");
                                xMLStreamWriter.writeCharacters("" + p.getDate().getDay());
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
                            xMLStreamWriter.writeCharacters(p.getPhone());
                        xMLStreamWriter.writeEndElement();
                      xMLStreamWriter.writeEndElement();
                }
            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();
            
            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            stringWriter.close();

            System.out.println(xmlString);
            FileWriter file = new FileWriter("students" + this.code + ".xml");
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
    
    private static String formatXML(String xml) throws TransformerException {

      TransformerFactory transformerFactory = TransformerFactory.newInstance();

      Transformer transformer = transformerFactory.newTransformer();

      
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");


      StreamSource source = new StreamSource(new StringReader(xml));
      StringWriter output = new StringWriter();
      transformer.transform(source, new StreamResult(output));

      return output.toString();

  }

    
}
