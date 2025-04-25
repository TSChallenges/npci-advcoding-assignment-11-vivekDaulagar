package com.agrichallenge.agdata.controller;

import com.agrichallenge.agdata.model.AgData;
import com.agrichallenge.agdata.service.AgDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/agdata")
public class AgDataController {

    @Autowired
    private AgDataService agDataService;

    @GetMapping("")
    public ResponseEntity<List<AgData>> getAllProducts() throws IOException {
        List<AgData> products = agDataService.loadAgData();
        if (products.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // TODO: GET /api/agdata/crop-count?cropName=corn
    @GetMapping("/crop-count")
    public ResponseEntity<String> getCropByName(@RequestParam(name ="cropName") String cropname){
    	return ResponseEntity.ok(agDataService.getCropCount(cropname).toString());	
    	
    }


    // TODO: GET /api/agdata/average-yield?cropName=wheat
    @GetMapping("/average-yield")
    public ResponseEntity<Double> getAvgYield(@RequestParam String cropName) {
    	return ResponseEntity.ok(agDataService.getAverageYield(cropName));
    }
    

    // TODO: GET /api/agdata/by-region?region=Midwest
    @GetMapping("/by-region")
    public ResponseEntity<List<AgData>> getByRegion(@RequestParam String region){
    	List<AgData> list = agDataService.getRecordsByRegion(region);
    	if(!list.isEmpty()) {
    		return ResponseEntity.ok(list);
    	}
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
