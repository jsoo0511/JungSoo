package com.ssafy.weather;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class WeatherMain {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		WeatherDAO wdao=new WeatherDAO();
		wdao.connectXML();
		List<Weather> weather=wdao.getDao();
		for(Weather w:weather)
			System.out.println(w);

	}

}
