package rfs;

public class Leg {
	private Location origin;
	private Location destination;
	private String daysAvailable;
	private int distance;
	private double costPerKm;
	
	/**
	 * <code>Leg</code> Constructor
	 * @param origin The Start of the Leg.
	 * @param destination The end of the Leg.
	 * @param distanceInKm The length of the Leg in kilometers
	 * @param days String representing the days of the week this Leg runs.
	 * @param costPerKm Cost per kilometer traveled on this Leg.
	 */
	public Leg(Location origin, Location destination, int distanceInKm, String days, double costPerKm){
		
	} // LegConstructor

	public Location getOrigin() {
		return origin;
	} // getOrigin

	public void setOrigin(Location origin) {
		this.origin = origin;
	} // setOrigin

	public Location getDestination() {
		return destination;
	} // getDestination

	public void setDestination(Location destination) {
		this.destination = destination;
	} // setDestination

	public String getDaysAvailable() {
		return daysAvailable;
	} // getDaysAvailable

	public void setDaysAvailable(String daysAvailable) {
		this.daysAvailable = daysAvailable;
	} // setDayAvailable

	public int getDistance() {
		return distance;
	} // getDisatance

	public void setDistance(int distance) {
		this.distance = distance;
	} // setDistance

	public double getCostPerKm() {
		return costPerKm;
	} // getCostPerKm

	public void setCostPerKm(double costPerKm) {
		this.costPerKm = costPerKm;
	} // setCostPerKm
} // Leg
