package me.ceramictitan.me.ceramictitan.packet;

import me.ceramictitan.packet.wrapper.DataWatcher;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class EntityUtils {

    static int ID_INDEX = Integer.MIN_VALUE;

    static List<Integer> uuids = new ArrayList<Integer>();

    public static Packet craftAttachPacket(int entity, int vehicle) {
        Packet packet = new Packet("PacketPlayOutAttachEntity");
        packet.setField("a", entity);
        packet.setField("b", vehicle);
        packet.setField("c", 0);
        return packet;
    }

    public static Packet craftSlimeSpawnPacket(int entityType, int id, Location location, int size) {

        Packet packet = new Packet("PacketPlayOutSpawnEntityLiving");

        packet.setField("a", id);
        packet.setField("b", entityType);
        packet.setField("c", floor(location.getX()));
        packet.setField("d", floor(location.getY()));
        packet.setField("e",floor(location.getZ()));
        packet.setField("i",asCompressedAngle(location.getYaw()));
        packet.setField("j",asCompressedAngle(location.getPitch()));

            DataWatcher watcher = new DataWatcher();
            //watcher.write(0, (Object)(byte)0x20);
            watcher.write(6, (Object)20.0f);
            watcher.write(16, (Object)(byte)size);

        packet.setField("l", watcher.getHandle());

        return packet;
    }
    public static Packet craftEntityDestroyPacket(int... entityIds){
        List<Integer> list = new ArrayList<Integer>();
        Packet packet = new Packet("PacketPlayOutEntityDestroy");
        for(int ids : entityIds){list.add(ids);}
        packet.setField("a", list.toArray());
        return packet;
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
}