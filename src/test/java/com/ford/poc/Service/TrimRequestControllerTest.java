package com.ford.poc.Service;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TrimRequestControllerTest {

	@Mock
	private VehicleTrimService vehicleTrimService;

	@Mock
	private VehiclePTVLService vehiclePTVLService;

	@InjectMocks
	private TrimRequestController controller;

	@Test
	public void shouldReturnTrimsForMakeModelAndYear() throws Exception {

		String year = "2015";
		String model = "Focus";
		String make = "Ford";
		String ptvl = "JUMP";
		List<String> expectedTrims = Lists.newArrayList("base", "SE", "Titanium", "ST", "RS");
		when(vehiclePTVLService.getPTVLForMakeModel(make, model)).thenReturn(ptvl);
		when(vehicleTrimService.getTrimsForModelYearAndPTVL(year, ptvl)).thenReturn(expectedTrims);

		List<String> actualTrims = controller.retrieveTrimTypesFromMakeModelYear(make, model, year);

		assertThat(actualTrims, Matchers.equalTo(expectedTrims));
	}

};
