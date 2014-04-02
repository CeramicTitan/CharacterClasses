package me.ceramictitan.me.ceramictitan.packet;

import me.ceramictitan.packet.wrapper.*;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class EntityUtils {

    static int ID_INDEX = Integer.MIN_VALUE;

    static List<Integer> uuids = new ArrayList<Integer>();

    public static PacketAttachEntity getPacketAttachEntity(int entity, int vehicle) {
        PacketAttachEntity attach = new PacketAttachEntity();
        attach.setEntityId(entity);
        attach.setVehicleId(vehicle);
        attach.setLeached(false);
        return attach;
    }
    public static PacketSpawnEntity getPacketSpawnEntity(int id, double x, double y, double z){
        PacketSpawnEntity block = new PacketSpawnEntity();
        block.setEntityId(id);
        block.setX(x);
        block.setY(y);
        block.setZ(z);
        block.setEntityType(2);
        block.setData(57);
        return block;
    }

    public static PacketSpawnMobEntity getPacketSpawnMobEntity(int id, double x, double y, double z, int size) {

        PacketSpawnMobEntity spawn = new PacketSpawnMobEntity();

        spawn.setEntityId(id);
        spawn.setEntityType(EntityType.SLIME.getTypeId());
        spawn.setX(x);
        spawn.setY(y);
        spawn.setZ(z);

            DataWatcher watcher = new DataWatcher();
            //watcher.watch(0, (Object)(byte)0x20);
            watcher.watch(6, (Object) 20.0f);
            watcher.watch(16, (Object) (byte) size);

        spawn.setDataWatcher(watcher);

        return spawn;
    }
    public static PacketDestroyEntity getPacketDestroyEntity(int[] entities){
        PacketDestroyEntity destroy = new PacketDestroyEntity();
        destroy.setEntities(entities);
        return destroy;

    }

    public static int floor(double d) {
        return (int) (d * 32.0D);
    }

    public static byte asCompressedAngle(float f) {
        return (byte) (f * 256.0F / 360.0F);
    }
    public static List<Integer> getUUIDS(){
        return uuids;
    }

    public static int generateUUID(){
        if(!getUUIDS().contains(ID_INDEX)){
            getUUIDS().add(ID_INDEX);
            return ID_INDEX;
        }
        while(getUUIDS().contains(ID_INDEX)){
            getUUIDS().add(ID_INDEX++);
            return ID_INDEX++;
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