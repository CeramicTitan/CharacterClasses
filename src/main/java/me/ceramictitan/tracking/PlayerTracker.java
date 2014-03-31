package me.ceramictitan.tracking;

import me.ceramictitan.me.ceramictitan.packet.EntityUtils;
import me.ceramictitan.me.ceramictitan.packet.Packet;
import me.ceramictitan.me.ceramictitan.packet.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerTracker extends Tracker{
    private Player player;

    public PlayerTracker(Player player){
        this.player = player;
    }
    public Player getTracker() {
       return player;
    }


    public Player setTracker(Player player) {
       return this.player = player;
    }

    public void showTrackingIcon() {
        Player p = getTracker();
        int slime1 = EntityUtils.generateUUID();
        int slime2 = EntityUtils.generateUUID();
        Item icon = p.getWorld().dropItemNaturally(p.getEyeLocation(), new ItemStack(Material.DIAMOND_BLOCK));
        Bukkit.getLogger().info("Slime1 entityId: "+slime1);
        Bukkit.getLogger().info("Slime2 entityId: "+ slime2);
        PlayerUtils.sendPacket(p, EntityUtils.craftSlimeSpawnPacket(EntityType.SLIME.getTypeId(), slime1, p.getLocation(), 1).getHandle());
        Bukkit.getLogger().info("Slime1 spawned!");
        PlayerUtils.sendPacket(p, EntityUtils.craftSlimeSpawnPacket(EntityType.SLIME.getTypeId(), slime2, p.getLocation(), 1).getHandle());
        Bukkit.getLogger().info("Slime2 spawned!");
        PlayerUtils.sendPacket(p, EntityUtils.craftAttachPacket(p.getEntityId(), slime1).getHandle());
        Bukkit.getLogger().info("Slime1 attached to "+ p.getName());
        PlayerUtils.sendPacket(p, EntityUtils.craftAttachPacket(slime1, slime2).getHandle());
        Bukkit.getLogger().info("Slime1 attached to slime slime2!");
        PlayerUtils.sendPacket(p, EntityUtils.craftAttachPacket(slime2, icon.getEntityId()).getHandle());
        Bukkit.getLogger().info("slime2 attached to icon");

    }
}
