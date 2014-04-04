package me.ceramictitan.tracking;

import com.comphenix.packetwrapper.WrapperPlayServerAttachEntity;
import com.comphenix.packetwrapper.WrapperPlayServerEntityMetadata;
import com.comphenix.packetwrapper.WrapperPlayServerSpawnEntity;
import com.comphenix.packetwrapper.WrapperPlayServerSpawnEntityLiving;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import me.ceramictitan.me.ceramictitan.packet.EntityUtils;
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

    public void showTrackingIcon(ItemStack icon) {
        Player p = getTracker();
        int slime1 = EntityUtils.generateEntityID();
        int slime2 = EntityUtils.generateEntityID();
        int blockEntityId = EntityUtils.generateEntityID();
        WrapperPlayServerSpawnEntityLiving ent1 = EntityUtils.spawnSlime(slime1, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 1);
        WrapperPlayServerSpawnEntityLiving ent2 = EntityUtils.spawnSlime(slime2, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 1);
        ent1.sendPacket(p);
        ent2.sendPacket(p);
        Bukkit.getLogger().info("slime1: "+ent1.getEntityID()+" Slime2: "+ent2.getEntityID());
        WrapperPlayServerAttachEntity attachToPlayer = EntityUtils.attachEntity(ent1.getEntityID(), p.getEntityId());
        attachToPlayer.sendPacket(p);
        WrapperPlayServerAttachEntity attachToSlime = EntityUtils.attachEntity(ent2.getEntityID(), ent1.getEntityID());
        attachToSlime.sendPacket(p);
        WrapperPlayServerSpawnEntity block = EntityUtils.spawnBlock(blockEntityId, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
        block.sendPacket(p);
        WrapperPlayServerAttachEntity attachBlock = EntityUtils.attachEntity(block.getEntityID(), ent2.getEntityID());
        attachBlock.sendPacket(p);
        WrapperPlayServerEntityMetadata meta = EntityUtils.editMeta(block.getEntityID(),icon);
        meta.sendPacket(p);





    }
}
