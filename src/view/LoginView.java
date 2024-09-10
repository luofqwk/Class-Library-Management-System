package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import base.base;
import uitl.DBuitl;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
public class LoginView {
	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBuitl a=new DBuitl("sa","2003qwk1128");//连接数据库
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setVisible1(){
        frame.setVisible(true);
    }
	public LoginView() {
		initialize();
	}


	private void initialize() {
		Statement sql=null;
		frame = new JFrame();
		frame.setTitle("班级图书系统登录界面");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(base.rootpath+"\\img\\loginicon.png"));
		frame.setBounds(100, 100, 488, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 474, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel.setBounds(103, 108, 58, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_1.setBounds(103, 152, 58, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(184, 105, 132, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(184, 149, 132, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("安全登录");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Connection conn = null;  
            PreparedStatement pstmt = null;  
            ResultSet rs = null;  
			char[] password = textField_1.getPassword();
			String password1 = new String(password);  
            //获取账号，密码
			if(textField.getText().equals("")){//如果账号为空
				JOptionPane.showMessageDialog(null, "账号不能为空", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else if(password1.equals("")){//如果密码为空
				JOptionPane.showMessageDialog(null, "密码不能为空", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else{//账号和密码都不为空
				try { 
				conn = DBuitl.getConnection(); 
				String username=textField.getText();
				String sql="Select * from ClassMember where ClassMemberName=? and ClassMemberPassword=?";
				pstmt = conn.prepareStatement(sql);  
                pstmt.setString(1, username);  
                pstmt.setString(2, password1); 
				rs = pstmt.executeQuery();  
					if (rs.next()) {  
					String sql2 = "SELECT * FROM Class WHERE ClassAdminUsername = ?";  
                    PreparedStatement pstmt2 = conn.prepareStatement(sql2);  
                    pstmt2.setString(1, username);  
                    ResultSet rs2 = pstmt2.executeQuery(); 
					if (rs2.next()) {  
						JOptionPane.showMessageDialog(frame, "管理员登录成功"); 
						frame.dispose();
						ManagerView window=new ManagerView(username);
						window.setVisible1();
					} else{
						JOptionPane.showMessageDialog(frame, "学生登录成功");  
						frame.dispose();;
						UserView userView=new UserView(username);
						userView.setVisible1();
					}
				}
					else {  
						JOptionPane.showMessageDialog(frame, "登录失败");   
					}  
				} catch (SQLException e1) {  
					e1.printStackTrace();  
					JOptionPane.showMessageDialog(frame, "数据库错误");  
				}
			}
			}
		});
		btnNewButton.setBounds(103, 192, 213, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("班级图书管理系统");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 34));
		lblNewLabel_2.setBounds(98, 45, 328, 40);
		panel.add(lblNewLabel_2);
		
		JButton lblNewLabel_3 = new JButton("注册账号>");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_3.setBounds(266, 238, 100, 25);
		panel.add(lblNewLabel_3);

		lblNewLabel_3.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				// 创建并显示注册窗口  
				register registerWindow = new register(); 
				registerWindow.setVisible1();  
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