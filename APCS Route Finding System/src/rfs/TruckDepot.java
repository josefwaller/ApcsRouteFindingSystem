package rfs;

public class TruckDepot extends Location {

	/**
	 * Constructs a TruckDepot Location.
	 * @param name Eight uppercase letters representing the name of this TruckDepot
	 */
	public TruckDepot(String name) {

		// validate airport name
		name.toUpperCase();
		name.trim();
		if (name.length() < 8) {
			for (int i = 0; i < 8 - name.length(); i++) {
				name += "-"; 
			}
		}
		name.substring(0, 8);

		// set TruckDepot name
		setName(name);
	} // TruckDepot Constructor
} // TruckDepot
