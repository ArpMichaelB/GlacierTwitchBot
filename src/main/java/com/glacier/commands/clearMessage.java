package com.glacier.commands;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class clearMessage extends Command{
	public clearMessage()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"clear");		
        setCommandAliases(new String[]{UtilsAndConstants.prefix+"purge", UtilsAndConstants.prefix+"delete",UtilsAndConstants.prefix+"clean"});
        setCategory("general");
        setDescription("Remind the moderators how to clear the chat, or, given a username, clean up their messages");
        getRequiredPermissions().add(CommandPermission.MODERATOR);
        setUsageExample("");
	}
	@Override 
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		if(messageEvent.getMessage().split(" ").length > 1)
		{
			//i.e. if the message has arguments
			sendMessageToChannel(messageEvent.getChannel().getName(),"/timeout " + messageEvent.getMessage().split(" ")[1] + " 1s");
		}
		else
		{
			sendMessageToChannel(messageEvent.getChannel().getName(),"You're looking for /timeout <username> 1s");
		}
	}
}
