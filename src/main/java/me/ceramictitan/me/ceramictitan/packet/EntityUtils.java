package me.ceramictitan.me.ceramictitan.packet;

import com.comphenix.packetwrapper.*;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityUtils {

    static int ID_INDEX = Integer.MIN_VALUE;

    static List<Integer> uuids = new ArrayList<Integer>();

    public static List<Integer> getUUIDS(){
        return uuids;
    }

    public static WrapperPlayServerSpawnEntityLiving spawnSlime(int id, double x, double y, double z, int size){
        WrapperPlayServerSpawnEntityLiving slime = new WrapperPlayServerSpawnEntityLiving();
        slime.setEntityID(id);
        slime.setX(x);
        slime.setY(y);
        slime.setZ(z);
        slime.setType(EntityType.SLIME);
        WrappedDataWatcher watcher = new WrappedDataWatcher();
        //watcher.setObject(0, (byte)0x20);
        watcher.setObject(6, 20.0f);
        watcher.setObject(16, (byte)size);
        slime.setMetadata(watcher);
        return slime;
    }
    public static WrapperPlayServerAttachEntity attachEntity(int entity, int vehicle){
        WrapperPlayServerAttachEntity attach = new WrapperPlayServerAttachEntity();
        attach.setEntityId(entity);
        attach.setVehicleId(vehicle);
        return attach;
    }
    public static WrapperPlayServerSpawnEntity spawnBlock(int id, double x, double y, double z){
        WrapperPlayServerSpawnEntity block = new WrapperPlayServerSpawnEntity();
        block.setEntityID(id);
        block.setX(x);
        block.setY(y);
        block.setZ(z);
        block.setType(2);
        return block;
    }
    public static WrapperPlayServerEntityMetadata editMeta(int id,ItemStack stack){
        WrapperPlayServerEntityMetadata metadata = new WrapperPlayServerEntityMetadata();
        metadata.setEntityId(id);
        metadata.setEntityMetadata(
          Arrays.asList(new WrappedWatchableObject(10, stack))
        );
        return metadata;
    }
    public static void killMobs(Player p,int[] entities){
        WrapperPlayServerEntityDestroy destroy = new WrapperPlayServerEntityDestroy();
        destroy.setEntities(entities);
        destroy.sendPacket(p);
        for(int id : entities){
        p.sendMessage("Entity Destroyed! "+ id);
        }
        getUUIDS().clear();


    }

    public static int generateEntityID(){
        if(!getUUIDS().contains(ID_INDEX)){
            getUUIDS().add(ID_INDEX);
            return ID_INDEX;
        }
        while(getUUIDS().contains(ID_INDEX)){
            getUUIDS().add(++ID_INDEX);
            return ID_INDEX;
        }
        return ID_INDEX;
    }
    public static int[] toIntArray(List<Integer> integerList) {
        int[] intArray = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            intArray[i] = integerList.get(i);
        }
        return intArray;
    }
}