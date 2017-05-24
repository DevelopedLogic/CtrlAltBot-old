package events;

import java.util.List;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Announce extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		List<Guild> guildList = vars.Handlers.jdaHandler.getGuilds();
		String prefix = vars.BotConfig.prefix;
		String[] message = event.getMessage().getContent().split(" ");
		String compiled = "";
		if(message[0].equals(prefix+"announce")){
			if(message.length < 2){
				event.getChannel().sendMessage("Usage: `"+prefix+"announce <word> (word) (word)...`").queue();
			}else{
				for(int i = 1; i < message.length; i++){
					compiled = compiled+" "+message[i];
				}
				final String compiled1 = compiled;
				guildList.stream().forEach(guild -> (guild.getPublicChannel().sendMessage("`"+compiled1+"`")).queue());
			}
		}
    }
}
