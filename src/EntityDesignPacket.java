import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;


public class EntityDesignPacket extends AddonPacket {

	private int id;
	private String url;
	
	public EntityDesignPacket () {
		
	}
	
	@Override
	public void read(SpoutInputStream in) {
		id = in.readInt();
		url = in.readString();
	}

	@Override
	public void run() {
		EntityDesign.registerDesign(id, url);
	}

	@Override
	public void write(SpoutOutputStream out) {
		
	}

}
