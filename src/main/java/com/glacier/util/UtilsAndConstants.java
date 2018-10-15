package com.glacier.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class UtilsAndConstants {
	
	private static final String PROPERTIES_FILENAME = "twitchbot.properties";
	public static final int BEFORE_HOURS = 10;
	public static final int AFTER_SECONDS = 19;
	public static Properties properties = setupProperties();
	public static String prefix = "~";
	
	private static Properties setupProperties()
	{
		Properties properties = new Properties();
        try {
        	ClassLoader classLoader = UtilsAndConstants.class.getClassLoader();
        	File propertiesFile = new File(classLoader.getResource(PROPERTIES_FILENAME).getFile());
            InputStream in = new FileInputStream(propertiesFile);
            properties.load(in);
            return properties;
        } catch (IOException e) {
            System.err.println("There was an error reading " + UtilsAndConstants.PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage() + " at " + getCurrentTimestamp());
            return null;
        }
	}

	public static String getCurrentTimestamp() {
		return DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(LocalDateTime.now());
	}

	public static String formatMilliseconds(long millis) {
		long seconds = millis/1000;
		long minutes = seconds/60;
		long hours = minutes/60;
		seconds = seconds%60;
		minutes = minutes%60;
		String ret = "We've been live for roughly: ";
		ret += hours+" hours, ";
		ret += minutes+" minutes, and ";
		ret += seconds+" seconds.";
		return ret;
	}
	
}
