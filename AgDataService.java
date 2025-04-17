package com.agrichallenge.agdata.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for analyzing agricultural data
 * 
 * TODO: Implement this service class according to the requirements.
 */
@Service
public class AgDataService {
    
    /**
     * Counts how many times a specific crop appears in the dataset
     * 
     * @param cropName  The name of the crop to search for
     * @return          The count of records containing the specified crop
     */
    public int getCropCount(String cropName) {
        // TODO: Implement this method
        return 0;
    }
    
    /**
     * Calculates the average yield for a specific crop
     * 
     * @param cropName  The name of the crop to calculate average yield for
     * @return          The average yield for the specified crop
     */
    public double getAverageYield(String cropName) {
        // TODO: Implement this method
        return 0.0;
    }
    
    /**
     * Gets all records from a specific region
     * 
     * @param region  The name of the region to search for
     * @return        List of agricultural records from the specified region
     */
    public List<?> getRecordsByRegion(String region) {
        // TODO: Implement this method
        // Note: You'll need to define your model classes
        return null;
    }
}
