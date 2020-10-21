
public class Time {
	
	private int hour, minute;
	
	public Time(int hour, int minute){
		this.hour = hour;   this.minute = minute;
	}
	
	
	public int getHour() { return hour; }
	
	public void setHour(int hour) { this.hour = hour; }

	public int getMinute() { return minute; }
	
	public void setMinute(int minute) { this.minute = minute; }

	
	public int getDifference(Time other){
		int firstTime = hour*60 + minute;
		int secondTime = other.hour*60 + other.minute;
		return (firstTime-secondTime)/60;
	}

}
