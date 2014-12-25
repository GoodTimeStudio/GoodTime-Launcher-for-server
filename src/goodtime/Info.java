package goodtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;



public class Info {

	public static String dir = "";
	public static String lib = "";
	public static String version = "";
	public static String id = "";
	public static String time = "";
	public static String rTime = "";
	public static String mA = "";
	public static String mLV = "";
	public static String ass = "";
	public static String main = "";
	public static String path = "./.minecraft/version/";
	public static File file=new File(path);
	public static String js = "";
	public static String json = "";
	public static String LibURL = "";
	public static JsonParser parser ;
	public static JsonObject object ;
	
	public static void main(String[] args)
	{
		parser = new JsonParser();
		getJsonPath();
	}
	
	public static void getJsonPath()
	{
		json = path+version+"/"+version+".json";
		System.out.println(json);
		try {
			object = (JsonObject) parser.parse(new FileReader(json));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ReadJson();
	}
	
	
	public static void ReadJson()
	{
			try {
				id = object.get("id").getAsString();
				time = object.get("time").getAsString();
				rTime = object.get("releaseTime").getAsString();
				mA = object.get("minecraftArguments").getAsString();
				mLV = object.get("minimumLauncherVersion").getAsString();
				//ass = object.get("assets").getAsString();
				main = object.get("mainClass").getAsString();
				
				JsonArray array = object.get("libraries").getAsJsonArray();
				for (int i = 0; i < array.size(); i++) 
				{	
					JsonObject arrayObject = array.get(i).getAsJsonObject();
					String a = arrayObject.get("name").getAsString();
					//String b = arrayObject.get("url").getAsString();
					System.out.println(a);
					//System.out.println(b);
					System.out.println("------------");
				}
				
				System.out.println("id="+id);
				System.out.println("time="+time);
				System.out.println("releaseTime"+rTime);
				System.out.println("minecraftArguments="+mA);
				System.out.println("minimumLauncherVersion="+mLV);
				System.out.println("assets="+ass);
				System.out.println("mainClass="+main);
				System.out.println("---------------------------------");

				
			} catch (JsonIOException e) {
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			}
			getAss();
			getLibURL();
		
	}
		
	public static void getAss()
	{
		ass = object.get("assets").getAsString();
		System.out.println("ass="+ass);
	}
	
	public static void getLibURL()
	{
		LibURL = object.get("url").getAsString();
		System.out.println("url="+LibURL);
	}
	
	public static void getLauncherVersion()
	{
		
	}
	
	//--------------------------------------------------
	//===================================================
	public static void getVersion()
	{
		String[] dirname = file.list();
		for (int i = 0; i < dirname.length; i++) {
			js = dirname[i].toString();
			CoreGui.comboBox.addItem(dirname[i]);
		}
		
	}
}
