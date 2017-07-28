package com.tacademy.json.vo;

public class Lists {
	private int num;
	private String title;
	private String writer;
	private String content;
	private int cnt;
	private boolean state;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Lists [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content + ", cnt=" + cnt
				+ ", state=" + state + "]";
	}
	
}
