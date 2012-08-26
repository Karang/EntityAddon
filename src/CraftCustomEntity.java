
import org.spoutcraft.client.SpoutcraftWorld;
import org.spoutcraft.client.entity.*;
import org.spoutcraft.spoutcraftapi.entity.*;
import org.spoutcraft.spoutcraftapi.util.FixedLocation;

@SuppressWarnings("unchecked")
public class CraftCustomEntity extends CraftEntity implements CustomEntity {

	public CraftCustomEntity(FixedLocation location) {
		super(location);
		handle = new EntityCustom(((SpoutcraftWorld)location.getWorld()).getHandle());
		teleport(location);
	}

	@Override
	public int getEntityId() {
		return ((EntityCustom)handle).getEntityId();
	}
	
	@Override
	public void setEntityId(int entityId) {
		((EntityCustom)handle).setEntityId(entityId);
	}
	
	@Override
	public void setTexture(String url) {
		((EntityCustom)handle).setTexture(url);
	}

	@Override
	public void setDesign(EntityDesign design) {
		((EntityCustom)handle).setDesign(design);
	}

	@Override
	public void addPassenger(int seatId, Entity passenger) {
		if (seatId<0 || seatId>=4)
			return;
		((EntityCustom)handle).passengers[seatId] = passenger;
	}

	@Override
	public Entity getPassenger(int seatId) {
		if (seatId<0 || seatId>=4)
			return null;
		return ((EntityCustom)handle).passengers[seatId];
	}

	@Override
	public void ejectPassenger(Entity passenger) {
		for (Entity p : ((EntityCustom)handle).passengers){
			if (p.equals(passenger))
				p = null;
		}
	}
}
