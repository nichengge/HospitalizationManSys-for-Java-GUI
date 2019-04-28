import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
class ManUI extends JFrame{
	public String JDriver ="com.mysql.jdbc.Driver";
	public String conURL ="jdbc:mysql://127.0.0.1:3306/hosmansys?user=root&password=admin&characterEncoding=GBK";
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTable table;
	private JTextField deletetextField;
	private JTextField newroomtextField1;
	private JTextField newroomtextField2;
	private JTextField updateroomtextField;
	private JTextField textField;
	private JTextField newroomtextField3;
	private JTextField textField_1;

public ManUI(){ 
	super("管理员操作窗口");
	setIconImage(Toolkit.getDefaultToolkit().getImage("pic\\ico.ico"));
	setSize(825,524);//窗体尺寸
	setLocation(400,200);//窗体绝对位置
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(new BorderLayout(0, 0));
	getContentPane().add(tabbedPane);
	
	JPanel setroompanel = new JPanel();
	tabbedPane.addTab("", new ImageIcon("pic\\newroom.jpg"), setroompanel, null);
	setroompanel.setLayout(null);
	
	newroomtextField1 = new JTextField();
	newroomtextField1.setText("#");
	newroomtextField1.setBounds(421, 94, 186, 24);
	setroompanel.add(newroomtextField1);
	newroomtextField1.setColumns(10);
	
	newroomtextField2 = new JTextField();
	newroomtextField2.setBounds(421, 152, 186, 24);
	setroompanel.add(newroomtextField2);
	newroomtextField2.setColumns(10);
	
	JLabel lblNewLabel_6 = new JLabel("\u75C5\u623F\u7F16\u53F7:");
	lblNewLabel_6.setFont(new Font("幼圆", Font.PLAIN, 21));
	lblNewLabel_6.setBounds(234, 85, 103, 39);
	setroompanel.add(lblNewLabel_6);
	
	JLabel lblNewLabel_7 = new JLabel("\u8D1F\u8D23\u4EBA\uFF1A");
	lblNewLabel_7.setFont(new Font("幼圆", Font.PLAIN, 21));
	lblNewLabel_7.setBounds(234, 150, 103, 24);
	setroompanel.add(lblNewLabel_7);
	
	JLabel lblNewLabel_8 = new JLabel("\u5E8A\u4F4D\u6570\uFF1A");
	lblNewLabel_8.setFont(new Font("幼圆", Font.PLAIN, 21));
	lblNewLabel_8.setBounds(235, 211, 92, 39);
	setroompanel.add(lblNewLabel_8);
	
	JLabel lblNewLabel_9 = new JLabel("\u75C5\u623F\u7C7B\u578B\uFF1A");
	lblNewLabel_9.setFont(new Font("幼圆", Font.PLAIN, 20));
	lblNewLabel_9.setBounds(237, 273, 135, 39);
	setroompanel.add(lblNewLabel_9);
	
	JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u75C5\u623F", "\u4E13\u5C5E\u75C5\u623F", "ICU\u75C5\u623F"}));
	comboBox_1.setBounds(421, 277, 92, 24);
	setroompanel.add(comboBox_1);
	
	//下拉框侦听
	/*comboBox_1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
     	   String S1=new String(comboBox_1.getSelectedItem().toString());
        }
});*/
	
	
	//提交更改侦听--添加新病房
	JButton btnNewButton_2 = new JButton("");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
				String find = "INSERT INTO RoomInf(RoomNum,RoomMan,RoomSpa,RoomType) VALUES('" + newroomtextField1.getText() + "','" + newroomtextField2.getText() + "'," + newroomtextField3.getText()+ ",'"+comboBox_1.getSelectedItem().toString() + "')";	
				PreparedStatement ps=con.prepareStatement(find);
				ps.executeUpdate(); 
				s.close();
				con.close();
				}
				catch ( SQLException f) {
				System.out.println("SQLException:"+f.getMessage());
					}    
				JOptionPane.showMessageDialog(null, "添置新病房成功！");
				}
		}
	);
	
	
	
	
	btnNewButton_2.setIcon(new ImageIcon("pic\\sumb.jpg"));
	btnNewButton_2.setBounds(388, 354, 113, 27);
	setroompanel.add(btnNewButton_2);
	
	newroomtextField3 = new JTextField();
	newroomtextField3.setBounds(421, 231, 49, 24);
	setroompanel.add(newroomtextField3);
	newroomtextField3.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setBounds(0, 1, 814, 438);
	setroompanel.add(lblNewLabel);
	lblNewLabel.setIcon(new ImageIcon("pic\\them0.jpg"));
	
	JPanel updateroompanel = new JPanel();
	tabbedPane.addTab("", new ImageIcon("pic\\xiugairoom.jpg"), updateroompanel, null);
	updateroompanel.setLayout(null);
	
	JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u75C5\u623F\u53F7\uFF1A");
	label.setFont(new Font("幼圆", Font.PLAIN, 22));
	label.setBounds(120, 49, 262, 43);
	updateroompanel.add(label);
	
	JLabel label_1 = new JLabel("\u8BF7\u952E\u5165\u65B0\u4FE1\u606F");
	label_1.setFont(new Font("幼圆", Font.PLAIN, 20));
	label_1.setBounds(121, 108, 152, 29);
	updateroompanel.add(label_1);
	
	updateroomtextField = new JTextField();
	updateroomtextField.setText("#");
	updateroomtextField.setBounds(371, 60, 241, 24);
	updateroompanel.add(updateroomtextField);
	updateroomtextField.setColumns(10);
	
	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(232, 171, 186, 24);
	updateroompanel.add(textField);
	
	JLabel label_2 = new JLabel("\u8D1F\u8D23\u4EBA\uFF1A");
	label_2.setFont(new Font("幼圆", Font.PLAIN, 21));
	label_2.setBounds(124, 170, 103, 24);
	updateroompanel.add(label_2);
	
	JLabel label_3 = new JLabel("\u5E8A\u4F4D\u6570\uFF1A");
	label_3.setFont(new Font("幼圆", Font.PLAIN, 21));
	label_3.setBounds(125, 227, 92, 39);
	updateroompanel.add(label_3);
	
	JLabel label_4 = new JLabel("\u75C5\u623F\u7C7B\u578B\uFF1A");
	label_4.setFont(new Font("幼圆", Font.PLAIN, 20));
	label_4.setBounds(123, 291, 113, 39);
	updateroompanel.add(label_4);
	
	JComboBox comboBox_3 = new JComboBox();
	comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u75C5\u623F", "\u4E13\u5C5E\u75C5\u623F", "ICU\u75C5\u623F"}));
	comboBox_3.setBounds(232, 300, 92, 24);
	updateroompanel.add(comboBox_3);
	
	
	
	
	//提交更改侦听-修改病房规格
	JButton button = new JButton("");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {Class.forName(JDriver);} 		
			catch (java.lang.ClassNotFoundException f) {
			System.out.println("forname:"+f.getMessage());}	
			
			if(updateroomtextField.getText().equals("")||updateroomtextField.getText().equals("#")){
			JOptionPane.showMessageDialog(null, "请先输入病房号！");
			updateroomtextField.setText("#");
			textField.setText("");
			textField_1.setText("");
			}else{
			try {
			Connection con =DriverManager.getConnection(conURL);			
			Statement s=con.createStatement();
			ResultSet rs1=s.executeQuery("select *  from RoomInf where RoomNum='"+updateroomtextField.getText()+"'");
			if(rs1.next()==false){JOptionPane.showMessageDialog(null, "要修改的病房不存在，请先设置新病房！");
			updateroomtextField.setText("#");
			textField.setText("");
			textField_1.setText("");
			}else{	
			//String res="update RoomInf  set RoomMan='"+ textField.getText()+"',RoomSpa="+textField_1.getText()+",RoomType='"+comboBox_3.getSelectedItem().toString()+"' where RoomNum='"+updateroomtextField.getText()+"'";
			String res1="update RoomInf  set RoomMan='"+ textField.getText()+"'where RoomNum='"+updateroomtextField.getText()+"'";
			String res2="update RoomInf  set RoomSpa="+ textField_1.getText()+"where RoomNum='"+updateroomtextField.getText()+"'";
			String res3="update RoomInf  set RoomType='"+ comboBox_3.getSelectedItem().toString()+"'where RoomNum='"+updateroomtextField.getText()+"'";
			
			PreparedStatement ps1=con.prepareStatement(res1);
			PreparedStatement ps2=con.prepareStatement(res2);
			PreparedStatement ps3=con.prepareStatement(res3);
			JOptionPane.showMessageDialog(null, "病房信息更新成功！");
			ps1.executeUpdate(); 
			ps2.executeUpdate(); 
			ps3.executeUpdate(); 
		    s.close(); 
			con.close();
			}
			}
			catch ( SQLException f)
			{
			System.out.println("SQLException:"+f.getMessage());
			}
			}
		}
	});
			
	
	
	
	
	button.setIcon(new ImageIcon("pic\\sumb.jpg"));
	button.setBounds(362, 364, 113, 27);
	updateroompanel.add(button);
	
	textField_1 = new JTextField();
	textField_1.setBounds(228, 236, 51, 24);
	updateroompanel.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setBounds(-215, 6, 1034, 431);
	lblNewLabel_1.setIcon(new ImageIcon("pic\\them0.jpg"));
	updateroompanel.add(lblNewLabel_1);
	
	JPanel deleteroompanel = new JPanel();
	tabbedPane.addTab("", new ImageIcon("pic\\zroom.jpg"), deleteroompanel, null);
	deleteroompanel.setLayout(null);
	
	deletetextField = new JTextField();
	deletetextField.setText("#");
	deletetextField.setBounds(363, 130, 181, 24);
	deleteroompanel.add(deletetextField);
	deletetextField.setColumns(10);
	
	JButton btnNewButton_1 = new JButton("");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName(JDriver);
				} 
				catch(java.lang.ClassNotFoundException f) {	
				System.out.println("forname:"+f.getMessage());
					}
			try {			
					Connection con =DriverManager.getConnection(conURL);
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery("select *  from RoomInf where RoomNum='"+deletetextField.getText()+"'");
					if(rs.next()==false){JOptionPane.showMessageDialog(null, "病房不存在，请检查病房号！");}else{
					String find = "DELETE FROM RoomInf WHERE RoomNum = '" + deletetextField.getText() + "'";	
					PreparedStatement ps=con.prepareStatement(find);
					ps.executeUpdate();   
					s.close();                
					con.close();
					JOptionPane.showMessageDialog(null, "成功撤除病房，资源释放成功！");
				} }
				catch ( SQLException f) {
				System.out.println("SQLException:"+f.getMessage());
					}
		}
	});
	btnNewButton_1.setIcon(new ImageIcon("pic\\sumb.jpg"));
	btnNewButton_1.setBounds(331, 236, 113, 27);
	deleteroompanel.add(btnNewButton_1);
	
	JLabel lblNewLabel_5 = new JLabel("\u8BF7\u8F93\u5165\u75C5\u623F\u7F16\u53F7:");
	lblNewLabel_5.setFont(new Font("幼圆", Font.PLAIN, 21));
	lblNewLabel_5.setBounds(181, 120, 168, 40);
	deleteroompanel.add(lblNewLabel_5);
	
	JLabel lblNewLabel_3 = new JLabel("New label");
	lblNewLabel_3.setBounds(-114, 0, 928, 439);
	lblNewLabel_3.setIcon(new ImageIcon("pic\\them0.jpg"));
	deleteroompanel.add(lblNewLabel_3);
	
	JPanel galancepanel = new JPanel();
	tabbedPane.addTab("", new ImageIcon("pic\\visitroom.jpg"), galancepanel, null);
	galancepanel.setLayout(null);
	
	table = new JTable();
	table.setFont(new Font("宋体", Font.PLAIN, 15));
	table.setColumnSelectionAllowed(true);
	table.setCellSelectionEnabled(true);
	table.setBackground(Color.WHITE);
	table.setForeground(Color.BLACK);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	
	//在表格中显示结果
	/*String[] col = { "房间号", "管理员", "剩余容量","病房类型" };
	DefaultTableModel mm = new DefaultTableModel(col, 0); // 定义一个表的模板
	
	try {Class.forName(JDriver);} 		
	catch (java.lang.ClassNotFoundException f) {
	System.out.println("forname:"+f.getMessage());}	
	try {
	Connection con =DriverManager.getConnection(conURL);			
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select *  from RoomInf");
	
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
	
	/*table.setModel(new DefaultTableModel(
		new Object[][] {
			{null, null, null, null},
		},
		new String[] {
			"\u75C5\u623F\u7C7B\u578B", "\u8D1F\u8D23\u4EBA", "\u5E8A\u4F4D\u6570", "\u75C5\u623F\u53F7"
		}
	));*/
	
	JLabel lblNewLabel_10 = new JLabel("\u75C5\u623F\u53F7        \u7BA1\u7406\u5458       \u5269\u4F59\u5BB9\u91CF        \u75C5\u623F\u7C7B\u578B");
	lblNewLabel_10.setForeground(Color.WHITE);
	lblNewLabel_10.setBackground(Color.LIGHT_GRAY);
	lblNewLabel_10.setFont(new Font("宋体", Font.BOLD, 15));
	lblNewLabel_10.setBounds(341, 39, 459, 30);
	galancepanel.add(lblNewLabel_10);
	
	
	table.setBounds(341, 70, 459, 356);
	galancepanel.add(table);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u4E13\u5C5E\u75C5\u623F", "\u666E\u901A\u75C5\u623F", "ICU\u75C5\u623F"}));
	comboBox.setBounds(47, 193, 89, 24);
	galancepanel.add(comboBox);
	
	JComboBox comboBox_2 = new JComboBox();
	comboBox_2.setBounds(165, 193, 57, 24);
	galancepanel.add(comboBox_2);
	
	
