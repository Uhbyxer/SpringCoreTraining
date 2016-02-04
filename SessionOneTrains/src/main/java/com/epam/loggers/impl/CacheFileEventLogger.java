package com.epam.loggers.impl;

import java.util.ArrayList;
import java.util.List;

import com.epam.beans.Event;

public class CacheFileEventLogger extends FileEventLogger {
	private int cacheSize;
	private List<Event> cache = new ArrayList<Event>();;
	

	public CacheFileEventLogger(String fileName, int cacheSize) {
		super(fileName);
		this.cacheSize = cacheSize;	
	}
	
	@Override
	public void logEvent(Event event) {
		cache.add(event);
		
		if(cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	private void writeEventsFromCache() {
		// TODO Auto-generated method stub
		
	}
	
	public void destroy() {
	
		if(!cache.isEmpty())
			writeEventsFromCache();

	}
}
