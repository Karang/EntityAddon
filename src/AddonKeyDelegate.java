
import org.spoutcraft.spoutcraftapi.entity.*;
import org.spoutcraft.spoutcraftapi.gui.*;
import org.spoutcraft.spoutcraftapi.keyboard.*;

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
			entity.setTicksLived(Integer.MAX_VALUE);
			entity.setTexture("https://dl.dropbox.com/u/99253345/furnitures.png");
			entity.setDesign(EntityDesign.designFromId(0));
		}
	}
}
