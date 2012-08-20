import java.io.*;
import java.util.*;
import java.util.logging.Level;

import org.lwjgl.util.vector.*;
import org.spoutcraft.spoutcraftapi.Spoutcraft;


public class EntityDesign {
	
	public List<String> faces = new ArrayList<String>();
	public List<Vector3f> vertices = new ArrayList<Vector3f>();
	public List<Vector2f> texCoords = new ArrayList<Vector2f>();
	
	public EntityDesign(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("v ")) {
					float x = Float.valueOf(line.split(" ")[1]);
					float y = Float.valueOf(line.split(" ")[2]);
					float z = Float.valueOf(line.split(" ")[3]);
					vertices.add(new Vector3f(x, y, z));
				} else if (line.startsWith("vt ")) {
					float x = Float.valueOf(line.split(" ")[1]);
					float y = Float.valueOf(line.split(" ")[2]);
					texCoords.add(new Vector2f(x, y));
				} else if (line.startsWith("f ")) {
					faces.add(line);
				}
			}
			reader.close();
		} catch (IOException e) {
			Spoutcraft.getLogger().log(Level.WARNING, "[AddonEntity] Unable to load the file : "+path);
			e.printStackTrace();
		}
	}
}
