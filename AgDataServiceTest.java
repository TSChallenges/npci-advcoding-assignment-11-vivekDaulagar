package com.agrichallenge.agdata.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Integration tests for the AgDataService
 * Note: These tests assume you've properly implemented the required models and service methods
 */
@SpringBootTest
public class AgDataServiceTest {

    @Autowired
    private AgDataService agDataService;

    @Test
    public void testGetCropCount() {
        // Act
        int cornCount = agDataService.getCropCount("corn");
        int wheatCount = agDataService.getCropCount("wheat");
        int nonExistentCount = agDataService.getCropCount("banana");

        // Assert
        assertEquals(8, cornCount, "Should find 8 corn records");
        assertEquals(3, wheatCount, "Should find 3 wheat records");
        assertEquals(0, nonExistentCount, "Should find 0 banana records");
    }

    @Test
    public void testGetAverageYield() {
        // Act
        double cornAvg = agDataService.getAverageYield("corn");
        double wheatAvg = agDataService.getAverageYield("wheat");
        
        // Assert
        assertEquals(171.875, cornAvg, 0.001, "Average corn yield should be ~171.875");
        assertEquals(43.667, wheatAvg, 0.001, "Average wheat yield should be ~43.667");
    }

    @Test
    public void testGetRecordsByRegion() {
        // Act - This will depend on your model class name, update as needed
        List<?> midwestRecords = agDataService.getRecordsByRegion("Midwest");
        List<?> southRecords = agDataService.getRecordsByRegion("South");
        List<?> nonExistentRecords = agDataService.getRecordsByRegion("Antarctica");

        // Assert
        assertEquals(7, midwestRecords.size(), "Should find 7 Midwest records");
        assertEquals(3, southRecords.size(), "Should find 3 South records");
        assertEquals(0, nonExistentRecords.size(), "Should find 0 Antarctica records");
    }
    
    @Test
    public void testCaseInsensitivity() {
        // Act
        int cornCount = agDataService.getCropCount("CORN");
        double wheatAvg = agDataService.getAverageYield("WhEaT");
        List<?> midwestRecords = agDataService.getRecordsByRegion("midWEST");
        
        // Assert
        assertEquals(8, cornCount, "Crop search should be case-insensitive");
        assertEquals(43.667, wheatAvg, 0.001, "Crop search for averages should be case-insensitive");
        assertEquals(7, midwestRecords.size(), "Region search should be case-insensitive");
    }
}
