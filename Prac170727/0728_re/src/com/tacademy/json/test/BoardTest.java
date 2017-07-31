package com.tacademy.json.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;

import com.tacademy.json.parser.BoardParser;
import com.tacademy.json.vo.BoardList;

public class BoardTest {
	
	JFrame f;
	JTable tb;
	TableModel model;
	
	BoardList board = null;
	
	public BoardTest(){

		//네트워크 변수
		String listURL = "http://192.168.205.112/JSProject/day5/list.txt";
		
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		
		
		//try catch에서 연결해서 json string받아오기
		try{
			url = new URL(listURL);	//string url을 넣는다 URL url에
			conn = (HttpURLConnection)url.openConnection(); //접속
			
			// con.setRequestProperty부분...
			
			
			
			//sb에서 읽어서 스트링에 넣기
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String readData = "";
			
			StringBuilder sb = new StringBuilder();
			
			while((readData = reader.readLine()) != null){
				sb.append(readData);
			}
			
			String jsonStr = sb.toString();
			
			BoardParser parser = new BoardParser();
			board = parser.parseListFile(jsonStr); //파스하고 리턴값을 넣는다
			System.out.println("jsonStr : " + jsonStr);
			System.out.println(board.toString());
			
			
		}catch(IOException e){
			System.out.println("넷웍오류: " + e);
		}
		
		
		BoardParser psr = new BoardParser();
		
		setGUI();
		
	}
	
	void setGUI(){
		f = new JFrame();
		f.setBounds(0,0,800,800);
		
		tb = new JTable();
		
		
//		System.out.println(board.toString());
		
		model = new TableModel();
		
		model.setBoardList(board.getList());
		tb.setModel(model);
		
//		shoo
//		tb.getSelectionModel().setValueIsAdjusting(false);
		tb.getTableHeader().setReorderingAllowed(false);
//		tb.setSelectionMode(SingleSelectionModel.);
//		tb.setDragEnabled(false);
		TableColumnModel columnModel = tb.getColumnModel();
		ListSelectionModel selectionModel = columnModel.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb.setSelectionModel(selectionModel);
		
		f.add(new JScrollPane(tb));
		
		f.setVisible(true);
	}
	
	public static void main(String[] args){
		new BoardTest();
	}
}
