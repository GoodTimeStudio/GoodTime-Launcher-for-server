package goodtime; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public class ConfigJson {

static JsonParser parser = new JsonParser(); 	
static String CfgPath = "./.minecraft/config.json";
static String profiles;
static String LVO;
public static String username = "";
public static String password = "";
public static String java = "";	
public static String memory = "";
public static String uuid = "";
static String javaArgs;
static JsonObject object = new JsonObject();
static JsonArray array = new JsonArray();
static JsonObject ver = new JsonObject();
	
	public static void main(String[] args) {
		create();
	}

	public static void Check()
	{
		File file = new File(CfgPath);
		if (file.exists())
		{
			CoreGui frame = new CoreGui();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		}
		else
		{
			first();
		}
	}
	
	
	public static void load()
	{
		File file = new File(CfgPath);
		String a = null;
		try {
			FileInputStream fip = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fip , "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			a = br.readLine();
			br.close();
			isr.close();
			fip.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			object = (JsonObject) parser.parse(a);
			array = object.get("profiles").getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				JsonObject pro = array.get(i).getAsJsonObject();
				profiles = pro.get("name").getAsString();
				System.out.println("profiles="+profiles);
				CoreGui.comboBox.addItem(profiles);
			}

		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void save()
	{
		load();
		File file = new File(CfgPath);/*
		String a = null;
		try {
			FileInputStream fip = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fip , "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			a = br.readLine();
			br.close();
			isr.close();
			fip.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

*/
		
		//JsonObject obj = (JsonObject) parser.parse(a);
		//JsonArray arr = obj.get("profiles").getAsJsonArray();
		//for (int i = 0; i < arr.size(); i++) {
			
			//JsonObject ao = arr.get(i).getAsJsonObject();
			//profiles = ao.get("name").getAsString();
			//System.out.println("pro="+i);

		ver.addProperty("name", profiles);
			ver.addProperty("Version", Info.version);
			ver.addProperty("GameDir", Info.gameDir);
			ver.addProperty("launcherVisibilityOnGameClose", ConfigJson.LVO);
			ver.addProperty("Max-Memory", ConfigJson.memory);
			ver.addProperty("java", ConfigJson.java);
			ver.addProperty("javaArgs", ConfigJson.javaArgs);
			array.add(ver);
			
		//}

		//array.add(o);
		
		
		
		
		//object.add("profiles", pro);
		
		object.add("profiles",array);
		
		object.addProperty("selectedProfile","");
		object.addProperty("clientToken", "88888888-8888-8888-8888-888888888888");
		object.addProperty("name", ConfigJson.username);
		object.addProperty("uuid", "");
		String json = object.toString();
		
		
		
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos , "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(json);
			
			bw.close();
			osw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void first()
	{
		//JsonObject pro = new JsonObject();
		

		ver.addProperty("name", "Ä¬ÈÏÅäÖÃ");
		ver.addProperty("Version", "");
		//pro.add("Ä¬ÈÏ", ver);
		array.add(ver);
		object.add("profiles",array);
		object.addProperty("selectedProfile","");
		object.addProperty("clientToken", "88888888-8888-8888-8888-888888888888");
		object.addProperty("name", "");
		object.addProperty("uuid", "");
		String json = object.toString();
		File file = new File(CfgPath);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos ,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(json);
			
			bw.close();
			osw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void create()
	{
		load();
		JsonObject nv = new JsonObject();
		nv.addProperty("name", Tip.Newpro);
		nv.addProperty("Version", Info.version);
		nv.addProperty("GameDir", Info.gameDir);
		nv.addProperty("launcherVisibilityOnGameClose", ConfigJson.LVO);
		nv.addProperty("Max-Memory", ConfigJson.memory);
		nv.addProperty("java", ConfigJson.java);
		nv.addProperty("javaArgs", ConfigJson.javaArgs);
		array.add(nv);
		object.add("profiles", array);
		String json = object.toString();
		System.out.println(json);
		try {
			File file = new File(CfgPath);
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos , "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(json);
			
			bw.close();
			osw.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void delect()
	{
		
	}
}
