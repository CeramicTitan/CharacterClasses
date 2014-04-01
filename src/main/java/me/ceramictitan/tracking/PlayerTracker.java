package me.ceramictitan.tracking;

import me.ceramictitan.me.ceramictitan.packet.EntityUtils;
import me.ceramictitan.me.ceramictitan.packet.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
        PlayerUtil.sendPacket(p, EntityUtils.craftSlimeSpawnPacket(EntityType.SLIME.getTypeId(), slime1, p.getLocation(), 1).getHandle());
        Bukkit.getLogger().info("Slime1 spawned!");
        PlayerUtil.sendPacket(p, EntityUtils.craftSlimeSpawnPacket(EntityType.SLIME.getTypeId(), slime2, p.getLocation(), 1).getHandle());
        Bukkit.getLogger().info("Slime2 spawned!");
        PlayerUtil.sendPacket(p, EntityUtils.craftAttachPacket(slime1, p.getEntityId()).getHandle());
        Bukkit.getLogger().info("Slime1 attached to "+ p.getName());
        PlayerUtil.sendPacket(p, EntityUtils.craftAttachPacket(slime2, slime1).getHandle());
        Bukkit.getLogger().info("Slime1 attached to slime slime2!");
        PlayerUtil.sendPacket(p, EntityUtils.craftAttachPacket(icon.getEntityId(), slime2).getHandle());
        Bukkit.getLogger().info("slime2 attached to icon");

    }
}
