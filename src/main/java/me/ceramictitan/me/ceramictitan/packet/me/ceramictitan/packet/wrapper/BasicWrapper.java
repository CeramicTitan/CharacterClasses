package me.ceramictitan.me.ceramictitan.packet.me.ceramictitan.packet.wrapper;

import me.ceramictitan.me.ceramictitan.packet.ReflectionUtils;
import org.bukkit.Bukkit;

public class BasicWrapper {

    protected Object handle;

    public BasicWrapper() {}

    public BasicWrapper(String className) {
        try {
            setHandle(ReflectionUtils.getNMSClass(className).newInstance());
        } catch (Exception e) {
            Bukkit.getLogger().warning("Could not set handle!");
            e.printStackTrace();
        }
    }

    protected void setHandle(Object handle) {
        if(handle == null) {
            throw new UnsupportedOperationException("Cannot set handle to null!");
        }
        this.handle = handle;
    }

    public Object getHandle() {
        return this.handle;
    }
}
