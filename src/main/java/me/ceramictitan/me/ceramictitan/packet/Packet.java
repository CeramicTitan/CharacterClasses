package me.ceramictitan.me.ceramictitan.packet;

import me.ceramictitan.packet.wrapper.BasicWrapper;

public class Packet extends BasicWrapper {

    public Packet(String packetName) {
        super(packetName);
    }

    public void setField(String fieldName, Object value) {
        ReflectionUtils.setField(getHandle().getClass(), fieldName, getHandle(), value);
    }
}