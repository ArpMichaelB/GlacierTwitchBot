package com.glacier.commands;

import java.util.Date;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class setStart extends Command {
	public setStart()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"setstart");		
        setCommandAliases(new String[]{UtilsAndConstants.prefix+"count", UtilsAndConstants.prefix+"begin",UtilsAndConstants.prefix+"start"});
        setCategory("general");
        setDescription("Set when we've started streaming, so the uptime command doesn't get confused");
        getRequiredPermissions().add(CommandPermission.MODERATOR);
        setUsageExample("");
	}
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		super.executeCommand(messageEvent);
		Date now = new Date();
		messageEvent.getChannel().setUpdatedAt(now);
		String response = "Stream officially started at " + now.toString().substring(UtilsAndConstants.BEFORE_HOURS,UtilsAndConstants.AFTER_SECONDS); 
		sendMessageToChannel(messageEvent.getChannel().getName(),response);
	}
}
