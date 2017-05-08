package rfs;

public class testRFS {
	public static void main(String[] args) {
		SystemManager sm = new SystemManager();
		Location loc1 = new BikeDeliveryLocation("BikeDepot1");
		Location loc2 = new BikeDeliveryLocation("BikeDepot2");
		Location loc3 = new BikeDeliveryLocation("BikeDepot3");

		Location loc4 = new BikeDeliveryLocation("BikeDepot4");
		Location loc5 = new BikeDeliveryLocation("BikeDepot5");
		Location loc6 = new BikeDeliveryLocation("BikeDepot6");

		Location loc7 = new TruckDepot("TRUCK007");
		Location loc8 = new TruckDepot("TRUCK008");

		Location loc9 = new TruckDepot("TRUCK009");
		Location loc10 = new TruckDepot("TRUCK010");

		Location loc11 = new Airport("ELV");
		Location loc12 = new Airport("TWL");
		Location loc13 = new Airport("THR");
		Location loc14 = new Airport("FRT");
		Location loc15 = new Airport("FFT");

		sm.addLocation(loc1);
		sm.addLocation(loc2);
		sm.addLocation(loc3);
		sm.addLocation(loc4);
		sm.addLocation(loc5);
		sm.addLocation(loc6);
		sm.addLocation(loc7);
		sm.addLocation(loc8);
		sm.addLocation(loc9);
		sm.addLocation(loc10);
		sm.addLocation(loc11);
		sm.addLocation(loc12);
		sm.addLocation(loc13);
		sm.addLocation(loc14);
		sm.addLocation(loc15);

		sm.addLeg(new BikeLeg(loc1, loc7, 2, "MTWRFSU"));
		sm.addLeg(new BikeLeg(loc2, loc7, 4, "MTWRFSU"));
		sm.addLeg(new BikeLeg(loc3, loc8, 1, "MTWRFSU"));
		sm.addLeg(new TruckLeg(loc7, loc11, 15, "MTWRFSU"));
		sm.addLeg(new TruckLeg(loc7, loc9, 300, "MTWRFSU"));
		sm.addLeg(new TruckLeg(loc7, loc12, 30, "F"));
		sm.addLeg(new TruckLeg(loc8, loc12, 8, "MTWRFSU"));
		sm.addLeg(new TruckLeg(loc8, loc10, 200, "MTWRFSU"));
		sm.addLeg(new Flight(loc11, loc13, 100, "MTWRFSU"));
		sm.addLeg(new Flight(loc11, loc14, 200, "MTWRFSU"));
		sm.addLeg(new Flight(loc11, loc15, 80, "MTWRFSU"));
		sm.addLeg(new Flight(loc12, loc13, 400, "MTWRFSU"));
		sm.addLeg(new Flight(loc12, loc15, 120, "MTWRFSU"));
		sm.addLeg(new Flight(loc15, loc13, 80, "MTWRFSU"));
		sm.addLeg(new Flight(loc15, loc14, 20, "F"));
		sm.addLeg(new TruckLeg(loc13, loc9, 18, "MTWRFSU"));
		sm.addLeg(new TruckLeg(loc14, loc9, 40, "MTWRFSU"));
		sm.addLeg(new TruckLeg(loc14, loc10, 30, "MTWRFSU"));
		sm.addLeg(new BikeLeg(loc9, loc4, 2, "MTWRFSU"));
		sm.addLeg(new BikeLeg(loc9, loc5, 7, "MTWRFSU"));
		sm.addLeg(new BikeLeg(loc10, loc5, 6, "MTWRFSU"));
		sm.addLeg(new BikeLeg(loc10, loc6, 1, "MTWRFSU"));

		// BikeDepot 1 to BikeDepot 4
		System.out.println("------- 1 to 4 ----------");
		Route r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Cheapest: " + r1.totalCost());
		System.out.println("\n\nRoute from 1 to 4 is: ");
		System.out.println(r1);
		
		Route r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Shortest: " + r2.totalDistance());
		Route r3 = sm.findMinStepsRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Min Steps: " + r3.totalSteps());
		System.out.println("");

		// BikeDepot 1 to BikeDepot 6
		System.out.println("------- 1 to 6 ----------");
		r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot6"), "M");
		System.out.println("Cheapest: " + r1.totalCost());
		r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot6"), "M");
		System.out.println("Shortest: " + r2.totalDistance());
		r3 = sm.findMinStepsRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot6"), "M");
		System.out.println("Min Steps: " + r3.totalSteps());
		System.out.println("");

		// BikeDepot 2 to BikeDepot 5
		System.out.println("------- 2 to 5 ----------");

		r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot2"), sm.findLocation("BikeDepot5"), "M");
		System.out.println("Cheapest: " + r1.totalCost());
		r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot2"), sm.findLocation("BikeDepot5"), "M");
		System.out.println("Shortest: " + r2.totalDistance());
		r3 = sm.findMinStepsRoute(sm.findLocation("BikeDepot2"), sm.findLocation("BikeDepot5"), "M");
		System.out.println("Min Steps: " + r3.totalSteps());
		System.out.println("");

		// BikeDepot 2 to BikeDepot 4
		System.out.println("------- 2 to 4 ----------");
		r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot2"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Cheapest: " + r1.totalCost());
		r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot2"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Shortest: " + r2.totalDistance());
		r3 = sm.findMinStepsRoute(sm.findLocation("BikeDepot2"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Min Steps: " + r3.totalSteps());
		System.out.println("");

		// BikeDepot 3 to BikeDepot 6
		System.out.println("------- 3 to 6 ----------");
		r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot3"), sm.findLocation("BikeDepot6"), "F");
		System.out.println("Cheapest: " + r1.totalCost());
		r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot3"), sm.findLocation("BikeDepot6"), "M");
		System.out.println("Shortest: " + r2.totalDistance());
		r3 = sm.findMinStepsRoute(sm.findLocation("BikeDepot3"), sm.findLocation("BikeDepot6"), "M");
		System.out.println("Min Steps: " + r3.totalSteps());
		System.out.println("");

		// BikeDepot 3 to BikeDepot 4
		System.out.println("------- 3 to 4 ----------");
		r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot3"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Cheapest: " + r1.totalCost());
		r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot3"), sm.findLocation("BikeDepot4"), "F");
		System.out.println("Shortest: " + r2.totalDistance());
		r3 = sm.findMinStepsRoute(sm.findLocation("BikeDepot3"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("Min Steps: " + r3.totalSteps());
		System.out.println("");

		// BikeDepot 4 to BikeDepot 5 NOT POSSIBLE
		System.out.println("------- 4 to 5 ----------");
		r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot4"), sm.findLocation("BikeDepot5"), "M");
		System.out.println("Cheapest: " + r1.totalCost());
		r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot4"), sm.findLocation("BikeDepot5"), "M");
		System.out.println("Shortest: " + r2.totalDistance());
		r3 = sm.findMinStepsRoute(sm.findLocation("BikeDepot4"), sm.findLocation("BikeDepot5"), "M");
		System.out.println("Min Steps: " + r3.totalSteps());
	} // main
}