/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_jexcel;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author pc
 */
public class MyFileUtilities {
    public static String formatXML(String xml) throws TransformerException {

      TransformerFactory transformerFactory = TransformerFactory.newInstance();

      Transformer transformer = transformerFactory.newTransformer();
      
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

      StreamSource source = new StreamSource(new StringReader(xml));
      StringWriter output = new StringWriter();
      transformer.transform(source, new StreamResult(output));

      return output.toString();

  }
    
    
     public static String encodeToString(BufferedImage image, String type) {
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, baos);
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException();
        }
}
     
     
    public static BufferedImage decodeToImage(String imageString) {
    BufferedImage image = null;
    byte[] imageByte;
    try {
        Base64.Decoder decoder = Base64.getDecoder();
        imageByte = decoder.decode(imageString);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();
    } catch (IOException e) {
    }
    return image;
}

}
