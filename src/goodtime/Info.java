package goodtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import sun.awt.AWTAccessor.SystemTrayAccessor;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;



public class Info {

	public static String dir = "";
	public static String lib = "";
	public static String version = "";
	public static String[] id = {};
	public static String time = "";
	public static String rTime = "";
	public static String mA = "";
	public static String mLV = "";
	public static String ass = "";
	public static String main = "";
	
	public static void main(String[] args)
	{
		ReadJson();
	}
	
	public static void ReadJson()
	{
		String path= "./.minecraft/version/";
		File file=new File(path);
		File[] ddir = file.listFiles();//��ȡ·��
		String[] dirname = file.list();//��ȡĿ¼��
		
		for (int i = 0; i < ddir.length; i++ ) for( int j = 0; j < dirname.length; j++) 
		{
			StringBuffer sb = new StringBuffer();
			sb. append(ddir[i]);
			String b = sb.toString();
			
			StringBuffer sc = new StringBuffer();
			sc. append(dirname[j]);
			String c = sc.toString();
			
			String json = b+"\\"+c+".json";	
			File rjson = new File(json);
			
			JsonParser parser = new JsonParser();
			try {
				JsonObject object = (JsonObject) parser.parse(new FileReader(rjson));
				id = object.get("id").getAsJsonArray();
				time = object.get("time").getAsString();
				rTime = object.get("releaseTime").getAsString();
				mA = object.get("minecraftArguments").getAsString();
				mLV = object.get("minimumLauncherVersion").getAsString();
				ass = object.get("assets").getAsString();
				main = object.get("mainClass").getAsString();
				
				/*
				System.out.println("id="+id);
				System.out.println("time="+time);
				System.out.println("releaseTime"+rTime);
				System.out.println("minecraftArguments="+mA);
				System.out.println("minimumLauncherVersion="+mLV);
				System.out.println("assets="+ass);
				System.out.println("mainClass="+main);
				*/
				System.out.println(Info.id);
				
			} catch (JsonIOException e) {
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
		
		
		
	
}
