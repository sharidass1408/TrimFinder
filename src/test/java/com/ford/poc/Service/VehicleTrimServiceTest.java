package com.ford.poc.Service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VehicleTrimServiceTest {
	
	@Mock
	private VechileDataSource vechileDataSource;
	
	@InjectMocks
	private VehicleTrimService vehicleTrimService;
	
	@Test
	public void shouldReturnTrimFromVehicle() throws Exception {
		String ptvl = "CGE";
		String trim = "SE";
		when(vechileDataSource.getVehicleList(ptvl)).thenReturn(Arrays.asList(createVehicle("2016", trim)));
		
		assertEquals(Arrays.asList(trim) , vehicleTrimService.getTrimsForModelYearAndPTVL("2016", ptvl));
	}

	@Test
	public void shouldReturnTrimFromMultipleVehicles() throws Exception {
		String ptvl = "CGE";
		String trim1 = "SE";
		String trim2 = "SES";
		when(vechileDataSource.getVehicleList(ptvl)).thenReturn(Arrays.asList(createVehicle("2016", trim1),createVehicle("2016", trim2)));
		
		assertEquals(Arrays.asList(trim1, trim2) , vehicleTrimService.getTrimsForModelYearAndPTVL("2016", ptvl));
	}

	@Test
	public void shouldOnlyReturnTrimsFromSpecifiedYear() throws Exception {
		String ptvl = "CGE";
		String trim1 = "SE";
		String trim2 = "SES";
		String trim3 = "Titanium";
		when(vechileDataSource.getVehicleList(ptvl)).thenReturn(Arrays.asList(createVehicle("2016", trim1),createVehicle("2016", trim2),createVehicle("2017", trim3)));
		
		assertEquals(Arrays.asList(trim1, trim2) , vehicleTrimService.getTrimsForModelYearAndPTVL("2016", ptvl));
	}
	
	@Test
	public void shouldReturnListOfVehicleTrimsForPTVLandYear() throws Exception {
		
		String year = "2016";
		String ptvl = "JUMP";

		Vehicle vehicle1 = createVehicle(year, "CZX");
		Vehicle vehicle2 = createVehicle(year, "ASD");
		
		Vehicle vehicle3 = createVehicle("2015", "BAD");
		
		when(vechileDataSource.getVehicleList(ptvl)).thenReturn(Arrays.asList(vehicle1, vehicle2, vehicle3));
		
		List<String> expectedTrimsList = Lists.newArrayList(vehicle1.getTrim(), vehicle2.getTrim());
		
		//Actual call to the service
		List<String> actualTrimsList = vehicleTrimService.getTrimsForModelYearAndPTVL(year, ptvl);
		
		//Testing the expected with actual restul
		assertThat(actualTrimsList, Matchers.equalTo(expectedTrimsList));

	}

	private Vehicle createVehicle(String year, String trim) {
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setTrim(trim);
		vehicle1.setYear(year);
		return vehicle1;
	}




	

	/*@Test
	public void shouldReturnListOfTrims() throws Exception {

		String year = "1999";
		String ptvl = "JUMP";
		List<String> expectedTrims = Lists.newArrayList("base", "XLT");
		//when(vehicleTrimService.getTrimsForModelYearAndPTVL(year, ptvl)).thenReturn(expectedTrims);

		List<String> actualTrims = vehicleTrimService.getTrimsForModelYearAndPTVL(year, ptvl);

		assertThat(actualTrims, Matchers.equalTo(expectedTrims));

	}

	
	@Test
	public void shouldCallVehicleTrimServiceToRetrieveListOfTrims() throws Exception {

		List<String> expectedTrims = Lists.newArrayList("base", "SE", "ZX3");
		String year = "2013";
		String ptvl = "CZE";
		//when(vehicleTrimService.getTrimsForModelYearAndPTVL(year, ptvl)).thenReturn(expectedTrims);

//		List<String> actualTrims = vehicleTrimService.getTrimsForModelYearAndPTVL(year, ptvl);
//
//		assertThat(actualTrims, Matchers.equalTo(expectedTrims));

	}*/

}
