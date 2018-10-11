package com.glacier.bot;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.TwitchClient;

public class Robot {

	private TwitchClient twitchClient;
	
	
	
	public void registerCommands() 
	{
		
		
	}
	
	public void registerEvents()
	{
		
	}
	
	public void launch()
	{
		twitchClient.getMessageInterface().joinChannel(UtilsAndConstants.properties.getProperty("twitch.channel"));
	}

}
