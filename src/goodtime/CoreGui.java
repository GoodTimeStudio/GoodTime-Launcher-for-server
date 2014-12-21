package goodtime;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

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
	

	public static void main(String[] args) 
	{		
		Config.ConfigCheck();			
	}


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
