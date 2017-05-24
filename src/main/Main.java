package main;

import javax.security.auth.login.LoginException;

import events.*;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Main{
    public static void main(String[] args) throws LoginException, RateLimitedException, InterruptedException{
        JDA bot = new JDABuilder(vars.BotConfig.accType).setToken(vars.BotConfig.token).buildBlocking();
        vars.Handlers.jdaHandler = bot;
        UI.init();
        bot.getPresence().setGame(Game.of(vars.BotConfig.prefix+"help")); //Not using State as this is the default.
        OnlineAct.statePresence();
        
        
        Reg.register(new Hello());
        Reg.register(new Shutdown());
        Reg.register(new Announce());
    }
}