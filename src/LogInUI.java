import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class LogInUI extends JFrame {
	public String JDriver ="com.mysql.jdbc.Driver";
	public String conURL ="jdbc:mysql://127.0.0.1:3306/hosmansys?user=root&password=admin&characterEncoding=GBK";
	private JFrame frame;
	private final JLabel Label1 = new JLabel("\u7528\u6237\u540D\uFF1A");
	public JTextField text1;
	private JPasswordField key;
	private JLabel lblNewLabel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInUI window = new LogInUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public LogInUI() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("creatuser.jpg"));
		frame.setTitle("\u6B22\u8FCE\u4F7F\u7528\u4F4F\u9662\u7BA1\u7406\u7CFB\u7EDF--\u767B\u5F55");
		frame.setFont(new Font("宋体", Font.PLAIN, 12));
		frame.setBounds(100, 100, 800, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Label1.setBounds(248, 243, 72, 21);
		frame.getContentPane().add(Label1);
		Label1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel Label2 = new JLabel("\u5BC6  \u7801\uFF1A");
		Label2.setBounds(248, 301, 72, 21);
		frame.getContentPane().add(Label2);
		Label2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		text1 = new JTextField();
		text1.setBounds(357, 242, 120, 24);
		frame.getContentPane().add(text1);
		text1.setColumns(10);
		
		key = new JPasswordField();
		key.setBounds(357, 300, 120, 24);
		frame.getContentPane().add(key);
		
		JButton button1 = new JButton("");
		button1.setBounds(215, 376, 111, 36);
		frame.getContentPane().add(button1);
		button1.addActionListener(new ActionListener() {//登录按钮侦听
			public void actionPerformed(ActionEvent e) {
				
				try {Class.forName(JDriver);} 		
    			catch (java.lang.ClassNotFoundException f) {
    			System.out.println("forname:"+f.getMessage());}	
    			String UserInputPWD= new String(key.getPassword());//密文变为明文
    			if(text1.getText().equals("")||UserInputPWD.equals("")){JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");}
    			else{
    			try {
    			Connection con =DriverManager.getConnection(conURL);			
    			Statement s=con.createStatement();
    			ResultSet rs1=s.executeQuery("select *  from UserInf where id='"+text1.getText()+"'");
    			if(rs1.next()==false){JOptionPane.showMessageDialog(null, "用户不存在！");}else{
    			ResultSet rs2=s.executeQuery("select *  from UserInf where id='"+text1.getText()+"'");
    			while(rs2.next()){
    			//System.out.println(rs1.getString("id")+"\t"+rs1.getString("pwd")+"\t"+rs1.getString("type")+"\t");}
    			//rs1.next();//挪动游标指向当前结果
    			String DBRetPWD=rs2.getString("pwd").trim();//数据库返回的密码
    			String DBRetType=rs2.getString("type").trim();//数据库返回的账户类型
    			//System.out.println(DBRetPWD);
    			if(DBRetPWD.equals(UserInputPWD)&&DBRetType.equals("A")){
    				//跳转到管理员界面	
				    ManUI manui=new ManUI();
					manui.setVisible(true);
					frame.dispose();//关闭窗口
					}
					
    			else if(DBRetPWD.equals(UserInputPWD)&&DBRetType.equals("U")){
						//跳转到普通用户界面
						UserUI userui=new UserUI();
						userui.setVisible(true);
						frame.dispose();//关闭窗口
						}
						
    			else{ JOptionPane.showMessageDialog(null, "用户名或密码错误！");}    
    				
    			}
    			}
    			s.close(); 
    			con.close();             
    			}
    			catch ( SQLException f)
    			{
    			System.out.println("SQLException:"+f.getMessage());
    			}}
			}
		});
		button1.setIcon(new ImageIcon("pic\\LogIn-ico.jpg"));
		
		JButton button2 = new JButton("");
		button2.setBounds(403, 376, 111, 36);
		frame.getContentPane().add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button2.setIcon(new ImageIcon("pic\\Exit-ico.jpg"));
		
		JButton btnNewButton = new JButton("\u6CE8\u518C\u7528\u6237");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//跳转到注册用户界面
				CreatUser creatuser=new CreatUser();
				creatuser.setVisible(true);
				frame.dispose();//关闭窗口
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(669, 525, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("pic\\them.jpg"));
		lblNewLabel.setBounds(-188, 0, 970, 552);
		frame.getContentPane().add(lblNewLabel);
	}
}
