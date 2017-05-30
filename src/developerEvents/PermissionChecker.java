package developerEvents;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class PermissionChecker extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String message = event.getMessage().getContent(); //Grab the actual message
		if(message.equals(prefix+"!permissioncheck")){
			if(event.getAuthor().getAsMention().equals(vars.Constants.developerName)){
				event.getChannel().sendMessage("You are registered as a developer!").queue();
			}else{
				event.getChannel().sendMessage("You are not registered as a developer!").queue();
			}
		}
    }
}
