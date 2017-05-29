package events;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class StateControls extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix;
		String message = event.getMessage().getContent();
		if(message.equals(prefix+"dnd")){
			main.State.setDnd();
			event.getChannel().sendMessage("Do Not Disturb Mode!");
		}else if(message.equals(prefix+"online")){
			main.State.setOnline();
			event.getChannel().sendMessage("Online Mode!");
		}else if(message.equals(prefix+"idle")){
			main.State.setIdle();
			event.getChannel().sendMessage("Idle Mode!");
		}else if(message.equals(prefix+"offline")){
			main.State.setOffline();
			event.getChannel().sendMessage("Offline Mode!");
		}
    }
}
