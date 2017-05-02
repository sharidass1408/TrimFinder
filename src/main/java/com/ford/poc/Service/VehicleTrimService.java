package com.ford.poc.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VehicleTrimService {

	private VechileDataSource vechileDataSource;

	public List<String> getTrimsForModelYearAndPTVL(String year, String ptvl) {
		List<String> vehicleTrimListMatchingYearCriteria = new ArrayList<String>();

		for (Vehicle vehicle : vechileDataSource.getVehicleList(ptvl)) {
			if (vehicle.getYear().equals(year)) {
				vehicleTrimListMatchingYearCriteria.add(vehicle.getTrim());
			}
		}

		return vehicleTrimListMatchingYearCriteria;
	}
}