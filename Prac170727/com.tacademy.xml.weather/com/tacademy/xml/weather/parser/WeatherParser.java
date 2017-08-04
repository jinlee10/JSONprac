package com.tacademy.xml.weather.parser;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.tacademy.xml.weather.handler.WeatherHandler;

import comtacademy.xml.weather.test.Weather;

public class WeatherParser {
	
	public WeatherParser(){
		
		
	}
	
	public Weather parse(InputStream is){
		Weather weather= null;
		// Design Pattern
		// MVC '//만들때 따로따로따로
		// Model View Control쪼개
		
		
		// Factory Pattern
		SAXParserFactory sFactory = null;
		SAXParser parser = null;
		
		sFactory = SAXParserFactory.newInstance(); //new를 막았죠?
		//클랫 ㅡ딱하나 만들어지게하는 싱글톤이랑 닮았죠?
		
		WeatherHandler dh = new WeatherHandler();
		
		try{
			parser = sFactory.newSAXParser();	//내가못만들더럭
			parser.parse(is, dh);
			
			weather =dh.getWeather(); //날씨정보다만들어진객체가여기안에있어야한다
			
		}catch(Exception e){
			//얘도 SAXExeption이 죽어라 
			System.out.println("parsing 오류: " + e);
		} 
		return weather;
	}
}
