package me.ceramictitan.tracking;

import me.ceramictitan.me.ceramictitan.packet.EntityUtils;
import me.ceramictitan.packet.wrapper.PacketAttachEntity;
import me.ceramictitan.packet.wrapper.PacketSpawnEntity;
import me.ceramictitan.packet.wrapper.PacketSpawnMobEntity;
import org.bukkit.Material;
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
        int block = EntityUtils.generateUUID();
        PacketSpawnEntity spawnBlock = EntityUtils.getPacketSpawnEntity(block,p.getLocation().getX(),p.getLocation().getY(), p.getLocation().getZ());
        PacketSpawnMobEntity spawnSlime = EntityUtils.getPacketSpawnMobEntity(slime1, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 1);
        PacketSpawnMobEntity spawnSecondSlime = EntityUtils.getPacketSpawnMobEntity(slime2, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 1);
        PacketAttachEntity  attachToPlayer = EntityUtils.getPacketAttachEntity(slime1, p.getEntityId());
        PacketAttachEntity  attachToSlime = EntityUtils.getPacketAttachEntity(slime2, slime1);
        PacketAttachEntity  attachBlock = EntityUtils.getPacketAttachEntity(block, slime2);
        spawnBlock.send(p);
        spawnSlime.send(p);
        spawnSecondSlime.send(p);
        attachToPlayer.send(p);
        attachToSlime.send(p);
        attachBlock.send(p);


    }
}
