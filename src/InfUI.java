import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class InfUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfUI frame = new InfUI();
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
	public InfUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("pic\\\u7EFC\u5408\u67E5\u8BE2.png"));
		setTitle("\u7EFC\u5408\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u4E13\u5C5E\u75C5\u623F", "\u666E\u901A\u75C5\u623F", "ICU\u75C5\u623F"}));
		comboBox.setBounds(14, 29, 89, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"201", "202", "203", "204"}));
		comboBox_1.setBounds(117, 29, 52, 24);
		contentPane.add(comboBox_1);
		
		table = new JTable();
		table.setBounds(51, 413, 529, -311);
		contentPane.add(table);
	}
}
