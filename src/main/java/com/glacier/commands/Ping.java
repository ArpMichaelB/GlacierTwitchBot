package com.glacier.commands;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class Ping extends Command {
	
	public Ping()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"ping");
		setCommandAliases(new String[]{UtilsAndConstants.prefix+"shout", UtilsAndConstants.prefix+"sayhello",UtilsAndConstants.prefix+"hello"});
		setCategory("general");
        setDescription("Displays a greeting message, to test the bot.");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("");
	}
	
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		super.executeCommand(messageEvent);
		String response = "Hi there! " + messageEvent.getUser().getDisplayName();
		sendMessageToChannel(messageEvent.getChannel().getName(),response);
		//huh, this twitch api works really similarly to the discord api I use
		//that's a good
	}
	
}
