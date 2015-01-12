package goodtime;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 601169365698763308L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("\u5173\u4E8EGoodTime Launcher");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblGoodtimeLauncherDev = new JLabel("GoodTime Launcher Dev 1501c");
		lblGoodtimeLauncherDev.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblGoodtimeLauncherDev.setBounds(10, 10, 249, 15);
		getContentPane().add(lblGoodtimeLauncherDev);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230GoodTime\u670D\u52A1\u5668");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 35, 155, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("By _JAVA7 & liach");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(316, 10, 108, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IndustrialCraft");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 60, 138, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GregTech Intergalactical");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 82, 155, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblGoodtiwicpnet = new JLabel("goodti.wicp.net");
		lblGoodtiwicpnet.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblGoodtiwicpnet.setForeground(Color.BLUE);
		lblGoodtiwicpnet.setBounds(10, 107, 138, 15);
		getContentPane().add(lblGoodtiwicpnet);
		
		JLabel lblQq = new JLabel("QQ\u7FA4:328994741");
		lblQq.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblQq.setBounds(10, 132, 138, 15);
		getContentPane().add(lblQq);
		
		JButton button = new JButton("\u6350\u52A9");
		button.setBackground(Color.LIGHT_GRAY);
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		button.setBounds(316, 56, 93, 23);
		getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u52A0\u5165QQ\u7FA4\r\n");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton.setBounds(316, 103, 93, 23);
		getContentPane().add(btnNewButton);
	}
}
