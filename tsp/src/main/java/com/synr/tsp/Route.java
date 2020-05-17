package com.synr.tsp;

import java.util.LinkedList;

public class Route {

	LinkedList<String> waypoints;
	long totalDistance;

	public LinkedList<String> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(LinkedList<String> waypoints) {
		if (waypoints == null)
			waypoints = new LinkedList<String>();
		this.waypoints = waypoints;
	}

	public long getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(long totalDistance) {
		this.totalDistance = totalDistance;
	}

	public void addWaypoints(String waypoint) {
		if (waypoints == null)
			waypoints = new LinkedList<String>();
		this.waypoints.add(waypoint);
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Route [");
		if (waypoints != null) {
			builder.append("waypoints=");
			builder.append(waypoints.subList(0, Math.min(waypoints.size(), maxLen)));
			builder.append(", ");
		}
		builder.append("totalDistance=");
		builder.append(totalDistance);
		builder.append("]");
		return builder.toString();
	}

}
