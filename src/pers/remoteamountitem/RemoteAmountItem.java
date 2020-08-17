package pers.remoteamountitem;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import pers.remoteamountitem.api.utils.InventoryUtil;
import pers.remoteamountitem.api.utils.MaterialUtil;

public class RemoteAmountItem extends JavaPlugin{
	private static RemoteAmountItem plugin;
	@Override
	public void onEnable() {
		setPlugin(this);
		MaterialUtil.init();
		getLogger().info("插件加载完毕");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("插件已卸载");
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (label.equalsIgnoreCase("remoteitem")){
	    	if(sender instanceof Player) {
	    	   Player player = (Player)sender;
	    	   if(args.length==2) {//remoteitem STONE 64 
	    		   //player.sendMessage("§a"+player.getItemInHand().getType().toString());
	    		   String reType=args[0];
	    		   int num=Integer.parseInt(args[1]);
	    		   InventoryUtil.remoteTypeItem(player.getInventory(), MaterialUtil.getMaterial(reType), num);
	    	   }else {
	    		   player.sendMessage("§c指令输入错误");
	    	   }
	    	   return true;
	    	}else {
	    		sender.sendMessage("本指令为玩家专用指令");
	    	}
	    }
	    return false;
	}

	public static RemoteAmountItem getPlugin() {
		return plugin;
	}

	public void setPlugin(RemoteAmountItem plugin) {
		this.plugin = plugin;
	}
	
}
