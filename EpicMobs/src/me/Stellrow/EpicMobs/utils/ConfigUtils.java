package me.Stellrow.EpicMobs.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;


public class ConfigUtils {
    private static FileConfiguration cfg;
    private static NamespacedKey pluginkey;
    public static void setCfg(FileConfiguration cfgu){
        cfg=cfgu;
    }
    public static void setPluginkey(NamespacedKey key){
        pluginkey=key;
    }

    public static ItemStack[] getMonsterEquipment(String configPath){
        //Helmet
        String path = "Mobs."+configPath+".equipment.";
        ItemStack helmet = null;
        if(cfg.contains(path+"helmet")) {
            helmet = new ItemStack(Material.valueOf(cfg.getString(path+"helmet.Type")));
            ItemMeta helmetMeta = helmet.getItemMeta();
            helmetMeta.getPersistentDataContainer().set(pluginkey, PersistentDataType.STRING,"epicmob");
            if(cfg.contains(path+"helmet.Enchantments")){
                for (String ec : cfg.getStringList(path+"helmet.Enchantments")){
                    String[] trsn = ec.split(" ");
                    helmetMeta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(trsn[0].toLowerCase())),Integer.parseInt(trsn[1]),true);
                }
                helmet.setItemMeta(helmetMeta);
            }
        }
        ItemStack chestplate = null;
        if(cfg.contains(path+"chestplate")) {
            chestplate = new ItemStack(Material.valueOf(cfg.getString(path+"chestplate.Type")));
            ItemMeta chestplateMeta = chestplate.getItemMeta();
            chestplateMeta.getPersistentDataContainer().set(pluginkey, PersistentDataType.STRING,"epicmob");
            if(cfg.contains(path+"chestplate.Enchantments")){
                for (String ec : cfg.getStringList(path+"chestplate.enchantments")){
                    String[] trsn = ec.split(" ");
                    chestplateMeta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(trsn[0].toLowerCase())),Integer.parseInt(trsn[1]),true);
                }
                chestplate.setItemMeta(chestplateMeta);
            }
        }
        ItemStack leggings = null;
        if(cfg.contains(path+"leggings")) {
            leggings = new ItemStack(Material.valueOf(cfg.getString(path+"leggings.Type")));
            ItemMeta leggingsMeta = leggings.getItemMeta();
            leggingsMeta.getPersistentDataContainer().set(pluginkey, PersistentDataType.STRING,"epicmob");
            if(cfg.contains(path+"leggings.Enchantments")){
                for (String ec : cfg.getStringList(path+"leggings.Enchantments")){
                    String[] trsn = ec.split(" ");
                    leggingsMeta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(trsn[0].toLowerCase())),Integer.parseInt(trsn[1]),true);
                }
                leggings.setItemMeta(leggingsMeta);
            }
        }
        ItemStack boots = null;
        if(cfg.contains(path+"boots")) {
            boots = new ItemStack(Material.valueOf(cfg.getString(path+"boots.Type")));
            ItemMeta bootsMeta = boots.getItemMeta();
            bootsMeta.getPersistentDataContainer().set(pluginkey, PersistentDataType.STRING,"epicmob");
            if(cfg.contains(path+"boots.Enchantments")){
                for (String ec : cfg.getStringList(path+"boots.Enchantments")){
                    String[] trsn = ec.split(" ");
                    bootsMeta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(trsn[0].toLowerCase())),Integer.parseInt(trsn[1]),true);
                }
                boots.setItemMeta(bootsMeta);
            }
        }
        ItemStack hand = null;
        if(cfg.contains(path+"hand")) {
            hand = new ItemStack(Material.valueOf(cfg.getString(path+"hand.Type")));
            ItemMeta handMeta = hand.getItemMeta();
            if(cfg.contains(path+"hand.Enchantments")){
                for (String ec : cfg.getStringList(path+"hand.Enchantments")){
                    String[] trsn = ec.split(" ");
                    handMeta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(trsn[0].toLowerCase())),Integer.parseInt(trsn[1]),true);
                }
                hand.setItemMeta(handMeta);
            }
        }
        return new ItemStack[]{helmet, chestplate, leggings, boots,hand};
    }

}
