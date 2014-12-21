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
				System.out.println("�ļ��Ѵ���");
				CoreGui frame = new CoreGui();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);//���ô���Ϊ��ʾ
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
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		InputStream ips = new BufferedInputStream(fis);
		Properties props = new Properties();
		try {
			props.load(ips);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
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
            // ���������ж�ȡ�����б�����Ԫ�ضԣ�  
            prop.load(fis);  
            // ���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�  
            // ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����  
            OutputStream fos = new FileOutputStream("config.properties");  
            prop.setProperty("name", username);
            prop.setProperty("password",password);
            prop.setProperty("Java-Path",java);
            prop.setProperty("Max-memory",memory);
         // ���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��  
            // ���� Properties ���е������б�����Ԫ�ضԣ�д�������  
            prop.store(fos, "GoodTime Launcher Config");  
            System.out.println("�ļ���Ϣ��д��");
        } catch (IOException e) {  
            System.err.println("Visit " + "config.properties" + " for updating " + "ddd"  
                    + " value error");  
        }  
	}
}  
  
