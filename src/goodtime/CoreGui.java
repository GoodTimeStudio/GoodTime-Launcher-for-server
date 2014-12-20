package goodtime;



import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.io.*;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class CoreGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		File file = new File("config.cfg");
		File launcher = new File("Launcher.bat");
		if (file.exists())
		{
			try {
				CoreGui frame = new CoreGui();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);//设置窗体为显示
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else {/*
			FirstTime dialog = new FirstTime();
			dialog.setVisible(true);
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}*/
			System.out.println("文件已创建");
			
			String content[] = {"//GoodTime Luancher Config","游戏名字=","密码=","最大内存=","JAVA路径="};
			File file1 = new File("config.cfg");
			try {
				FileWriter fw = new FileWriter(file1); // 创建FileWriter类对象
				// 创建BufferedWriter类对象
				BufferedWriter bufw = new BufferedWriter(fw); 
				for (int k = 0; k < content.length; k++) { // 循环遍历数组
					bufw.write(content[k]); // 将字符串数组中元素写入到磁盘文件中
					bufw.newLine(); // 将数组中的单个元素以单行的形式写入文件
				}
				bufw.close(); // 将BufferedWriter流关闭
				fw.close(); // 将FileWriter流关闭
			} catch (Exception e) { // 处理异常
				e.printStackTrace();
			}
			System.out.println("已写入");
			CoreGui frame = new CoreGui();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);//设置窗体为显示
			
		}
		
		if (launcher.exists())
		{}
		else {

		}
			
	}//DANGER


	/**
	 * Create the frame.
	 */
	public CoreGui() {
		setTitle("GoodTime\u542F\u52A8\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//-------------------
				try {
					Options dialog = new Options();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.setBounds(601, 372, 110, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u79BB\u7EBF\u6E38\u620F");
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(601, 325, 110, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5F00\u542FGoodTime\u4E4B\u65C5\uFF01");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//启动

			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton_2.setBounds(424, 325, 167, 84);
		contentPane.add(btnNewButton_2);
		
		JLabel lblGoodtimeLuancherDev = new JLabel("GoodTime Luancher Dev 1209a");
		lblGoodtimeLuancherDev.setBounds(0, 404, 193, 15);
		contentPane.add(lblGoodtimeLuancherDev);
		
		JLabel lblGoodtiwicpnet = new JLabel("goodti.wicp.net");
		lblGoodtiwicpnet.setBounds(0, 0, 139, 15);
		contentPane.add(lblGoodtiwicpnet);
		
		JLabel lblJava = new JLabel("by JAVA7");
		lblJava.setBounds(666, 0, 55, 15);
		contentPane.add(lblJava);
	}
}
