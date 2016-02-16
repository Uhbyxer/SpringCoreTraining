package com.epam.spring.core;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.aspects.StatisticsAspect;
import com.epam.beans.Client;
import com.epam.beans.Event;
import com.epam.beans.EventType;
import com.epam.loggers.impl.ConsoleEventLogger;
import com.epam.loggers.EventLogger;

public class App {
	private Client client;
	
	private StatisticsAspect sa;
	
	
	public void setSa(StatisticsAspect sa) {
		this.sa = sa;
	}

	private EventLogger eventLogger = new ConsoleEventLogger();
	
	private Map<EventType, EventLogger> loggers;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EventLogger getEventLogger() {
		return eventLogger;
	}

	public void setEventLogger(EventLogger eventLogger) {
		this.eventLogger = eventLogger;
	}
	
	public App() {
		eventLogger = new ConsoleEventLogger();
		client = new Client("1", "Laura Palmer");
	}
	
	
	public App(Client client, Map<EventType, EventLogger> loggers) {
		this.client = client;
		//this.eventLogger = eventLogger;
		
		this.loggers = loggers;
		
	}

	public void logEvent(EventType type, String msg) {
		EventLogger logger = loggers.get(type);
		if(logger == null)
			logger = eventLogger;
		
		
		
		String message = msg.replaceAll(client.getId(),
				client.getFullName());
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		Event event = (Event) ctx.getBean("event");
		event.setMsg(message);
		
		logger.logEvent(event);
		
		
	
		
	}
	
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		App app = (App) ctx.getBean("app");
		 
		if(app == null) {
			System.out.println("app == null");
		}
		
		app.logEvent(EventType.ERROR , "ERROR: some event for user 2");
		app.logEvent(EventType.INFO, "INFO: some event for user 1");
		
		
		Event ev = new Event(new Date(), java.text.DateFormat.getDateTimeInstance());
		ev.setMsg("Custom logger message");
		
		if(app.eventLogger != null)
			app.eventLogger.logEvent(ev);
		
		
		
		//System.out.println(app.sa.getCounter());
		
		
		ctx.close();
		
		
	}
}
