

import java.lang.reflect.*;

import org.spoutcraft.client.entity.CraftEntity;
import org.spoutcraft.spoutcraftapi.entity.*;
import org.spoutcraft.spoutcraftapi.gui.*;
import org.spoutcraft.spoutcraftapi.keyboard.*;
import org.spoutcraft.client.*;

public class AddonKeyDelegate extends BindingExecutionDelegate {
	public EntityAddon addon;
	
	public AddonKeyDelegate (EntityAddon addon) {
		this.addon = addon;
	}
	
	@Override
	public void onKeyPress(KeyBindingPress event) {
		if (event.getScreen() == ScreenType.GAME_SCREEN) {
			ActivePlayer p = addon.getClient().getActivePlayer();
			CustomEntity entity = p.getWorld().spawn(p.getLocation(), CustomEntity.class);
			p.sendMessage("1:"+entity.getClass().toString());
			entity.setTicksLived(Integer.MAX_VALUE);
			entity.setRotatingWithPlayer(true);
			entity.setScale(1.f);
			entity.setTexture("http://arthur.hennequin.free.fr/Minecraft/textures/furnitures.png");
			entity.setDesign(addon.mailbox);
			
			try {
				Field handleField = CraftEntity.class.getDeclaredField("handle");
				handleField.setAccessible(true);
				
				Object handleObject = handleField.get((CraftEntity)entity);
				
				Method methodAddEntity = ((SpoutcraftWorld)p.getWorld()).getHandle().getClass().getMethod("a", Class.forName("nn"));
				methodAddEntity.invoke(((SpoutcraftWorld)p.getWorld()).getHandle(), Class.forName("nn").cast(handleObject));
			} catch (Exception e2) {
				p.sendMessage("Error");
			}
		}
	}
}
