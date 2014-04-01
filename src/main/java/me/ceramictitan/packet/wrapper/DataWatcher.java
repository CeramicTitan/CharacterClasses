package me.ceramictitan.packet.wrapper;


import me.ceramictitan.me.ceramictitan.packet.ReflectionUtils;
import org.bukkit.Bukkit;

public class DataWatcher extends BasicWrapper {

    public DataWatcher() {

        try {
            setHandle(ReflectionUtils.getNMSClass("DataWatcher").getDeclaredConstructor(new Class[]{ReflectionUtils.getNMSClass("Entity")}).newInstance(new Object[]{null}));
        } catch (Exception e) {
            Bukkit.getLogger().warning("Failed to create new DataWatcher!");
            e.printStackTrace();
        }

    }

    public void write(int i, Object object){
        ReflectionUtils.invokeMethod(ReflectionUtils.getMethod(getHandle().getClass(), "a", int.class, Object.class), getHandle(), i, object);
    }
}
