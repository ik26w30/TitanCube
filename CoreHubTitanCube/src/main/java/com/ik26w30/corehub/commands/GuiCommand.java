package com.ik26w30.corehub.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Inventory inv = Bukkit.createInventory(null, 36, "Gui");

        p.openInventory(inv);

        return false;
    }
}
