package com.epam.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.beans.Client;
import com.epam.beans.Event;
import com.epam.loggers.impl.ConsoleEventLogger;
import com.epam.loggers.EventLogger;

public class App {
	private Client client;
		
	private EventLogger eventLogger;

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
	
	
	public App(Client client, EventLogger eventLogger) {
		this.client = client;
		this.eventLogger = eventLogger;
	}

	public void logEvent(String msg) {
		String message = msg.replaceAll(client.getId(),
				client.getFullName());
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		Event event = (Event) ctx.getBean("event");
		event.setMsg(message);
		
		eventLogger.logEvent(event);
	}
	
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		App app = (App) ctx.getBean("app");
		app.logEvent("some event for user 2");
		app.logEvent("some event for user 1");
		
		ctx.close();
		
		
	}
}
