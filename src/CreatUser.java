import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CreatUser extends JFrame {
	public String JDriver ="com.mysql.jdbc.Driver";
	public String conURL ="jdbc:mysql://127.0.0.1:3306/hosmansys?user=root&password=admin&characterEncoding=GBK";
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");
	private JTextField creatusertext;
	private JPasswordField creatuserpwd1;
	private JPasswordField creatuserpwd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatUser frame = new CreatUser();
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
	public CreatUser() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("pic\\creatuser.jpg"));
		setTitle("\u6CE8\u518C\u7528\u6237");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 23));
		lblNewLabel_1.setBounds(61, 114, 99, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 21));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(64, 188, 75, 53);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("幼圆", Font.BOLD, 21));
		lblNewLabel_3.setBounds(60, 270, 135, 69);
		contentPane.add(lblNewLabel_3);
		
		creatusertext = new JTextField();
		creatusertext.setBounds(161, 118, 153, 31);
		contentPane.add(creatusertext);
		creatusertext.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u666E\u901A\u7528\u6237");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(67, 380, 88, 27);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("\u7BA1\u7406\u5458");
		checkBox.setEnabled(false);
		checkBox.setBounds(236, 381, 88, 27);
		contentPane.add(checkBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName(JDriver);
					} 		
    			catch (java.lang.ClassNotFoundException f) {
    			System.out.println("forname:"+f.getMessage());
    			}
				String UserInPutUserName=new String(creatusertext.getText());//暂存用户输入的用户名
    			String UserInputPWD1=  new String(creatuserpwd1.getPassword());//获取用户两次输入的密码
    			String UserInputPWD2=new  String(creatuserpwd2.getPassword());
    			if(creatusertext.getText().equals("")||UserInputPWD1.equals("")){JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");}
    			else if(UserInputPWD1.equals(UserInputPWD2)){
        			try {
            			Connection con =DriverManager.getConnection(conURL);			
            			Statement s=con.createStatement();
            			ResultSet rs=s.executeQuery("select *  from UserInf where id='"+creatusertext.getText()+"'");
            			if(rs.next()==true){JOptionPane.showMessageDialog(null, "当前用户已经存在，请直接登录！");
            			dispose();//关闭窗口
            			LogInUI Login=new  LogInUI();//返回到登陆页面
        				Login.setVisible(true);
        				Login.setVisible(true);
        				Login.text1.setText(UserInPutUserName);
            			}else{
            				String find = "INSERT INTO UserInf(id,pwd,type) VALUES('" + creatusertext.getText() + "','" + UserInputPWD1 + "','U')" ;	
            				PreparedStatement ps=con.prepareStatement(find);
            				ps.executeUpdate(); 
            				JOptionPane.showMessageDialog(null, "注册成功，请登录！");
            			    LogInUI Login=new  LogInUI();//返回到登陆页面
            				Login.setVisible(true);
            				Login.text1.setText(UserInPutUserName);
            				dispose();//关闭窗口
            			}
            			s.close(); 
            			con.close(); }
        		catch ( SQLException f)
    			{
    			System.out.println("SQLException:"+f.getMessage());
    			}
    			}else{
    			JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！");
    			creatusertext.setText("");
    			creatuserpwd1.setText("");
    			creatuserpwd2.setText("");//清空内容 	
		}}});
		btnNewButton.setIcon(new ImageIcon("pic\\loginnew.jpg"));
		btnNewButton.setBounds(145, 442, 125, 36);
		contentPane.add(btnNewButton);
		
		creatuserpwd1 = new JPasswordField();
		creatuserpwd1.setBounds(161, 204, 153, 31);
		contentPane.add(creatuserpwd1);
		
		creatuserpwd2 = new JPasswordField();
		creatuserpwd2.setBounds(161, 294, 153, 31);
		contentPane.add(creatuserpwd2);
		lblNewLabel.setIcon(new ImageIcon("pic\\creatuserdesktop111.jpg"));
		lblNewLabel.setBounds(0, 0, 432, 517);
		contentPane.add(lblNewLabel);
	}
}
