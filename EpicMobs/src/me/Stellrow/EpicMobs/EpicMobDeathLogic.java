package me.Stellrow.EpicMobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Random;

public class EpicMobDeathLogic implements Listener {
    private final NamespacedKey pluginKey;
    private List<String> rewards;
    private Random rnd = new Random();

    public EpicMobDeathLogic(NamespacedKey pluginKey,List<String> rewards) {
        this.rewards=rewards;
        this.pluginKey=pluginKey;
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event){
        if(isAnEpicMob(event.getEntity())){
            event.getEntity().getKiller().sendMessage(ChatColor.GREEN+"Ai ucis un mob epic! Vei primi o rasplata acum!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),rewards.get(rnd.nextInt(rewards.size())).replaceAll("%player",event.getEntity().getKiller().getName()));
            return;
        }
    }
    private boolean isAnEpicMob(LivingEntity entity){
        if(entity.getEquipment().getHelmet()!=null){
            if(entity.getEquipment().getHelmet().hasItemMeta()&&entity.getEquipment().getHelmet().getItemMeta().getPersistentDataContainer().has(pluginKey, PersistentDataType.STRING)){
                return true;
            }
        }
        if(entity.getEquipment().getChestplate()!=null){
            if(entity.getEquipment().getChestplate().hasItemMeta()&&entity.getEquipment().getChestplate().getItemMeta().getPersistentDataContainer().has(pluginKey, PersistentDataType.STRING)){
                return true;
            }
        }
        if(entity.getEquipment().getLeggings()!=null){
            if(entity.getEquipment().getLeggings().hasItemMeta()&&entity.getEquipment().getLeggings().getItemMeta().getPersistentDataContainer().has(pluginKey, PersistentDataType.STRING)){
                return true;
            }
        }
        if(entity.getEquipment().getBoots()!=null){
            if(entity.getEquipment().getBoots().hasItemMeta()&&entity.getEquipment().getBoots().getItemMeta().getPersistentDataContainer().has(pluginKey, PersistentDataType.STRING)){
                return true;
            }
        }
        return false;
    }
}
