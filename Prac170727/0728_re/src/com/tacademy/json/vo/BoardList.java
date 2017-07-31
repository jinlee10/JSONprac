package com.tacademy.json.vo;

import java.util.ArrayList;

public class BoardList {
	private String status;
	private int count;
	private ArrayList<Lists> list;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<Lists> getList() {
		return list;
	}
	public void setList(ArrayList<Lists> list) {
		this.list = list;
	}
	
	
	@Override
	public String toString() {
		return "BoardList [status=" + status + ", count=" + count + ", list=" + list + "]";
	}
	
}
