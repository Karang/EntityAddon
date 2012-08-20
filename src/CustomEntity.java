

import org.spoutcraft.spoutcraftapi.entity.Entity;

public abstract interface CustomEntity extends Entity {
	public abstract String getText();
	
	public abstract void setText(String paramString);
	
	public abstract boolean isRotatingWithPlayer();
	
	public abstract void setRotatingWithPlayer(boolean paramBoolean);
	
	public abstract float getScale();
	
	public abstract void setScale(float paramFloat);
	
	//
	
	public abstract void setTexture(String url);
	
	public abstract void setDesign(EntityDesign design);
}
