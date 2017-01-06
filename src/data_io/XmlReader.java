/*
 * XmlReader
 *
 * RadioInfo Project,
 * Coursework 5DV135 Application Development in Java
 * at Umea University, December, January 2016/2017
 *
 * Lorenz Gerber
 *
 * Version 0.1
 *
 * Licensed under GPLv3
 *
 */
package data_io;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


/**
 * XmlReader Class
 * This class provides the DOM document read from an URL that provides
 * XML data. It is used in conjunction with the Channel/-
 * and the ScheduleParser.
 */
public class XmlReader {

    Document doc = null;

    /**
     * XmlReader
     * Constructor method that sets up the XML DOM parser
     * with a URL and provides access to the parsed DOM
     * document.
     * @param stringUrl
     */
    public XmlReader(String stringUrl){

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(String.valueOf(stringUrl));
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
