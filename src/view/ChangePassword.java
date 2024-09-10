package view;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.EventQueue;
import javax.swing.JFrame;  
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import base.base;
import uitl.DBuitl;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword {
	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	int a;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword("root",1);
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
	String account;
	public ChangePassword(String account ,int a) {
		this.account=account;
		this.a=a; 
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("修改密码界面");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(base.rootpath+"\\img\\loginicon.png"));
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("旧密码：");
		lblNewLabel_1.setBounds(34, 40, 77, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(116, 41, 255, 32);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("新密码：");
		lblNewLabel_2.setBounds(34, 98, 77, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(116, 99, 255, 32);
		frame.getContentPane().add(passwordField_2);
		
		JLabel lblNewLabel = new JLabel("确认密码：");
		lblNewLabel.setBounds(34, 153, 77, 32);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 154, 255, 32);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("修改密码");
		btnNewButton.setBounds(136, 203, 195, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] password = passwordField_1.getPassword();
				String olps = new String(password); //获取旧密码
                char[] password1=passwordField_2.getPassword();
				String nlps = new String(password1); //获取新密码
                char[] password2 = passwordField.getPassword();
				String onlps = new String(password2); //获取确认密码
				if(olps.equals("")) {
                    JOptionPane.showMessageDialog(frame, "旧密码不能为空"); 
				}else if(nlps.equals("")) {
					JOptionPane.showMessageDialog(frame, "新密码不能为空");  
				}else if(onlps.equals("")) {
					JOptionPane.showMessageDialog(frame, "确认密码不能为空");  
				}else if(!nlps.equals(onlps)) {
					JOptionPane.showMessageDialog(frame, "确认密码与新密码不一致");
				}
				else {
					Connection conn = null;  
                    PreparedStatement pstmt = null;  
                    ResultSet rs = null;  
					try{
					conn = DBuitl.getConnection(); 
					String sqlcheck="Select ClassMemberPassword from ClassMember where ClassMemberName=?";
					pstmt = conn.prepareStatement(sqlcheck);
					pstmt.setString(1, account);  
					rs = pstmt.executeQuery();  
					if(!rs.next()){
						JOptionPane.showMessageDialog(frame, "旧密码输入错误");
						return;
					} 
					}
					catch(Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(frame, "判断旧密码是否正确时发生错误");
					}
					
					try{
					if(a==1){
					String sql="Update Class SET ClassAdminPassword = ? where ClassAdminUsername=?";
					PreparedStatement pstmtAdmin = conn.prepareStatement(sql);
					pstmtAdmin.setString(1, nlps);
					pstmtAdmin.setString(2, account);
					pstmtAdmin.executeUpdate();
					}
					String sql2="Update ClassMember SET ClassMemberPassword = ? where ClassMemberName=?";
					PreparedStatement pstmtAdmin2 = conn.prepareStatement(sql2);
					pstmtAdmin2.setString(1, nlps);
					pstmtAdmin2.setString(2, account);
					pstmtAdmin2.executeUpdate();
					JOptionPane.showMessageDialog(frame, "密码修改成功");  
					frame.dispose();
					ManagerView window=new ManagerView(account);
                    window.setVisible1();
					}
					catch(Exception ex){
						ex.printStackTrace();
						JOptionPane.showMessageDialog(frame, "数据库错误");
					}
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton);
	}

}