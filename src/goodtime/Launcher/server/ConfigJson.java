package goodtime.Launcher.server; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import javax.swing.JFrame;

import org.json.JSONException;
import org.json.JSONObject;


public class ConfigJson {

//static JsonParser parser = new JsonParser(); 	
static String CfgPath = "gtL.json";
static String profiles = "";
static String LVO;
public static String username = "";
public static String password = "";
public static String java = "";	
public static String memory = "";
public static String uuid = "";
static String javaArgs;
static String gamePath;
static JSONObject object = new JSONObject();
static JSONObject pro = new JSONObject();
static JSONObject ver = new JSONObject();
static String oldPro = "";
	

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
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			object = new JSONObject(a);
						
			
			//=======================================================
			pro = object.getJSONObject("profiles");
			profiles = object.getString("selectedProfile");
			ver = pro.getJSONObject(profiles);
			gamePath = ver.getString("GameDir");
			java = ver.getString("java");
			javaArgs = ver.getString("javaArgs");
			Info.version = ver.getString("Version");
			LVO = ver.getString("launcherVisibilityOnGameClose");
			memory = ver.getString("Max-Memory");
			
			Options.textField_2.setText(memory);
			Options.comboBox.setSelectedItem(Info.version);
			Options.comboBox_1.setSelectedItem(LVO);
			//Options.textField
			if (gamePath.isEmpty()) {
				Options.chckbxNewCheckBox.setSelected(false);
			} else {
				Options.textField_3.setText(gamePath);
				Options.chckbxNewCheckBox.setSelected(true);
			}
			
			if (java.isEmpty()) {
				Options.chckbxJava.setSelected(false);
			} else {
				Options.textField.setText(java);
				Options.chckbxJava.setSelected(true);
			}
			
			if (javaArgs.isEmpty()) {
				Options.chckbxNewCheckBox_2.setSelected(false);
			} else {
				Options.chckbxNewCheckBox_2.setSelected(true);
				Options.textField_4.setText(javaArgs);
			}
			//===========================================
		} catch (JSONException e) {
			e.printStackTrace();
		} 
	}
	
	public static void getPro()
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
			//object = (JsonObject) parser.parse(a);
			object = new JSONObject(a);
			pro = object.getJSONObject("profiles");
			Iterator<String> it = pro.keys();
			while (it.hasNext()) {  
				String key = (String) it.next();  
				CoreGui.comboBox.addItem(key);
				//JSONArray array = pro.getJSONArray(key);
			}
			CoreGui.comboBox.setSelectedItem(object.getString("selectedProfile"));
			//System.out.println(b);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void save()
	{
		File file = new File(CfgPath);
		profiles = Options.textField_1.getText();

		ver.put("name", profiles);
		ver.put("Version", Info.version);
		ver.put("GameDir", Info.gameDir);
		ver.put("launcherVisibilityOnGameClose", ConfigJson.LVO);
		ver.put("Max-Memory", ConfigJson.memory);
		ver.put("java", ConfigJson.java);
		ver.put("javaArgs", ConfigJson.javaArgs);
		System.out.println("v="+profiles);
		
			
		//}

		//array.add(o);
		if (oldPro.equals(profiles)) {} else {
			CoreGui.comboBox.addItem(profiles);
			CoreGui.comboBox.removeItem(oldPro);
			pro.put(profiles , ver);
			pro.remove(oldPro);
			
		}
		
		//object.add("profiles", pro);
		
		object.put("profiles", pro);
		
		object.put("selectedProfile","");
		object.put("clientToken", "88888888-8888-8888-8888-888888888888");
		object.put("name", "");
		object.put("password", "");
		object.put("uuid", "");
		object.put("selectedProfile", CoreGui.comboBox.getSelectedItem());
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
		
		System.out.println(oldPro.equals(profiles));

	}
	
	public static void first()
	{
		//JsonObject pro = new JsonObject();
		
		ver.put("name", "默认配置");
		ver.put("Version", "");
		ver.put("GameDir", "");
		ver.put("launcherVisibilityOnGameClose", "");
		ver.put("Max-Memory", "");
		ver.put("java", "");
		ver.put("javaArgs", "");
		//pro.add("默认", ver);
		pro.put("默认配置" , ver);
		object.put("profiles",pro);
		object.put("selectedProfile","");
		object.put("clientToken", "88888888-8888-8888-8888-888888888888");
		object.put("name", "");
		object.put("password", "");
		object.put("uuid", "");
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
		CoreGui frame = new CoreGui();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void remove() {
		pro.remove(profiles);
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
		CoreGui.comboBox.removeItem(profiles);
	}
	
	public static void getAlreadyToPlay()
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
		String getitem = (String) CoreGui.comboBox.getSelectedItem();
		System.out.println(getitem);
		object = new JSONObject(a);
		pro = object.getJSONObject("profiles");
		ver = pro.getJSONObject(getitem);
		Info.version = ver.getString("Version");
		CoreGui.label_1.setText("即将开始"+Info.version);
	}
	
	public static void loadLogin() {
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
		object = new JSONObject(a);
		username = object.getString("name");
		password = object.getString("password");
	

	}
	
	
	public static void saveLogin() {
		System.out.println("Save");
		object.put("name", username);
		object.put("password", password);
		
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
		if (ConfigJson.username.isEmpty()) {} else {
			CoreGui.label.setText("尊敬的 "+ConfigJson.username);
		}
	}
}
