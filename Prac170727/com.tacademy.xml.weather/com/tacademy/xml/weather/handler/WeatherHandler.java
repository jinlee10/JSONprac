package com.tacademy.xml.weather.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.tacademy.xml.weather.vo.Local;

import comtacademy.xml.weather.test.Weather;

public class WeatherHandler extends DefaultHandler {
	
	//SAXParser는 이벤트파싱이다
	//==>local하나읽을떄마다동작
	
	private Weather weather;
	private Local local = null; //ararylist들어갈떄변수 바깥에 싸는게 좋아
	private String tName = "";

	public Weather getWeather() {
		return weather;
	}

	//DefaultHandler 오버라이딩
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		switch(tName){
		case "local":
			local.setlName(str);
			break;
		}
	}


	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName){
		case "local":	
			weather.getList().add(local);
			break;
		}
		// =-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// 엄 청 난 팁												|
		// =-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		tName = "";//공백들어가는걸막을수있을까나몰라				|
		//															|
		// ==========================================================
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(qName){
		case "weather":
//			System.out.println("qName: " + qName);
			weather = new Weather();
			//자바선 properties를 attributes라고부른다dqt
			weather.setYear(attributes.getValue("year"));
			weather.setMonth(attributes.getValue("month"));
			weather.setDay(attributes.getValue("day"));
			weather.setHour(attributes.getValue("hour"));
			break;
		case "local":	//만나면 ㅏㄴ들어준다
			local = new Local();		//JSON은 없으면 exception나는데 얘는 없으면 안읽어온다 그러니까 다썸마
			local.setStn_id(attributes.getValue("stn_id"));
			local.setIcon(attributes.getValue("icon"));
			local.setDesc(attributes.getValue("desc"));
			local.setTa(attributes.getValue("ta"));
			local.setRn_hr1(attributes.getValue("rn_hr1"));
			local.setlName(attributes.getValue("lName"));
			break;
		//서순맞춰 하나씩해주기만하면된다
		}
		
		tName = qName;
	}
	
}
