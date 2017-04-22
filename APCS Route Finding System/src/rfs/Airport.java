package rfs;

public class Airport extends Location {

	/**
	 * Constructs an Airport Location
	 * @param name Three uppercase letters representing the name of this airport
	 */
	public Airport(String name) {

		// validate airport name
		name.toUpperCase();
		name.trim();
		if (name.length() < 3) {
			for (int i = 0; i < 3 - name.length(); i++) {
				name += "-"; 
			}
		}
		name.substring(0, 3);

		// set Airport name
		setName(name);
	} // Airport Constructor
} // Airport
