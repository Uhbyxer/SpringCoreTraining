package com.epam.spring.core;

import com.epam.beans.Client;
import com.epam.loggers.impl.ConsoleEventLogger;

public class App {
	private Client client;
		
	private ConsoleEventLogger eventLogger;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ConsoleEventLogger getEventLogger() {
		return eventLogger;
	}

	public void setEventLogger(ConsoleEventLogger eventLogger) {
		this.eventLogger = eventLogger;
	}
	
	public void logEvent(String msg) {
		String message = msg.replaceAll(client.getId(),
				client.getFullName());
		
		eventLogger.logEvent(message);
	}
	
	public static void main(String[] args) {
		App app = new App();
		
		app.client = new Client("1", "Laura Palmer");
		app.eventLogger = new ConsoleEventLogger();
		
		app.logEvent("some event for user 1");
		
	}
}
