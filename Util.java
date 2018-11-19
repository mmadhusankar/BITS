/**
 * 
 */
package com.bits.daa;

/**
 * @author MMaddikera
 *
 */
import java.util.Arrays;

class Util {
	// Function to find minimum number of platforms needed in the
	// station so to avoid any delay in arrival of any train.
	public static int minPlatforms(double[] arrival, double[] departure) {
		// maintains the count of trains
		int count = 0;

		// stores minimum platforms needed
		int platforms = 0;

		// take two indices for arrival and departure time
		int i = 0, j = 0;

		// run till train is scheduled to arrive
		while (i < arrival.length) {
			// if train is scheduled to arrive next
			if (arrival[i] < departure[j]) {
				// increase the count of trains and update minimum
				// platforms if required
				platforms = Integer.max(platforms, ++count);

				// move the pointer to next arrival
				i++;
			}

			// if train is scheduled to depart next i.e.
			// (departure[j] < arrival[i]), decrease the count of trains
			// and move pointer j to next departure

			// If two trains are arriving and departing at the same time,
			// i.e. (arrival[i] == departure[j]) depart the train first
			else {
				count--;
				j++;
			}
		}

		return platforms;
	}

	// Find minimum number of platforms needed in the station to avoid any
	// delay in arrival of any train
	public static void main(String[] args) {
		double[] arrival = { 9.00, 9.15, 10.30, 10.45 };
		double[] departure = { 9.30, 13.00, 11.00, 11.45 };

		
		
		// sort arrival time of trains
		Arrays.sort(arrival);

		// sort departure time of trains
		Arrays.sort(departure);

		System.out.print("Minimum platforms needed is " + minPlatforms(arrival, departure));
	}
}