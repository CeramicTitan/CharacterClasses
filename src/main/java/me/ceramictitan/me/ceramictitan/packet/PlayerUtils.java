package me.ceramictitan.me.ceramictitan.packet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;

public class PlayerUtils {


    public static void sendPacket(Player player, Object packet){
        Method sendPacket = ReflectionUtils.getMethod(ReflectionUtils.getNMSClass("PlayerConnection"), "sendPacket", ReflectionUtils.getNMSClass("Packet"));
        Object playerConnection = getPlayerConnection(player);

        try {
            sendPacket.invoke(playerConnection, packet);
        } catch (Exception e) {
            Bukkit.getLogger().warning("Failed to send a packet to: " + player.getName());
            e.printStackTrace();
        }
    }

    public static Object playerToEntityPlayer(Player player){
        Method getHandle = ReflectionUtils.getMethod(player.getClass(), "getHandle");
        try {
            return getHandle.invoke(player);
        } catch (Exception e) {
            Bukkit.getLogger().warning("Failed retrieve the NMS Player-Object of:" + player.getName());
            return null;
        }
    }

    public static Object getPlayerConnection(Player player){
        Object connection = ReflectionUtils.getField(ReflectionUtils.getNMSClass("EntityPlayer"), "playerConnection", playerToEntityPlayer(player));
        return connection;
    }

}