package com.glacier.commands;

import java.util.Date;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class Uptime extends Command {
	public Uptime()
	{
		setCommand("uptime");
        setCommandAliases(new String[]{"howlong", "length","streamlength"});
        setCategory("general");
        setDescription("Just how long have we been streaming?");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("");
	}
	
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		super.executeCommand(messageEvent);
		Date startDate = messageEvent.getChannel().getUpdatedAt();
		Date now = new Date();
		long howLong = now.getTime()-startDate.getTime();
		String response = UtilsAndConstants.formatMilliseconds(howLong);
		sendMessageToChannel(messageEvent.getChannel().getName(),response);
	}
}
