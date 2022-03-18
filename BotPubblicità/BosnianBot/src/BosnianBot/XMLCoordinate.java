package BosnianBot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author prof
 */
public class XMLCoordinate {
    
    private Document document;
    private String fileName="csv/coordinate.csv";
    private String xmlFile="xml/location.xml";
    public String lat="";
    public String lon="";

    public Document getDocument() {
        return document;
    }
    
    public boolean getXMLToCSV(String ricerca, int idChat, String nomeUtente) throws IOException{
        
        getXML(ricerca);
        boolean exists=true;
        String coordinate="";
        
        try {
            coordinate = getCoordinate();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLCoordinate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLCoordinate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!coordinate.equals("")){
            String testo=coordinate+";"+idChat+";"+nomeUtente;
            AddToCSV(testo);
        }else{
            exists=false;
        }
        return exists;
    }
    
    public void getXML(String ricerca) throws FileNotFoundException, MalformedURLException, IOException{
        BufferedReader in = null;
        PrintWriter out;
        out = new PrintWriter(xmlFile);
        URL url;
        String search = "https://nominatim.openstreetmap.org/search?q="+URLEncoder.encode(ricerca, StandardCharsets.UTF_8)+"&format=xml&polygon_geojson=1&addressdetails=1";
        url = new URL(search);
        Scanner scanner = new Scanner(url.openStream());//per leggere tutto file
        scanner.useDelimiter("\u001a");//indica la fine del file
        String file = scanner.next();
        out.write(file);
        out.close();
    }
    
    public String getCoordinate() throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Element root, element;
        NodeList nodelist;
        String coordinate="";
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        
        document = builder.parse(xmlFile);
        root = document.getDocumentElement();
        nodelist = root.getElementsByTagName("place");
        if (nodelist != null && nodelist.getLength() > 0) {
            int numNode = nodelist.getLength();
            element = (Element) nodelist.item(0);
            String lat=element.getAttribute("lat");
            String lon=element.getAttribute("lon");
            coordinate = lat+";"+lon;
        }
        
        return coordinate;
    }
    
    public void AddToCSV(String testo) throws IOException{
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(testo);
        bw.newLine();
        bw.close();
    }
}
