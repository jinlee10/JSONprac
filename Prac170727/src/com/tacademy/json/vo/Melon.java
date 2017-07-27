package com.tacademy.json.vo;

import java.util.ArrayList;

public class Melon {
	
	private int menuId;
	private int count;
	private int page;
	private int totalPages;
	private String rankDay;
	private String rankHour;
	private ArrayList<Song> songs;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public String getRankDay() {
		return rankDay;
	}
	public void setRankDay(String rankDay) {
		this.rankDay = rankDay;
	}
	public String getRankHour() {
		return rankHour;
	}
	public void setRankHour(String rankHour) {
		this.rankHour = rankHour;
	}
	public ArrayList<Song> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "Melon [menuId=" + menuId + ", count=" + count + ", page=" + page + 
				"\ntotalPages=" + totalPages
				+ ", rankDay=" + rankDay + ", rankHour=" + rankHour + 
				"\nsongs=" + songs + "]";
	}
	
	
	
}
