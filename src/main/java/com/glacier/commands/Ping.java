package com.glacier.commands;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class Ping extends Command {
	
	public Ping()
	{
		setCommand("ping");
        setCommandAliases(new String[]{"shout", "sayhello","hello"});
        setCategory("general");
        setDescription("Displays a greeting message, to test the bot.");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("");
	}
	
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		super.executeCommand(messageEvent);
		String response = "Hi there! I work!";
		sendMessageToChannel(messageEvent.getChannel().getName(),response);
		//huh, this twitch api works really similarly to the discord api I use
		//that's a good
	}
	
}
