package goodtime;

import java.io.File;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;



public class Info {

	public static String dir = "";
	public static String lib = "";
	
	
	public static void main(String[] args)
	{
		ReadJson();
	}
	
	public static void ReadJson()
	{
		String path= "./.minecraft/version/";
		File file=new File(path);
		File[] tempList = file.listFiles();
		for (int i = 0; i < tempList.length; i++) {
		File a = tempList[i];
		System.out.println(tempList[i]);
		}
	}
}
