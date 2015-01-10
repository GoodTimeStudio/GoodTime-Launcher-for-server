package goodtime;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Test {

	public static void main(String[] args)
	{
		String json = "./.minecraft/versions/1.7.10-Forge10.13.2.1231/1.7.10-Forge10.13.2.1231.json";
		JsonParser parser = new JsonParser();
		try {
			JsonObject object = (JsonObject) parser.parse(new FileReader(json));
			
			JsonArray array = object.get("libraries").getAsJsonArray();
			for (int a = 0; a < array.size(); a++) 
			{	
				JsonObject arrayObject = array.get(a).getAsJsonObject();
				String lib = arrayObject.get("name").getAsString();
				/*
				try {
					LibURL = arrayObject.get("url").getAsString();
				} catch (Exception e) {
					System.out.println("异常:键值'url'不存在");
				}*/
				String path = "";
				System.out.println(lib);
				System.out.println("-------");
			}	
				
				
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			
		}
	

}
