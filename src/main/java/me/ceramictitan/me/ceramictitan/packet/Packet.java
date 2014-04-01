package me.ceramictitan.me.ceramictitan.packet;

import me.ceramictitan.packet.wrapper.AbstractWrapper;
import me.ceramictitan.packets.protocol.Protocol;
import org.bukkit.entity.Player;

import java.util.Map;

public class Packet {

    private Class packetClass;
    private Object packetHandle;
    private Protocol protocol;
    private Sender sender;

    public Packet(PacketType packetType) {
        this(packetType.getProtocol(), packetType.getSender(), packetType.getId(), packetType.getLegacyId());
    }

    public Packet(Protocol protocol, Sender sender, int id, int legacyId) {


            this.packetClass = PacketUtil.getPacket(protocol, sender, id);
            try {
                this.packetHandle = this.packetClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
    }

    /**
     * This class needs a lot improvement :/
     *
     * @param packet
     */
    public Packet(Object packet) {
        this.packetHandle = packet;
        this.packetClass = packet.getClass();
    }

    public <T> T read(String fieldName) {
        return ReflectionUtil.getField(getPacketClass(), fieldName, this.getPacketHandle());
    }

    public void write(String fieldName, Object value) {
        ReflectionUtil.setField(getPacketClass(), fieldName, getPacketHandle(), value);
    }

    public void send(Player receiver) {
        PlayerUtil.sendPacket(receiver, getPacketHandle());
    }

    public Class getPacketClass() {
        return this.packetClass;
    }

    public Object getPacketHandle() {
        return this.packetHandle;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public Sender getSender() {
        return this.sender;
    }
}