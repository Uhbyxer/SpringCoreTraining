package com.epam.loggers.impl;

import java.util.Collection;

import com.epam.beans.Event;
import com.epam.loggers.EventLogger;

public class CombinedEventLogger implements EventLogger {
	
	private Collection<EventLogger> loggers;
	
	
	public CombinedEventLogger(Collection<EventLogger> loggers) {
		this.loggers = loggers;
	}

	public Collection<EventLogger> getLoggers() {
		return loggers;
	}


	public void setLoggers(Collection<EventLogger> loggers) {
		this.loggers = loggers;
	}


	@Override
	public void logEvent(Event event) {
		loggers.forEach(x -> x.logEvent(event));
	}

}
