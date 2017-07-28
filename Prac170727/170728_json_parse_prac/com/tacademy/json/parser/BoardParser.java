package com.tacademy.json.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tacademy.json.vo.BoardList;
import com.tacademy.json.vo.Lists;

public class BoardParser {
	public BoardList parseListFile(String jsonStr){
		
		BoardList board = new BoardList();
		ArrayList<Lists> list = null;
		JSONObject obj = new JSONObject();
		JSONObject jobj = new JSONObject();
		JSONObject tList = null;
		JSONObject lists = null;
		JSONArray listArr = null;
		
		try{
			obj = new JSONObject(jsonStr);
			board.setStatus(obj.getString("status"));
			board.setCount(obj.getInt("count"));
			
			listArr = obj.getJSONArray("list");
			list = new ArrayList<Lists>();
			Lists lst = null;
			
			for(int i = 0; i < listArr.length(); i++){
				tList = listArr.getJSONObject(i);
				lst = new Lists();
				lst.setNum(tList.getInt("num"));
				lst.setTitle(tList.getString("title"));
				lst.setWriter(tList.getString("writer"));
				lst.setContent(tList.getString("content"));
				lst.setCnt(tList.getInt("cnt"));
				lst.setState(tList.getBoolean("state"));
				
				list.add(lst);
//				board.getList().add(lst);
			}
			
			board.setList(list);
			
			System.out.println("board의 list size(): " + board.getList().size());
			
			
			
		}catch(JSONException e){
			System.out.println("제이슨 파스 실패: " + e);
		}
		
		
		
		
		return board;
	}
}
