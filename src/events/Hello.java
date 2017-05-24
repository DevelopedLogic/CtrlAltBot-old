package events;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Hello extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix;
		String message = event.getMessage().getContent();
		if(message.equals(prefix+"hello")){
			EmbedBuilder eb = new EmbedBuilder();
	        eb.setDescription("Hello "+event.getAuthor().getAsMention());
	        eb.setColor(new Color(255, 0, 0));
			event.getChannel().sendMessage(eb.build()).queue();
		}
    }
}
