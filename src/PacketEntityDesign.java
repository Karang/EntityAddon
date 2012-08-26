import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;


public class PacketEntityDesign extends AddonPacket {

	private int id;
	private String url;
	private float width;
	private float height;
	private boolean canBeCollidedWith;
	
	public PacketEntityDesign () {
		
	}
	
	@Override
	public void read(SpoutInputStream in) {
		id = in.readInt();
		url = in.readString();
		canBeCollidedWith = in.readBoolean();
		width = in.readFloat();
		height = in.readFloat();
	}

	@Override
	public void run() {
		EntityDesign design = EntityDesign.registerDesign(id, url);
		design.width = width;
		design.height = height;
		design.canBeCollidedWith = canBeCollidedWith;
	}

	@Override
	public void write(SpoutOutputStream out) {
		
	}

}
