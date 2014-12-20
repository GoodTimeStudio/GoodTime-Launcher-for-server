package goodtime;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


import javax.swing.JPasswordField;


public class Options extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1 = null;
	private JTextField textField_2;
	private JPasswordField passwordField;
	
	
	public static String username = "";
	public static String password = "";
	public static String Maxmemory = "";
	public static String java = "";
	public static String assistdir = "";
	public static String mcdir = "";


	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
				
		//-------------
		try {
			Options dialog = new Options();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Options() {
		setTitle("\u8BBE\u7F6E");
		setBounds(100, 100, 526, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 54, 15);
		contentPanel.add(label);
		
		
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58\u8BBE\u7F6E");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = textField_1.getText();
				@SuppressWarnings("deprecation")
				String pwd = passwordField.getText();
				String Max = textField_2.getText();
				String Java = textField.getText();
				File file = new File("Start.bat");
				String cfg[] = {""};
				try {
					FileWriter fw = new FileWriter(file); // 创建FileWriter类对象
					// 创建BufferedWriter类对象
					BufferedWriter bufw = new BufferedWriter(fw); 
					for (int k = 0; k < cfg.length; k++) { // 循环遍历数组
						bufw.write(cfg[k]); // 将字符串数组中元素写入到磁盘文件中
						bufw.newLine(); // 将数组中的单个元素以单行的形式写入文件
					}
					bufw.close(); // 将BufferedWriter流关闭
					fw.close(); // 将FileWriter流关闭
				} catch (Exception e) { // 处理异常
					e.printStackTrace();
				}


			}
		});
		btnNewButton.setBounds(407, 158, 93, 51);
		contentPanel.add(btnNewButton);
		
		JLabel lblJava = new JLabel("JAVA \u8DEF\u5F84");
		lblJava.setBounds(10, 87, 73, 15);
		contentPanel.add(lblJava);
		
		textField = new JTextField();
		textField.setBounds(80, 84, 234, 21);
		contentPanel.add(textField);//JAVA路径
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6E38\u620F\u540D\u5B57");
		label_1.setBounds(10, 10, 54, 15);
		contentPanel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 7, 112, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);//名字
		
		JLabel label_2 = new JLabel("\u6700\u5927\u5185\u5B58");
		label_2.setBounds(10, 123, 54, 15);
		contentPanel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(79, 120, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);//最大内存
		
		JLabel lblM = new JLabel("M");
		lblM.setBounds(144, 87, 13, 15);
		contentPanel.add(lblM);
		
		JButton btnjava = new JButton("\u9009\u62E9JAVA");
		btnjava.setBounds(333, 83, 93, 23);
		contentPanel.add(btnjava);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801");
		label_3.setBounds(10, 49, 54, 15);
		contentPanel.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 46, 112, 21);
		contentPanel.add(passwordField);//密码
		
		File file = new File("config.cfg");

		try { 
			BufferedReader filebr = new BufferedReader(new FileReader(file));
			@SuppressWarnings("unused")
			String str=filebr.readLine();
			String str1=filebr.readLine();//2名字
			String str2=filebr.readLine();//3密码
			String str3=filebr.readLine();//4Max Ram
			String str4=filebr.readLine();//5JAVA
			String str1f = str1;  str1f=str1f.replace("游戏名字=","");
			String str2f = str2;  str2f=str2f.replace("密码=", "");
			String str3f = str3;  str3f=str3f.replace("最大内存=", "");
			String str4f = str4;  str4f=str4f.replace("JAVA路径=", "");
			textField_1.setText(str1f);
			passwordField.setText(str2f);
			textField_2.setText(str3f);
			textField.setText(str4f);
			textField_1.setText(str1f);
			filebr.close();
		} catch (IOException e) { e.printStackTrace(); }
	}
}
