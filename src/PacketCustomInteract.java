import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;


public class PacketCustomInteract extends AddonPacket {

	private int entityId;
	
	public PacketCustomInteract () {
		
	}
	
	public PacketCustomInteract (int entityId) {
		this.entityId = entityId;
	}
	
	@Override
	public void read(SpoutInputStream in) {
		
	}

	@Override
	public void run() {
		
	}

	@Override
	public void write(SpoutOutputStream out) {
		out.writeInt(entityId);
	}

}
