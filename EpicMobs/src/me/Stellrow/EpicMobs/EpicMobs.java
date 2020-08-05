package me.Stellrow.EpicMobs;

import me.Stellrow.EpicMobs.utils.ConfigUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;


public class EpicMobs extends JavaPlugin {
    private NamespacedKey epicmobskey = new NamespacedKey(this,"epicmob");
    private MobModifierLogic mml = new MobModifierLogic(this);
    public void onEnable(){
        loadConfig();
        ConfigUtils.setCfg(getConfig());
        ConfigUtils.setPluginkey(epicmobskey);
        mml.updateGear();
        getServer().getPluginManager().registerEvents(new RandomSelectingLogic(getConfig().getInt("GeneralConfig.chanceToReplaceMob"), this),this);
        getServer().getPluginManager().registerEvents(new EpicMobDeathLogic(epicmobskey,getConfig().getStringList("Rewards")),this);

    }
    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    public MobModifierLogic getMML(){
        return mml;
    }

}
