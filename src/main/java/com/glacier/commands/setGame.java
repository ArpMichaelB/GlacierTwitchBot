package com.glacier.commands;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class setGame extends Command {
	public setGame()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"game");
		setCommandAliases(new String[]{});
		setCategory("general");
        setDescription("Based on the command/arguments and what's available, fill the user in on some friend codes.");
        getRequiredPermissions().add(CommandPermission.MODERATOR);
        setUsageExample("");
	}
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		if(messageEvent.getMessage().split(" ").length == 1)
		{
			sendMessageToChannel(messageEvent.getChannel().getName(),"I need a game to set with, dude!");
		}
		else
		{
			String game = "";
			for(String x : messageEvent.getMessage().split(" "))
			{
				if(!x.contains("~"))
				{
					game+=(x + " ");
				}
			}
			messageEvent.getChannel().setGame(game);
			sendMessageToChannel(messageEvent.getChannel().getName(),"Game has been set to " + game);
		}
	}
}
