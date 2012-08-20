

import org.newdawn.slick.opengl.Texture;
import org.spoutcraft.client.*;
import org.spoutcraft.client.entity.EntityText;
import org.spoutcraft.client.io.CustomTextureManager;

public class EntityCustom extends EntityText {
	
	private String texUrl;
	public Texture texture;
	public EntityDesign design;
	
	public EntityCustom (SpoutcraftWorld world) {
		super(world.getHandle());
		texUrl = "";
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
}
