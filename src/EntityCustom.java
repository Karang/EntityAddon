

import org.newdawn.slick.opengl.Texture;
import org.spoutcraft.client.io.CustomTextureManager;

public class EntityCustom extends nn {
	
	private String texUrl;
	public Texture texture;
	public EntityDesign design;
	
	public EntityCustom (xd world) {
		super(world);
		texUrl = "";
		world.a(this);// spawn
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
