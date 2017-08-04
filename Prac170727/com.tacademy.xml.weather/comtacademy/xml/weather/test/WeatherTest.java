package comtacademy.xml.weather.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.tacademy.json.vo.Melon;
import com.tacademy.xml.weather.parser.WeatherParser;

public class WeatherTest {
	
	JFrame f;
	JTextArea ta;
	Melon melon;
	
	
	public WeatherTest(){
		
		//네트워크가 필요하다
		String weatherURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		
		try{
			//
			url = new URL(weatherURL);
			conn = (HttpURLConnection)url.openConnection();
			int code = conn.getResponseCode();
			switch(code){
			case HttpURLConnection.HTTP_OK: //200이면
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				WeatherParser parser = new WeatherParser();
				Weather weather = parser.parse(conn.getInputStream());
				System.out.println(weather);	//JTable로 또 해봐야겠지?
				break;
			default:
				System.out.println("에러");	
				break;
					
			}
			
			
		}catch(IOException e){
			
		}
			
			
//			url = new URL(weatherURL);		
//			
//			conn = (HttpURLConnection)url.openConnection();	//접속이이뤄진다
//			//header 세팅하는것이야 필요없으니 지운다
////			conn.setRequestProperty("appKey", "31c1e579-b9c2-3697-95d3-ed1ba8a82815");
////			conn.setRequestProperty("format", "json");
//			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String readData = "";
//			
//			StringBuilder sb = new StringBuilder();
//			
//			while((readData = reader.readLine())  != null){
//				sb.append(readData);
//			}
//			
//			String jsonStr = sb.toString();
////			MelonParser parser = new MelonParser();//얘는 여다 ui꾸밀수잇겟네 //파싱작업따로할수잇겟네 //git으루다가 하면대갯내 -->기능을 쪼개
////			melon = parser.doMelonParser(jsonStr);
////			System.out.println(jsonStr);
//////			System.out.println(melon);
////			System.out.println(melon.toString());
////			System.out.println("melon은 널이냐? " 
////					+ ((melon == null) ? true : false));
////			
////			setGUI();
////			console.log(jsonStr);
//			System.out.println(jsonStr);
//			
//		}catch(IOException e){
//			System.out.println("url 에러: " + e);
//		}
		
//	}
//	
//	void setGUI(){
//		f = new JFrame("JSON 파싱 연습");
//		f.setBounds(0,0,800,700);
//		
//		ta = new JTextArea();
//		ta.setText(melon.toString());
//		
//		f.add(new JScrollPane(ta));
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args){
		new WeatherTest();
	}
}
