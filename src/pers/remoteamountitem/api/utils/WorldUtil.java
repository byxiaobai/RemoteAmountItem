package pers.remoteamountitem.api.utils;

import org.bukkit.World;

public class WorldUtil {
	public static boolean isEnd(String worldName) {
		if(worldName==null)return false;
		return worldName.toLowerCase().contains("end");
	}
	public static boolean isWorld(String worldName) {
		if(worldName==null)return false;
		return worldName.toLowerCase().contains("world");
	}
	public static boolean isEnd(World world) {
		if(world==null)return false;
		return isEnd(world.getName());
	}
}
