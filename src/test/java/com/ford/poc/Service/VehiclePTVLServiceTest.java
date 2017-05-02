package com.ford.poc.Service;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class VehiclePTVLServiceTest {

	@Mock
	private FordMakeSource fordMakeSource;
	
	@Mock
	private LinconMakeSource LinconMakeSource;
	
	@InjectMocks
	private VehiclePTVLService vehiclePTVLService;

	@Test
	public void shouldReturnPTVLForMakeModel() throws Exception {

		String model = "Mustang";
		String make = "Ford";
		String expectedPtvl = "CZX";
		
		
		
		//when(vehiclePTVLService.getPTVLForMakeModel(make, model)).thenReturn(expectedPtvl);

		//String actualPtvl = ptvlService.getPTVLForMakeModel(make, model);

	//	assertThat(actualPtvl, Matchers.equalTo(expectedPtvl));

	}

}
