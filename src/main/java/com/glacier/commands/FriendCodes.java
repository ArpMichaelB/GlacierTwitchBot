package com.glacier.commands;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class FriendCodes extends Command {
	public FriendCodes()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"friendcode");
		setCommandAliases(new String[]{UtilsAndConstants.prefix+"switch",UtilsAndConstants.prefix+"fc",UtilsAndConstants.prefix+"wiiu"});
		setCategory("general");
        setDescription("Based on the command/arguments and what's available, fill the user in on some friend codes.");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("~friendcode switch");
	}
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		String switchCode = UtilsAndConstants.properties.getProperty("code.switch", " not saved.");
		String wiiUCode = UtilsAndConstants.properties.getProperty("code.wiiu", " not saved.");
		if(messageEvent.getMessage().contains("friendcode") || messageEvent.getMessage().contains("fc"))
		{
			if(messageEvent.getMessage().split(" ").length == 1)
			{
				sendMessageToChannel(messageEvent.getChannel().getName(),"Gonna need one to look for, bud.");
			}
			else if(messageEvent.getMessage().split(" ")[1].toLowerCase().contains("switch"))
			{
				sendMessageToChannel(messageEvent.getChannel().getName(),"The Switch friend code is " + switchCode);
			}
			else if(messageEvent.getMessage().split(" ")[1].toLowerCase().contains("wiiu"))
			{
				sendMessageToChannel(messageEvent.getChannel().getName(),"The Wii U friend code is " + wiiUCode);
			}
			else
			{
				sendMessageToChannel(messageEvent.getChannel().getName(),"Ope, that's not a valid argument. Try WiiU or Switch?");
			}
		}
		else if(messageEvent.getMessage().toLowerCase().contains("switch"))
		{
			sendMessageToChannel(messageEvent.getChannel().getName(),"The Switch friend code is " + switchCode);
		}
		else if(messageEvent.getMessage().toLowerCase().contains("wiiu"))
		{
			sendMessageToChannel(messageEvent.getChannel().getName(),"The Wii U friend code is " + wiiUCode);
		}
	}
}
