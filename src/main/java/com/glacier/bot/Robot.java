package com.glacier.bot;

import java.io.File;

import com.glacier.commands.Ping;
import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.TwitchClient;
import me.philippheuer.twitch4j.TwitchClientBuilder;

public class Robot {

	private TwitchClient twitchClient;
	
	public Robot()
	{
		twitchClient = TwitchClientBuilder.init()
                .withClientId(UtilsAndConstants.properties.getProperty("twitch.clientID"))
                .withClientSecret(UtilsAndConstants.properties.getProperty("twitch.clientIDSecret"))
                .withCredential(UtilsAndConstants.properties.getProperty("twitch.IRC"))
                .withAutoSaveConfiguration(true)
                .withConfigurationDirectory(new File(File.listRoots()[0].getPath()+"Glacier Nester/logs/TwitchBotConfig"))
                .connect();
		//initialize the twitch client with all the whatnots from the properties file
		twitchClient.getDispatcher().registerListener(this);
		//register this class to handle all the stuff with the @EventSubscriber annotation
	}
	
	public void registerCommands() 
	{
		twitchClient.getCommandHandler().registerCommand(Ping.class);
	}
	
	public void registerEvents()
	{
		
	}
	
	public void launch()
	{
		//TODO: find a way to embed a string array into the properties file, so this can join more than one channel
		twitchClient.getMessageInterface().joinChannel(UtilsAndConstants.properties.getProperty("twitch.channel"));
	}

}
