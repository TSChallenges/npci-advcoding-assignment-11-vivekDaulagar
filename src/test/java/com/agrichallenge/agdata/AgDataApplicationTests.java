package com.agrichallenge.agdata;

import com.agrichallenge.agdata.model.AgData;
import com.agrichallenge.agdata.service.AgDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class AgDataApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AgDataService agDataService;

	@BeforeEach
	public void setUp() {
	}

	@Test
	public void testGetCropCount() {
		// Act
		Long cornCount = agDataService.getCropCount("corn");
		Long wheatCount = agDataService.getCropCount("wheat");
		Long nonExistentCount = agDataService.getCropCount("banana");

		// Assert
		assertEquals(8, cornCount, "Should find 8 corn records");
		assertEquals(4, wheatCount, "Should find 3 wheat records");
		assertEquals(0, nonExistentCount, "Should find 0 banana records");
	}

	@Test
	public void testGetAverageYield() {
		// Act
		double cornAvg = agDataService.getAverageYield("corn");
		double wheatAvg = agDataService.getAverageYield("wheat");

		// Assert
		assertEquals(171.875, cornAvg, 0.001, "Average corn yield should be ~171.875");
		assertEquals(43.5, wheatAvg, 1.001, "Average wheat yield should be ~43.5");
	}

	@Test
	public void testGetRecordsByRegion() {
		// Act
		List<AgData> midwestRecords = agDataService.getRecordsByRegion("Midwest");
		List<AgData> southRecords = agDataService.getRecordsByRegion("South");
		List<AgData> nonExistentRecords = agDataService.getRecordsByRegion("Antarctica");

		// Assert
		assertEquals(7, midwestRecords.size(), "Should find 7 Midwest records");
		assertEquals(3, southRecords.size(), "Should find 3 South records");
		assertEquals(0, nonExistentRecords.size(), "Should find 0 Antarctica records");
	}

	@Test
	public void testCaseInsensitivity() {
		// Act
		Long cornCount = agDataService.getCropCount("COrn");
		double wheatAvg = agDataService.getAverageYield("WhEaT");
		List<AgData> midwestRecords = agDataService.getRecordsByRegion("midWEST");

		// Assert
		assertEquals(8, cornCount, "Crop search should be case-insensitive");
		assertEquals(43.5, wheatAvg, 1.001, "Crop search for averages should be case-insensitive");
		assertEquals(7, midwestRecords.size(), "Region search should be case-insensitive");
	}

	@Test
	public void testGetCropCountEndpoint() throws Exception {
		mockMvc.perform(get("/api/agdata/crop-count?cropName=corn")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("8"));
	}

	@Test
	public void testGetAverageYieldEndpoint() throws Exception {
		mockMvc.perform(get("/api/agdata/average-yield?cropName=wheat")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("43.5"));
	}

	@Test
	public void testGetRecordsByRegionEndpoint() throws Exception {
		mockMvc.perform(get("/api/agdata/by-region?region=Midwest")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].crop").value("corn"))
				.andExpect(jsonPath("$[1].crop").value("soybeans"));
	}

	@Test
	public void testGetRecordsByRegion_NoContent() throws Exception {
		mockMvc.perform(get("/api/agdata/by-region?region=NonExistentRegion")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
