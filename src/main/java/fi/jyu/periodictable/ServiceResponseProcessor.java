package fi.jyu.periodictable;

import com.aonaware.services.webservices.*;
import net.webservicex.Periodictable;
import net.webservicex.PeriodictableSoap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 08.09.2017.
 */
public class ServiceResponseProcessor {

    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    public static List<PeriodicElement> getElements() throws Exception {

        List<PeriodicElement> periodicElementList = new ArrayList<>();
        Periodictable periodictable = new Periodictable();
        PeriodictableSoap periodictableSoap = periodictable.getPeriodictableSoap();
        String atoms = periodictableSoap.getAtoms();

        Document doc = loadXMLFromString(atoms);
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("Table");
        for(int i=0; i<nodeList.getLength(); ++i){
            Node elementNode = nodeList.item(i);
            String elementName = elementNode.getTextContent().trim();
            PeriodicElement element = new PeriodicElement(elementName);
            periodicElementList.add(element);
        }

        return periodicElementList;
    }

    private static String getElementDefinition(String element) throws Exception{
        DictService dictService = new DictService();
        DictServiceSoap dictServiceSoap = dictService.getDictServiceSoap();
        WordDefinition definitionResponse = dictServiceSoap.define(element);
        ArrayOfDefinition arrayOfDefinition = definitionResponse.getDefinitions();
        String response;
        if(arrayOfDefinition.getDefinition().size() > 0) {
            Definition firstDefinition = arrayOfDefinition.getDefinition().get(0);
            Dictionary d = firstDefinition.getDictionary();
            response = firstDefinition.getWord() + " => " + firstDefinition.getWordDefinition().trim() + "[" + d.getName().trim() + "]";
        }
        else{
            response = "No definition found.";
        }
        return response;
    }

    public static PeriodicElement getElementInfo(String element) throws Exception{
        Periodictable periodictable = new Periodictable();
        PeriodictableSoap periodictableSoap = periodictable.getPeriodictableSoap();
        String infoResponse = periodictableSoap.getAtomicNumber(element);
        Document doc = loadXMLFromString(infoResponse);
        Element root = doc.getDocumentElement();
        Element elementInfo = (Element) root.getElementsByTagName("Table").item(0);
        int atomicNumber = Integer.parseInt(elementInfo.getElementsByTagName("AtomicNumber").item(0).getTextContent());
        String symbol = elementInfo.getElementsByTagName("Symbol").item(0).getTextContent();
        return new PeriodicElement(atomicNumber, element, symbol);
    }

    public static void defineElement(PeriodicElement element) throws Exception{
        String name = element.getElementName();
        element.setDefinition(getElementDefinition(name));
    }
}
