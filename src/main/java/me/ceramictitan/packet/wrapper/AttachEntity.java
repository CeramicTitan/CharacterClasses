package me.ceramictitan.packet.wrapper;

import me.ceramictitan.me.ceramictitan.packet.Packet;
import me.ceramictitan.me.ceramictitan.packet.PacketType;

public class AttachEntity extends Packet {

    public AttachEntity() {
        super(PacketType.ENTITY_ATTACH);
    }

    public void setLeached(boolean flag) {
        this.write("a", flag ? 1 : 0);
    }

    public boolean getLeached() {
        return (Integer) this.read("a") != 0;
    }

    public void setEntityId(int value) {
        this.write("b", value);
    }

    public int getEntityId() {
        return (Integer) this.read("b");
    }

    public void setVehicleId(int value) {
        this.write("c", value);
    }

    public int getVehicleId() {
        return (Integer) this.read("c");
    }
}