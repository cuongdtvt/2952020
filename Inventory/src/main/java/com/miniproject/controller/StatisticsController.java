package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.model.Statistics;
import com.miniproject.service.StatisticsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StatisticsController {
	
	private StatisticsService statisticsService;
	
	@Autowired
	public StatisticsController(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}
	
	@RequestMapping(value = "/statistics30imports", method = RequestMethod.GET)
	public ResponseEntity<List<Statistics>> statisticsImportByMonth() {
		List<Statistics> statistics = statisticsService.statisticsImportByMonth();
		if (statistics.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/statistics30exports", method = RequestMethod.GET)
	public ResponseEntity<List<Statistics>> statisticsExportByMonth() {
		List<Statistics> statistics = statisticsService.statisticsExportByMonth();
		if (statistics.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/statistics7imports", method = RequestMethod.GET)
	public ResponseEntity<List<Statistics>> statisticsImportByWeek() {
		List<Statistics> statistics = statisticsService.statisticsImportByWeek();
		if (statistics.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/statistics7exports", method = RequestMethod.GET)
	public ResponseEntity<List<Statistics>> statisticsExportByWeek() {
		List<Statistics> statistics = statisticsService.statisticsExportByWeek();
		if (statistics.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
	

}



