import org.bukkit.*;
import org.bukkit.scheduler.BukkitScheduler;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

import org.bukkit.entity.*;

import org.bukkit.event.EventHandler; 
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;
import java.util.List;



public class HeadPlugin extends JavaPlugin implements Listener{
    private List<SpawnMob> heads; 
    
    public void onEnable(){
    
        heads = new ArrayList<>();
        
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
    }    
    
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
    
        SpawnMob sb = new SpawnMob(e.getDrops(),e.getEntity()); 
        
        this.heads.add(sb); 
        
        e.getDrops().clear(); 
    }    
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractAtEntityEvent e){
    
        final Player p = e.getPlayer();
        
        Location firstLocation;
		firstLocation = p.getLocation(); 
        
        final Entity en = e.getRightClicked();
        
        if(en instanceof ArmorStand){
        
            for(SpawnMob sm : this.heads){
            
                if(sm.getAs().equals(en)){ 
                
                    
                    
                    final Inventory playerInv = Bukkit.createInventory(null,54,"loot");
                                                        
                    for(ItemStack i : sm.getItems()){
                            playerInv.addItem(i); 
                    
                    }
                        
                    BukkitScheduler scheduler = getServer().getScheduler(); 
                    scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                   
                        @Override
                        public void run() {
                        	Location secondLocation; 
                        	secondLocation = p.getLocation(); 
                        	if (firstLocation.distanceSquared(secondLocation) < 1){
                        		p.openInventory(playerInv);
                                
                                return;
                        	
                        	}
                                else{
                                	
                        	}
                  
                            return;
                        }
                    }, 60L);
                }
            }
        }
    }
    
}
        
    
     
    

  
 
    

	

		

	



		
		
		



