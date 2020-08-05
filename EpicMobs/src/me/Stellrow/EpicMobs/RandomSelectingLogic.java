package me.Stellrow.EpicMobs;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Random;

public class RandomSelectingLogic implements Listener {
    private Random rnd = new Random();
    private Integer chance;
    private final EpicMobs pl;

    public RandomSelectingLogic(Integer chance, EpicMobs pl) {
        this.pl = pl;
        this.chance=chance;
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event){
        if(!(event.getSpawnReason()==CreatureSpawnEvent.SpawnReason.NATURAL)){
            return;
        }
        if(shouldBeReplaced()){
            pl.getMML().modifyMob(event.getEntity());
            return;
        }

    }
    private boolean shouldBeReplaced(){
        int rng = rnd.nextInt(100)+1;
        if(rng<=5){
            return true;
        }
        return false;

    }

}
