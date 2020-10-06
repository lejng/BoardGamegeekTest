package utils;

import com.sun.org.apache.xml.internal.dtm.ref.DTMNodeList;
import io.qameta.allure.Allure;
import org.xml.sax.InputSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XmlParser {

    public static DTMNodeList getValueByXpath(String xml, String xpathValue){
        InputSource inputXML = new InputSource(new StringReader(xml));
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            DTMNodeList result = (DTMNodeList) xPath.evaluate(xpathValue, inputXML, XPathConstants.NODESET);
            return result;
        } catch (Exception error){
            Allure.addAttachment("Error to parse xml", error.getMessage());
            return null;
        }
    }
}
