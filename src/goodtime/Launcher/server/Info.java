package goodtime.Launcher.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



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
	public static int mLV = 0;
	public static String ass = "";
	public static String main = "";
	public static String path = "./.minecraft/versions/";
	public static File file=new File(path);
	public static String js = "";
	public static String json = "";
	public static String LibURL = "";
	//public static JsonParser parser ;
	public static JSONObject object ;
	static int i;
	public static String libp = "";
	public static String verp;
	public static String gameDir;
	
	public static void main(String[] args)
	{
		//parser = new JsonParser();
		getJsonPath();
	}
	
	public static void getJsonPath()
	{
		json = path+version+"/"+version+".json";
		System.out.println(json);
		//File file = new File(json);
		ReadJson();
	}
	
	
	public static void ReadJson()
	{
		StringBuffer stringBuffer = new StringBuffer();
		String line = null ;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(json)));
			while( (line = br.readLine())!= null ){
				stringBuffer.append(line);
			} 
			br.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		object = new JSONObject(stringBuffer.toString());
		System.out.println(object);
			
	
		try {
				id = object.getString("id");
				time = object.getString("time");
				rTime = object.getString("releaseTime");
				mA = object.getString("minecraftArguments");
				mLV = object.getInt("minimumLauncherVersion");
				main = object.getString("mainClass");
				try {
					ass = object.getString("assets");
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

				
			} catch (JSONException e) {
				e.printStackTrace();
				//System.out.println("1");
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
	
	
	
	public static void getSystemInfo()
	{
		os = System.getProperty("os.name");
		System.getProperty("os.arch");
		System.out.println(os);
	}
	

	
	
	//--------------------------------------------------
	//===================================================
	
	public static void getLib()
	{
		json = path+version+"/"+version+".json";
		JSONArray array = (JSONArray) object.get("libraries");
		for (int a = 0; a < array.length(); a++) 
		{	
			JSONObject arrayObject = (JSONObject) array.get(a);
			lib = arrayObject.get("name").toString();

			/*try {
				LibURL = arrayObject.get("url").getAsString();
			} catch (Exception e) {
				System.out.println("异常:键值'url'不存在");
			}*/
			String bs = lib.substring(0 , lib.lastIndexOf(":"));
			String t = bs.replace(".", "/");
			String f = t.replace(":", "/");
			String es = lib.substring(lib.lastIndexOf(":")+1 );
			String u = f+"/"+es+"/";
			String z = lib.substring(lib.indexOf(":")+1);
			String l = "\""+"./.minecraft/libraries/"+u+z.replace(":", "-")+".jar" ;
			libp = libp+l+"\""+";";


		}
		//return array;
	}
	
	public static void getVersion()
	{
		String[] dirname = file.list();
		for (int i = 0; i < dirname.length; i++) {
			js = dirname[i].toString();
			Options.comboBox.addItem(js);
			//System.out.println(js);
			//CoreGui.comboBox.addItem(js);
		}
		
	}
	
	public static void getverPath()
	{
		
		verp = path+version+"/";
	}
	
	
	public static void getJavaInfo()
	{
		jre = System.getProperty("sun.arch.data.model");
		System.out.println(jre);
		String java = System.getProperty("java.home");
		jpath = java+"/javaw.exe";
	}
	
	
}
