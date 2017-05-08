package rfs;

import java.util.ArrayList;

public abstract class Location {
	private String name;
	ArrayList<Leg> connectingLegs; // all legs that connect to this location

	/**
	 * Adds a given <code>Leg</code> to this Location's connected Legs.
	 * @param newLeg The <code>Leg</code> to be connected.
	 */
	public void addConnection(Leg newLeg) {
		connectingLegs.add(newLeg);
	} // addConnection

	 
	/**
	 * @param loc The <code>Location</code> to find a route to.
	 * @param day The day to find the route for.
	 * @return The cheapest Route between this location and loc on a given day.
	 *         Returns null if no route is found or if there are no outgoing
	 *         connections from this location.
	 */
	/* UNUSED, BUT IN CLASS DIAGRAM
	public Route cheapestRouteTo(Location loc, String day) {
		return null;
	} // cheapestRouteTo
	*/

	/**
	 * @param loc The <code>Location</code> to find a route to.
	 * @param day The day to find the route for.
	 * @return The Route with the minimum number of steps between this location
	 *         and loc on given day. Returns null if no route is found or if there 
	 *         are no outgoing connections from this location.
	 */
	/* UNUSED, BUT IN CLASS DIAGRAM
	public Route minStepsRouteTo(Location loc, String day) {		
		return null;
	} // minStepsRouteTo
	*/

	/**
	 * @param loc The <code>Location</code> to find a route to.
	 * @param day The day to find the route for.
	 * @return The shortest Route (by distance) between this location and loc on
	 *         a given day. Returns null if no route is found or if there are no
	 *         outgoing connections from this location.
	 */
	/* UNUSED, BUT IN CLASS DIAGRAM
	public Route shortestKmRouteTo(Location loc, String day) {		
		return null;
	} // shortestKmRouteTo
	*/
	
	public String getName() {
		return name;
	} // getName

	public void setName(String name) {
		this.name = name;
	} // setName
	
	@Override
	public String toString() {
		return getName();
	}
} // Location
