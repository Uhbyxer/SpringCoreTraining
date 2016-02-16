package com.epam.loggers.impl;

import java.io.File;
import java.io.IOException;

import com.epam.beans.Event;
import com.epam.loggers.EventLogger;

public class FileEventLogger implements EventLogger{
	
	private String fileName;
	private File file;

	@Override
	public void logEvent(Event event) {
		System.out.println("Fake writing 2 file -> " + event);
		
		//throw new RuntimeException("hohoho");
	}
	
	
	public void init() throws IOException {
		if(fileName == null) return;
		
		this.file = new File(fileName);
		
		if(!file.canWrite()) { 
			//throw new IOException("Can't write 2 file: " + fileName);
			System.out.println("(fake) Can't write 2 file: " + fileName);
			
		}	
	}
	
	
	public void destroy() {
		
	}


	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}
	
	
}
