package com.synr.tsp;

import java.util.ArrayList;

public class Example {

	static String[] label1 = new String[] { "A", "B", "C", "D" };

	public static void main(String[] args) {

		// n is the number of nodes i.e. V
		int numberOfNode = 4;

		// @formatter:off
		int[][] graph = { { 0, 10, 15, 20 }, { 10, 0, 35, 25 }, { 15, 35, 0, 30 }, { 20, 25, 30, 0 } };

		// @formatter:on

		// Boolean array to check if a node
		// has been visited or not
		boolean[] visited = new boolean[numberOfNode];

		// Mark 0th node as visited
		visited[0] = true;
		int minimumWeight = Integer.MAX_VALUE;
		int startedNode = 0, cost = 0, count = 1;

		ArrayList<Route> routes = new ArrayList<Route>();
		Route route = new Route();

		// Find the minimum weight Hamiltonian Cycle
		minimumWeight = getMinimumWeight(graph, visited, minimumWeight, numberOfNode, startedNode, cost, count, routes,
				route);
		System.out.println("....." + minimumWeight);

		for (Route route1 : routes) {
			System.out.println(route1);
		}

	}

	private static int getMinimumWeight(int[][] graph, boolean[] visited, int minimumWeight, int numberOfNode,
			int startedNode, int cost, int count, ArrayList<Route> routes, Route route) {

		if (count == numberOfNode && graph[startedNode][0] > 0) {
			int costToRootNode = cost + graph[startedNode][0];
			minimumWeight = Math.min(minimumWeight, costToRootNode);
			System.out.print(getLabel(startedNode, 0));
			route.addWaypoints(getLabel(startedNode, 0));
			route.setTotalDistance(minimumWeight);
			routes.add(route);

			System.out.println(" weight ->" + graph[startedNode][0]);
			return minimumWeight;
		}

		for (int col = 0; col < numberOfNode; col++) {
			if (visited[col] == false && graph[startedNode][col] > 0) {
				visited[col] = true;

				System.out.print(getLabel(startedNode, col));
				System.out.println(" weight ->" + graph[startedNode][col]);
				route.addWaypoints(getLabel(startedNode, col));

				minimumWeight = getMinimumWeight(graph, visited, minimumWeight, numberOfNode, col,
						cost + graph[startedNode][col], count + 1, routes, route);

				visited[col] = false;
				route = new Route();

			}

		}
		System.out.println(minimumWeight);

		return minimumWeight;
	}

	private static String getLabel(int fromIndex, int ToIndex) {

		return label1[fromIndex] + " to " + label1[ToIndex];

	}

}
