package com.kaptureCRM.javaProject.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaptureCRM.javaProject.model.Call;
import com.kaptureCRM.javaProject.service.CallService;

@RestController
public class CallController 
{
	@Autowired
	private CallService service;
	
	public CallController(CallService service)
	{
		this.service= service;
	}
	
	@PostMapping("/saveCall")
	public void saveCall(@RequestBody Call call)
	{
		long diff=(call.getEnd_time().getTime() - call.getStart_time().getTime()); 
		int temp=(int) TimeUnit.MILLISECONDS.toSeconds(diff);
		call.setDuration(temp);
		service.save(call);
	}
	
	@GetMapping("/getHighestCallsDay")
	public String getHighestCallsDay()
	{
		return service.getHighestCallsDay();
	}
	
	@GetMapping("/getLongestCallsDay")
	public String getLongestCallsDay()
	{
		return service.getLongestCallsDay();
	}
	
	@GetMapping("/getHighestCallsHour")
	public int getHighestCallsHour()
	{
		return service.getHighestCallsHour();
	}
	
	@GetMapping("/getLongestCallsHour")
	public int getLongestCallsHour()
	{
		return service.getLongestCallsHour();
	}
}
