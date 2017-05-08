package rfs;

import java.util.ArrayList;

public class Route {
	ArrayList<Leg> connectedLegs = new ArrayList<>();
	
	public Route(ArrayList<Leg> L){
		this.connectedLegs = L;
	} // Route Constructor
	
	/**
	 * Calculates the total cost of traversing this route.
	 * @return The total cost of this route.
	 */
	public double totalCost(){
		double totalCost = 0;
		for (Leg leg : connectedLegs) {
			totalCost += leg.getCostPerKm()*leg.getDistance();
		}
		return totalCost;
	} // totalCost
	
	/**
	 * Calculates the total distance covered by this route.
	 * @return The total length of this route in kilometers.
	 */
	public int totalDistance(){
		int totalDistance = 0;
		for (Leg leg: connectedLegs){
			totalDistance += leg.getDistance();
		}
		return totalDistance;
	} // totalDistance
	
	/**
	 * @return The total number of legs in this route.
	 */
	public int totalSteps(){
		return connectedLegs.size();
	} // totalSteps
	
	/**
	 * The adds a new leg onto the end of this route
	 * @param newLeg The <code>Leg</code> to be added.
	 */
	public void addLeg(Leg newLeg){
		
		// add the new Leg
		connectedLegs.add(newLeg);
	} // addLeg
	
	/**
	 * @return A string representation of this Route
	 */
	@Override
	public String toString(){
		String s = "[";
		for(int i = 0; i < connectedLegs.size(); i++){
			s += i + ": (" + connectedLegs.get(i).toString() + ((i == connectedLegs.size() - 1)? ")":")\n");
		}
		return s + "]";
	} // toString
} // Route
