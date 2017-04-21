package rfs;

import java.util.ArrayList;

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
		
	} // addLocation
	
	/**
	 * Adds a given Leg to the RFS.
	 * @param l The leg to be added.
	 */
	public void addLeg(Leg l){
		
	} // addLeg
	
	/**
	 * Returns a Location object if one exists in the RFS with a 
	 * matching name.
	 * @param name The name of the Location to be searched for.
	 * @return
	 */
	public Location findLocation(String name){
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
		return null;
	} // findShortestKmRoute

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
