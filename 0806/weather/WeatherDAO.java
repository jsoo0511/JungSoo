package com.ssafy.weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class WeatherDAO {
	private static List<Weather> list=new ArrayList<>();
	
	
	public WeatherDAO() {
		super();
	}

	public List<Weather> getDao() {
		return list;
	}
	
	
	
	public void connectXML() throws ParserConfigurationException, SAXException, IOException {
		String urlStr="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		URL url=new URL(urlStr);
		Document doc = builder.parse(url.openStream());
		
        Element root= doc.getDocumentElement();
		
		NodeList nodes=root.getElementsByTagName("data"); //root가 가지고 있는 모든 요소들 중 data라는 애가 있는지 검사
		
		for(int i=0;i<nodes.getLength();i++) {
			Weather check = new Weather();
			list.add(check);
			
			Node checkNode = nodes.item(i);
			
			
			//속성 가져오기
			NamedNodeMap nmap=checkNode.getAttributes();
		
			
			NodeList childs = checkNode.getChildNodes();
			for(int j=0;j<childs.getLength();j++) {
				Node child = childs.item(j);
				if(child.getNodeName().equals("hour")) {
					check.setHour(Integer.parseInt(child.getTextContent()));
				} else if(child.getNodeName().equals("temp")) {
					check.setTemp(Double.parseDouble(child.getTextContent()));
				} else if(child.getNodeName().equals("wfKor")) {
					check.setWfKor(child.getTextContent());
				} else if(child.getNodeName().equals("reh")) {
					check.setReh(Integer.parseInt((child.getTextContent())));
				}
			}
		}
	}

}
