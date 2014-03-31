package me.ceramictitan.me.ceramictitan.packet;

import me.ceramictitan.me.ceramictitan.packet.me.ceramictitan.packet.wrapper.BasicWrapper;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.util.logging.Level;

public class Packet extends BasicWrapper {

    public Packet(String packetName) {
        super(packetName);
    }

    public void setField(String fieldName, Object value) {
        ReflectionUtils.setField(getHandle().getClass(), fieldName, getHandle(), value);
    }
}