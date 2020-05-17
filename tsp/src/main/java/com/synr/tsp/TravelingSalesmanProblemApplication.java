package com.synr.tsp;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelingSalesmanProblemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TravelingSalesmanProblemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// final DataModel data = new DataModel();
		final DataModel2 data = new DataModel2();
		RoutingIndexManager manager = new RoutingIndexManager(data);
		RoutingModel routing = new RoutingModel(manager);
		ArrayList<Route> routes = routing.getAllRoutings();
		for (Route route : routes) {
			System.out.println(route);
		}

	}

}
