package com.epam.loggers.impl;

import com.epam.loggers.EventLogger;

public class ConsoleEventLogger implements EventLogger {
	
	/* (non-Javadoc)
	 * @see com.epam.loggers.impl.EventLogger#logEvent(java.lang.String)
	 */
	@Override
	public void logEvent(String msg) {
		System.out.println(msg);
	}
}
