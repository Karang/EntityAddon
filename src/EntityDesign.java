import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;

import org.lwjgl.util.vector.*;
import org.spoutcraft.spoutcraftapi.Spoutcraft;


public class EntityDesign {
	public static HashMap<String, String> urlToDesign = new HashMap<String, String>();
	public static HashMap<Integer, EntityDesign> designs = new HashMap<Integer, EntityDesign>();
	
	public List<String> faces = new ArrayList<String>();
	public List<Vector3f> vertices = new ArrayList<Vector3f>();
	public List<Vector2f> texCoords = new ArrayList<Vector2f>();
	
	public EntityDesign(String url) {
		String path = urlToDesign.get(url);
		if (path==null) {
			EntityDesign.downloadObjectToCache(url);
			path = urlToDesign.get(url);
			if (path==null)
				return;
		}
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
	
	public static void downloadObjectToCache(String url) {
		try {
			final URLConnection connection = (new URL(url)).openConnection();
			final int fileLength = connection.getContentLength();

			if (fileLength == -1)
				throw new Exception("Invalide URL or file.");
			
			final String filename = EntityAddon.pathToCache + url.substring(url.lastIndexOf("/"));
			
			final InputStream input = connection.getInputStream();
			final FileOutputStream writeFile = new FileOutputStream(filename);
			final byte[] buffer = new byte[1024];
			int read;

			while ((read = input.read(buffer)) > 0)
				writeFile.write(buffer, 0, read);
			writeFile.flush();

			writeFile.close();
			input.close();
			
			urlToDesign.put(url, filename);
		} catch (Exception e) {
			Spoutcraft.getLogger().log(Level.WARNING, "[EntityAddon] Unable to download the file : "+url);
			e.printStackTrace();
		}
	}
	
	public static void registerDesign(int id, String url) {
		if (designs.get(id)==null) {
			designs.put(id, new EntityDesign(url));
		}
	}
	
	public static EntityDesign designFromId(int id) {
		return designs.get(id);
	}
}
