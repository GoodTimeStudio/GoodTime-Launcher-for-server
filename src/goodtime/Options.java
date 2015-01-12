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
import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;


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
	static JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	
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
		setTitle("\u914D\u7F6E\u8BBE\u7F6E");
		setBounds(100, 100, 670, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 54, 15);
		contentPanel.add(label);
		
		
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58\u8BBE\u7F6E");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) //±£´æÉèÖÃ
			{
				Config.java = textField.getText();//JAVAÂ·¾¶
				//Config.username = textField_1.getText();
				Config.memory = textField_2.getText();//×î´óÄÚ´æ
				//String pwd = passwordField.getText();//ÏÈ¼ÓÃÜ¡£¡£
				//..
				//Config.password = pwd;
				Config.WriteConfig();
				opt.setEnabled(false);
				opt.setVisible(false);
				opt.dispose();
			}
		});
		btnNewButton.setBounds(551, 301, 93, 51);
		contentPanel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textField.setBounds(195, 243, 234, 21);
		contentPanel.add(textField);//JAVAÂ·¾¶
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textField_2.setBounds(195, 124, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);//×î´óÄÚ´æ
		
		JLabel lblM = new JLabel("MB");
		lblM.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblM.setBounds(260, 127, 23, 15);
		contentPanel.add(lblM);
		
		JButton btnjava = new JButton("\u9009\u62E9JAVA");
		btnjava.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//Ñ¡Ôñjava
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter f = new FileNameExtensionFilter("Ó¦ÓÃ³ÌÐò(.exe)", "exe");
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
		btnjava.setBounds(429, 243, 93, 23);
		contentPanel.add(btnjava);
		
		JButton button = new JButton("\u5173\u4E8E");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) //¹ØÓÚ
			{
				About dialog = new About();
				dialog.setVisible(true);
			}
		});
		button.setBounds(10, 329, 93, 23);
		contentPanel.add(button);
		
		JButton btnNewButton_1 = new JButton("\u81EA\u52A8\u8BBE\u7F6E");
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//×Ô¶¯ÉèÖÃÄÚ´æ
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
		btnNewButton_1.setBounds(285, 123, 93, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton button_1 = new JButton("\u81EA\u52A8\u9009\u62E9");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {//×Ô¶¯Ñ¡Ôñjava
				Info.getJavaInfo();
				textField.setText(Info.jpath);
			}
		});
		button_1.setBounds(521, 243, 93, 23);
		contentPanel.add(button_1);
		
		JButton btnNewButton_2 = new JButton("\u4E0B\u8F7D\u6E38\u620F");
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Downloader.main(null);
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(453, 301, 88, 51);
		contentPanel.add(btnNewButton_2);
		
		JLabel label_1 = new JLabel("\u914D\u7F6E\u4FE1\u606F");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_1.setBounds(10, 10, 54, 15);
		contentPanel.add(label_1);
		
		JLabel label_3 = new JLabel("\u914D\u7F6E\u540D\u79F0\uFF1A");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_3.setBounds(29, 33, 116, 15);
		contentPanel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 33, 183, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u6E38\u620F\u76EE\u5F55 (\u7248\u672C\u72EC\u7ACB)");
		chckbxNewCheckBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(29, 63, 150, 23);
		contentPanel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u542F\u52A8\u5668\u53EF\u89C6\u72B6\u6001");
		chckbxNewCheckBox_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBounds(29, 93, 150, 23);
		contentPanel.add(chckbxNewCheckBox_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(195, 63, 308, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6700\u5927\u5185\u5B58");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_2.setBounds(29, 123, 150, 15);
		contentPanel.add(label_2);
		
		JLabel label_4 = new JLabel("\u4F7F\u7528\u7684\u6E38\u620F\u7248\u672C");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_4.setBounds(29, 153, 150, 15);
		contentPanel.add(label_4);
		
		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		comboBox.setBounds(195, 153, 308, 21);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u9AD8\u7EA7\u8BBE\u7F6E");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 213, 73, 15);
		contentPanel.add(lblNewLabel);
		
		JComboBox<?> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(195, 93, 308, 21);
		contentPanel.add(comboBox_1);
		
		JCheckBox chckbxJava = new JCheckBox("JAVA\u8DEF\u5F84");
		chckbxJava.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		chckbxJava.setBounds(10, 243, 103, 23);
		contentPanel.add(chckbxJava);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\u989D\u5916JAVA\u53C2\u6570");
		chckbxNewCheckBox_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		chckbxNewCheckBox_2.setBounds(10, 273, 103, 23);
		contentPanel.add(chckbxNewCheckBox_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(195, 273, 308, 21);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		Config.ReadConfig();

	}
}
