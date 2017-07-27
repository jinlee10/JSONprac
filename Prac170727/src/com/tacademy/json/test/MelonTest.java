package com.tacademy.json.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.tacademy.json.parser.MelonParser;
import com.tacademy.json.vo.Melon;

public class MelonTest {
	
	JFrame f;
	JTextArea ta;
	Melon melon;
	
	
	public MelonTest(){
		
		//네트워크가 필요하다
		String melonURL = "http://apis.skplanetx.com/melon/"
				+ "charts/realtime?count=10&page=1&version=1";
		
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		
		try{
			url = new URL(melonURL);		
			
			conn = (HttpURLConnection)url.openConnection();	//접속이이뤄진다
			
			conn.setRequestProperty("appKey", "31c1e579-b9c2-3697-95d3-ed1ba8a82815");
			conn.setRequestProperty("format", "json");
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String readData = "";
			
			StringBuilder sb = new StringBuilder();
			
			while((readData = reader.readLine())  != null){
				sb.append(readData);
			}
			
			String jsonStr = sb.toString();
			MelonParser parser = new MelonParser();//얘는 여다 ui꾸밀수잇겟네 //파싱작업따로할수잇겟네 //git으루다가 하면대갯내 -->기능을 쪼개
			melon = parser.doMelonParser(jsonStr);
			System.out.println(jsonStr);
//			System.out.println(melon);
			System.out.println(melon.toString());
			System.out.println("melon은 널이냐? " 
					+ ((melon == null) ? true : false));
			
			setGUI();
			
		}catch(IOException e){
			System.out.println("url 에러: " + e);
		}
		
	}
	
	void setGUI(){
		f = new JFrame("JSON 파싱 연습");
		f.setBounds(0,0,800,700);
		
		ta = new JTextArea();
		ta.setText(melon.toString());
		
		f.add(new JScrollPane(ta));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args){
		new MelonTest();
	}
}
