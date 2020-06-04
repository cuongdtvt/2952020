package com.miniproject.repository.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Statistics;
import com.miniproject.repository.IStatistics;

@Repository
public class StatisticsImp implements IStatistics{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override	
	public List<Statistics> statisticsImportByMonth() {
		return jdbcTemplate.query(
			"Select Cast(create_date as DATE) as create_date, sum (qty) as qty from import WHERE CAST(create_date as DATE) BETWEEN CAST(DATEADD(DD,-6,GETDATE()) as DATE) AND CAST(GETDATE() as DATE) GROUP BY CAST(create_date AS DATE)",
			(rs, rowNum) ->
					new Statistics(
							rs.getDate("create_date"),
							rs.getLong("qty")
                   )
			);
	 }

	@Override
	public List<Statistics> statisticsExportByMonth() {
		return jdbcTemplate.query(
				"Select Cast(create_date as DATE) as create_date, sum (qty) as qty from export WHERE CAST(create_date as DATE) BETWEEN CAST(DATEADD(DD,-6,GETDATE()) as DATE) AND CAST(GETDATE() as DATE) GROUP BY CAST(create_date AS DATE)",
				(rs, rowNum) ->
						new Statistics(
								rs.getDate("create_date"),
								rs.getLong("qty")
	                   )
				);
	}

	@Override
	public List<Statistics> statisticsImportByWeek() {
		return jdbcTemplate.query(
				"DECLARE @7DaysAgo DATE = CAST(DATEADD(DD,-6,GETDATE()) as DATE) DECLARE @now DATE = CAST(GETDATE() as DATE); WITH DateTable AS (SELECT @7DaysAgo AS [DATE] UNION ALL SELECT DATEADD(dd, 1, [DATE]) FROM DateTable WHERE DATEADD(dd, 1, [DATE]) <= @now ) SELECT ISNULL(b.qty, 0) as qty FROM [DateTable] dt left JOIN (Select Cast(create_date as DATE) as create_date, sum (qty) as qty from import WHERE CAST(create_date as DATE) BETWEEN CAST(DATEADD(DD,-6,GETDATE()) as DATE) AND CAST(GETDATE() as DATE) GROUP BY CAST(create_date AS DATE)) b ON CAST(b.create_date AS Date) = dt.[DATE]",
				(rs, rowNum) ->
						new Statistics(
								
								rs.getLong("qty")
	                   )
				);
	}

	@Override
	public List<Statistics> statisticsExportByWeek() {
		return jdbcTemplate.query(
				"DECLARE @7DaysAgo DATE = CAST(DATEADD(DD,-6,GETDATE()) as DATE) DECLARE @now DATE = CAST(GETDATE() as DATE); WITH DateTable AS (SELECT @7DaysAgo AS [DATE] UNION ALL SELECT DATEADD(dd, 1, [DATE]) FROM DateTable WHERE DATEADD(dd, 1, [DATE]) <= @now ) SELECT ISNULL(b.qty, 0) as qty FROM [DateTable] dt left JOIN (Select Cast(create_date as DATE) as create_date, sum (qty) as qty from export WHERE CAST(create_date as DATE) BETWEEN CAST(DATEADD(DD,-6,GETDATE()) as DATE) AND CAST(GETDATE() as DATE) GROUP BY CAST(create_date AS DATE)) b ON CAST(b.create_date AS Date) = dt.[DATE]",
				(rs, rowNum) ->
						new Statistics(
								
								rs.getLong("qty")
	                   )
				);
	}

	@Override
	public List<Statistics> statisticsImportByYear() {
		return jdbcTemplate.query(
				"Select Cast(create_date as DATE) as create_date, sum (qty) as qty from export WHERE CAST(create_date as DATE) BETWEEN CAST(DATEADD(DD,-364,GETDATE()) as DATE) AND CAST(GETDATE() as DATE) GROUP BY CAST(create_date AS DATE)",
				(rs, rowNum) ->
						new Statistics(
								rs.getDate("create_date"),
								rs.getLong("qty")
	                   )
				);
	}

	@Override
	public List<Statistics> statisticsExportByYear() {
		return jdbcTemplate.query(
				"Select Cast(create_date as DATE) as create_date, sum (qty) as qty from export WHERE CAST(create_date as DATE) BETWEEN CAST(DATEADD(DD,-364,GETDATE()) as DATE) AND CAST(GETDATE() as DATE) GROUP BY CAST(create_date AS DATE)",
				(rs, rowNum) ->
						new Statistics(
								rs.getDate("create_date"),
								rs.getLong("qty")
	                   )
				);
	}
	
	
	

}
