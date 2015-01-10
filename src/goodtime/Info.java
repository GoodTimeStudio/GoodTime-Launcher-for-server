package goodtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;



public class Info {

	public static String os;
	public static String jre;
	public static String jpath;
	public static String library;
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
	public static String path = ".\\.minecraft\\versions\\";
	public static File file=new File(path);
	public static String js = "";
	public static String json = "";
	public static String LibURL = "";
	public static JsonParser parser ;
	public static JsonObject object ;
	static int i;
	public static String libp = "";
	public static String verp;
	
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
				main = object.get("mainClass").getAsString();
				try {
					ass = object.get("assets").getAsString();
				} catch (Exception e) {
					System.out.println("异常:键值'assets'不存在");
				}
	
				//System.out.println("name="+lib);
				//System.out.println("url="+LibURL);
				//System.out.println("------------");
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
				System.out.println("1");
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
				System.out.println("2");
			}
			
		
	}
	
	/*
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
	*/
	
	public static void getLauncherVersion()
	{
		
	}
	
	
	public static void getSystemInfo()
	{
		os = System.getProperty("os.name");
		System.getProperty("os.arch");
		System.out.println(os);
	}
	

	
	
	//--------------------------------------------------
	//===================================================
	
	public static Object getLib()
	{
		json = path+version+"/"+version+".json";
		JsonArray array = object.get("libraries").getAsJsonArray();
		for (int a = 0; a < array.size(); a++) 
		{	
			JsonObject arrayObject = array.get(a).getAsJsonObject();
			lib = arrayObject.get("name").getAsString();

			/*try {
				LibURL = arrayObject.get("url").getAsString();
			} catch (Exception e) {
				System.out.println("异常:键值'url'不存在");
			}*/
			String bs = lib.substring(0 , lib.lastIndexOf(":"));
			String t = bs.replace(".", "\\");
			String f = t.replace(":", "\\");
			String es = lib.substring(lib.lastIndexOf(":")+1 );
			String u = f+"\\"+es+"\\";
			String z = lib.substring(lib.indexOf(":")+1);
			String l = "\""+".\\.minecraft\\libraries\\"+u+z.replace(":", "-")+".jar" ;
			libp = libp+l+"\""+";";


		}
		return array;
	}
	
	public static void getVersion()
	{
		String[] dirname = file.list();
		for (int i = 0; i < dirname.length; i++) {
			js = dirname[i].toString();
			System.out.println(js);
			CoreGui.comboBox.addItem(js);
		}
		
	}
	
	public static void getverPath()
	{
		Object gver = CoreGui.comboBox.getSelectedItem();
		verp = path+gver+"\\";
	}
	
	public void LibPath(){
		
	}
	
	public static void getJavaInfo()
	{
		jre = System.getProperty("sun.arch.data.model");
		System.out.println(jre);
		String java = System.getProperty("java.home");
		jpath = java+"\\javaw.exe";
	}
}
