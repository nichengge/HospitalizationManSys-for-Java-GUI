import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InHosUI extends JFrame {
	public String JDriver ="com.mysql.jdbc.Driver";
	public String conURL ="jdbc:mysql://127.0.0.1:3306/hosmansys?user=root&password=admin&characterEncoding=GBK";
	private JPanel contentPane;
	private JTextField Nametext;
	private JTextField InHosNum;
	private JTextField DocName;
	private JTextPane textPane;
	private JButton btnNewButton;
	private JTextField InHosTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InHosUI frame = new InHosUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InHosUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("pic\\\u5165\u9662\u767B\u8BB0.png"));
		setResizable(false);
		setTitle("\u5165\u9662\u767B\u8BB0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Nametext = new JTextField();
		Nametext.setBounds(198, 75, 143, 24);
		contentPane.add(Nametext);
		Nametext.setColumns(10);
		
		JComboBox SexcomboBox = new JComboBox();
		SexcomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		SexcomboBox.setBounds(198, 128, 44, 24);
		contentPane.add(SexcomboBox);
		
		InHosNum = new JTextField();
		InHosNum.setBounds(197, 165, 144, 24);
		contentPane.add(InHosNum);
		InHosNum.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		//comboBox_1.setModel(new DefaultComboBoxModel(new String[] {}));//下拉框置空，等待触发事件填充内容
		//comboBox_1.addItem("111");//向下拉框添加元素
		comboBox_1.setBounds(288, 263, 53, 24);
		contentPane.add(comboBox_1);
		
		DocName = new JTextField();
		DocName.setBounds(198, 309, 143, 24);
		contentPane.add(DocName);
		DocName.setColumns(10);
		
		textPane = new JTextPane();
		textPane.setBounds(197, 365, 144, 71);
		contentPane.add(textPane);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u75C5\u623F", "\u4E13\u5C5E\u75C5\u623F", "ICU\u75C5\u623F"}));
		comboBox_2.setBounds(198, 263, 89, 24);
		contentPane.add(comboBox_2);

		
//下拉框侦听
comboBox_2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
 	   String S1=new String(comboBox_2.getSelectedItem().toString());
 	   comboBox_1.setModel(new DefaultComboBoxModel(new String[] {}));//下拉框置空，等待触发事件填充内容
 	  try {
			Connection con =DriverManager.getConnection(conURL);			
			Statement s=con.createStatement();
			ResultSet rs1=s.executeQuery("select RoomNum from RoomInf where RoomType='"+S1+"' and RoomSpa>=1");
			if(rs1.next()==false){comboBox_1.setModel(new DefaultComboBoxModel(new String[]{}));}else{
				ResultSet rs2=s.executeQuery("select RoomNum from RoomInf where RoomType='"+S1+"' and RoomSpa>=1");
			while(rs2.next()){
				comboBox_1.addItem(rs2.getString("RoomNum").trim());//向下拉框添加元素	
			}
			s.close(); 
			con.close();
			}}
			catch ( SQLException f)
			{
			System.out.println("SQLException:"+f.getMessage());
			}
    }
});	
		
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {//患者住院
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName(JDriver);
					   } 
					catch (java.lang.ClassNotFoundException f)
					   {
						   System.out.println("forname:"+f.getMessage());
								}
					try{
					Connection con =DriverManager.getConnection(conURL);
					Statement s=con.createStatement();
					ResultSet rs1=s.executeQuery("select *  from IllInf where iNum='"+InHosNum.getText()+"'");
	    			if(rs1.next()==true){JOptionPane.showMessageDialog(null, "当前住院号已有患者:"+rs1.getString("iName").trim()+"!");}else{
					String find1 = "INSERT INTO IllInf(iName,iNum,iSex,iTime,RoomNum,iDoc,iText,iSta) VALUES('" + Nametext.getText() + "','" + InHosNum.getText() + "','" + SexcomboBox.getSelectedItem().toString()+ "','"+InHosTime.getText() +"','"+comboBox_1.getSelectedItem().toString()+ "','"+DocName.getText()+"','"+textPane.getText()+"','"+1+"')";
					String find2 = "UPDATE RoomInf Set RoomSpa=RoomSpa-1 where RoomNum='"+comboBox_1.getSelectedItem().toString()+"'";
					PreparedStatement ps1=con.prepareStatement(find1);
					PreparedStatement ps2=con.prepareStatement(find2);
					JOptionPane.showMessageDialog(null, "入院成功！");
					ps1.executeUpdate(); 
					ps2.executeUpdate(); 
					s.close();
					con.close();
					}
					}
					catch ( SQLException f) {
					System.out.println("SQLException:"+f.getMessage());
						}    
					}
		});
		
		
		
		btnNewButton.setIcon(new ImageIcon("pic\\sumb.jpg"));
		btnNewButton.setBounds(153, 473, 120, 31);
		contentPane.add(btnNewButton);
		
		InHosTime = new JTextField();
		InHosTime.setBounds(198, 215, 140, 24);
		contentPane.add(InHosTime);
		InHosTime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pic\\\u5165\u9662\u767B\u8BB0\u58C1\u7EB8\u5E26\u5B57.jpg"));
		lblNewLabel.setBounds(0, 0, 426, 537);
		contentPane.add(lblNewLabel);
		
	}
}


