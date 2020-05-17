package com.synr.tsp;

import org.springframework.stereotype.Component;

@Component
public class DataModel2 {

	public final long[][] distanceMatrix = { { 0, 10, 15, 20 }, { 10, 0, 35, 25 }, { 15, 35, 0, 30 },
			{ 20, 25, 30, 0 } };

	/**
	 * The number of vehicles in the problem, which is 1 because this is a TSP
	 */
	public final int vehicleNumber = 1;
	/**
	 * The depot: the start and end location for the route. In this case, the depot
	 * is 0, which corresponds to New York.
	 */
	public final int depot = 0;

	public final String[] locationLable = new String[] { "A", "B", "C", "D" };

}
