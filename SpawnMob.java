import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.entity.ArmorStand;
import java.util.List;
public class SpawnMob {
	  private ArmorStand as;
	  private List<ItemStack> items;
	  
	    
	  public SpawnMob(List<ItemStack> drops,Player p){
	        this.as = p.getWorld().spawn(p.getLocation(),ArmorStand.class);
	        ItemStack i = new ItemStack(Material.SKULL_ITEM);
	        i.setDurability((short)3);
	        SkullMeta meta = (SkullMeta) i.getItemMeta();
	        meta.setOwner(p.getName());
	        i.setItemMeta(meta);
	        as.setHelmet(i);
	        as.setVisible(false);
	                this.items = drops;
	   
	    }
	    

	    public ArmorStand getAs(){
	        return this.as;
	    } 
	    
	    public List<ItemStack> getItems(){
	        return this.items;
	    }


	}
