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
		boolean isDeveloper = false;
		for(String devId:vars.Constants.developerNames){
            if(devId.equals(event.getAuthor().getId())){
                isDeveloper = true;
                break;
            }
        }
		if(isDeveloper){
			if(message[0].equals(prefix+"!fvcj")){
				if(message.length < 2){
					event.getChannel().sendMessage("Usage: `,!fvcj <channel ID> (server ID)`").queue();
					return;
				}
				//Join execution
				if(message.length == 2){
					AudioManager manager = event.getGuild().getAudioManager();
					manager.openAudioConnection(event.getGuild().getVoiceChannelById(message[1]));
				}else{
					AudioManager manager = vars.Handlers.jdaHandler.getGuildById(message[2]).getAudioManager();
					manager.openAudioConnection(vars.Handlers.jdaHandler.getGuildById(message[2]).getVoiceChannelById(message[1]));
				}
			}else if(message[0].equals(prefix+"!fvcl")){
				//Leave execution
				if(message.length == 1){
					AudioManager manager = event.getGuild().getAudioManager();
					manager.closeAudioConnection();	
				}else{
					AudioManager manager = vars.Handlers.jdaHandler.getGuildById(message[1]).getAudioManager();
					manager.closeAudioConnection();
				}
			}
		}
    }
}
