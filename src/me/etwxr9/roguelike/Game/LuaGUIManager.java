package me.etwxr9.roguelike.Game;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

public class LuaGUIManager implements Listener {
    public static Map<Inventory, Map<Integer, GUIButton>> invMap = new HashMap<Inventory, Map<Integer, GUIButton>>();

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        var buttons = invMap.get(e.getClickedInventory());
        if (buttons == null) {
            // e.getWhoClicked().sendMessage("没找到btn");
            return;
        }
        ItemStack item = e.getCurrentItem();
        if (item == null) {
            return;
        }
        GUIButton button = buttons.get(e.getSlot());

        if (button == null)
            return;
        e.setCancelled(true);
        button.func.call(CoerceJavaToLua.coerce((Player) e.getWhoClicked()));
        // e.getInventory().clear();
        // e.getWhoClicked().closeInventory();
        // invMap.remove(e.getInventory());
    }

    public static void DestoryGUI(Inventory inv) {
        inv.clear();
        invMap.remove(inv);
    }

}
