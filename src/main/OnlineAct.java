package main;

import java.util.List;

import net.dv8tion.jda.core.entities.Guild;

public class OnlineAct{
	public static void statePresence(){
		List<Guild> guildList = vars.Handlers.jdaHandler.getGuilds();
		guildList.stream().forEach(guild -> (guild.getPublicChannel().sendMessage("Hello! I'm online!")).queue());
		System.out.println("[OnlineAct] Successfuly notified all Guilds of presence");
	}
}
