import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OutHosUI extends JFrame {
	public String JDriver ="com.mysql.jdbc.Driver";
	public String conURL ="jdbc:mysql://127.0.0.1:3306/hosmansys?user=root&password=admin&characterEncoding=GBK";
	private JPanel contentPane;
	private JTextField iNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutHosUI frame = new OutHosUI();
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
	public OutHosUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("pic\\\u51FA\u9662\u767B\u8BB0.png"));
		setResizable(false);
		setTitle("\u51FA\u9662\u767B\u8BB0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iNum = new JTextField();
		iNum.setBounds(246, 45, 230, 35);
		contentPane.add(iNum);
		iNum.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
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
					ResultSet rs1=s.executeQuery("select *  from IllInf where iNum='"+iNum.getText()+"'");
					if(rs1.next()==false){JOptionPane.showMessageDialog(null, "无此病历，请检查入院编号!");}else{
					ResultSet rs2=s.executeQuery("select *  from IllInf where iNum='"+iNum.getText()+"'");
					while(rs2.next()){
					String s1=new String(rs2.getString("RoomNum").trim());//记录房间号用于释放房间资源
					String s2=new String(rs2.getString("iSta").trim());//记录患者标志位用于判断患者是否已经出院
	    			if(s1.equals("")||s2.equals("0")){JOptionPane.showMessageDialog(null, "该病例已经出院!");}else{
					String find1 = "UPDATE IllInf Set iSta=0 where iNum='"+iNum.getText()+"'";;//标志置0
					String find2 = "UPDATE RoomInf Set RoomSpa=RoomSpa+1 where RoomNum='"+s1+"'";//释放病房资源
					PreparedStatement ps1=con.prepareStatement(find1);
					PreparedStatement ps2=con.prepareStatement(find2);
					JOptionPane.showMessageDialog(null, "出院成功！");
					//dispose();//关闭窗口
					ps1.executeUpdate(); 
					ps2.executeUpdate(); 
	    			}}
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
		btnNewButton.setBounds(205, 148, 113, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pic\\outhospital.jpg"));
		lblNewLabel.setBounds(0, 0, 527, 245);
		contentPane.add(lblNewLabel);
	}
}
