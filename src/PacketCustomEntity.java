

import org.spoutcraft.spoutcraftapi.entity.ActivePlayer;
import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;
import org.spoutcraft.spoutcraftapi.util.MutableLocation;

public class PacketCustomEntity extends AddonPacket {

	private int entityId;
	private int type;
	private String texture;
	private double x;
	private double y;
	private double z;
	
	@Override
	public void read(SpoutInputStream in) {
		entityId = in.readInt();
		type =  in.readInt();
		texture = in.readString();
		x = in.readDouble();
		y = in.readDouble();
		z = in.readDouble();
	}

	@Override
	public void run() {
		ActivePlayer p  = EntityAddon.getInstance().getClient().getActivePlayer();
		p.sendMessage("Custom Entity infos : "+type+" ("+x+", "+y+", "+z+")");
		
		if (EntityAddon.getInstance().getEntity(entityId)!=null)
			return;
		
		CustomEntity entity = p.getWorld().spawn(new MutableLocation(p.getWorld(), x, y, z), CustomEntity.class);
		entity.setEntityId(entityId);
		entity.setTexture(texture);
		entity.setDesign(EntityDesign.designFromId(type, entity.getEntityId()));
		entity.setTicksLived(Integer.MAX_VALUE);
		
		EntityAddon.getInstance().addEntity(entityId, entity);
	}

	@Override
	public void write(SpoutOutputStream out) {
		
	}

}
