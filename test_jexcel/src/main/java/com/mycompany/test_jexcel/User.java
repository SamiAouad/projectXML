/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import static com.mycompany.test_jexcel.MyFileUtilities.formatXML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.batik.xml.XMLException;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

/**
 *
 * @author pc
 */
public class User {
   private String cne;

    public User(String cne){
        this.cne = cne;
        StringWriter stringWriter = new StringWriter();
        XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
        try{
            XMLStreamWriter xMLStreamWriter =  xMLOutputFactory.createXMLStreamWriter(stringWriter);
            xMLStreamWriter.writeStartDocument("utf-8", "1.0");
             xMLStreamWriter.writeStartElement("user");
                xMLStreamWriter.writeStartElement("cne");
                    xMLStreamWriter.writeCharacters(cne);
                xMLStreamWriter.writeEndElement();
             xMLStreamWriter.writeEndElement();
         xMLStreamWriter.writeEndDocument();
         xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();
            stringWriter.close();
            
            Files.createDirectories(Paths.get("students"));
            
            FileWriter file = new FileWriter("user.xml");
            xmlString = formatXML(xmlString);
            file.write(xmlString);
            file.close();
        } catch (XMLStreamException ex) {
           Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
       } catch (TransformerException ex) {
           Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
   public void genereCarteEtu() throws TransformerConfigurationException, FOPException, TransformerException, FileNotFoundException, IOException{
      // the XSL FO file
        File xsltFile = new File("students/carteEtudiantsGINF2.xsl");
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File("students/students_GINF2.xml"));
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out;
        out = new java.io.FileOutputStream("students/carteEtudiant.pdf");
    
        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then 
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
   }
}
