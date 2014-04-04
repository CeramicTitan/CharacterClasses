package me.ceramictitan.tracking;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class Tracker {
    HashMap<String, String> tracker = new HashMap<String, String>();

    public abstract Player getTracker();
    public abstract Player setTracker(Player player);
    public abstract void showTrackingIcon(ItemStack icon);
}
