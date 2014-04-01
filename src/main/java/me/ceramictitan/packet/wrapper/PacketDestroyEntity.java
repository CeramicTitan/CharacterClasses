package me.ceramictitan.packet.wrapper;

import me.ceramictitan.me.ceramictitan.packet.Packet;
import me.ceramictitan.me.ceramictitan.packet.PacketType;

import java.util.Arrays;
import java.util.List;

public class PacketDestroyEntity extends Packet {

    public PacketDestroyEntity() {
        super(PacketType.ENTITY_DESTROY);
    }

    public void setEntities(int[] value) {
        this.write("a", value);
    }

    public List<Integer> getEntities() {
        return Arrays.asList((Integer[]) this.read("a"));
    }
}