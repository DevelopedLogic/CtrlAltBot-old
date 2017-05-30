package developerEvents;

//This class manages the force voice chat leave and join commands.

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

public class ForceJoinAndLeaveVoice extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String[] message = event.getMessage().getContent().split(" "); //Split the message up into arguments
		if(event.getAuthor().getAsMention().equals(vars.Constants.developerName)){
			if(message[0].equals(prefix+"!fvcj")){
				if(message.length < 2){
					event.getChannel().sendMessage("Usage: `,!fvcj <channel ID>`").queue();
					return;
				}
				//Join execution
				AudioManager manager = event.getGuild().getAudioManager();
				manager.openAudioConnection(event.getGuild().getVoiceChannelById(message[1]));
			}else if(message[0].equals(prefix+"!fvcl")){
				//Leave execution
				AudioManager manager = event.getGuild().getAudioManager();
				manager.closeAudioConnection();
			}
		}
    }
}
