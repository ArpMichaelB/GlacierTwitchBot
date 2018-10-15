package com.glacier.bot;

import java.io.File;

import com.glacier.commands.Gutenberg;
import com.glacier.commands.Ping;
import com.glacier.commands.Uptime;
import com.glacier.commands.clearMessage;
import com.glacier.commands.setStart;
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
		twitchClient.getCommandHandler().registerCommand(Uptime.class);
		twitchClient.getCommandHandler().registerCommand(setStart.class);
		twitchClient.getCommandHandler().registerCommand(Gutenberg.class);
		twitchClient.getCommandHandler().registerCommand(clearMessage.class);
		//the setstart command really shouldnt have to exist but I can't find a way to track uptime in this api
		//so instead I'm having the start time manually get set by changing the last updated at
		//besides it's best to have a manual start time anyway since then I can cut out the "setup" time 
		//so the timestamps are closer to the stream VODs
		//TODO: implement my custom nightbot commands
		//TODO: implement prefix changing
	}
	
	public void registerEvents()
	{
		
	}
	
	public void launch()
	{
		//TODO: find a way to embed a string array into the properties file, so this can join more than one channel
		twitchClient.getMessageInterface().joinChannel(UtilsAndConstants.properties.getProperty("twitch.channel"));
		/*
	 	for(int i = 0; (value = YOUR_PROPERTY_OBJECT.getProperty("twitch.channel." + i)) != null; i++) 
	 	{
    		result.add(value);
	 	}
    	   and then have a command that's stream-owner only that'll write another property twitch.channel.x
    	   (where x is the current max channels+1)
    	   to the file 
    	   fair attribution, I got the idea for the loop code from stackoverflow. Thanks somtomas, you saved me from learning config files
		 */
	}

}
