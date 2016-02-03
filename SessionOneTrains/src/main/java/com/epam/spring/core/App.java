package com.epam.spring.core;

import com.epam.beans.Client;
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
		
		eventLogger.logEvent(message);
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.logEvent("some event for user 1");
		
	}
}
