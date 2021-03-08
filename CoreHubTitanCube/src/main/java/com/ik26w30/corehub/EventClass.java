package com.ik26w30.corehub;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class EventClass implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        /* -- -- */
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName("§aCompass §7(click destro)");
        compass.setItemMeta(compassMeta);

        /* -- INK SACK -- */
        ItemStack inkSack = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        ItemMeta inkSackMeta = inkSack.getItemMeta();
        inkSackMeta.setDisplayName("§aAbilita velocita §7(click destro)");
        inkSack.setItemMeta(inkSackMeta);

        /* -- OAK FENCE -- */
        ItemStack oakFence = new ItemStack(Material.DARK_OAK_FENCE);
        ItemMeta oakFenceMeta = oakFence.getItemMeta();
        oakFenceMeta.setDisplayName("§aParkour §7(click destro)");
        oakFence.setItemMeta(oakFenceMeta);

        /* -- DIAMOND SWORD -- */
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta diamondSwordMeta = diamondSword.getItemMeta();
        diamondSwordMeta.setDisplayName("§aSpada PvP §7(click destro)");
        diamondSword.setItemMeta(diamondSwordMeta);

        /* -- CHEST -- */
        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.setDisplayName("§aGadgets §7(click destro)");
        chest.setItemMeta(chestMeta);

        /* -- HEAD -- */
        ItemStack head = new ItemStack(Material.SKULL_ITEM);
        ItemMeta headMeta = head.getItemMeta();
        headMeta.setDisplayName("§aIl mio profilo §7(click destro)");
        head.setItemMeta(headMeta);
        
        e.getPlayer().getInventory().setItem(0, compass);
        e.getPlayer().getInventory().setItem(1, inkSack);
        e.getPlayer().getInventory().setItem(2, oakFence);
        e.getPlayer().getInventory().setItem(6, diamondSword);
        e.getPlayer().getInventory().setItem(7, chest);
        e.getPlayer().getInventory().setItem(8, head);

        e.getPlayer().getInventory().setHelmet(new ItemStack(Material.GLASS));
        e.getPlayer().getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        e.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        e.getPlayer().getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));

    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onAction(PlayerInteractEvent e){
        try {
            ItemStack inkSackViolet = new ItemStack(Material.INK_SACK, 1, (byte) 5);
            ItemMeta inkSackVMeta = inkSackViolet.getItemMeta();
            inkSackVMeta.setDisplayName("§aDisabilita velocita §7(click destro)");
            inkSackViolet.setItemMeta(inkSackVMeta);

            /*  ----------------  */

            ItemStack inkSack = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta inkSackMeta = inkSack.getItemMeta();
            inkSackMeta.setDisplayName("§aAbilita velocita §7(click destro)");
            inkSack.setItemMeta(inkSackMeta);

            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAbilita velocita §7(click destro)")){
                e.getPlayer().getInventory().setItem(1, inkSackViolet);
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 1));
            }else if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aDisabilita velocita §7(click destro)")){
                e.getPlayer().getActivePotionEffects().clear();
                e.getPlayer().getInventory().setItem(1, inkSack);
            }

            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCompass §7(click destro)")){
                Inventory inv = Bukkit.createInventory(null, 36, "Gui");
                e.getPlayer().openInventory(inv);
            }

            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpada PvP §7(click destro)")){
                ItemStack redStone = new ItemStack(Material.REDSTONE);
                ItemMeta redStoneMeta = redStone.getItemMeta();
                redStoneMeta.setDisplayName("§cStop PvP");
                redStone.setItemMeta(redStoneMeta);

                /* ------ */

                e.getPlayer().sendMessage("§aBitwise 5 seconds you will PvP");
                new
                        BukkitRunnable(){

                            @Override
                            public void run() {
                                e.getPlayer().sendMessage("§aYou can do PvP now!");
                                e.getPlayer().getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                                e.getPlayer().getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                                e.getPlayer().getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                                e.getPlayer().getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                                e.getPlayer().getInventory().clear(0);
                                e.getPlayer().getInventory().clear(1);
                                e.getPlayer().getInventory().clear(2);
                                e.getPlayer().getInventory().clear(6);
                                e.getPlayer().getInventory().clear(7);
                                e.getPlayer().getInventory().clear(8);
                                e.getPlayer().getInventory().setItem(4, new ItemStack(Material.DIAMOND_SWORD));
                                e.getPlayer().getInventory().setItem(8, redStone);
                            }
                        }.runTaskLater(CoreHub.getInstance(), 100);
            }

            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cStop PvP")){
                e.getPlayer().sendMessage("§aYou will stop PvP bitwise 5 seconds");
                new BukkitRunnable(){

                    @Override
                    public void run() {
                        e.getPlayer().sendMessage("§aYou can't do PvP now!");
                        e.getPlayer().getInventory().clear(4);
                        e.getPlayer().getInventory().clear(8);
                        e.getPlayer().getInventory().setHelmet(new ItemStack(Material.GLASS));
                        e.getPlayer().getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        e.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        e.getPlayer().getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        e.getPlayer().kickPlayer("Rejoin");

                    }
                }.runTaskLater(CoreHub.getInstance(), 100);
            }
        }catch (NullPointerException ex){

        }

    }

    @EventHandler
    public void onMove(PlayerDropItemEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        e.setCancelled(true);
    }

}
