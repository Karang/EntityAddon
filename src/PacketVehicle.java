import org.spoutcraft.spoutcraftapi.entity.Player;
import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;


public class PacketVehicle extends AddonPacket {
	public final short CONFIG = 0;
	public final short ENTER = 1;
	public final short LEAVE = 2;
	
	public short action;
	public int entityId;
	public String playerName;
	public short seatId;
	public double x;
	public double y;
	public double z;
	
	public PacketVehicle() {
		
	}
	
	@Override
	public void read(SpoutInputStream in) {
		action = in.readShort();
		entityId = in.readInt();
		if (action==CONFIG) {
			seatId = in.readShort();
			x = in.readDouble();
			y = in.readDouble();
			z = in.readDouble();
		} else if (action==ENTER) {
			seatId = in.readShort();
			playerName = in.readString();
		} else if (action==LEAVE) {
			playerName = in.readString();
		}
	}

	@Override
	public void run() {
		if (action==CONFIG) {
			
		} else if (action==ENTER) {
			Player passenger = EntityAddon.getInstance().getClient().getPlayer(playerName);
			CustomEntity entity = EntityAddon.getInstance().getEntity(entityId);
			entity.addPassenger(seatId, passenger);
		} else if (action==LEAVE) {
			Player passenger = EntityAddon.getInstance().getClient().getPlayer(playerName);
			CustomEntity entity = EntityAddon.getInstance().getEntity(entityId);
			entity.ejectPassenger(passenger);
		}
		
	}

	@Override
	public void write(SpoutOutputStream out) {
		
	}

}
