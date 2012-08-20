

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.lwjgl.input.Keyboard;
import org.spoutcraft.client.entity.CraftEntity;
import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.addon.java.JavaAddon;
import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.keyboard.KeyBinding;

public class EntityAddon extends JavaAddon {
	public static EntityAddon addon;
	public KeyBinding testKey;
	
	public EntityDesign mailbox;
	
	public void onDisable() {
		
	}

	public void onEnable() {
		AddonPacket.register(CustomEntityPacket.class, "Custom Entity");
		addon = this;
		testKey = new KeyBinding(Keyboard.KEY_E, this, "Entity addon", "spawn entity");
		testKey.setDelegate(new AddonKeyDelegate(this));
		this.getClient().getKeyBindingManager().registerControl(testKey);
		this.getClient().getActivePlayer().sendMessage("[Entity Addon] enabled");
		
		registerTypes(CustomEntity.class, CraftCustomEntity.class);
		registerRender(EntityCustom.class, new RenderCustomEntity());
		
		mailbox = new EntityDesign(Spoutcraft.getAddonFolder().getAbsolutePath()+"/EntityAddon/mailbox.obj");
	}
	
	public void registerRender(Class<?> entity, RenderCustomEntity render) {
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
	
	public static EntityAddon getInstance() {
		return addon;
	}
}