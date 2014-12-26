package goodtime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.JComboBox;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.awt.Color;



public class CoreGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static int getid = 0; 
	static String ggetid = "0";
	static JComboBox<Object> comboBox = new JComboBox<Object>();
	/*
	 * ±³¾°²âÊÔ
	 */
	private JPanel imagePanel;
	private ImageIcon background;
	
	 /* 
	 */
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
		setTitle("GoodTime-Launcher Dev 1226a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E&\u66F4\u591A");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//-------------------
				try {
					Options.main(null);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("ºÚÌå", Font.PLAIN, 14));
		btnNewButton.setBounds(792, 555, 110, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u79BB\u7EBF\u6E38\u620F");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("ºÚÌå", Font.PLAIN, 14));
		btnNewButton_1.setBounds(792, 508, 110, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5F00\u542FGoodTime\u4E4B\u65C5\uFF01");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			//-------------------------------------------
			public void mouseClicked(MouseEvent arg0) {
				//Æô¶¯
				try 
				{
					getid = comboBox.getSelectedIndex();
					ggetid = String.valueOf(getid); 
					Object gver = comboBox.getSelectedItem();
					Info.version = gver.toString();
					Config.WriteConfig();
					Info.main(null);
					Launcher.main(null);
					System.exit(0);
				} 
				catch (JsonIOException e) {
					e.printStackTrace();
				} catch (JsonSyntaxException e) {
					e.printStackTrace();
				}
			}
			//-------------------------------------------
		});
		btnNewButton_2.setFont(new Font("ºÚÌå", Font.PLAIN, 14));
		btnNewButton_2.setBounds(615, 508, 167, 84);
		contentPane.add(btnNewButton_2);
		
		//±³¾°--------------------------------------
		
		URL bgtp = this.getClass().getResource("bg.jpg");
		System.out.println(bgtp);
		background = new ImageIcon(bgtp);// ±³¾°Í¼Æ¬
		JLabel bg = new JLabel(background);
		bg.setBounds(0, 0, background.getIconWidth(),
		background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().setLayout(null);
		  // °Ñ±³¾°Í¼Æ¬Ìí¼Óµ½·Ö²ã´°¸ñµÄ×îµ×²ã×÷Îª±³¾°
		this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setResizable(false);
		this.setVisible(true);
		comboBox.setBackground(Color.LIGHT_GRAY);
		
		//---------------------------------------
		
		comboBox.setBounds(615, 477, 287, 21);
		contentPane.add(comboBox);
		Info.getVersion();
		Config.ReadConfig();
		getid = Integer.valueOf(ggetid).intValue();
		comboBox.setSelectedIndex(getid);
	}
	

}
