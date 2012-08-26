
import org.spoutcraft.spoutcraftapi.entity.*;

public abstract interface CustomEntity extends Entity {
	
	public abstract int getEntityId();
	
	public abstract void setEntityId(int entityId);
	
	public abstract void setTexture(String url);
	
	public abstract void setDesign(EntityDesign design);
	
	public abstract Entity getPassenger(int seatId);
	
	public abstract void addPassenger(int seatId, Entity passenger);
	
	public abstract void ejectPassenger(Entity passenger);
}
