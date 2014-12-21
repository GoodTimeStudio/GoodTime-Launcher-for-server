package goodtime;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;


public class Config
{
	public static void configcheck()
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
	
	public static void config()
	{
		
	}
}  
  
