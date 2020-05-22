package ru.j4web.examples.java.xml;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.IOException;

import org.xml.sax.SAXException;


public class Main3 {
    private static final String FILENAME = "staff.xml";
    public static void main(String[] args) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element company = document.createElement("company");
            document.appendChild(company);

            Element staff = document.createElement("staff");
            company.appendChild(staff);

            Attr id = document.createAttribute("id");
            id.setTextContent("1");
            staff.setAttributeNode(id);

            Element firstname = document.createElement("firstname");
            firstname.setTextContent("Vlad");
            staff.appendChild(firstname);

            Element lastname = document.createElement("lastname");
            lastname.setTextContent("Ryazanov");
            staff.appendChild(lastname);

            Element nickname = document.createElement("nickname");
            nickname.setTextContent("BASO");
            staff.appendChild(nickname);

            Element salary = document.createElement("salary");
            salary.setTextContent("10000000");
            staff.appendChild(salary);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult( new File(System.getProperty("user.dir")+ File.separator + FILENAME));

            transformer.transform(source, result);
            System.out.println("File save

        } catch (ParserConfigurationException | TransformerConfigurationException ex)
        {
            Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex)
        {
            Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            final String filepath = System.getProperty("user.dir")+ File.separator + FILENAME;
            final File xmlFile = new File(filepath);
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            doc.normalize();
            Node company = doc.getFirstChild();
            Node staff = doc.getElementsByTagName("staff").item(0);
            NodeList nodeList = staff.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nextNode = nodeList.item(i);

                if (nextNode.getNodeName().equals("salary")) {
                    nextNode.setTextContent("15000");
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filepath));
                transformer.transform(source, result);
                System.out.println("Сhanges saved");

        }
     catch (SAXException | IOException | ParserConfigurationException| TransformerConfigurationException ex)
    {
        Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (TransformerException ex)
    {
        Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
}
