package goodtime;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.JPasswordField;

import java.awt.Color;


public class Options extends JDialog {
	static Options opt = new Options();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;
	static JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {	
		//-------------
		try {
			opt.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			opt.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the dialog.
	 */

	public Options() {
		setTitle("\u8BBE\u7F6E");
		setBounds(100, 100, 670, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 54, 15);
		contentPanel.add(label);
		
		
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58\u8BBE\u7F6E");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) //保存设置
			{
				Config.java = textField.getText();//JAVA路径
				Config.username = textField_1.getText();
				Config.memory = textField_2.getText();//最大内存
				String pwd = passwordField.getText();//先加密。。
				//..
				Config.password = pwd;
				Config.WriteConfig();
				opt.setEnabled(false);
				opt.setVisible(false);
				opt.dispose();
			}
		});
		btnNewButton.setBounds(551, 301, 93, 51);
		contentPanel.add(btnNewButton);
		
		JLabel lblJava = new JLabel("JAVA \u8DEF\u5F84");
		lblJava.setBounds(10, 125, 73, 15);
		contentPanel.add(lblJava);
		
		textField = new JTextField();
		textField.setBounds(79, 122, 234, 21);
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
		label_2.setBounds(10, 87, 54, 15);
		contentPanel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(79, 84, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);//最大内存
		
		JLabel lblM = new JLabel("MB");
		lblM.setBounds(147, 90, 23, 15);
		contentPanel.add(lblM);
		
		JButton btnjava = new JButton("\u9009\u62E9JAVA");
		btnjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//选择java
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter f = new FileNameExtensionFilter("应用程序(.exe)", "exe");
				fc.setFileFilter(f);
				int i = fc.showOpenDialog(getContentPane());
				if (i == JFileChooser.APPROVE_OPTION)
				{
					File sf = fc.getSelectedFile();
					textField.setText(sf.getPath());
				}
			}
		});
		btnjava.setBackground(Color.LIGHT_GRAY);
		btnjava.setBounds(77, 150, 93, 23);
		contentPanel.add(btnjava);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801");
		label_3.setBounds(10, 49, 54, 15);
		contentPanel.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 46, 112, 21);
		contentPanel.add(passwordField);//密码
		
		JButton button = new JButton("\u5173\u4E8E");
		button.setBackground(Color.LIGHT_GRAY);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) //关于
			{
				About dialog = new About();
				dialog.setVisible(true);
			}
		});
		button.setBounds(10, 329, 93, 23);
		contentPanel.add(button);
		
		JButton btnNewButton_1 = new JButton("\u81EA\u52A8\u8BBE\u7F6E");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//自动设置内存
				Info.getJavaInfo();
				int jree = Integer.valueOf(Info.jre).intValue();
				if (jree == 64)
				{
					textField_2.setText("2048");
				}
				else {
					textField_2.setText("1024");
				}
			}
		});
		btnNewButton_1.setBounds(170, 83, 93, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton button_1 = new JButton("\u81EA\u52A8\u9009\u62E9");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//自动选择java
				Info.getJavaInfo();
				textField.setText(Info.jpath);
			}
		});
		button_1.setBounds(170, 150, 93, 23);
		contentPanel.add(button_1);
		
		JButton btnNewButton_2 = new JButton("\u4E0B\u8F7D\u6E38\u620F");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Downloader.main(null);
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(453, 301, 88, 51);
		contentPanel.add(btnNewButton_2);
		
		Config.ReadConfig();

	}
}
