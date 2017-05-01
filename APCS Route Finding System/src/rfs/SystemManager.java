package rfs;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemManager {
	private ArrayList<Location> locations = new ArrayList<Location>();
	private ArrayList<Leg> legs = new ArrayList<Leg>(); 
	
	/**
	 * <code>SystemManager</code> Constructor
	 */
	public SystemManager(){
		
	} // SystemManager constructor
	
	/**
	 * Prints a string representation of this system to the console.
	 */
	public void DisplaySystemDetails(){
		System.out.println(toString());
	} // DisplaySystemDetails
	
	/**
	 * Returns a String representation of this object.
	 */
	public String toString(){
		return "";
	} // toString
	
	/**
	 * Adds a given location to the RFS.
	 * @param L The location to be added.
	 */
	public void addLocation(Location L){
		
		locations.add(L);
		
	} // addLocation
	
	/**
	 * Adds a given Leg to the RFS.
	 * @param l The leg to be added.
	 */
	public void addLeg(Leg l){
		
		legs.add(l);
		
	} // addLeg
	
	/**
	 * Returns a Location object if one exists in the RFS with a 
	 * matching name.
	 * @param name The name of the Location to be searched for.
	 * @return
	 */
	public Location findLocation(String name){
		
		for (int i = 0; i < locations.size(); i++) {
			
			if (locations.get(i).getName().equals(name)) {
				return locations.get(i);
			}
			
		}
		
		return null;
		
	} // findLocation
	
	/**
	 * Returns the cheapest route between two locations on a given day 
	 * by calling cheapestRouteTo() in the Location class.
	 * @param origin The Location to calculate the route from.
	 * @param destination The Location to calculate the route to.
	 * @param day The day to calculate the route on.
	 * @return The cheapest Route between <code>origin</origin> and <code>destination</code>
	 */
	public Route findCheapestRoute (Location origin, Location destination, String day){
		return null;
	} // findCheapestRoute
	
	/**
	 * returns the route with the minimum number of steps between two locations on 
	 * a given day by calling minStepsRouteTo() in the Location class.
	 * @param origin The Location to calculate the route from.
	 * @param destination The Location to calculate the route to.
	 * @param day The day to calculate the route on.
	 * @return The shortest (by number of steps) Route between <code>origin</origin> and <code>destination</code>
	 */
	public Route findMinStepsRoute (Location origin, Location destination, String day){
		return null;
	} // findMinStepsRoute
	
	/**
	 * returns the shortest route between two locations on a given day by calling 
	 * shortestKmRouteTo() in the Location class.
	 * @param origin The Location to calculate the route from.
	 * @param destination The Location to calculate the route to.
	 * @param day The day to calculate the route on.
	 * @return The shortest (by km travelled) Route between <code>origin</origin> and <code>destination</code>
	 */
	public Route findShortestKmRoute (Location origin, Location destination, String day){
		return findBestRoute(origin, destination, day);
	} // findShortestKmRoute
	
	public Route findBestRoute (Location origin, Location destination, String day) {
		
		ArrayList<Location> deadLocations = new ArrayList();
		HashMap<Location, Route> bestRoutes = new HashMap();
		bestRoutes.put(origin, new Route(new ArrayList()));
		
		Location startingLocation = origin;
		
		for (int i = 0;startingLocation != destination && i < 15; i++) {
			System.out.println("Starting round " + i);
			
			// updates the distances to the connections
			updateRoutes(startingLocation, bestRoutes);
			
			deadLocations.add(startingLocation);
			
			// finds the next starting location
			double dis = Double.MAX_VALUE;
			for (Location l: bestRoutes.keySet()) {
				
				if (!deadLocations.contains(l)){
					
					if (bestRoutes.get(l).totalDistance() < dis) {
						
						startingLocation = l;
						dis = bestRoutes.get(l).totalDistance();
						
					}
					
				}
				
			}
			
			System.out.println("Starting location is now " + startingLocation);
			
		}
		
		System.out.println("Finished!");
		System.out.println("The shortest route is " + bestRoutes.get(destination).totalDistance());
		
		return null;
	} // findBestRoute
	
	private void updateRoutes(Location l, HashMap<Location, Route> routes) {
		
		ArrayList<Leg> connectedLegs = getSortedLegs(l);
		
		for (Leg leg: connectedLegs) {
			
			Location dest = leg.getDestination();
			double distance = routes.get(l).totalDistance() + leg.getDistance();
			
			if (!routes.containsKey(dest) || routes.get(dest).totalDistance() > distance) {
				
				Route newRoute = new Route(new ArrayList(routes.get(l).connectedLegs));
				
				newRoute.addLeg(leg);
				
				routes.put(dest, newRoute);
				
				System.out.println("The shortest route to " + dest + " is now " + newRoute.totalDistance());
			}
		
		}
	}
	
	private ArrayList<Leg> getSortedLegs(Location l) {
		
		ArrayList<Leg> connected = new ArrayList<Leg>();
		
		for (int i = 0; i < legs.size(); i++) {
		
			if (legs.get(i).getOrigin() == l) {
				connected.add(legs.get(i));
			}
			
		}
		
		return connected;
	}
	
	public ArrayList<Location> getLocations() {
		return locations;
	} // getLocations

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	} // setLocations

	public ArrayList<Leg> getLegs() {
		return legs;
	} // getLegs

	public void setLegs(ArrayList<Leg> legs) {
		this.legs = legs;
	} // setLegs
} // SystemManager
