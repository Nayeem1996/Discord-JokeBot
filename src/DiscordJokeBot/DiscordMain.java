package DiscordJokeBot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class DiscordMain {
    public static JDA jda;
    public static String prefix = "~";

    // Main method
    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken("NTkwNjQ5NTgwMjcwNTE4Mzc3.XQlTYg.sQX_dVzb3e6frC2E6Okm3w7Oy2Q").buildAsync();

        //Set status to idle
        jda.getPresence().setStatus(OnlineStatus.IDLE);
        System.out.println("Current status: " + jda.getPresence().getStatus());

        //Set listening to \m/
        jda.getPresence().setGame(Game.listening("\\m/"));
        System.out.println("Game playing: " + jda.getPresence().getGame().getName());

        jda.addEventListener(new Commands());
    }
}
