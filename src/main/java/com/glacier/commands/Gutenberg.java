package com.glacier.commands;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class Gutenberg extends Command {
	public Gutenberg()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"books");
		setCommandAliases(new String[]{UtilsAndConstants.prefix+"gutenberg"});
		setCategory("general");
        setDescription("Tells the viewer who asked where we find our books, and tells them to check their messages.");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("");
	}
	
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		super.executeCommand(messageEvent);
		String response = "Check your messages, ";
		response += messageEvent.getUser().getName();
		sendMessageToChannel(messageEvent.getChannel().getName(),response);
		sendMessageToUser(messageEvent.getUser().getName(), "We find our public domain books at a site called Project Gutenberg! Check it out at http://www.gutenberg.org");
	}
}
