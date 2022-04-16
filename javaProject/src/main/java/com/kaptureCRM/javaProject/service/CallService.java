package com.kaptureCRM.javaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaptureCRM.javaProject.model.Call;
import com.kaptureCRM.javaProject.repository.CallRepository;

@Service
public class CallService 
{
	@Autowired
	private CallRepository repository;
	
	
	public CallService(CallRepository repository)
	{
		this.repository=repository;
	}
	
	public void save(Call call)
	{
		repository.saveCall(call.getFrom_number(), call.getStart_time(), call.getEnd_time(), call.getDuration());
	}
	
	
	public int getHighestCallsHour()
	{
		return repository.getHighestCallsHour();
	}
	
	
	public int getLongestCallsHour()
	{
		return repository.getLongestCallsHour();
	}
	
	public String getHighestCallsDay()
	{
		return repository.getHighestCallsDay();
	}
	
	public String getLongestCallsDay()
	{
		return repository.getLongestCallsDay();
	}
	
	
	
}
