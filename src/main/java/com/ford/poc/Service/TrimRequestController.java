
package com.ford.poc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TrimRequestController {

	@Autowired
	VehicleTrimService trimService;

	@Autowired
	VehiclePTVLService ptvlService;
	
	public List<String> retrieveTrimTypesFromMakeModelYear(String make, String model, String year) {

		String pvtl = ptvlService.getPTVLForMakeModel(make, model);

		return trimService.getTrimsForModelYearAndPTVL(year, pvtl);
	}

}
