

import org.spoutcraft.client.SpoutcraftWorld;
import org.spoutcraft.client.entity.*;
import org.spoutcraft.spoutcraftapi.util.FixedLocation;

@SuppressWarnings("unchecked")
public class CraftCustomEntity extends CraftEntity implements CustomEntity {

	public CraftCustomEntity(FixedLocation location) {
		super(location);
		handle = new EntityCustom(((SpoutcraftWorld)location.getWorld()).getHandle());
		teleport(location);
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
