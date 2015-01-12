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
import java.util.Calendar;

import javax.swing.JComboBox;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class CoreGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static int getid = 0; 
	static String ggetid = "0";
	static JComboBox<Object> comboBox = new JComboBox<Object>();
	static JLabel lblNewLabel = new JLabel();
	static JLabel label_1;
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
		
	
		
		JButton btnNewButton_2 = new JButton("\u79BB\u7EBF\u6E38\u620F");
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
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E&\u66F4\u591A");
		btnNewButton.setBounds(10, 555, 110, 37);
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
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				label_1.setText("即将开始"+comboBox.getSelectedItem());
			}
		});
		
		comboBox.setBounds(10, 508, 230, 21);
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
			editorPane.setPage("http://ip138.com");//更新日志网址

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel.setBounds(556, 508, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5C0A\u656C\u7684\u6E38\u5BA2");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label.setBounds(623, 508, 138, 15);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("\u8D26\u53F7\u7BA1\u7406");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login.main(null);
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton_1.setBounds(809, 555, 93, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u5148\u767B\u5F55\uFF0C\u6216\u79BB\u7EBF\u6E38\u620F");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(556, 528, 138, 15);
		contentPane.add(lblNewLabel_1);
		
		label_1 = new JLabel("\u5373\u5C06\u5F00\u59CB\u6E38\u620F");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setBounds(556, 548, 205, 15);
		contentPane.add(label_1);
		label_1.setText("即将开始"+comboBox.getSelectedItem());
		getTime();
	}
	
	public static void getTime()
	{
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		if (hour < 11)
		{
			lblNewLabel.setText("早上好!");
		}
		else if (hour < 13)
		{
			lblNewLabel.setText("中午好！");
		}
		else if (hour < 18)
		{
			lblNewLabel.setText("下午好！");
		}
		else 
		{
			lblNewLabel.setText("晚上好！");
		}
	}
}
