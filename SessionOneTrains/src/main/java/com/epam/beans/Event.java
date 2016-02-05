package com.epam.beans;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
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
	
	public static boolean idDay() {
		Date testDate = new Date();
		return !(testDate .before(START_DATE) || testDate.after(AFTER_DATE));
	}
	
	public static final Date START_DATE;
	
	public static final Date AFTER_DATE;
	
	static {
        Calendar from = Calendar.getInstance();
        from.set(Calendar.HOUR_OF_DAY,9);
        from.set(Calendar.MINUTE,0);
        from.set(Calendar.SECOND,0);
        from.set(Calendar.MILLISECOND,0);
		START_DATE = from.getTime();
		
        Calendar to = Calendar.getInstance();
        to.set(Calendar.HOUR_OF_DAY,18);
        to.set(Calendar.MINUTE,0);
        to.set(Calendar.SECOND,0);
        to.set(Calendar.MILLISECOND,0);

		AFTER_DATE = to.getTime();
		
		System.out.println("start date: " + START_DATE);
		System.out.println("end date: " + AFTER_DATE);
		
		System.out.println("Is day: " + idDay());
		
	}

}
