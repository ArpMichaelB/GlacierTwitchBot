package com.glacier.commands;

import java.util.Date;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class Uptime extends Command {
	public Uptime()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"uptime");
        setCommandAliases(new String[]{UtilsAndConstants.prefix+"howlong", UtilsAndConstants.prefix+"length",UtilsAndConstants.prefix+"streamlength"});
        //originally I was having an if where this doesn't happen if the prefix is ! and we let it require a command trigger
        //but that's more lines than I feel like is necessary so we're just gonna do this
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
