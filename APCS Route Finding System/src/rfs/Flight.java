package rfs;

public class Flight extends Leg {

	/*
	 * <code>Flight</code>
	 * 
	 * @param origin: The origin of the flight
	 * @param destination: The destination of the flight
	 * @param distanceInKm: The distance of the flight, in kilometers
	 * @param days: The days of the week when the flight is available
	 */
	public Flight(Location origin, Location destination, int distanceInKm, String days) {
		
		super(origin, destination, distanceInKm, days, 0.23);
		
	} // FlightConstructor
	
} // Flight
