package com.epam.spring.core.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.beans.Event;
import com.epam.loggers.EventLogger;

@Configuration
public class AppConfig {
	
	@Bean
	@Scope("prototype")
	public Event event() {
		java.text.DateFormat df = java.text.DateFormat.getDateTimeInstance();
		return new Event(new Date(), df);
	}
	
	@Autowired
	private EventLogger eventLogger;
	
}
