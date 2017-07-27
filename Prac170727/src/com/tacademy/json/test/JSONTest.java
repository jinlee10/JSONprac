package com.tacademy.json.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tacademy.json.vo.Student;

public class JSONTest {
	
	public JSONTest(){
	
		Student student = new Student();
		student.setName("John Cena");
		student.setHakbun("T001");
		student.setAge(30);
		student.setGender(true);
		student.setHobby(new String[]{"태권도", "태극권"});
		
		
		//student -=> json 문자열로 변경!
		//JSON MAKING!
		
		//JSON Parser Library
//		JSONObject.
		
//		JSONParser parser = new JSONParser();
		JSONObject object = new JSONObject();	//JSON 문자열을관리할객체
		object.put("name", student.getName());	//JDBC의 preparedStatement랑비슷하죠?
		object.put("age", student.getAge());
		object.put("hakbun", student.getHakbun());
		object.put("sex", student.isGender());	
		JSONArray arr = new JSONArray();		//JSON의 배열을 관리하는객체
		
		String[] hobbys = student.getHobby();
		for(String s : hobbys){
			arr.put(s);
		}
		object.put("hobby", arr);
		
		//마지막으로 JSONObject를 JSON문자열로 변환한다
		String jsonStr1 = object.toString();
		
		//JSON Parsing					//이거몰르면암것두못해
		Student std = new Student();
		JSONObject obj1 = null;
		try{
			obj1 = new JSONObject(jsonStr1);
			std.setGender(obj1.getBoolean("sex"));
			std.setName(obj1.getString("name"));
			std.setHakbun(obj1.getString("hakbun"));
			std.setAge(obj1.getInt("age"));
			
			JSONArray jsonArr = obj1.getJSONArray("hobby");
			String[] hobbys1 = new String[jsonArr.length()];
			
			for(int i= 0; i < hobbys.length;i++){
				hobbys1[i] = jsonArr.getString(i);
			}
			std.setHobby(hobbys1);
			//파싱완료
		}catch(JSONException e){
			System.out.println("파싱 오류: " + e);
		}
		
		
		
		//['축구', '야구', '농구'] -->이렇게 바꿔줘야지!
		String hobbyStr = "[";
		for(String s : hobbys){
			hobbyStr += "'" + s + "',";
		}
		hobbyStr = hobbyStr.substring(0, hobbyStr.length() - 1);
		System.out.println(hobbyStr);
		hobbyStr += "]";
		System.out.println(hobbyStr);
		
		
		String jsonStr = String.format("{name : %s, age: %s, "
				+ "hakbun: %s, gender: %b, hobby: %s}", 
				student.getName(), student.getAge(), 
				student.getHakbun(), student.isGender(), hobbyStr);
		
		System.out.println(jsonStr);
		System.out.println(jsonStr.toString());
		
		
		
		
		
		// JSON문자열을 JAVA의 객체로 parsing 하기
		// JSON 파싱! 그래야 db로 넣든 필요한데 쓰든 할 것 아녀
		// (Same as XML)얻어진걸우리가원하는객체로변환시켜주는과-정
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args){
		new JSONTest();
	}

}

