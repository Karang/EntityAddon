

import org.spoutcraft.client.SpoutcraftWorld;
import org.spoutcraft.client.entity.*;
import org.spoutcraft.spoutcraftapi.util.FixedLocation;

@SuppressWarnings("unchecked")
public class CraftCustomEntity extends CraftEntity implements CustomEntity {

	public CraftCustomEntity(FixedLocation location) {
		super(location);
		handle = new EntityCustom((SpoutcraftWorld)location.getWorld());
		teleport(location);
	}

	@Override
	public float getScale() {
		return ((EntityText)handle).getScale();
	}

	@Override
	public String getText() {
		return ((EntityText)handle).getText();
	}

	@Override
	public boolean isRotatingWithPlayer() {
		return ((EntityText)handle).isRotateWithPlayer();
	}

	@Override
	public void setRotatingWithPlayer(boolean arg0) {
		((EntityText)handle).setRotateWithPlayer(arg0);
	}

	@Override
	public void setScale(float arg0) {
		((EntityText)handle).setScale(arg0);
	}

	@Override
	public void setText(String arg0) {
		((EntityText)handle).setText(arg0);
	}

	@Override
	public void setTexture(String url) {
		((EntityCustom)handle).setTexture(url);
	}

	@Override
	public void setDesign(EntityDesign design) {
		((EntityCustom)handle).setDesign(design);
	}
}
