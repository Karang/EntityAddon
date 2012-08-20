

import org.spoutcraft.spoutcraftapi.entity.Entity;

public abstract interface CustomEntity extends Entity {
	
	public abstract void setTexture(String url);
	
	public abstract void setDesign(EntityDesign design);
}
