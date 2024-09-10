package base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import uitl.DBuitl;
import view.ManagerView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ClassBorrowingWordsView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBuitl a=new DBuitl("sa","2003qwk1128");//连接数据库
					ClassBorrowingWordsView window = new ClassBorrowingWordsView("刘毅");
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
	public ClassBorrowingWordsView(String account) {
		this.account=account;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("每个班级借阅统计-管理员");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 Connection conn=null;
				 PreparedStatement  pst=null;
				 ResultSet rs = null; 
				 try{
					conn=DBuitl.getConnection();
					String sql="SELECT SUM(BookInfo.BookWordCount) AS TotalWordCount FROM BookInfo  INNER JOIN BorrowRecord ON BorrowRecord.BrrowbookID = BookInfo.BookID  INNER JOIN ClassMember ON BorrowRecord.BrrownumberID = ClassMember.ClassMemberID INNER JOIN Class ON ClassMember.ClassMemberClass = Class.ClassAdminClass WHERE Class.ClassAdminUsername = ?";
					pst=conn.prepareStatement(sql);
					pst.setString(1, account);
                    rs = pst.executeQuery();
					while(rs.next()){
						int total=rs.getInt("TotalWordCount");
						String totalString=String.valueOf(total);
						textField.setText(totalString);
					}
				 }
				 catch(Exception ep){
					ep.printStackTrace();
					 JOptionPane.showMessageDialog(frame, "数据库错误");  
				 }
			}

		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(91, 138, 216, 66);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(202, 70, 167, 58);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("班级借阅量（字数）：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel.setBounds(23, 62, 187, 66);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("返回应用界面>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  ManagerView ManagerView = new ManagerView(account);
				  frame.dispose();
				  ManagerView.setVisible1();
			}

		});
		btnNewButton_1.setBounds(307, 230, 119, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}