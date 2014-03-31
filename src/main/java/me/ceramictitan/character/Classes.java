package me.ceramictitan.character;

import me.ceramictitan.me.ceramictitan.packet.EntityUtils;
import me.ceramictitan.tracking.PlayerTracker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Classes extends JavaPlugin {

    public void onEnable(){

    }
    public void onDisable(){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("track") && args.length == 0){
            if(sender instanceof Player){
            Player player = (Player)sender;
            PlayerTracker tracker = new PlayerTracker(player);
                tracker.showTrackingIcon();
                return true;
        }
    }
        if(cmd.getName().equalsIgnoreCase("generate") && args.length == 0){
            sender.sendMessage(String.valueOf(EntityUtils.generateUUID()));
            return true;
        }
        return false;
}
}
