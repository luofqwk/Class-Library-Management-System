package base;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import view.ManagerView;
import uitl.DBuitl;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class StudentBorrowingWordsView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentBorrowingWordsView window = new StudentBorrowingWordsView("刘毅");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    String account;
	public void setVisible1(){
        frame.setVisible(true);
    }
	public StudentBorrowingWordsView(String account) {
		this.account=account;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("每个学生借阅统计-管理员");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				PreparedStatement  pst=null;
				ResultSet rs = null; 
				String studentID=textField_1.getText();
				try{
				   conn=DBuitl.getConnection();
				   String sql="SELECT SUM(BookInfo.BookWordCount) AS TotalWordCount FROM BookInfo  INNER JOIN BorrowRecord ON BorrowRecord.BrrowbookID = BookInfo.BookID  Where BrrownumberID=?";
				   pst=conn.prepareStatement(sql);  
				   pst.setString(1, studentID);
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
		btnNewButton.setBounds(134, 167, 158, 48);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(203, 102, 158, 48);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("学生借阅量（字数）：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel.setBounds(26, 91, 187, 66);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1.setBounds(122, 26, 158, 59);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 33, 158, 48);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("返回应用界面>");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  ManagerView ManagerView = new ManagerView(account);
				  frame.dispose();
				  ManagerView.setVisible1();
			}

		});
		btnNewButton_1.setBounds(305, 220, 121, 33);
		frame.getContentPane().add(btnNewButton_1);
	}
}