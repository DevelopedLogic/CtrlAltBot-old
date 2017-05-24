package events;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Shutdown extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix;
		String message = event.getMessage().getContent();
		if(message.equals(prefix+"quit")){
			event.getChannel().sendMessage("Bot backend will shut down in 3 seconds!").queue();
			main.State.setDnd();
			try{
				TimeUnit.SECONDS.sleep(3);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			main.State.shutdown();
		}
    }
}
