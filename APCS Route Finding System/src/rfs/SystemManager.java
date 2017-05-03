package rfs;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemManager {
	private ArrayList<Location> locations = new ArrayList<Location>();
	private ArrayList<Leg> legs = new ArrayList<Leg>(); 
	
	/*
	 * What medium to use when routefinding
	 * Ex: RouteValues.Money will be used to
	 * Find the cheapest route
	 */
	// Todo: rename this
	enum RouteValues {
		Distance,
		Money,
		Steps
	}
	
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
		
		// the locations which have already been checked
		ArrayList<Location> deadLocations = new ArrayList();
		
		// the shortest route from origin to each location
		HashMap<Location, Route> bestRoutes = new HashMap();
		
		// adds the origin with an empty ArrayList
		bestRoutes.put(origin, new Route(new ArrayList<Leg>()));
		
		// the value to use when measuring routes
		RouteValues val = RouteValues.Distance;
		
		
		// the starting location
		Location startingLocation = origin;
		
		for (int i = 0;startingLocation != destination && i < 15; i++) {

			// updates the distances to the connections
			updateRoutes(startingLocation, bestRoutes, val, day);
			
			// adds the starting location to dead locations
			// so that we don't check it again
			deadLocations.add(startingLocation);
			
			// finds the next starting location
			double dis = Double.MAX_VALUE;
			
			for (Location l: bestRoutes.keySet()) {
				
				// checks it hasn't already been used
				if (!deadLocations.contains(l)){
					
					// checks if it's the shortest
					if (getRouteValue(bestRoutes.get(l), val) < dis) {
						
						// sets this location as startingLocation
						startingLocation = l;
						dis = getRouteValue(bestRoutes.get(l), val);
						
					}
					
				}
				
			}
			
			System.out.println("Starting location is now " + startingLocation);
			
		}
		
		System.out.println("Finished!");
		System.out.println("The best route is " + getRouteValue(bestRoutes.get(destination), val));
		
		return bestRoutes.get(destination);
	} // findBestRoute
	
	/*
	 * Returns the route's value based on an RouteValues value
	 */
	private double getRouteValue(Route one, RouteValues val) {
		
		if (val == RouteValues.Money) {
			return one.totalCost();
			 
		} else if (val == RouteValues.Distance) {
			return one.totalDistance();
			
		} else if (val == RouteValues.Steps) {
			return one.totalSteps();
			
		}
		
		System.err.println("Invalid RouteValues value");
		return 0.0;
	}
	
	/*
	 * Retusn the legs value based on the RouteValues value
	 */
	private double getLegValue(Leg l, RouteValues val) {
		
		if (val == RouteValues.Distance) {
			return l.getDistance();
		
		} else if (val == RouteValues.Money) {
			return l.getCostPerKm() * l.getDistance();
			
		} else if (val == RouteValues.Steps) {
			return 1.0;
		}
		
		System.err.println("Invalid RouteVales val");
		return 0.0;
	}
	
	/*
	 * Goes to each route connected to l and checks if
	 * the route from l is shorter than the current route to get there
	 */
	private void updateRoutes(Location l, HashMap<Location, Route> routes, RouteValues val, String day) {
		
		// gets the legs connected to l
		ArrayList<Leg> connectedLegs = getConnectedLegs(l, val);
		
		for (Leg leg: connectedLegs) {
			
			// checks the leg can be used on this 
			if (!leg.getDaysAvailable().contains(day)) continue;
			
			// gets the destination of the leg
			Location dest = leg.getDestination();
			
			// creates a route to compare values
			Route r = new Route(new ArrayList<Leg>());
			r.addLeg(leg);
			
			// gets the value to compare
			double distance = getRouteValue(routes.get(l), val) + getRouteValue(r, val);
			
			// checks if the dictionary doesn't have a route to the destination
			// or if the route going through l is shorter
			if (!routes.containsKey(dest) || getRouteValue(routes.get(dest), val) > distance) {
				
				// creates a new route, which is just a copy of the shortest route to l
				Route newRoute = new Route(new ArrayList<Leg>(routes.get(l).connectedLegs));
				
				// adds the newest leg to it
				newRoute.addLeg(leg);
				
				// adds it to the HashMap
				routes.put(dest, newRoute);
				
				System.out.println("The best route to " + dest + " is now " + getRouteValue(newRoute, val));
			}
		
		}
	}
	
	private ArrayList<Leg> getConnectedLegs(Location l, RouteValues val) {
		
		
		// Gets all the legs connected to this location
		ArrayList<Leg> connected = new ArrayList<Leg>();
		
		for (int i = 0; i < legs.size(); i++) {
		
			if (legs.get(i).getOrigin() == l) {
				connected.add(legs.get(i));
			}
			
		}
		
		// sorts them according to the value used
		for(int i = 0; i < connected.size(); i++) {
			
			int leastIndex = i;
			
			for (int j = i + 1; j < connected.size(); j++) {
				
				if (getLegValue(connected.get(j), val) < getLegValue(connected.get(leastIndex), val)) {
					
					leastIndex = j;
					
				}
				
			}
			
			Leg temp = connected.get(i);
			connected.set(i, connected.get(leastIndex));
			connected.set(leastIndex, temp);
			
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
