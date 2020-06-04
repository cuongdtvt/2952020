package com.miniproject.service;

import java.util.List;

import com.miniproject.model.Statistics;

public interface StatisticsService {
	public List<Statistics> statisticsImportByMonth();

	public List<Statistics> statisticsExportByMonth();

	public List<Statistics> statisticsImportByWeek();

	public List<Statistics> statisticsExportByWeek();
	
	public List<Statistics> statisticsImportByYear();

	public List<Statistics> statisticsExportByYear();
}
