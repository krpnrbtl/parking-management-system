
public class Subscription {

	private Datee begin, end;
	private SubscribedVehicle vehicle;
	
	public Subscription(Datee begin, Datee end, String plate){
		this.begin = begin;   this.end = end;
		vehicle = new SubscribedVehicle(plate);
	}

	public Datee getBegin() { return begin; }

    public Datee getEnd() { return end; }

    public void setBegin(Datee begin) { this.begin = begin; }

	public void setEnd(Datee end) { this.end = end; }

	public SubscribedVehicle getVehicle() { return vehicle; }
    
	public void setVehicle(SubscribedVehicle vehicle) {	this.vehicle = vehicle; }

    public boolean isValid(){
    	if(begin.getYear()>Datee.TodayYear() || end.getYear()<Datee.TodayYear())
    		return false;
    	else if(begin.getYear()==Datee.TodayYear() && begin.getMonth()>Datee.TodayMonth())
    		return false;
    	else if(begin.getYear()==Datee.TodayYear() && begin.getMonth()==Datee.TodayMonth()
    			&& begin.getDay()>Datee.TodayDay())
    		return false;
    	else if(end.getYear()==Datee.TodayYear() && end.getMonth()<Datee.TodayMonth())
    		return false;
    	else if(end.getYear()==Datee.TodayYear() && end.getMonth()==Datee.TodayMonth()
    			&& end.getDay()<Datee.TodayDay())
    		return false;
    	else 
    		return true;
	}
    
}
