package me.ceramictitan.character;

import me.ceramictitan.me.ceramictitan.packet.EntityUtils;
import me.ceramictitan.me.ceramictitan.packet.PlayerUtil;
import me.ceramictitan.tracking.PlayerTracker;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


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
                tracker.showTrackingIcon();
        }
    }
        if(cmd.getName().equalsIgnoreCase("generate") && args.length == 0){
            sender.sendMessage(String.valueOf(EntityUtils.generateUUID()));
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("kill") && args.length == 0 && EntityUtils.getUUIDS().size() > 0){
            if(sender instanceof Player){
                Player player = (Player)sender;
                EntityUtils.getPacketDestroyEntity(EntityUtils.toIntArray(EntityUtils.getUUIDS())).send(player);
                player.sendMessage("Killed all entities");
            return true;
            }
        }
        return false;
}
}
