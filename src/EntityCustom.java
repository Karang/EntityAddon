
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;
import org.spoutcraft.client.io.CustomTextureManager;
import org.spoutcraft.spoutcraftapi.entity.*;

public class EntityCustom extends nn {
	
	private int entityId;
	private String texUrl;
	public Texture texture;
	public EntityDesign design;
	public Vector3f[] seats = new Vector3f[4];
	public Entity[] passengers = new Entity[4];
	
	public EntityCustom (xd world) {
		super(world);
		texUrl = "";
		world.a(this); // spawn
	}
	
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	
	public int getEntityId() {
		return entityId;
	}
	
	public void setTexture(String url) {
		texUrl = url;
		if (texUrl!=null)
			CustomTextureManager.downloadTexture(texUrl);
	}
	
	public String getTexUrl() {
		return texUrl;
	}
	
	public void setDesign(EntityDesign design) {
		this.design = design;
		setSize(design.width, design.height);
	}
	
	public void setSize(float width, float height) {
		a(width, height);
	}
	
	@Override
	public void B() {
		super.B();
	}
	
	public boolean c(yw p) { // interact
	    PacketCustomInteract packet = new PacketCustomInteract(entityId);
	    packet.send();
	    
	    return true;
	}
	
	public boolean l_() { // canBePushed
		return true;
	}
	
	public boolean d_() { // canBeCollidedWith
		return design.canBeCollidedWith;
	}
	
	@Override
	protected void a(ady arg0) {
		
	}

	@Override
	protected void b(ady arg0) {
		
	}
	
	@Override
	protected void b() {
		
	}
}
