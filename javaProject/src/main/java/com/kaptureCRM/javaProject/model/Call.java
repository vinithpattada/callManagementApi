package com.kaptureCRM.javaProject.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="call_table")

public class Call 
{
	@Id
	@GeneratedValue
	private int id;
	//@Column(name="From_Phone_Number")
	private String from_number;
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date start_time;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date end_time;
	@Column(name="Duration")
	private int duration;
	
	public Call() {
		System.out.println("Hello");
	}
	public Call(String from_number, Date start_time, Date end_time,int duration)
	{
		this.start_time=start_time;
		this.end_time=end_time;
		this.duration=duration;
		this.from_number=from_number;
	}
	
	public Call(String from_number, String start_time, String end_time) {
		super();
		//this.id = id;
		this.from_number = from_number;
		
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
		Date date1=null;
		try {
			date1 = format.parse(start_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date2=null;
		try {
			date2 = format.parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start_time = date1;
		this.end_time = date2;
		long diff=(date1.getTime() - date2.getTime()); 
		int temp=(int) TimeUnit.MILLISECONDS.toSeconds(diff);
		//this(from_number,date1,date2,temp);
		setDuration(temp);
		System.out.println(date1+" "+date2+" "+duration);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom_number() {
		return from_number;
	}
	public void setFrom_number(String from_number) {
		this.from_number = from_number;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	

}
