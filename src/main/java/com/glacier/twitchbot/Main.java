package com.glacier.twitchbot;

import com.glacier.bot.Robot;

public class Main {

	public static void main(String[] args) {
		
		Robot bot = new Robot();
		bot.registerCommands();
		bot.registerEvents();
		bot.launch();
		
	}

}
