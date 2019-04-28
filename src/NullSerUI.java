import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class NullSerUI extends JFrame {
	public String JDriver ="com.mysql.jdbc.Driver";
	public String conURL ="jdbc:mysql://127.0.0.1:3306/hosmansys?user=root&password=admin&characterEncoding=GBK";
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NullSerUI frame = new NullSerUI();
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
	public NullSerUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("pic\\\u7A7A\u5E8A\u67E5\u8BE2.png"));
		setTitle("\u7A7A\u5E8A\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setEnabled(false);
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\u75C5\u623F\u7C7B\u578B", "\u8D1F\u8D23\u4EBA", "\u5269\u4F59\u5E8A\u4F4D\u6570", "\u75C5\u623F\u53F7"
			}
		));*/
		table.setBounds(14, 26, 438, 357);
		contentPane.add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u75C5\u623F", "\u4E13\u5C5E\u75C5\u623F", "ICU\u75C5\u623F"}));
		comboBox.setBounds(71, 415, 85, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(183, 415, 64, 24);
		contentPane.add(comboBox_2);
		
		JLabel label = new JLabel("\u75C5\u623F\u53F7        \u7BA1\u7406\u5458       \u5269\u4F59\u5BB9\u91CF        \u75C5\u623F\u7C7B\u578B");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("宋体", Font.BOLD, 15));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(14, 0, 449, 30);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pic\\nullroomser.jpg"));
		lblNewLabel.setBounds(0, 0, 477, 452);
		contentPane.add(lblNewLabel);
		
		//下拉框侦听
		comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//下面影响病房号复选框
			   String S1=new String(comboBox.getSelectedItem().toString());
			   comboBox_2.setModel(new DefaultComboBoxModel(new String[] {}));//下拉框置空，等待触发事件填充内容
			  try {
				Connection con =DriverManager.getConnection(conURL);			
				Statement s=con.createStatement();
				ResultSet rs1=s.executeQuery("select RoomNum from RoomInf where RoomType='"+S1+"' and RoomSpa>=1");
				if(rs1.next()==false){comboBox_2.setModel(new DefaultComboBoxModel(new String[]{}));}else{
					ResultSet rs2=s.executeQuery("select RoomNum from RoomInf where RoomType='"+S1+"' and RoomSpa>=1");
				while(rs2.next()){
					comboBox_2.addItem(rs2.getString("RoomNum").trim());//向下拉框添加元素	
				}
				s.close(); 
				con.close();
				}}
				catch ( SQLException f)
				{
				System.out.println("SQLException:"+f.getMessage());
				}
			  //下面影响表格显示的结果
			  String[] col = { "房间号", "管理员", "剩余容量","病房类型" };
				DefaultTableModel mm = new DefaultTableModel(col, 0); // 定义一个表的模板
				String S2=new String(comboBox.getSelectedItem().toString());
				try {Class.forName(JDriver);} 		
				catch (java.lang.ClassNotFoundException f) {
				System.out.println("forname:"+f.getMessage());}	
				try {
				Connection con =DriverManager.getConnection(conURL);			
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("select *  from RoomInf where RoomType='"+S2+"' AND RoomSpa>=1");
				while(rs.next()){
					String RoomNum = rs.getString("RoomNum");
					String RoomMan = rs.getString("RoomMan");
					String RoomSpa = String.valueOf(rs.getInt("RoomSpa"));
					String RoomType = rs.getString("RoomType");
				
				String[] str_row = {RoomNum,RoomMan,RoomSpa,RoomType}; // 将一行的数据存在str_row字符串数组里
				mm.addRow(str_row);// 添加在表模板中
				}
				table.setModel(mm);// 将jtable这个表 设置为刚刚定义的模板
			    s.close(); 
				con.close();
				}
				catch ( SQLException f)
				{
				System.out.println("SQLException:"+f.getMessage());
				}
		}
		});	


		comboBox_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			  //下面影响表格显示的结果
			  String[] col = { "房间号", "管理员", "剩余容量","病房类型" };
				DefaultTableModel mm = new DefaultTableModel(col, 0); // 定义一个表的模板
				String S2=new String(comboBox.getSelectedItem().toString());//记录病房类型
				String S3=new String(comboBox_2.getSelectedItem().toString());//记录病房号
				try {Class.forName(JDriver);} 		
				catch (java.lang.ClassNotFoundException f) {
				System.out.println("forname:"+f.getMessage());}	
				try {
				Connection con =DriverManager.getConnection(conURL);			
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("select *  from RoomInf where RoomType='"+S2+"' AND RoomNum='"+S3+"'");
				while(rs.next()){
					String RoomNum = rs.getString("RoomNum");
					String RoomMan = rs.getString("RoomMan");
					String RoomSpa = String.valueOf(rs.getInt("RoomSpa"));
					String RoomType = rs.getString("RoomType");
				
				String[] str_row = {RoomNum,RoomMan,RoomSpa,RoomType}; // 将一行的数据存在str_row字符串数组里
				mm.addRow(str_row);// 添加在表模板中
				}
				table.setModel(mm);// 将jtable这个表 设置为刚刚定义的模板
			    s.close(); 
				con.close();
				}
				catch ( SQLException f)
				{
				System.out.println("SQLException:"+f.getMessage());
				}
		}
		});	
	}
}

