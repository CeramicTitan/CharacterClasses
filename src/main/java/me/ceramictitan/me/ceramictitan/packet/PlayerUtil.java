package me.ceramictitan.me.ceramictitan.packet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PlayerUtil {

    private static final Method sendPacket = ReflectionUtil.getMethod(ReflectionUtil.getNMSClass("PlayerConnection"), "sendPacket", ReflectionUtil.getNMSClass("Packet"));

    public static void sendPacket(Player player, Object packet) {
        Object playerConnection = getPlayerConnection(player);
        try {
            sendPacket.invoke(playerConnection, packet);
        } catch (IllegalAccessException e) {
            Bukkit.getLogger().warning("Failed to retrieve the PlayerConnection of: " + player.getName());
        } catch (IllegalArgumentException e) {
            Bukkit.getLogger().warning("Failed to retrieve the PlayerConnection of: " + player.getName());
        } catch (InvocationTargetException e) {
            Bukkit.getLogger().warning("Failed to retrieve the PlayerConnection of: " + player.getName());
        }
    }

    public static Object playerToEntityPlayer(Player player) {
        Method getHandle = ReflectionUtil.getMethod(player.getClass(), "getHandle");
        try {
            return getHandle.invoke(player);
        } catch (IllegalAccessException e) {
            Bukkit.getLogger().warning("Failed retrieve the NMS Player-Object of:" + player.getName());
            return null;
        } catch (IllegalArgumentException e) {
            Bukkit.getLogger().warning("Failed retrieve the NMS Player-Object of:" + player.getName());
            return null;
        } catch (InvocationTargetException e) {
            Bukkit.getLogger().warning("Failed retrieve the NMS Player-Object of:" + player.getName());
            return null;
        }
    }

    public static Object getPlayerConnection(Player player) {
        return ReflectionUtil.getField(ReflectionUtil.getNMSClass("EntityPlayer"), "playerConnection", playerToEntityPlayer(player));
    }
}