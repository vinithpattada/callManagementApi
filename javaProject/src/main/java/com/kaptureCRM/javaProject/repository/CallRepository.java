package com.kaptureCRM.javaProject.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kaptureCRM.javaProject.model.Call;

@Transactional
@Repository
public interface CallRepository extends JpaRepository<Call, Integer>
{
	@Modifying
	@Query(value="insert into call_table (from_number, start_time, end_time, duration) values (:fromNumber,:startTime,:endTime,:duration)", nativeQuery = true)
	public void saveCall(@Param("fromNumber") String fromNumber, @Param("startTime") Date startTime,  @Param("endTime") Date endTime, @Param("duration") int duration);

	@Query(value="select dayname(start_time) from call_table group by dayname(start_time) order by count(dayname(start_time)) desc limit 1", nativeQuery=true)
	public String getHighestCallsDay();

	
	@Query(value="select dayname(start_time) from call_table group by dayname(start_time) order by avg(duration) desc limit 1", nativeQuery=true)
	public String getLongestCallsDay();

	@Query(value="select hour(start_time) from call_table group by (hour(start_time)) order by count(start_time) desc limit 1", nativeQuery = true)
	public int getHighestCallsHour();

	@Query(value="select hour(start_time) from call_table group by (hour(start_time)) order by avg(duration) desc limit 1", nativeQuery = true)
	public int getLongestCallsHour(); 
	
	
	
	

}
