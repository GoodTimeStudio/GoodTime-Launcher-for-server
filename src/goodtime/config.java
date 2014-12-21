package goodtime;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JFrame;

public class Config
{

public static String username = "";
public static String password = "";
public static String java = "";	
public static String memory = "";
public static String uuid = "";
public static String token = "";
	
	public static void main(String[] args)
	{

	}
	
	public static void ConfigCheck()
	{
		File cfg = new File("config.properties");
		{
			if (cfg.exists()){
				System.out.println("文件已存在");
				CoreGui frame = new CoreGui();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);//设置窗体为显示
			}
			else {
				First.main(null);
				try {
					cfg.createNewFile();
					} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	public static void ReadConfig()
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("config.properties");
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		InputStream ips = new BufferedInputStream(fis);
		Properties props = new Properties();
		try {
			props.load(ips);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String username= props.getProperty("name");
		String password= props.getProperty("password");
		String memory = props.getProperty("Max-Memory");
		String java = props.getProperty("Java-Path");
		Options.textField.setText(java);
		Options.textField_1.setText(username);
		Options.textField_2.setText(memory);
		Options.passwordField.setText(password);
	}
	
	public static void WriteConfig()
	{
		Properties prop = new Properties();  
        try {  
            InputStream fis = new FileInputStream("config.properties");  
            // 从输入流中读取属性列表（键和元素对）  
            prop.load(fis);  
            // 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。  
            OutputStream fos = new FileOutputStream("config.properties");  
            prop.setProperty("name", username);
            prop.setProperty("password",password);
            prop.setProperty("Java-Path",java);
            prop.setProperty("Max-memory",memory);
         // 以适合使用 load 方法加载到 Properties 表中的格式，  
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流  
            prop.store(fos, "GoodTime Launcher Config");  
            System.out.println("文件信息已写入");
        } catch (IOException e) {  
            System.err.println("Visit " + "config.properties" + " for updating " + "ddd"  
                    + " value error");  
        }  
	}
}  
  
