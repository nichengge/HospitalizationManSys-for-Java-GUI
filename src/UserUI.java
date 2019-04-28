import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Toolkit;

//普通用户界面
class UserUI extends JFrame{
	JButton button1 =new JButton("退出登录");
	public UserUI(){ 
		super("用户操作窗口");
		setIconImage(Toolkit.getDefaultToolkit().getImage("pic\\creatuser.jpg"));
		setResizable(false);
		setTitle("\u533B\u62A4\u4EBA\u5458\u64CD\u4F5C\u7A97\u53E3");
		setSize(409,344);//窗体尺寸
		setLocation(400,300);//窗体绝对位置
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		button1.setSize(100,20);
		button1.setLocation(157,286);
		getContentPane().add(button1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//跳转到入院登记界面	
			    InHosUI inhosui=new InHosUI();
			    inhosui.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setIcon(new ImageIcon("pic\\\u5165\u9662\u767B\u8BB0.png"));
		btnNewButton.setBounds(0, 0, 120, 107);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//跳转到出院登记界面	
			    OutHosUI outhosui=new OutHosUI();
			    outhosui.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1.setIcon(new ImageIcon("pic\\\u51FA\u9662\u767B\u8BB0.png"));
		btnNewButton_1.setBounds(287, 0, 120, 107);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//跳转到信息维护界面	
			    InfUI infui=new InfUI();
			    infui.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_2.setIcon(new ImageIcon("pic\\\u7EFC\u5408\u67E5\u8BE2.png"));
		btnNewButton_2.setBounds(0, 199, 120, 107);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//跳转到空床查询界面	
			    NullSerUI nullserui=new NullSerUI();
			    nullserui.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("pic\\\u7A7A\u5E8A\u67E5\u8BE2.png"));
		btnNewButton_3.setForeground(SystemColor.inactiveCaptionBorder);
		btnNewButton_3.setBounds(287, 199, 120, 107);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pic\\gif.gif"));
		lblNewLabel.setBounds(0, 0, 407, 319);
		getContentPane().add(lblNewLabel);
		//以下为退出登录按钮添加侦听
			button1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e ){
		    	System.exit(0);
				}	
		    });
}
}
