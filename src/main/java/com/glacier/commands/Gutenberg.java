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
        setDescription("Tells the viewer who asked where we find our books.");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("");
	}
	
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		super.executeCommand(messageEvent);
		String response = "I get my books from Project Gutenberg, which you can look through here: http://www.gutenberg.org";
		sendMessageToChannel(messageEvent.getChannel().getName(),response);
		//originally this was going to whisper to the user, but the message functions weren't working
	}
}
