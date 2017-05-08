package rfs;

public class BikeLeg extends Leg{

	/**
	 * A route leg for bikes. Origin and destination must be TruckDepot and BikeDeliveryStation or two
	 * BikeDeliveryStations.
	 * @param origin
	 * @param distanceInKm The length of the Leg in kilometers             
	 * @param days String representing the days of the week this Leg runs.  
	 */
	public BikeLeg(Location origin, Location destination, int distanceInKm, String days) {

		super(origin, destination, distanceInKm, days, 1);
	} // BikeLeg Constructor
} // BikeLeg
