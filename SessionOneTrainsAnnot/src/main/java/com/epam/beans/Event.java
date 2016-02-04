package com.epam.beans;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Random;

public class Event {
	private int id = new Random().nextInt();
	private String msg;
	private Date date;
	private DateFormat df;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Event() {
		date = new Date();

	}
	
	public Event(Date date, DateFormat df) {
		this.date = date;
		this.df = df;
	}
	
	@Override
	public String toString() {
		
		return "Event [id=" + id + ", msg=" + msg + ", date=" + df.format(date) + "]";
	}
	
	

}
