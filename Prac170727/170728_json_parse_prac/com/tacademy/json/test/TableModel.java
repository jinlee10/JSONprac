package com.tacademy.json.test;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.tacademy.json.vo.BoardList;
import com.tacademy.json.vo.Lists;

public class TableModel extends AbstractTableModel{
	
	String[] colName = {"num", "title", "writer", "content",
			"cnt", "state"};
	BoardList board;
	
//	String boardStatus;
//	int boardCount;
	ArrayList<Lists> list;
	
	private static final long serialVersionUID = 3418208518494822434L;
	
	@Override
	public int getColumnCount() {
		return colName.length;
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Lists leet = list.get(rowIndex);
		switch(columnIndex){
		case 0:
			return leet.getNum();
		case 1:
			return leet.getTitle();
		case 2:
			return leet.getWriter();
		case 3:
			return leet.getContent();
		case 4:
			return leet.getCnt();
		case 5:
			return leet.isState();
		}
		
		return null;
	}
	
	//getter setter
	public ArrayList<Lists> getBoardList() {
		return list;
	}

	public void setBoardList(ArrayList<Lists> list) {
		this.list = list;
	}

	
	// -------------------------------------------------
	// 고 ---- 정
	
	
	
	@Override
	public String getColumnName(int idx) {
		
		return colName[idx];
	}
	
	
	
	
	
	
	
	
	
	// -------------------------------------------------
	//board에서 뭔가 뽑아내야한다
	
}
