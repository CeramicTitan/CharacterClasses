package me.ceramictitan.packet.wrapper;

import me.ceramictitan.me.ceramictitan.packet.Packet;
import me.ceramictitan.me.ceramictitan.packet.PacketType;
import me.ceramictitan.me.ceramictitan.packet.SafeMethod;

public class PacketEntityMetadata extends Packet {

    public PacketEntityMetadata() {

        super(PacketType.ENTITY_METADATA);
    }

    public void setEntityId(int value) {
        this.write("a", value);
    }

    public int getEntityId() {
        return (Integer) this.read("a");
    }

    public void setMetadata(DataWatcher metadata) {
        Object handle = metadata.getHandle();
        this.write("b", new SafeMethod<Void>(handle.getClass(), "c").invoke(handle));
    }
}