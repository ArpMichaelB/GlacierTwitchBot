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
	public static Properties properties = setupProperties();
	
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
	
}
