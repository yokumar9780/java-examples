package com.synr.tsp;

public class RoutingIndexManager {

	private int distanceMatrixLength, totalNoOfVehicle, startingDepot;
	private DataModel2 data;
	private String[] locationLable;

	public RoutingIndexManager(int distanceMatrixLength, int totalNoOfVehicle, int startingDepot) {
		this.distanceMatrixLength = distanceMatrixLength;
		this.totalNoOfVehicle = totalNoOfVehicle;
		this.startingDepot = startingDepot;
	}

	public RoutingIndexManager(DataModel2 data) {
		this.data = data;
		this.distanceMatrixLength = data.distanceMatrix.length;
		this.totalNoOfVehicle = data.vehicleNumber;
		this.startingDepot = data.depot;
		this.locationLable = data.locationLable;
	}

	public final DataModel2 getDataModel() {
		return this.data;
	}

	public final int getDistanceMatrixLength() {
		return this.distanceMatrixLength;
	}

	public final int getTotalNoOfVehicle() {
		return this.totalNoOfVehicle;
	}

	public final int getStartingDepot() {
		return this.startingDepot;
	}

	public final String[] getLocationLable() {
		return this.locationLable;
	}

	public String getLabel(int fromIndex, int ToIndex) {
		return this.locationLable[fromIndex] + " to " + this.locationLable[ToIndex];
	}

}
