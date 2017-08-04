package comtacademy.xml.weather.test;

import java.util.ArrayList;

import com.tacademy.xml.weather.vo.Local;

public class Weather {
	private String year;
	private String month;
	private String day;
	private String hour;	//보드의 이미지. 댓글 좋아여
	ArrayList<Local> list = new ArrayList<Local>();
	
	
	
	// -----------------------------------------------------
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String naonth) {
		this.month = naonth;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public ArrayList<Local> getList() {
		return list;
	}
	public void setList(ArrayList<Local> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Weather [year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", list=" + list
				+ "]";
	}
	
}
