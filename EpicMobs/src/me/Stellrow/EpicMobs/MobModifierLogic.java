package me.Stellrow.EpicMobs;

import me.Stellrow.EpicMobs.utils.ConfigUtils;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class MobModifierLogic {
    private final EpicMobs pl;
    private ItemStack[] zombieGear;
    private ItemStack[] skeletonGear;
    private int zombieHealth;
    private int skeletonHealth;

    public MobModifierLogic(EpicMobs pl) {
        this.pl = pl;
        zombieHealth = pl.getConfig().getInt("Mobs.zombie.health");
        skeletonHealth = pl.getConfig().getInt("Mobs.skeleton.health");
    }
    public void modifyMob(Entity toBeModified){
        EntityType targetType = toBeModified.getType();
        switch (targetType){
            case ZOMBIE:{
                LivingEntity liv = (LivingEntity) toBeModified;
                liv.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(zombieHealth);
                liv.setHealth(zombieHealth);
                liv.getEquipment().setHelmet(zombieGear[0]);
                liv.getEquipment().setHelmetDropChance(0);
                liv.getEquipment().setChestplate(zombieGear[1]);
                liv.getEquipment().setChestplateDropChance(0);
                liv.getEquipment().setLeggings(zombieGear[2]);
                liv.getEquipment().setLeggingsDropChance(0);
                liv.getEquipment().setBoots(zombieGear[3]);
                liv.getEquipment().setBootsDropChance(0);
                liv.getEquipment().setItemInMainHand(zombieGear[4]);
                liv.getEquipment().setItemInMainHandDropChance(0);
            }
            case SKELETON:{
                LivingEntity liv = (LivingEntity) toBeModified;
                liv.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(skeletonHealth);
                liv.setHealth(skeletonHealth);
                liv.getEquipment().setHelmet(skeletonGear[0]);
                liv.getEquipment().setHelmetDropChance(0);
                liv.getEquipment().setChestplate(skeletonGear[1]);
                liv.getEquipment().setChestplateDropChance(0);
                liv.getEquipment().setLeggings(skeletonGear[2]);
                liv.getEquipment().setLeggingsDropChance(0);
                liv.getEquipment().setBoots(skeletonGear[3]);
                liv.getEquipment().setBootsDropChance(0);
            }
        }
    }
    public void updateGear(){
        zombieGear = ConfigUtils.getMonsterEquipment("zombie");
        skeletonGear = ConfigUtils.getMonsterEquipment("skeleton");
    }
}
