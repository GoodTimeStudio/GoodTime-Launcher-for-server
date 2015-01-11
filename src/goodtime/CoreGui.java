package goodtime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JComboBox;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;



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
	 * 背景测试
	 */
	//private JPanel imagePanel;
	//private ImageIcon background;
	
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
		setTitle("GoodTime-Launcher Dev 1501a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JButton btnNewButton_2 = new JButton("\u5F00\u542FGoodTime\u4E4B\u65C5\uFF01");
		btnNewButton_2.setBounds(379, 508, 167, 84);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			//-------------------------------------------
			public void mouseClicked(MouseEvent arg0) {
				//启动
				try 
				{
					getid = comboBox.getSelectedIndex();
					ggetid = String.valueOf(getid); 
					Object gver = comboBox.getSelectedItem();
					Info.version = gver.toString();
					Config.WriteConfig();
					Info.main(null);
					try {
						Launcher.main(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
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
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("\u79BB\u7EBF\u6E38\u620F");
		btnNewButton_1.setBounds(802, 518, 110, 37);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E&\u66F4\u591A");
		btnNewButton.setBounds(802, 565, 110, 37);
		contentPane.add(btnNewButton);
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
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		
		
	/*/背景--------------------------------------
		
		URL bgtp = this.getClass().getResource("bg.jpg");
		System.out.println(bgtp);
		background = new ImageIcon(bgtp);// 背景图片
		JLabel bg = new JLabel(background);
		bg.setBounds(0, 0, background.getIconWidth(),
		background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().setLayout(null);
		  // 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setResizable(false);
		
		
		//=============================*/
		Info.getVersion();
		Config.ReadConfig();
		getid = Integer.valueOf(ggetid).intValue();
		
		comboBox.setBounds(10, 518, 287, 21);
		contentPane.add(comboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setSelectedIndex(getid);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(0, 0, 922, 498);
		contentPane.add(tabbedPane);	
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		tabbedPane.addTab("更新日志", null, editorPane, null);
		tabbedPane.setVisible(true);
		try {
			editorPane.setPage("http://ip138.com");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
