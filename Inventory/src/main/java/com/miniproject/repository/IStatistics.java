package com.miniproject.repository;

import java.util.List;

import com.miniproject.model.Statistics;

public interface IStatistics {
	
	public List<Statistics> statisticsImportByMonth();

	public List<Statistics> statisticsExportByMonth();
	
	public List<Statistics> statisticsImportByWeek();

	public List<Statistics> statisticsExportByWeek();
	
	public List<Statistics> statisticsImportByYear();

	public List<Statistics> statisticsExportByYear();
}
