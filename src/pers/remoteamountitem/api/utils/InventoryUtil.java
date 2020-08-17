package pers.remoteamountitem.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;


/** 
* @author byxiaobai
* 背包工具类
*/
public class InventoryUtil {
	private static final ItemStack AIR=new ItemStack(Material.AIR);
	public static Inventory createInventory(int size,String title) {
		Inventory inv=Bukkit.createInventory(null, size,title);
		return inv;
	}
	  public static void setInventoryItem(Inventory gui,ItemStack item,int... slot) {
		  if(item==null)item=AIR;
			for(int i:slot) {
				gui.setItem(i, item.clone());
			}
	  }
	  
	public static void remoteTypeItem(Inventory inv,Material mater,int amount) {
		ItemStack item=new ItemStack(mater);
		ItemStack[] contents=inv.getContents();
		for(ItemStack content:contents) {
			if(content!=null&&ItemUtil.isSame(content, item)) {
				System.out.println("test");
				int conAmount=content.getAmount();
				if(conAmount>=amount) {//足够
					content.setAmount(conAmount-amount);
					return;
				}
				amount-=conAmount;
				System.out.println("amount:"+amount+",conAmount:"+conAmount);
				content.setType(Material.AIR);
			}
		}
	}
	
	public static void remoteItem(Inventory inv,int slot) {
		ItemStack item=inv.getItem(slot);
		item.setAmount(item.getAmount()-1);
		inv.setItem(slot, item);
	}
	public static int getItemAmount(Inventory inv,ItemStack item) {
		int amount=0;
		ItemStack[] contents=inv.getContents();
		for(ItemStack content:contents) {
			if(content!=null&&ItemUtil.isSame(content, item)) {
				amount+=item.getAmount();
			}
		}
		return amount;
	}
	/**
	 * 判断背包中的格子是否没物品
	 * @param inv
	 * @param slots
	 * @return
	 */
	public static boolean isNoItem(Inventory inv,int...slots) {
		for(int slot:slots) {
			ItemStack item=inv.getItem(slot);
			if(item==null) {
				continue;
			}
			if(item.getType()!=Material.AIR) {
				return false;
			}
		}
		return true;
	}
	public static boolean haveItem(Inventory inv,ItemStack item) {
		ItemStack[] contents=inv.getContents();
		for(ItemStack content:contents) {
			if(ItemUtil.isSame(content, item)) {
				return true;
			}
		}
		return false;
	}
	public static ItemStack getItem(Inventory inv,ItemStack item) {
		ItemStack[] contents=inv.getContents();
		for(ItemStack content:contents) {
			if(ItemUtil.isSame(content, item)) {
				return content;
			}
		}
		return null;
	}
}
