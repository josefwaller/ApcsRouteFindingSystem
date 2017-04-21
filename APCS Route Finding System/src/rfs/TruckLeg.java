package rfs;

public class TruckLeg extends Leg {
	public static final double COST_PER_KILOMETER = 0.58; 

	/**
	 * A route leg for trucks. Origin and destination must be TruckRoute and 
	 * Airport or two TruckRoutes
	 * @param origin
	 * @param destination
	 * @param distanceInKm
	 * @param days
	 */
	public TruckLeg(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, COST_PER_KILOMETER);
		
	} // TuckLeg Constructor
} // TruckLeg
