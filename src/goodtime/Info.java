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
		String path="d:/";
		File file=new File(path);
		File[] tempList = file.listFiles();
		for (int i = 0; i < tempList.length; i++) 
		{
			if (tempList[i].isDirectory()) 
				{
				System.out.println(tempList[i]);//��ȡĿ¼�µ��ļ���
				}
		}
		
		File[] js = (tempList);
		System.out.println("./.minecraft/version/"+js);
	}
}
