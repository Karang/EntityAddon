

import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;

public class CustomEntityPacket extends AddonPacket {

	private int type;
	private double x;
	private double y;
	private double z;
	
	@Override
	public void read(SpoutInputStream in) {
		type=  in.readInt();
		x = in.readDouble();
		y = in.readDouble();
		z = in.readDouble();
	}

	@Override
	public void run() {
		System.out.println("Custom Entity infos : "+type+" ("+x+", "+y+", "+z+")");
	}

	@Override
	public void write(SpoutOutputStream out) {
		System.out.println("Custom Entity need to send something");
	}

}
