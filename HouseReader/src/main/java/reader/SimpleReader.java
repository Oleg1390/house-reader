package reader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SimpleReader {
    private static HashMap<Building, Integer> buildings = new HashMap<Building, Integer>();
    private static HashMap<String, int[]> cities = new HashMap<String, int[]>();
    private static Integer totalCount = 0;
    
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Создание фабрики и экземпляра парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        
        XMLHandler handler = new XMLHandler();
        parser.parse(new File("resource/address.xml"), handler);
		
        System.out.println("Считывание завершено.");
    	for(Map.Entry<Building, Integer> entry: buildings.entrySet()) {
    		if(entry.getValue() > 1) {
            	System.out.println(String.format("Город - %s, улица - %s, дом - %s, этажность - %s, дубликаты - %s", entry.getKey().getCity(), entry.getKey().getStreet(), entry.getKey().getHouse(), entry.getKey().getFloor(), entry.getValue()));	
    		}
    	}
    	
    	for(Map.Entry<String, int[]> entry: cities.entrySet()) {
            	System.out.println(String.format("Город - %s, здания - %s", entry.getKey(),  Arrays.toString(entry.getValue())));	
    	}
    	
    	System.out.println(totalCount);
    }
	
	private static class XMLHandler extends DefaultHandler {
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	       if (qName.equals("item")) {
	    	   totalCount++;
	            String city = attributes.getValue("city");
	            String street = attributes.getValue("street");
	            String house = attributes.getValue("house");
	            String floor = attributes.getValue("floor");
	            
				Building building = new Building(city, street, house, floor);
				
				Integer count =  buildings.get(building);
				buildings.put(building, count == null ? 1: count + 1);
				
				int[] cityBuildings =  cities.get(city);
								
				if(cityBuildings == null) {
					cities.put(city, new int[] {1,1,1,1,1});
				} else {
				     for (int i = 1; i <= cityBuildings.length; i++) {
				    	 if(i == Integer.parseInt(floor)) {
				    		 cityBuildings[i-1]++;
				    	 }
				      }
					cities.put(city, cityBuildings);
				}				
	        }
		}
	}
	


}