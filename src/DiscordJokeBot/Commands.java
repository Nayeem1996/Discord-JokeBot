package DiscordJokeBot;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        //Gets message from the Discord chat and checks if first character is the dedicated prefix
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        // If '~info' is entered
        if (args[0].equalsIgnoreCase(DiscordMain.prefix + "info")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("In the average lifetime, a person will walk the equivalent of 5 times around the equator.").queue();

            // If '~joke' is entered
        } else if (args[0].equalsIgnoreCase(DiscordMain.prefix + "joke")) {
            WebScraper x = new WebScraper();
            String y = x.generateJoke();

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(y).queue();
        }
    }
}
