
public class AutoPark {
	
	private SubscribedVehicle[] subscribedVehicles;
	private ParkRecord[] parkRecords;
	private double hourlyFee, incomeDaily;
	private int capacity;
	private int subscribedVehiclesCount;
	private int vehicleCount;
	
	public AutoPark(double hourlyFee, int capacity){
		this.hourlyFee = hourlyFee;   this.capacity = capacity;
		subscribedVehicles = new SubscribedVehicle[capacity];
		parkRecords = new ParkRecord[capacity];
		incomeDaily = 0;   subscribedVehiclesCount=0;   vehicleCount = 0;
	}

	public double getHourlyFee() { return hourlyFee; }

	public void setHourlyFee(double hourlyFee) { this.hourlyFee = hourlyFee; }

	public double getIncomeDaily() { return incomeDaily; }

	public void setIncomeDaily(double incomeDaily) { this.incomeDaily = incomeDaily; }

	public int getCapacity() { return capacity; }

	public void setCapacity(int capacity) { this.capacity = capacity; }

	public int getSubscribedVehiclesCount() { return subscribedVehiclesCount; }

	public void setSubscribedVehiclesCount(int subscribedVehiclesCount) {
		this.subscribedVehiclesCount = subscribedVehiclesCount;
	}

	public int getVehicleCount() { return vehicleCount; }

	public void setVehicleCount(int vehicleCount) { this.vehicleCount = vehicleCount; }

	public SubscribedVehicle searchVehicle(String plate){
		for(int i=0; i<subscribedVehiclesCount; i++)
			if(subscribedVehicles[i].getPlate().compareTo(plate)==0)
				return subscribedVehicles[i];
		return null;
	}
	
	public boolean isParked(String plate){
		for(int i=0; i<vehicleCount; i++)
			if(parkRecords[i].getVehicle().getPlate().compareTo(plate)==0 &&
			      parkRecords[i].getExitTime()==null)
				return true;
		return false;
	}
	
	private void enlargeVehicleArray(){
		capacity +=10;
		System.out.println("Otopark kapasitesi 10 araç artýrýldý.");
	}
	
	public boolean addVehicle(SubscribedVehicle vehicle){
		if(subscribedVehiclesCount==capacity || vehicle==null ||
				searchVehicle(vehicle.getPlate())!=null)
			return false;
		subscribedVehicles[subscribedVehiclesCount]=vehicle;
		subscribedVehiclesCount++;
		return true;
	}
	
	public boolean vehicleEnters(Vehicle vehicle, Time enter, boolean isOfficial){
		for(int i=0; i<vehicleCount; i++){
			if(parkRecords[i].getVehicle()==vehicle && parkRecords[i].getExitTime()==null){
				System.out.println("Bu araç zaten park halinde!");
		        return false;
			}
		}
		if(capacity>vehicleCount){
			for(int i=0; i<subscribedVehiclesCount; i++){
				if(subscribedVehicles[i]==vehicle){
					parkRecords[vehicleCount] = 
							new ParkRecord(enter, null, subscribedVehicles[i]);
					vehicleCount++;
				    return true;
				}
				    
	    	}
			if(isOfficial==true){
				parkRecords[vehicleCount] = new ParkRecord(null, null, vehicle);
				vehicleCount++;
				return true;
			}
			else if(isOfficial==false){
				parkRecords[vehicleCount] = new ParkRecord(enter, null, vehicle);
				vehicleCount++;
			    return true;
			}
		}
		else if(capacity <= vehicleCount) 
			enlargeVehicleArray();
			return false;
	}
	
	double fee = 0;
	public boolean vehicleExits(Vehicle vehicle, Time enter, Time exit){
		for(int i=0; i<vehicleCount; i++){
			if(parkRecords[i].getVehicle()==vehicle){
				parkRecords[i] = new ParkRecord(enter, exit, vehicle);
				if(vehicle.isSpecial()==false){
					fee = exit.getDifference(enter)*hourlyFee;
				    incomeDaily += fee;
				    return true;
				}
			}		
		}
		return false;
	}
	
	private String sv_tmp;
	public String svPlateDondurme(int i) {
		sv_tmp = subscribedVehicles[i].getPlate();
		return sv_tmp;
	}
	
	private String pr_tmp;
	public String prPlateDondurme(int i) {
		pr_tmp = parkRecords[i].getVehicle().getPlate();
		return pr_tmp;
	}
	
	private int prgsaat_tmp;
	public int prgSaatDondurme(int i) {
		prgsaat_tmp = parkRecords[i].getEnterTime().getHour();
		return prgsaat_tmp;
	}
	
	private int prgdakika_tmp;
	public int prgDakikaDondurme(int i) {
		prgdakika_tmp = parkRecords[i].getEnterTime().getMinute();
		return prgdakika_tmp;
	}
	
	private int prcsaat_tmp;
	public int prcSaatDondurme(int i) {
		if(parkRecords[i].getExitTime()!=null) {
			prcsaat_tmp = parkRecords[i].getExitTime().getHour();
		    return prcsaat_tmp;
		}
		return -1;
	}
	
	private int prcdakika_tmp;
	public int prcDakikaDondurme(int i) {
		if(parkRecords[i].getExitTime()!=null) {
			prcdakika_tmp = parkRecords[i].getExitTime().getMinute();
		    return prcdakika_tmp;
		}
		return -1;
	}
	
	public String toString(){
		return "Otoparkýn kapasitesi " +capacity+ " araçtýr.\nSaatlik ücreti " +hourlyFee+
				" tl'dir.\nGünlük kazanç " +incomeDaily+ " tl'dir.";
	}
	
}
