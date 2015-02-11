package com.example.ko.mobileoffice.xmlparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class OfficeParser extends Parser{
	
	public OfficeParser(String xmlData)
    {
        super(xmlData);
    }
	public Map<String, String> getBlock(int x, int y) {
		// TODO Auto-generated method stub
		String location = x+","+y;
		
		Element root = dom.getDocumentElement();
		NodeList blockList = root.getElementsByTagName("block");
		Map<String,String> blockData = new HashMap<String, String>();
	
		 
		 for(int i=0; i< blockList.getLength(); i++){
			 Element block = (Element) blockList.item(i);
			 if(block.getAttribute("location").equals(location))
			 {
				 blockData.put("temperature", getTextValue(block, "temperature"));
				 blockData.put("brightness", getTextValue(block, "brightness"));
				 blockData.put("humidity", getTextValue(block, "humidity"));
				 NodeList is_occupiedList = block.getElementsByTagName("is_occupied");
				 Element is_occupied = (Element) is_occupiedList.item(0);
				 Element user_info = (Element) is_occupied.getElementsByTagName("user_info").item(0);
				 if(user_info != null)
				 {
					 blockData.put("id", user_info.getAttribute("id"));
					 blockData.put("name", getTextValue(user_info, "name"));
					 blockData.put("location", getTextValue(user_info, "location"));
					 blockData.put("job",getTextValue(user_info, "job"));
					 NodeList preferenceList = user_info.getElementsByTagName("preference");
					 
					 for(int j=0;j<preferenceList.getLength();j++)
					 {
						Element preference = (Element) preferenceList.item(j);
						if(preference.getAttribute("factor").equals("Temperature"))
						{
							String prefix = "Temperature_";
							putPreference(preference, blockData, prefix);
						}
						else if (preference.getAttribute("factor").equals("Brightness")) {
							String prefix = "Brightness_";
							putPreference(preference, blockData, prefix);
							
						}
						else if (preference.getAttribute("factor").equals("Humidty")) {
							String prefix = "Humidty_";
							putPreference(preference, blockData, prefix);
							
						}
					 }
				 }
				 NodeList actuators = block.getElementsByTagName("actuators");
				 Element actuatorsEle = (Element) actuators.item(0);
				 NodeList actuatorList = actuatorsEle.getElementsByTagName("actuator");
				 String actuatorNames = "";
				 for(int k=0;k<actuatorList.getLength();k++)
				 {
					 Element actuator = (Element)actuatorList.item(k);
					 actuatorNames += actuator.getAttribute("id") + " ";
				 }
				 blockData.put("actuators", actuatorNames);
				 
			 }
			 
		 }
		
		
		
		return blockData;
	}
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	private void putPreference(Element preferenceEle,Map blockData,String prefix)
	{
		blockData.put(prefix+"logical", getTextValue(preferenceEle,"logical"));
		blockData.put(prefix+"degree", getTextValue(preferenceEle,"degree"));
		blockData.put(prefix+"unit", getTextValue(preferenceEle, "unit"));
	}

}
