

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.spoutcraft.client.entity.CraftEntity;
import org.spoutcraft.spoutcraftapi.addon.java.JavaAddon;
import org.spoutcraft.spoutcraftapi.io.AddonPacket;

public class EntityAddon extends JavaAddon {
	public static String pathToCache;
	public static EntityAddon addon;
	public HashMap<Integer, CustomEntity> entities = new HashMap<Integer, CustomEntity>();
	
	public void onDisable() {
		
	}

	public void onEnable() {
		if (!getDataFolder().exists())
			getDataFolder().mkdir();
		
		pathToCache = getDataFolder().getPath()+"/cache";
		File cache = new File(pathToCache);
		if (!cache.exists())
			cache.mkdir();
		
		addon = this;
		AddonPacket.register(PacketCustomEntity.class, "entity");
		AddonPacket.register(PacketEntityDesign.class, "entityDesign");
		AddonPacket.register(PacketCustomInteract.class, "entityInteract");
		AddonPacket.register(PacketVehicle.class, "entityVehicle");
		
		this.getClient().getActivePlayer().sendMessage("[Entity Addon] enabled");
		
		registerTypes(CustomEntity.class, CraftCustomEntity.class);
		registerRender(EntityCustom.class, new RenderCustomEntity());
	}
	
	public void registerRender(Class<?> entity, it render) {
		try {
			Field entityRenderMap = Class.forName("ahu").getDeclaredField("o");
			entityRenderMap.setAccessible(true);
			Object renderManager = Class.forName("ahu").getDeclaredField("a").get(null);
			
			Method put = HashMap.class.getDeclaredMethod("put", Object.class, Object.class);
			put.invoke(entityRenderMap.get(renderManager), entity, render);
			
			Method setRenderManager = Class.forName("um").getDeclaredMethod("a", Class.forName("ahu"));
			setRenderManager.invoke(render, renderManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registerTypes(Class<?> entity, Class<?> craftEntity) {
		try {
			Field interfacedClasses = CraftEntity.class.getDeclaredField("interfacedClasses");
			interfacedClasses.setAccessible(true);
			
			Method methodPut = HashMap.class.getDeclaredMethod("put", Object.class, Object.class);
			methodPut.invoke(interfacedClasses.get(null), entity, craftEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CustomEntity getEntity(int entityId) {
		return entities.get(entityId);
	}
	
	public void addEntity(int entityId, CustomEntity entity) {
		entities.put(entityId, entity);
	}
	
	public static EntityAddon getInstance() {
		return addon;
	}
}
