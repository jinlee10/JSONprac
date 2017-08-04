package com.tacademy.xml.weather.vo;

public class Local {
	//<local stn_id="90" icon="" desc="-" ta="28.2">속초</local>
	
	//얘 관리할놈 하나 만든다 => 객체 =>변슈
	
	private String stn_id;
	private String icon;
	private String desc;
	private String ta;
	//XML은 속성값 갯수가 일정하지 않다 그러므로 가장많은걸루다가만들어
	private String rn_hr1;
	
	private String lName;	//지역명 //속초
	

	
	//XML에선 태그하나당 클래스를 만들어내문댄다
	//근데 하위 엘리먼트로 할수도있어서(프로퍼티가아니라)
	//두가지방법이잇을수잇어서 고민좀해야함
	
	//속성은 java의 멤바변수
	
	//setter getter 2string
	

	public String getStn_id() {
		return stn_id;
	}

	public void setStn_id(String stn_id) {
		this.stn_id = stn_id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public String getRn_hr1() {
		return rn_hr1;
	}

	public void setRn_hr1(String rn_hr1) {
		this.rn_hr1 = rn_hr1;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Local [stn_id=" + stn_id + ", icon=" + icon + ", desc=" + desc + ", ta=" + ta + ", rn_hr1=" + rn_hr1
				+ ", lName=" + lName + "]";
	}
}
