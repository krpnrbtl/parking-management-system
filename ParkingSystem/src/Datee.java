
import java.util.Calendar;

public class Datee {
	
	private int day, month, year;
	
	public Datee(int day, int month, int year){
		this.day = day;    this.month = month;   this.year = year;
	}
	
	
	public int getDay() { return day; }
	
	public void setDay(int day) { this.day = day; }

	public int getMonth() { return month; }
	
	public void setMonth(int month) { this.month = month; }

	public int getYear() { return year; }
	
	public void setYear(int year) { this.year = year; }

	public boolean isAfterThan(Datee other){
		if(getYear()>other.getYear())
			return true;
		else if(getYear()==other.getYear() && getMonth()>other.getMonth())
			return true;
		else if(getYear()==other.getYear() && getMonth()==other.getMonth() && 
				getDay()>other.getDay())
			return true;
		else   return false;
	}
	
	public boolean isBeforeThan(Datee other){
		if(getYear()<other.getYear())
			return true;
		else if(getYear()==other.getYear() && getMonth()<other.getMonth())
			return true;
		else if(getYear()==other.getYear() && getMonth()==other.getMonth() && 
				getDay()<other.getDay())
			return true;
		else   return false;	
	}
	
	public boolean isEqualsWith(Datee other){
		if(getYear()==other.getYear() && getMonth()==other.getMonth() && 
				getDay()==other.getDay())
			return true;
		return false;	
	}
	
	static Calendar today = Calendar.getInstance();
	
	public static int TodayDay(){
		return today.get(Calendar.DATE);
	}	
	
	public static int TodayMonth(){
		return today.get(Calendar.MONTH);
	}
	
	public static int TodayYear(){
		return today.get(Calendar.YEAR);
	}

}
