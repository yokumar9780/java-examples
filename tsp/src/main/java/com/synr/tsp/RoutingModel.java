package com.synr.tsp;

import java.util.ArrayList;

public class RoutingModel {

	private RoutingIndexManager manager;

	public RoutingModel(RoutingIndexManager manager) {
		this.manager = manager;
	}

	/*
	 * This function that takes any pair of locations and returns the distance
	 * between them
	 * 
	 * @param fromIndex
	 * 
	 * @param toIndex
	 * 
	 * @return
	 */
	public int transitIndex(int fromIndex, int toIndex) {
		// Convert from routing variable Index to user NodeIndex.
		// int fromNode = manager.indexToNode(fromIndex);
		// int toNode = manager.indexToNode(toIndex);
		return (int) this.manager.getDataModel().distanceMatrix[fromIndex][toIndex];
	}

	/**
	 * Set the cost of travel - The arc cost evaluator tells the solver how to
	 * calculate the cost of travel between any two locations—in other words, the
	 * cost of the edge (or arc) joining them in the graph for the problem.
	 */
	public void setArcCostEvaluatorOfAllVehicles(int arcCost) {

	}

	public ArrayList<Route> getAllRoutings() {
		ArrayList<Route> routes = new ArrayList<Route>();
		Route route = new Route();
		// Boolean array to check if a node has been visited or not
		boolean[] visited = new boolean[manager.getDistanceMatrixLength()];
		// Mark 0th node as visited
		visited[0] = true;

		int startingNode = manager.getStartingDepot(), counter = 1;
		long weight = 0;

		getAllRoutes(visited, startingNode, weight, counter, routes, route);

		return routes;
	}

	private void getAllRoutes(boolean[] visited, int startingNode, long weight, int counter, ArrayList<Route> routes,
			Route route) {

		if (counter == manager.getDistanceMatrixLength()
				&& manager.getDataModel().distanceMatrix[startingNode][0] > 0) {
			long totalWeight = weight + manager.getDataModel().distanceMatrix[startingNode][0];

			// System.out.print(manager.getLabel(startingNode, 0));
			route.addWaypoints(manager.getLabel(startingNode, 0));
			route.setTotalDistance(totalWeight);
			// System.out.println(route);
			routes.add(route);

			// System.out.println(" weight ->" +
			// manager.getDataModel().distanceMatrix[startingNode][0]);
			return;
		}

		for (int col = 0; col < manager.getDistanceMatrixLength(); col++) {
			if (visited[col] == false && manager.getDataModel().distanceMatrix[startingNode][col] > 0) {
				visited[col] = true;

				// System.out.print(manager.getLabel(startingNode, col));
				// System.out.println(" weight ->" +
				// manager.getDataModel().distanceMatrix[startingNode][col]);
				route.addWaypoints(manager.getLabel(startingNode, col));

				getAllRoutes(visited, col, weight + manager.getDataModel().distanceMatrix[startingNode][col],
						counter + 1, routes, route);

				visited[col] = false;
				route = new Route();

			}

		}

		return;

	}

}
