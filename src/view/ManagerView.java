package view;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import panl.*;
import base.BookcategoryView;
import base.BookquantityView;
import base.ClassBorrowingView;
import base.ClassBorrowingWordsView;
import base.StudentBorrowingView;
import base.StudentBorrowingWordsView;
import base.base;
import uitl.DBuitl;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.Date;  
import javax.swing.JCheckBox;
import java.text.SimpleDateFormat;
public class ManagerView {
	private JFrame frame;
	String account;
	public ManagerView(String account) {
		this.account=account;
		initialize();

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    DBuitl a=new DBuitl("sa","2003qwk1128");//连接数据库
					ManagerView window = new ManagerView("刘毅");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_6;
    
	public void setVisible1(){
        frame.setVisible(true);
    }
	private void initialize() {
		frame = new JFrame();

		frame.getContentPane().setBackground(new Color(135, 206, 250));

		

		frame.setTitle("图书管理系统-管理员");

		frame.setBackground(new Color(135, 206, 235));

		frame.setBounds(100, 100, 688, 551);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		frame.getContentPane().setLayout(null);


		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

		tabbedPane.setFont(new Font("宋体", Font.PLAIN, 16));

		tabbedPane.setBounds(0, 38, 600, 433);

		frame.getContentPane().add(tabbedPane);

		

		JPanel panel = new JPanel();

		panel.setBackground(new Color(240, 240, 240));

		tabbedPane.addTab("图书添加", null, panel, null);

		panel.setLayout(null);

		

		JLabel lblNewLabel = new JLabel("图书编码");
		lblNewLabel.setBounds(88, 23, 73, 38);
		panel.add(lblNewLabel);

		

		textField = new JTextField();
		textField.setBounds(156, 20, 162, 38);
		panel.add(textField);
		textField.setColumns(10);

		
		JLabel lblNewLabel_1 = new JLabel("班级号");
		lblNewLabel_1.setBounds(88, 71, 73, 43);
		panel.add(lblNewLabel_1);

		

		JLabel lblNewLabel_2 = new JLabel("书名");
		lblNewLabel_2.setBounds(88, 121, 73, 38);
		panel.add(lblNewLabel_2);

		

		JLabel lblNewLabel_3 = new JLabel("作者");
		lblNewLabel_3.setBounds(88, 162, 73, 38);
		panel.add(lblNewLabel_3);

		

		JLabel lblNewLabel_4 = new JLabel("类别");
		lblNewLabel_4.setBounds(88, 208, 73, 43);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("字数");
		lblNewLabel_5.setBounds(88, 253, 73, 38);
		panel.add(lblNewLabel_5);

		

		textField_1 = new JTextField();
		textField_1.setBounds(156, 71, 162, 38);
		panel.add(textField_1);
		textField_1.setColumns(10);

		

		textField_2 = new JTextField();
		textField_2.setBounds(156, 118, 162, 38);
		panel.add(textField_2);
		textField_2.setColumns(10);

		

		textField_3 = new JTextField();
		textField_3.setBounds(156, 164, 169, 36);
		panel.add(textField_3);
		textField_3.setColumns(10);

		

		textField_4 = new JTextField();
		textField_4.setBounds(156, 210, 169, 38);
		panel.add(textField_4);
		textField_4.setColumns(10);


		textField_5 = new JTextField();
		textField_5.setBounds(156, 261, 169, 30);
		panel.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("添加");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BookID=textField.getText();//获取图书编码
				String ClassID=textField_1.getText();//获取班级编码
				String Bookname=textField_2.getText();//获取书名
				String author=textField_3.getText();//获取作者名字
				String catgory=textField_4.getText();//获取书的类别
				String bookword=textField_5.getText();//获取图书组数
				String addnumber1=textField_6.getText();//获取添加量
				int addnumber=Integer.parseInt(addnumber1);
				if (BookID.isEmpty() || ClassID.isEmpty() || Bookname.isEmpty() || author.isEmpty()||catgory.isEmpty()||addnumber1.isEmpty()) {  
					JOptionPane.showMessageDialog(frame, "所有字段都是必填的！");  
					return;  
				}  
				Connection conn=null;
				PreparedStatement  pst=null;
				ResultSet rs = null; 
				try{
					conn = DBuitl.getConnection(); 
							//检查班级是否不存在
							String sqlCheckClass = "SELECT * FROM Class WHERE ClassAdminClass = ?";  
							try (PreparedStatement pstmtCheckClass = conn.prepareStatement(sqlCheckClass)) {  
							pstmtCheckClass.setString(1, ClassID);  
							ResultSet rsbook = pstmtCheckClass.executeQuery();  
							if (!rsbook.next()) {  
							JOptionPane.showMessageDialog(frame, "班级不存在");  
								 return;  
							 }  
							 }    
					String bookcheck="Select Title from BookInfo where Title=?";
					PreparedStatement  pst2=conn.prepareStatement(bookcheck);
					pst2.setString(1, Bookname);
					ResultSet rs2 = pst2.executeQuery();
					if (rs2.next() ) {  
						try{
						String sql3 = "SELECT StockCount AS TotalStockCount FROM BookInfo WHERE Title = ? and Author=? and Category=? "; 
						PreparedStatement pst3 = conn.prepareStatement(sql3);  
						pst3.setString(1, Bookname);
						pst3.setString(2, author );
						pst3.setString(3, catgory);
						ResultSet rs3 = pst3.executeQuery();
						while(rs3.next()){ 
						int totalStockCount = rs3.getInt("TotalStockCount");  						
						addnumber=totalStockCount+addnumber;				
                        String sql4="Update BookInfo Set StockCount = ? where Title = ? and Author=? and Category=?";
						PreparedStatement pst4 = conn.prepareStatement(sql4); 
						pst4.setInt(1, addnumber); 
						pst4.setString(2, Bookname);
						pst4.setString(3, author );
						pst4.setString(4, catgory);
						pst4.executeUpdate();
						}
						}
						catch(Exception e4){
							e4.printStackTrace(); 							
					        JOptionPane.showMessageDialog(frame, "寻找相同书籍报错");  
						}
					}
					System.out.println(addnumber);
					String bookadd="INSERT INTO BookInfo values(?,?,?,?,?,0,?,?)";
					pst=conn.prepareStatement(bookadd);
					pst.setString(1, BookID);
					pst.setString(2, Bookname);
					pst.setString(3, author);
					pst.setString(4, catgory);
                    pst.setInt(5, addnumber);
					pst.setString(6, bookword);
					pst.setString(7, ClassID);
					pst.executeUpdate(); 
					JOptionPane.showMessageDialog(frame, "添加图书成功");  
				}
                catch(SQLException e22){
                    e22.printStackTrace();
					JOptionPane.showMessageDialog(frame, "数据库添加图书错误"+e22.getMessage());  
				}
			}

		});

		btnNewButton.setBounds(91, 363, 102, 38);
		panel.add(btnNewButton);
		//清空图书添加中文字功能
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(218, 363, 100, 38);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText("");  
			// 清空班级编码  
			textField_1.setText("");  
			// 清空书名  
			textField_2.setText("");  
			// 清空作者名字  
			textField_3.setText("");  
			// 清空书的类别  
			textField_4.setText("");  
			textField_5.setText("");  
			textField_6.setText("");  
			}
		});
		JLabel lblNewLabel_7 = new JLabel("添加量");
		lblNewLabel_7.setBounds(82, 301, 73, 38);
		panel.add(lblNewLabel_7);
		textField_6 = new JTextField();
		textField_6.setBounds(156, 310, 169, 30);
		panel.add(textField_6);
		textField_6.setColumns(10);

		//查询统计功能
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("查询统计", null, panel_2, null);
		panel_2.setLayout(null);

		

		JLabel lblNewLabel_15 = new JLabel("学生借阅查询：");
		lblNewLabel_15.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_15.setBounds(83, 10, 187, 73);
		panel_2.add(lblNewLabel_15);

		

		JLabel lblNewLabel_17 = new JLabel("每类图书借阅量：");
		lblNewLabel_17.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_17.setBounds(83, 137, 227, 73);
		panel_2.add(lblNewLabel_17);

		

		JLabel lblNewLabel_19 = new JLabel("每个同学借阅量（字数）：");
		lblNewLabel_19.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_19.setBounds(83, 261, 317, 73);
		panel_2.add(lblNewLabel_19);

		
        //学生借阅查询
		JButton btnNewButton_5 = new JButton("查询");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  StudentBorrowingView studentBorrowingView = new StudentBorrowingView(account);
				  frame.dispose();
				  studentBorrowingView.setVisible1();
			}
		});
		btnNewButton_5.setBounds(400, 27, 80, 46);
		panel_2.add(btnNewButton_5);

		
        //每本图书借阅量查询
		JButton btnNewButton_7 = new JButton("查询");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  BookquantityView bookquantityView=new BookquantityView(account);
				  frame.dispose();
				  bookquantityView.setVisible1();   
			}

		});
		btnNewButton_7.setBounds(400, 210, 80, 46);
		panel_2.add(btnNewButton_7);

		
        //每个同学借阅量查询
		JButton btnNewButton_8 = new JButton("查询");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  StudentBorrowingWordsView studentBorrowingWordsView=new StudentBorrowingWordsView(account);
				  frame.dispose();
				  studentBorrowingWordsView.setVisible1();   
			}

		});
		btnNewButton_8.setBounds(400, 265, 80, 50);
		panel_2.add(btnNewButton_8);

		

		JLabel lblNewLabel_17_1 = new JLabel("班级借阅查询：");
		lblNewLabel_17_1.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_17_1.setBounds(83, 72, 187, 73);
		panel_2.add(lblNewLabel_17_1);

		

		JLabel lblNewLabel_17_2 = new JLabel("每个班级借阅量（字数）：");
		lblNewLabel_17_2.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_17_2.setBounds(83, 331, 317, 73);
		panel_2.add(lblNewLabel_17_2);

		

		JLabel lblNewLabel_17_3 = new JLabel("每本图书借阅量：");
		lblNewLabel_17_3.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_17_3.setBounds(83, 193, 215, 73);
		panel_2.add(lblNewLabel_17_3);

		
        //班级借阅查询（图书）
		JButton btnNewButton_5_1 = new JButton("查询");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  ClassBorrowingView classBorrowingView=new ClassBorrowingView(account);
				  frame.dispose();
				  classBorrowingView.setVisible1();   
			}

		});
		btnNewButton_5_1.setBounds(400, 89, 80, 46);
		panel_2.add(btnNewButton_5_1);

		
        //每个班级借阅量（字数）查询
		JButton btnNewButton_5_2 = new JButton("查询");
		btnNewButton_5_2.setBounds(400, 348, 80, 46);
		panel_2.add(btnNewButton_5_2);
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 ClassBorrowingWordsView classBorrowingWordsView=new ClassBorrowingWordsView(account);
				 frame.dispose();
				 classBorrowingWordsView.setVisible1();
			}

		});

		
        //每类图书借阅量查询
		JButton btnNewButton_5_3 = new JButton("查询");
		btnNewButton_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 BookcategoryView bookcategoryView = new BookcategoryView(account);
				 frame.dispose();
				 bookcategoryView.setVisible1();
			}

		});
		btnNewButton_5_3.setBounds(400, 143, 80, 46);
		panel_2.add(btnNewButton_5_3);

		
        //增添成员功能
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("增减成员", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("学号");
		lblNewLabel_8.setBounds(93, 55, 58, 15);
		panel_3.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("姓名");
		lblNewLabel_9.setBounds(93, 105, 58, 15);
		panel_3.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("班级");
		lblNewLabel_10.setBounds(93, 155, 58, 15);
		panel_3.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("密码");
		lblNewLabel_11.setBounds(93, 200, 58, 15);
		panel_3.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("信用分");
		lblNewLabel_12.setBounds(93, 245, 58, 15);
		panel_3.add(lblNewLabel_12);	
        //学号
		textField_8 = new JTextField();
		textField_8.setBounds(171, 55, 139, 21);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
        //姓名
		textField_9 = new JTextField();
		textField_9.setBounds(171, 105, 139, 21);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
        //班级
		textField_10 = new JTextField();
		textField_10.setBounds(171, 155, 139, 21);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
        //密码
		textField_11 = new JTextField();
		textField_11.setBounds(171, 200, 139, 21);
		panel_3.add(textField_11);
		textField_11.setColumns(10);
        //信用分
		textField_12 = new JTextField();
		textField_12.setBounds(171, 245, 139, 21);
		panel_3.add(textField_12);
		textField_12.setColumns(10);
    
		JLabel lblNewLabel_16 = new JLabel("增加");
		lblNewLabel_16.setForeground(Color.RED);
		lblNewLabel_16.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_16.setBounds(93, 295, 58, 21);
		panel_3.add(lblNewLabel_16);
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(234, 295, 109, 23);
		panel_3.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_18 = new JLabel("删除");
		lblNewLabel_18.setForeground(Color.RED);
		lblNewLabel_18.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_18.setBounds(93, 346, 58, 24);
		panel_3.add(lblNewLabel_18);
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(234, 345, 109, 23);
		panel_3.add(chckbxNewCheckBox_1);
		JButton btnNewButton_2 = new JButton("确定");
        btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String StudentID=textField_8.getText();//获取学号
				String StudentName=textField_9.getText();//获取学生姓名
				String StudentClass=textField_10.getText();//获取班级
				String password5=textField_11.getText();//获取密码
				String credit=textField_12.getText();//获取信誉分
				boolean isadd = chckbxNewCheckBox.isSelected(); 
				boolean isdelete = chckbxNewCheckBox_1.isSelected(); 
				String sqlclass1=null;
				String sqlname=null;
				String sqlID=null;
				if (StudentID.isEmpty()) {  
					JOptionPane.showMessageDialog(frame, "学号是必填的！");  
					return;  
				}  
				if (StudentName.isEmpty()) {  
					JOptionPane.showMessageDialog(frame, "姓名是必填的！");  
					return;  
				} 
				if (StudentClass.isEmpty()) {  
					JOptionPane.showMessageDialog(frame, "班级是必填的！");  
					return;  
				} 
				if (password5.isEmpty()) {  
					JOptionPane.showMessageDialog(frame, "密码是必填的！");  
					return;  
				} 
				if (credit.isEmpty()) {  
					JOptionPane.showMessageDialog(frame, "信誉分是必填的！");  
					return;  
				} 
				if(isadd){
					try{
					Connection conn1=DBuitl.getConnection();
					//检验学号输入是否重复
					String sqlCheckStudentId = "SELECT * FROM ClassMember WHERE ClassMemberID = ?";  
						try (PreparedStatement pstmtCheckStudentId = conn1.prepareStatement(sqlCheckStudentId)) {  
							pstmtCheckStudentId.setString(1, StudentID);  
							ResultSet rs1 = pstmtCheckStudentId.executeQuery();  
							if (rs1.next() ) {  
								JOptionPane.showMessageDialog(frame, "学号输入错误");  
								return;  
							}  
						}
					//检验班级是否正确
					String sqlCheckClass = "SELECT ClassAdminclass FROM Class WHERE ClassAdminUsername = ?";  
					try (PreparedStatement pstmtCheckClass = conn1.prepareStatement(sqlCheckClass)) {  
					pstmtCheckClass.setString(1, account);  
					ResultSet rsclass = pstmtCheckClass.executeQuery();  
						while(rsclass.next()){ 
						 sqlclass1 = rsclass.getString("ClassAdminclass");  	
						}						
					if (!sqlclass1.equals(StudentClass)) {  
					JOptionPane.showMessageDialog(frame, "不可添加其他班级学生");  
						 return;  
					 }  
					 }  
					String sqladd="Insert INTO ClassMember values(?,?,?,?,?,null,0)";
					PreparedStatement pstadd=conn1.prepareStatement(sqladd);
					pstadd.setString(1, StudentID);
					pstadd.setString(2, StudentName);
					pstadd.setString(3, password5);
					pstadd.setString(4, credit);
					pstadd.setString(5, StudentClass);
					pstadd.executeUpdate(); 
					JOptionPane.showMessageDialog(frame, "添加成员成功");  
					}		
					catch(Exception eadd){
						eadd.printStackTrace();
						JOptionPane.showMessageDialog(frame, "数据库错误");  
					}	
				}
				else if(isdelete){
                    try{
						Connection conn2=DBuitl.getConnection();
						int flag=0;
						//检验班级是否正确
						String sqlCheckClass = "SELECT ClassAdminclass FROM Class WHERE ClassAdminUsername = ?";  
						try (PreparedStatement pstmtCheckClass2 = conn2.prepareStatement(sqlCheckClass)) {  
						pstmtCheckClass2.setString(1, account);  
						ResultSet rsclass2 = pstmtCheckClass2.executeQuery();  
							while(rsclass2.next()){ 
							 sqlclass1 = rsclass2.getString("ClassAdminclass");  	
							}						
						if (!sqlclass1.equals(StudentClass)) {  
						JOptionPane.showMessageDialog(frame, "不可删除其他班级学生");  
							 return;  
						 }  
						 } 
						 //检查姓名是否在此班级
						 String sqlCheckname = "SELECT ClassMemberName FROM ClassMember WHERE ClassMemberclass = ?";  
						 try (PreparedStatement pstmtCheckname = conn2.prepareStatement(sqlCheckname)) {  
						 pstmtCheckname.setString(1, StudentClass);  
						 ResultSet rsname2 = pstmtCheckname.executeQuery();  
							 while(rsname2.next()){ 
							  sqlname = rsname2.getString("ClassMemberName");  	
							  if (sqlname.equals(StudentName)) {  
								    flag=1;
									continue;  
								 }  
							 }												
							 if (flag==0) {  
								JOptionPane.showMessageDialog(frame, "此同学不在本班级");  
									return;
								 }
						  } 
						  //检查学号是否正确
						  String sqlCheckID = "SELECT ClassMemberID FROM ClassMember WHERE ClassMemberName = ?";  
						  try (PreparedStatement pstmtCheckID = conn2.prepareStatement(sqlCheckID)) {  
						  pstmtCheckID.setString(1, StudentName);  
						  ResultSet rsID2 = pstmtCheckID.executeQuery();  
							  while(rsID2.next()){ 
							   sqlID = rsID2.getString("ClassMemberID");  	
							  }						
						  if (!sqlID.equals(StudentID)) {  
						  JOptionPane.showMessageDialog(frame, "学号输入错误");  
							   return;  
						   }  
						   } 
						String sqldelete="DELETE FROM ClassMember where ClassMemberName=? and ClassMemberID=? and ClassMemberclass=?";
						PreparedStatement pstdelete=conn2.prepareStatement(sqldelete);
					    pstdelete.setString(1, StudentName);
						pstdelete.setString(2, StudentID);
						pstdelete.setString(3, StudentClass);
						pstdelete.executeUpdate(); 
						JOptionPane.showMessageDialog(frame, "删除成员成功");  
						}		
						catch(Exception eadd){
							eadd.printStackTrace();
							JOptionPane.showMessageDialog(frame, "数据库错误");  
						}	
				}
			    else{
					JOptionPane.showMessageDialog(frame, "选择添加或者删除成员时发生错误!");
				}
			}
		});
		btnNewButton_2.setBounds(103, 377, 97, 23);
		panel_3.add(btnNewButton_2);
		JButton btnNewButton_9 = new JButton("取消");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField_8.setText("");   
			textField_9.setText("");  
			textField_10.setText("");   
			textField_11.setText("");  
			textField_12.setText("");  
			textField_13.setText("");  
			textField_14.setText("");  
			chckbxNewCheckBox.setSelected(false);
			chckbxNewCheckBox_1.setSelected(false);
			}
		});
		btnNewButton_9.setBounds(234, 377, 97, 23);
		panel_3.add(btnNewButton_9);
			
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("借阅书籍", null, panel_1, null);
		panel_1.setLayout(null);

		JButton btnNewButton_10 = new JButton("查询");
		btnNewButton_10.setBounds(210, 26, 68, 23);
		panel_1.add(btnNewButton_10);

		JLabel lblNewLabel_21 = new JLabel("书名：");
		lblNewLabel_21.setBounds(53, 30, 58, 15);
		panel_1.add(lblNewLabel_21);

		textField_21 = new JTextField();
		textField_21.setBounds(102, 27, 98, 21);
		panel_1.add(textField_21);
		textField_21.setColumns(10);
		JPanel panel_11 = new JPanel();
		panel_11.setForeground(new Color(0, 0, 0));
		panel_11.setBounds(24, 56, 467, 45);
		panel_1.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel lblNewLabel_23 = new JLabel("书名");
		lblNewLabel_23.setBackground(Color.BLACK);
		panel_11.add(lblNewLabel_23);
		JLabel lblNewLabel_25 = new JLabel("作者");
		panel_11.add(lblNewLabel_25);
		JLabel lblNewLabel_24 = new JLabel("类别");
		panel_11.add(lblNewLabel_24);
		JLabel lblNewLabel_22 = new JLabel("库存量");
		panel_11.add(lblNewLabel_22);
		JLabel lblNewLabel_6 = new JLabel("借阅");
		panel_11.add(lblNewLabel_6);
		//---------------------------------
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(22, 98, 469, 289);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("归还书籍", null, panel_4, null);
		panel_4.setLayout(null);
		JLabel lblNewLabel_26 = new JLabel("编号：");
		lblNewLabel_26.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_26.setBounds(104, 80, 91, 35);
		panel_4.add(lblNewLabel_26);
		JLabel lblNewLabel_27 = new JLabel("书名：");
		lblNewLabel_27.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_27.setBounds(104, 152, 91, 35);
		panel_4.add(lblNewLabel_27);
		textField_22 = new JTextField();
		textField_22.setBounds(176, 78, 108, 42);
		panel_4.add(textField_22);
		textField_22.setColumns(10);
		textField_23 = new JTextField();
		textField_23.setBounds(176, 145, 108, 52);
		panel_4.add(textField_23);
		textField_23.setColumns(10);
		JButton btnNewButton_11 = new JButton("确定");//还书功能
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputbookid=textField_22.getText();
				String inputbookString=textField_23.getText();
				Connection conn = null;  
				PreparedStatement pst = null;  
				PreparedStatement pst1 = null;  
				PreparedStatement pst2 = null; // 新增的PreparedStatement  
				PreparedStatement pst3 = null; // 新增的PreparedStatement  
				PreparedStatement pst4 = null;
				PreparedStatement pst5=null;
				ResultSet rst = null;  
				ResultSet rst1 = null;  
				ResultSet rst2 = null; // 新增的ResultSet 
				ResultSet rst5 = null; 
				String bookname=null;
				String recordID=null;
				String brrownumberID=null;
				String reaason=null;
				int a;
				 String sql1="Select Title from BookInfo where BookID=?";
		
				 String sql5="SELECT BorrowRecords from ClassMember where  ClassMember.ClassMemberName=?";
				 String sql = "SELECT RecordID, BrrownumberID ,BrrowbookID FROM BorrowRecord INNER JOIN ClassMember ON BorrowRecord.BrrownumberID = ClassMember.ClassMemberID    WHERE ClassMember.ClassMemberName = ?;";  //获取 RecordID 
                 String sql2 = "UPDATE BorrowRecord  SET ReturnDate = ?,  ChangeReason = CASE  WHEN DATEDIFF(MONTH, BorrowDate, ReturnDate) > 1 THEN '还书超时'   ELSE '还书及时'  END,   Score = CASE    WHEN DATEDIFF(MONTH, BorrowDate, ReturnDate) > 1 THEN Score - 1  ELSE IIF(Score + 1 > 100, 100, Score + 1)   END  WHERE RecordID = ?;";  
                String sql3 = "UPDATE BookInfo SET StockCount = StockCount + 1, Borrowingvolume = Borrowingvolume - 1 WHERE BookID = ?";  
                String sql4 = "UPDATE ClassMember SET BookID = NULL, BorrowRecords = 0 WHERE ClassMemberName = ?";  
                 try{
					conn=DBuitl.getConnection();
					pst=conn.prepareStatement(sql);
					pst.setString(1, account);  
			        rst = pst.executeQuery(); 
					pst5=conn.prepareStatement(sql5);
					pst5.setString(1, account);
					rst5= pst5.executeQuery();
					if(rst5.next()){
                        a=rst5.getInt("BorrowRecords");
						if(a==0){
						JOptionPane.showMessageDialog(null, "学生没有借书"); 
						return;
						}
					}
					else{
						String bookID=rst.getString("BrrowbookID");
						
                        if(!inputbookid.equals(bookID)){
							JOptionPane.showMessageDialog(null, "书籍编号输入错误");
							return;
						}
						pst1=conn.prepareStatement(sql1);
						pst1.setString(1, inputbookid);
						rst1=pst1.executeQuery();
					     if(rst1.next()){
						     bookname=rst1.getString("Title");
						}
						if(!inputbookString.equals(bookname)){
						JOptionPane.showMessageDialog(null, "书籍书名输入错误");
						return;
						}
					}
					
					recordID = rst.getString("RecordID");  
					System.out.println(recordID);
                    brrownumberID = rst.getString("BrrownumberID");  
					Date now = new Date();  
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
					String formattedDate = sdf.format(now);  
					java.util.Date utilDate = sdf.parse(formattedDate); // 将字符串解析回 java.util.Date  
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
					pst2 = conn.prepareStatement(sql2);  
					pst2.setDate(1, sqlDate);  
					pst2.setString(2, recordID);  
					pst2.executeUpdate(); 
				 // Step 4: 更新BookInfo表  
				 pst3 = conn.prepareStatement(sql3);  
				 pst3.setString(1, inputbookid); // 假设bookID从前面的逻辑中已获取  
				 pst3.executeUpdate();  
		   
				 // Step 5: 更新ClassMember表  
				 pst4 = conn.prepareStatement(sql4);  
				 pst4.setString(1, account);  
				 pst4.executeUpdate();  
		   
				 JOptionPane.showMessageDialog(null, "还书成功！");  
		   
			 } catch (SQLException ex) {  
				 JOptionPane.showMessageDialog(null, "数据库操作失败：" + ex.getMessage());  
			 } catch (Exception ex) {  
				 JOptionPane.showMessageDialog(null, "发生错误：" + ex.getMessage());  
			 } finally {  
				 // 关闭资源（ResultSet, PreparedStatement, Connection）  
				 try {  
					 if (rst != null) rst.close();  
					 if (rst1 != null) rst1.close();  
					 if (rst2 != null) rst2.close(); // 如果有rst2，也需关闭  
					 if (pst != null) pst.close();  
					 if (pst1 != null) pst1.close();  
					 if (pst2 != null) pst2.close();  
					 if (pst3 != null) pst3.close();  
					 if (pst4 != null) pst4.close();  
					 if (conn != null) conn.close();  
				 } catch (SQLException ex) {  
					 JOptionPane.showMessageDialog(null, "关闭资源时发生错误：" + ex.getMessage());  
				 }  
			 }  
			}
		});
		btnNewButton_11.setBounds(135, 207, 97, 42);
		panel_4.add(btnNewButton_11);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(24, 373, 467, 45);
		panel_1.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		//设置菜单条

		base.setBar(frame, account,1);
        //设置借阅书籍查询监听器
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
				String borrowbook=textField_21.getText();
	           if(borrowbook.equals("")){	
				//查找全部
			 
				panel_7.removeAll();
				
				SwingUtilities.updateComponentTreeUI(panel_7);
				PageBU pageBU=new PageBU(account,panel_7,panel_5);
				SwingUtilities.updateComponentTreeUI(panel_7);
	            try{
					Connection conn1=DBuitl.getConnection();
					String sqlsearchall="SELECT * from BookInfo ,class where Class.ClassAdminUsername=? ORDER BY BookID OFFSET 0 ROWS  FETCH NEXT 5 ROWS ONLY";
						try (PreparedStatement pstmtCheckStudentId = conn1.prepareStatement(sqlsearchall)) {
							panel_5.removeAll();
							pstmtCheckStudentId.setString(1, account);  
							ResultSet rs1 = pstmtCheckStudentId.executeQuery();  
							while (rs1.next() ) {  
								String BookID=rs1.getString("BookID");
								String Bookname=rs1.getString("Title");
								String author=rs1.getString("Author");
								String category=rs1.getString("Category");
								int stocknumber=rs1.getInt("StockCount");
                                StockPanl text=new StockPanl(BookID,Bookname,author,category,stocknumber,panel_5,account);
								SwingUtilities.updateComponentTreeUI(panel_5);
							    }
							}  
						}		
						catch(Exception exw){
							exw.printStackTrace();
							JOptionPane.showMessageDialog(frame, "数据库查询可借阅图书错误");  
						}
					}
			   else{
				    String searchbook=textField_21.getText();
					ResultSet rs2=null;	
					panel_7.removeAll();			
					SwingUtilities.updateComponentTreeUI(panel_7);
                    try{
						Connection conn9=DBuitl.getConnection();
						String sqlCheckBookname = "SELECT * from BookInfo inner join Class on BookInfo.Bookclass = Class.ClassAdminclass where Class.ClassAdminUsername=? and Title =?";  
						try (PreparedStatement pstmtbookcheck = conn9.prepareStatement(sqlCheckBookname)) {  
							pstmtbookcheck.setString(1, account);  
							pstmtbookcheck.setString(2, searchbook);  
							rs2 = pstmtbookcheck.executeQuery();  
							if (!rs2.next()) {  
								JOptionPane.showMessageDialog(frame, "本班无此书籍");  
								return;  
							}  
							else{
								panel_5.removeAll();
								PageBU1 pageBU1=new PageBU1(account,panel_7,panel_5,searchbook);
				                SwingUtilities.updateComponentTreeUI(panel_7);
								SwingUtilities.updateComponentTreeUI(panel_1);
								while (rs2.next()) {  
								    String BookID=rs2.getString("BookID");
									String Bookname=rs2.getString("Title");
									String author=rs2.getString("Author");
									String category=rs2.getString("Category");
									int stocknumber=rs2.getInt("StockCount");
									StockPanl text=new StockPanl(BookID,Bookname,author,category,stocknumber,panel_5,account);
									SwingUtilities.updateComponentTreeUI(panel_5);								
									}
									JOptionPane.showMessageDialog(frame, "查询可借阅图书成功");
							
							}
						
						}
					}
					catch(Exception exw){
						exw.printStackTrace();
						JOptionPane.showMessageDialog(frame, "数据库查询可借阅图书错误");  
					}
			   }
			}
		});
           //btnNewButton_10.doClick();
}
}
