
public class MainClass {

	public static void main(String[] args) {
		
		AutoPark kardeslerOto = new AutoPark(5.7, 50);
		
		SubscribedVehicle bmw = new SubscribedVehicle("34 AS 842");
		kardeslerOto.addVehicle(bmw);
		Subscription subBmw= new Subscription(new Datee(24, 12, 2015), 
				                              new Datee(10, 8, 2019), "34 AS 842");
		if(subBmw.isValid()==true)
			System.out.println("Abonelik geçerlidir.");
		else
			System.out.println("Abonelik geçerli deðildir.");
		
		OfficialVehicle police =  new OfficialVehicle("06 P 1473");
		
		SubscribedVehicle mercedes = new SubscribedVehicle("61 YFA 95");
		kardeslerOto.addVehicle(mercedes);
		Subscription subMercedes= new Subscription(new Datee(6, 3, 2017), 
				                                   new Datee(30, 12, 2020), "61 YFA 95");
		if(subMercedes.isValid()==true)
			System.out.println("Abonelik geçerlidir.");
		else
			System.out.println("Abonelik geçerli deðildir.");
		
		RegularVehicle audi = new RegularVehicle("35 KV 983");
		
		OfficialVehicle ambulans =  new OfficialVehicle("01 A 7902");
		
		RegularVehicle porsche = new RegularVehicle("16 ND 693");
		
		SubscribedVehicle volkswagen = new SubscribedVehicle("34 CS 057");
		kardeslerOto.addVehicle(volkswagen);
		Subscription subVolkwagen= new Subscription(new Datee(13, 6, 2013), 
                                                    new Datee(28, 11, 2016), "34 CS 057");
		if(subVolkwagen.isValid()==true)
			System.out.println("Abonelik geçerlidir.");
		else
			System.out.println("Abonelik geçerli deðildir.");
		
		if(kardeslerOto.searchVehicle("61 YFA 95")!=null)
			System.out.println("Plakasý girilen aracýn otoparkta aboneliði bulunmaktadýr.");
		else
			System.out.println("Plakasý girilen aracýn otoparkta aboneliði bulunmamaktadýr.");
		
		if(kardeslerOto.searchVehicle("16 ND 693")!=null)
			System.out.println("Plakasý girilen aracýn otoparkta aboneliði bulunmaktadýr.");
		else
			System.out.println("Plakasý girilen aracýn otoparkta aboneliði bulunmamaktadýr.");
		
		Time time1 = new Time(01,48);
		Time time2 = new Time(16,34);
		
		kardeslerOto.vehicleEnters(audi, time1, false);
		
		if(kardeslerOto.isParked("35 KV 983")==true)
			System.out.println("Plakasý girilen araç otoparkta park halindedir.");
		else
			System.out.println("Plakasý girilen araç otoparkta park halinde deðildir.");
		
		kardeslerOto.vehicleEnters(ambulans, new Time(07,42), false);
		kardeslerOto.vehicleEnters(mercedes, new Time(11,57), false);
		kardeslerOto.vehicleEnters(bmw, new Time(13,27), false);
		kardeslerOto.vehicleEnters(porsche, new Time(20,30), false);
		kardeslerOto.vehicleEnters(police, new Time(22,00), false);
		kardeslerOto.vehicleEnters(mercedes, new Time(11,57), false);
		
		kardeslerOto.vehicleExits(bmw, new Time(13,27), time2);
		kardeslerOto.vehicleExits(porsche, new Time(20,30), new Time(21,17));
		kardeslerOto.vehicleExits(ambulans, new Time(07,42), new Time(12,45));
		
		kardeslerOto.vehicleEnters(porsche, new Time(22,04), false);
		
		if(kardeslerOto.isParked("16 ND 693")==true)
			System.out.println("Plakasý girilen araç otoparkta park halindedir.");
		else
			System.out.println("Plakasý girilen araç otoparkta park halinde deðildir.");
			
		System.out.println(kardeslerOto.toString());
	}

}