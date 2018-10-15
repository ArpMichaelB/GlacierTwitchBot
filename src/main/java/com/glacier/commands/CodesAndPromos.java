package com.glacier.commands;

import com.glacier.util.UtilsAndConstants;

import me.philippheuer.twitch4j.events.event.irc.ChannelMessageEvent;
import me.philippheuer.twitch4j.message.commands.Command;
import me.philippheuer.twitch4j.message.commands.CommandPermission;

public class CodesAndPromos extends Command {
	public CodesAndPromos()
	{
		setRequiresCommandTrigger(false);
		setCommand(UtilsAndConstants.prefix+"friendcode");
		setCommandAliases(new String[]{UtilsAndConstants.prefix+"switch",UtilsAndConstants.prefix+"fc",UtilsAndConstants.prefix+"wiiu",UtilsAndConstants.prefix+"promo"});
		setCategory("general");
        setDescription("Based on the command/arguments and what's available, fill the user in on some friend codes.");
        getRequiredPermissions().add(CommandPermission.EVERYONE);
        setUsageExample("~friendcode switch");
	}
	@Override
	public void executeCommand(ChannelMessageEvent messageEvent)
	{
		String code;
		if(messageEvent.getMessage().contains("friendcode") || messageEvent.getMessage().contains("fc") || messageEvent.getMessage().contains("promo"))
		{
			if(messageEvent.getMessage().split(" ").length == 1)
			{
				sendMessageToChannel(messageEvent.getChannel().getName(),"Gonna need one to look for, bud.");
			}
			code = UtilsAndConstants.properties.getProperty(messageEvent.getMessage().split(" ")[1].toLowerCase() + ".code", "nothing, because I don't have that!");
			sendMessageToChannel(messageEvent.getChannel().getName(),"Here, have " + code + "!");
		}
		else if(messageEvent.getMessage().toLowerCase().contains("switch"))
		{
			code = UtilsAndConstants.properties.getProperty("switch.code", " not found.");
			sendMessageToChannel(messageEvent.getChannel().getName(),"The Switch friend code is " + code);
		}
		else if(messageEvent.getMessage().toLowerCase().contains("wiiu"))
		{
			code = UtilsAndConstants.properties.getProperty("wiiu.code"," not found.");
			sendMessageToChannel(messageEvent.getChannel().getName(),"The Wii U friend code is " + code);
		}
		
		
	}
}
