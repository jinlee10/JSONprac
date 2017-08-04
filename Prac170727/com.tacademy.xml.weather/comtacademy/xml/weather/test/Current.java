package comtacademy.xml.weather.test;
import comtacademy.xml.weather.test.Weather;

public class Current {
	
	private String xmlns;
	Weather weather;
	
	//xml을 자바로 파싱하려면 해당파일이  존자 있고 ㅇ
	
	
	public String getXmlns() {
		return xmlns;
	}
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	@Override
	public String toString() {
		return "Current [xmlns=" + xmlns + ", weather=" + weather + "]";
	}
	
	
	
}
