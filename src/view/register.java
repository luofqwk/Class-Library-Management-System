package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import base.base;
import uitl.DBuitl;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
public class register  {
	private JFrame frame;
	private JTextField textField1;
	private JPasswordField textField2;
    private JTextField textField3;
    private JPasswordField textField4;
    private JCheckBox isAdminCheckBox;
    Connection conn = null;  
    PreparedStatement pstmt = null;  
    ResultSet rs = null; 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBuitl a=new DBuitl("sa","2003qwk1128");//连接数据库
					register window = new register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public register() {
		initialize();
	}
    public void setVisible1(){
        frame.setVisible(true);
    }
	private void initialize() {
		Statement sql=null;
		frame = new JFrame();
		frame.setTitle("鲜花管理系统注册界面");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(base.rootpath+"\\img\\loginicon.png"));
		frame.setBounds(100, 100, 488, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 474, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("姓名：");
		lblNewLabel1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel1.setBounds(103, 54, 58, 15);
		panel.add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("班级：");
		lblNewLabel2.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel2.setBounds(103, 88, 58, 15);
		panel.add(lblNewLabel2);

        JLabel lblNewLabel3 = new JLabel("学号：");
		lblNewLabel3.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel3.setBounds(103, 122, 58, 15);
		panel.add(lblNewLabel3);


        JLabel lblNewLabel4 = new JLabel("密码：");
		lblNewLabel4.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel4.setBounds(103, 152, 58, 15);
		panel.add(lblNewLabel4);

        JLabel lblNewLabel5 = new JLabel("是否为管理员：");
		lblNewLabel5.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel5.setBounds(103, 182, 108, 15);
		panel.add(lblNewLabel5);



        isAdminCheckBox = new JCheckBox();  
        isAdminCheckBox.setBounds(220, 178, 100, 20); // 调整以适应复选框的大小和位置  
        panel.add(isAdminCheckBox);  
		
		textField1 = new JTextField();
		textField1.setBounds(184, 54, 132, 21);
		panel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JPasswordField();
		textField2.setBounds(184, 88, 132, 21);
		panel.add(textField2);
		textField2.setColumns(10);

        textField3 = new JPasswordField();
		textField3.setBounds(184, 122, 132, 21);
		panel.add(textField3);
		textField3.setColumns(10);


        textField4 = new JPasswordField();
		textField4.setBounds(184, 152, 132, 21);
		panel.add(textField4);
		textField4.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(103, 212, 213, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				String name = textField1.getText();  
				String className = new String(textField2.getPassword()); // 注意：这里密码字段以明文处理，实际应加密  
				String studentId = textField3.getText();  
				String password = new String(textField4.getPassword()); // 应加密存储  
				if (name.isEmpty() || className.isEmpty() || studentId.isEmpty() || password.isEmpty()) {  
					JOptionPane.showMessageDialog(frame, "所有字段都是必填的！");  
					return;  
				}  
		  
				boolean isAdmin = isAdminCheckBox.isSelected();  
		  
				try (Connection conn = DBuitl.getConnection()) { // 使用try-with-resources自动关闭连接  
					if (isAdmin) {  
						String sqlCheckAdmin = "SELECT ClassAdminID FROM Class WHERE ClassAdminClass = ? AND ClassAdminID IS NOT NULL";  
						try (PreparedStatement pstmtCheck = conn.prepareStatement(sqlCheckAdmin)) {  
							pstmtCheck.setString(1, className);  
							ResultSet rs = pstmtCheck.executeQuery();  
							if (rs.next()) {  
								JOptionPane.showMessageDialog(frame, "班级已经存在班级管理员！");
								JOptionPane.showMessageDialog(frame, "注册失败");
								return;
							} else {  
								String sqlInsertAdmin = "UPDATE Class SET ClassAdminID = ?, ClassAdminPassword = ? , ClassAdminUsername = ?WHERE ClassAdminclass = ?";  
								// 注意：这里应该检查ClassName列，而不是ClassAdminClass  
								try (PreparedStatement pstmtAdmin = conn.prepareStatement(sqlInsertAdmin)) {  
									pstmtAdmin.setString(1, studentId);    
									pstmtAdmin.setString(2, password);  
									pstmtAdmin.setString(3, name);  
									pstmtAdmin.setString(4, className);  
									pstmtAdmin.executeUpdate();  
									JOptionPane.showMessageDialog(frame, "注册成功，并且已设置为班级管理员！");  
								}  
							}  
						}  
					} else {  
						//检查学号是否已经存在
						String sqlCheckStudentId = "SELECT * FROM ClassMember WHERE ClassMemberID = ?";  
						try (PreparedStatement pstmtCheckStudentId = conn.prepareStatement(sqlCheckStudentId)) {  
							pstmtCheckStudentId.setString(1, studentId);  
							ResultSet rs = pstmtCheckStudentId.executeQuery();  
							if (rs.next() && rs.getInt(1) > 0) {  
								JOptionPane.showMessageDialog(frame, "学号输入错误");  
								return;  
							}  
						}
						//检查班级是否不存在
					   String sqlCheckClass = "SELECT * FROM Class WHERE ClassAdminClass = ?";  
                       try (PreparedStatement pstmtCheckClass = conn.prepareStatement(sqlCheckClass)) {  
                       pstmtCheckClass.setString(1, className);  
                       ResultSet rs = pstmtCheckClass.executeQuery();  
                       if (!rs.next()) {  
                       JOptionPane.showMessageDialog(frame, "班级不存在");  
                            return;  
                        }  
                        }    
						String sql = "INSERT INTO ClassMember (ClassMemberName, ClassMemberClass, ClassMemberID, ClassMemberPassword, CreditScore) VALUES (?, ?, ?, ?, 100)";  
						try (PreparedStatement pstmt = conn.prepareStatement(sql)) {  
							pstmt.setString(1, name);  
							pstmt.setString(2, className);  
							pstmt.setString(3, studentId);  
							pstmt.setString(4, password);  
							pstmt.executeUpdate();  
							JOptionPane.showMessageDialog(frame, "注册成功！");  	
							LoginView LoginViewWindow = new LoginView();  
							LoginViewWindow.setVisible1();  
							frame.setVisible(false);   
						}  
					}  
				} catch (SQLException ex) {  
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frame, "数据库错误：" + ex.getMessage());  
				}  
			}   
		});

		JLabel lblNewLabel_2 = new JLabel("鲜花管理系统");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 24));
		lblNewLabel_2.setBounds(98, 5, 228, 40);
		panel.add(lblNewLabel_2);
		
		JButton lblNewLabel_3 = new JButton("返回登录界面>");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_3.setBounds(346, 238, 120, 25);
		panel.add(lblNewLabel_3);

        lblNewLabel_3.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				// 创建并显示注册窗口  
				LoginView LoginViewWindow = new LoginView(); 
				LoginViewWindow.setVisible1();  
		        frame.setVisible(false);
			}  
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(base.rootpath+"\\img\\loginback.png"));
		lblNewLabel_4.setBounds(0, 0, 484, 253);
		panel.add(lblNewLabel_4);
		
		//System.out.println(BaseCode.rootpath+"\\img\\loginicon.png");
		//登录账号
	}
}