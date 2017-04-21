package rfs;

public class TestDriver {
	SystemManager sm = new SystemManager();
	Location loc1 = new Airport("YYJ");
	Location loc2 = new TruckDepot("PURVIC01");
	Location loc3 = new BikeDeliveryLocation("Empress Hotel, Victoria BC");
	Location loc4 = new Airport("YVR");
	Location loc5 = new BikeDeliveryLocation("Ogden Point");
	Location loc6 = new Airport("INH");
	Location loc7 = new TruckDepot("PURLAURE");
	sm.addLocation(loc1);
	sm.addLocation(loc2);
	sm.addLocation(loc3);
	sm.addLocation(loc4);
	sm.addLocation(loc5);
	sm.addLocation(loc6);
	sm.addLocation(loc7);
	sm.addLeg(new TruckLeg(loc1, loc2, 25, "MW"));
	sm.addLeg(new BikeLeg(loc2, loc3, 10, "MTWRFSU"));
	sm.addLeg(new BikeLeg(loc3, loc5, 10, "MFS"));
	sm.addLeg(new TruckLeg(loc6, loc7, 1, "M"));
	sm.addLeg(new Flight(loc1,loc6, 30, "MTWRFSU"));
	sm.addLeg(new BikeLeg(loc7, loc5, 2, "MFS"));
	sm.addLeg(new Flight(loc7, loc5, 2, "MFS")); // error
	sm.addLeg(new BikeLeg(loc7, loc3, 2, "Z")); // error
	sm.addLeg(new BikeLeg(loc7, loc3, 1, "T")); // error
	sm.printSystemDetails();
	Route r1 = sm.findCheapestRoute(sm.findLocation("YYJ"), sm.findLocation("Ogden Point"), "M");
	System.out.println(r1);
	Route r2 = sm.findShortestKmRoute(sm.findLocation("YYJ"), sm.findLocation("Empress Hotel, Victoria BC"), "M");
	System.out.println(r2);
	Route r3 = sm.findMinStepsRoute(sm.findLocation("YYJ"), sm.findLocation("Empress Hotel, Victoria BC"), "M");
	System.out.println(r3);
}
