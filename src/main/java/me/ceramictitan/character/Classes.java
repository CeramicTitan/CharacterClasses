package me.ceramictitan.character;

import me.ceramictitan.me.ceramictitan.packet.EntityUtils;
import me.ceramictitan.tracking.PlayerTracker;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
            Player p = (Player)sender;
            PlayerTracker tracker = new PlayerTracker(p);
                tracker.showTrackingIcon(new ItemStack(Material.DIAMOND_BLOCK,1));
        }
    }
        if(cmd.getName().equalsIgnoreCase("generate") && args.length == 0){
            sender.sendMessage(String.valueOf(EntityUtils.generateEntityID()));
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("kill") && args.length == 0 && EntityUtils.getUUIDS().size() > 0){
            if(sender instanceof Player){
                Player player = (Player)sender;
                EntityUtils.killMobs(player, EntityUtils.toIntArray(EntityUtils.getUUIDS()));
            return true;
            }
        }
        return false;
}
}
