package pers.remoteamountitem.api.utils;

import java.util.HashMap;

import org.bukkit.Material;

public class MaterialUtil {
	private static boolean isInit=false;
	private static HashMap<String,Material> materMap;
	
	
	public static void init() {
		materMap=new HashMap<>();
		for(Material mater:Material.values()) {
			
			materMap.put(mater.toString(), mater);
			if(mater.toString().equalsIgnoreCase("PODZOL"))
			System.out.println("in "+mater.toString());
		}
		
		isInit=true;
	}
	
	public static Material getMaterial(String name) {
		if(!isInit) {
			init();
		}
		return materMap.get(name);
	}
	
}