//下拉框侦听
comboBox.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	//下面影响病房号复选框
	   String S1=new String(comboBox.getSelectedItem().toString());
	   comboBox_2.setModel(new DefaultComboBoxModel(new String[] {}));//下拉框置空，等待触发事件填充内容
	  try {
		Connection con =DriverManager.getConnection(conURL);			
		Statement s=con.createStatement();
		ResultSet rs1=s.executeQuery("select RoomNum from RoomInf where RoomType='"+S1+"'");
		if(rs1.next()==false){comboBox_2.setModel(new DefaultComboBoxModel(new String[]{}));}else{
			ResultSet rs2=s.executeQuery("select RoomNum from RoomInf where RoomType='"+S1+"'");
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
		ResultSet rs=s.executeQuery("select *  from RoomInf where RoomType='"+S2+"'");
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

	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setBounds(-275, 13, 1162, 577);
	lblNewLabel_2.setIcon(new ImageIcon("pic\\them0.jpg"));
	galancepanel.add(lblNewLabel_2);
	
	JPanel advancepanel = new JPanel();
	tabbedPane.addTab("", new ImageIcon("pic\\advance.jpg"), advancepanel, null);
	
	JButton putonginButton = new JButton("");
	putonginButton.setBounds(237, 5, 167, 45);
	putonginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//跳转到普通用户界面
			UserUI userui=new UserUI();
			userui.setVisible(true);
		    dispose();//关闭窗口
		}
	});
	advancepanel.setLayout(null);
	putonginButton.setIcon(new ImageIcon("pic\\putoin.jpg"));
	advancepanel.add(putonginButton);
	
	JButton exitbutton = new JButton("");
	exitbutton.setBounds(409, 5, 167, 45);
	exitbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	exitbutton.setIcon(new ImageIcon("pic\\exitlog.jpg"));
	advancepanel.add(exitbutton);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setBounds(0, 5, 814, 434);
	lblNewLabel_4.setIcon(new ImageIcon("pic\\them0.jpg"));
	advancepanel.add(lblNewLabel_4);
	
	this.setResizable(false);
		
}
}
