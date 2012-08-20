
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.*;
import org.spoutcraft.client.entity.RenderText;
import org.spoutcraft.client.io.CustomTextureManager;


public class RenderCustomEntity extends RenderText {
	
	public RenderCustomEntity () {
		
	}
	
	public void a(nn entity, double x, double y, double z, float yaw, float pitch) {
		EntityCustom customEntity = (EntityCustom) entity;
		
		if (customEntity.texture==null) {
			customEntity.texture = CustomTextureManager.getTextureFromUrl(customEntity.getTexUrl());
			if (customEntity.texture==null)
				return;
		}
		
		if (customEntity.design==null)
			return;
		
	    GL11.glPushMatrix();
	    tf.a();
		GL11.glTranslated(x, y, z);
		GL11.glRotatef(yaw, 0, 1.0F, 0);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, customEntity.texture.getTextureID());
		
		adz tessellator = adz.a;
		tessellator.b();
		for (String face : customEntity.design.faces) {
			for (String vertex : face.substring(2).split(" ")) {
				Vector3f v = customEntity.design.vertices.get(Integer.valueOf(vertex.split("/")[0])-1);
				Vector2f t = customEntity.design.texCoords.get(Integer.valueOf(vertex.split("/")[1])-1);
				tessellator.a(v.x, v.y, v.z, t.x, t.y);
			}
		}
		tessellator.a();
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		tf.b();
		GL11.glPopMatrix();
	  }
}
