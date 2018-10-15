package com.glacier.commands;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class DiscordAnnouncement extends Command {
	public DiscordAnnouncement()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"discord");
		setCommandAliases(new String[]{UtilsAndConstants.prefix+"chat"});
		setCategory("general");
        setDescription("If we have a discord, shout it out! If not, tell the user that.");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("");
	}
	
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		super.executeCommand(messageEvent);
		String discordLink = UtilsAndConstants.properties.getProperty("discord.link", "no actual discord");
		if(discordLink.equals("no actual discord"))
		{
			sendMessageToChannel(messageEvent.getChannel().getName(),"Looks like there's no discord set up!");
		}
		else
		{
			sendMessageToChannel(messageEvent.getChannel().getName(),"The discord is right here!\n" + discordLink);
		}
	}
}
