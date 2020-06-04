package com.miniproject.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.model.Statistics;
import com.miniproject.repository.IStatistics;
import com.miniproject.service.StatisticsService;

@Service
public class StatisticsServiceImp implements StatisticsService {
	
	private IStatistics iStatistics;
	
	@Autowired
	public StatisticsServiceImp (IStatistics iStatistics){
        this.iStatistics = iStatistics;
    }

	@Override
	public List<Statistics> statisticsImportByMonth() {
		 return (List<Statistics>) iStatistics.statisticsImportByMonth();
	}

	@Override
	public List<Statistics> statisticsExportByMonth() {
		return (List<Statistics>) iStatistics.statisticsExportByMonth();
	}

	@Override
	public List<Statistics> statisticsImportByWeek() {
		return (List<Statistics>) iStatistics.statisticsImportByWeek();
	}

	@Override
	public List<Statistics> statisticsExportByWeek() {
		return (List<Statistics>) iStatistics.statisticsExportByWeek();
	}

	@Override
	public List<Statistics> statisticsImportByYear() {
		return (List<Statistics>) iStatistics.statisticsImportByYear();
	}

	@Override
	public List<Statistics> statisticsExportByYear() {
		return (List<Statistics>) iStatistics.statisticsExportByYear();
	}
	
}
