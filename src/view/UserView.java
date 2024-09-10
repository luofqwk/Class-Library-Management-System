package view;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import base.base;
import listen.PrePageListen;
import panl.BookcategoryPage;
import panl.BookcategoryStock;
import panl.CategoryPage;
import panl.CategoryStock;
import panl.PageBU;
import panl.PageBU1;
import panl.StockPanl;
import uitl.DBuitl;
import javax.swing.JOptionPane;
import javax.swing.JTextField;  
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;
import java.util.Date;  
import javax.swing.JCheckBox;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
public class UserView {
	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView window = new UserView("一三");
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
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public UserView(String account) {
		this.account="一三";
		initialize();

	}
	private void initialize() {
		
        frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 650, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 10, 655, 461);
		frame.getContentPane().add(tabbedPane);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		tabbedPane.addTab("借阅书籍", null, panel_1_1, null);
		panel_1_1.setLayout(null);

		JButton btnNewButton_10_1 = new JButton("查询");
		btnNewButton_10_1.setBounds(210, 26, 68, 23);
		panel_1_1.add(btnNewButton_10_1);

		JLabel lblNewLabel_21_1 = new JLabel("书名：");
		lblNewLabel_21_1.setBounds(53, 30, 58, 15);
		panel_1_1.add(lblNewLabel_21_1);

		JTextField textField_21_1 = new JTextField();
		textField_21_1.setBounds(102, 27, 98, 21);
		panel_1_1.add(textField_21_1);
		textField_21_1.setColumns(10);
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setForeground(new Color(0, 0, 0));
		panel_11_1.setBounds(24, 56, 467, 45);
		panel_1_1.add(panel_11_1);
		panel_11_1.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel lblNewLabel_23_1 = new JLabel("书名");
		lblNewLabel_23_1.setBackground(Color.BLACK);
		panel_11_1.add(lblNewLabel_23_1);
		JLabel lblNewLabel_25_1 = new JLabel("作者");
		panel_11_1.add(lblNewLabel_25_1);
		JLabel lblNewLabel_24_1 = new JLabel("类别");
		panel_11_1.add(lblNewLabel_24_1);
		JLabel lblNewLabel_22_1 = new JLabel("库存量");
		panel_11_1.add(lblNewLabel_22_1);
		JLabel lblNewLabel_6_1 = new JLabel("借阅");
		panel_11_1.add(lblNewLabel_6_1);
		//---------------------------------
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(22, 98, 469, 289);
		panel_1_1.add(panel_5_1);
		panel_5_1.setLayout(new GridLayout(0, 1, 0, 0));



		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBounds(24, 373, 467, 45);
		panel_1_1.add(panel_7_1);
		panel_7_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	
		

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("信用分记录", null, panel_2, null);
		panel_2.setLayout(null);
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(33, 27, 408, 392);
		panel_2.add(panel_12);
		panel_12.setLayout(new GridLayout(0,1, 0, 0));
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel lblNewLabel_18 = new JLabel("借阅编号");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_18);
		JLabel lblNewLabel_17 = new JLabel("书名");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_17);	
		JLabel lblNewLabel_19 = new JLabel("作者");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_19);
		JLabel lblNewLabel_16 = new JLabel("原因");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_16);
		JLabel lblNewLabel_7 = new JLabel("信用分");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_7);
        
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(22, 98, 469, 289);
		panel_12.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));

       
		JButton button2222 = new JButton("点击我");  
        JLabel label2222 = new JLabel("这是一个标签");  
  

		JPanel panel_19 = new JPanel();
		panel_12.add(panel_19);
		panel_19.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));



		ResultSet rs2=null;	
		panel_19.removeAll();			
		SwingUtilities.updateComponentTreeUI(panel_19);
	    try{
				Connection conn9=DBuitl.getConnection();
				String sqlCheckBookname = "Select  BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName='刘毅'";  
				try (PreparedStatement pstmtbookcheck = conn9.prepareStatement(sqlCheckBookname)) {  
				
					  rs2 = pstmtbookcheck.executeQuery();  
							panel_14.removeAll();
							CategoryPage pageBU1=new CategoryPage(account,panel_19,panel_14);
							SwingUtilities.updateComponentTreeUI(panel_19);
							SwingUtilities.updateComponentTreeUI(panel_14);
							while (rs2.next()) { 
							String BookID=rs2.getString("RecordID");
							String Bookname=rs2.getString("Title");
							String author=rs2.getString("Author");
							String category=rs2.getString("ChangeReason");
							int Brrownumber=rs2.getInt("Score");
							CategoryStock text=new CategoryStock(BookID,Bookname,author,category,Brrownumber,panel_14,account);
							SwingUtilities.updateComponentTreeUI(panel_14);								
							}						 
						 
						 }
					 }
					 catch(Exception exw){
						 exw.printStackTrace();
						 JOptionPane.showMessageDialog(frame, "数据库查询信誉分错误");  
					 }
		
				



		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("归还书籍", null, panel_4, null);
		panel_4.setLayout(null);	
        //图书编号
		JLabel lblNewLabel_5 = new JLabel("编号");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_5.setBounds(118, 156, 81, 51);
		panel_4.add(lblNewLabel_5);
		textField_1 = new JTextField();
		textField_1.setBounds(186, 156, 81, 48);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
        //书名
		JLabel lblNewLabel_20 = new JLabel("书名");
		lblNewLabel_20.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20.setBounds(118, 217, 81, 56);
		panel_4.add(lblNewLabel_20);
		textField_2 = new JTextField();
		textField_2.setBounds(186, 214, 81, 48);
		panel_4.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_2 = new JButton("确定");

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputbookid=textField_1.getText();
				String inputbookString=textField_2.getText();
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

		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_2.setBounds(137, 283, 88, 48);
		panel_4.add(btnNewButton_2);



		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("个人信息", null, panel_3, null);
		panel_3.setLayout(null);
		JLabel lblNewLabel_8 = new JLabel("学号");
		lblNewLabel_8.setBounds(93, 36, 58, 15);
		panel_3.add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("姓名");
		lblNewLabel_9.setBounds(93, 77, 58, 15);
		panel_3.add(lblNewLabel_9);
		JLabel lblNewLabel_10 = new JLabel("班级");
		lblNewLabel_10.setBounds(93, 122, 58, 15);
		panel_3.add(lblNewLabel_10);
		JLabel lblNewLabel_11 = new JLabel("密码");
		lblNewLabel_11.setBounds(93, 166, 58, 15);
		panel_3.add(lblNewLabel_11);
		JLabel lblNewLabel_12 = new JLabel("信用分");
		lblNewLabel_12.setBounds(93, 215, 58, 15);
		panel_3.add(lblNewLabel_12);

        //学号
		textField_8 = new JTextField();
		textField_8.setBounds(171, 33, 139, 21);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
        //姓名
		textField_9 = new JTextField();
		textField_9.setBounds(171, 74, 139, 21);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
        //班级
		textField_10 = new JTextField();
		textField_10.setBounds(171, 119, 139, 21);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
        //密码
		textField_11 = new JTextField();
		textField_11.setBounds(171, 163, 139, 21);
		panel_3.add(textField_11);
		textField_11.setColumns(10);
        //信用分
		textField_12 = new JTextField();
		textField_12.setBounds(171, 212, 139, 21);
		panel_3.add(textField_12);
		textField_12.setColumns(10);

		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		try{
			con = DBuitl.getConnection(); 
			String sql="Select * from ClassMember where ClassMemberName=? ";
			pst= con.prepareStatement(sql);  
			pst.setString(1, account);  
			rst = pst.executeQuery();  
			while(rst.next()){
				String ClassnumberID=rst.getString("ClassMemberID");
				String ClassMemberName=rst.getString("ClassMemberName");
				String ClassMemberPassword=rst.getString("ClassMemberPassword");
				String CreditScore=rst.getString("CreditScore");
				String ClassMemberclass=rst.getString("ClassMemberclass");

				System.out.println(ClassnumberID);
                textField_8.setText(ClassnumberID);
				textField_9.setText(ClassMemberName);
				textField_10.setText(ClassMemberclass);
				textField_11.setText(ClassMemberPassword);
				textField_12.setText(CreditScore);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(frame, "查询个人信息失败"); 
		}
		//设置菜单条
		base.setBar(frame, account,0);

  		//设置图书借阅监听器
		  btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
				String borrowbook=textField_21_1.getText();
	           if(borrowbook.equals("")){	
				//查找全部
			 
				panel_7_1.removeAll();
				
				SwingUtilities.updateComponentTreeUI(panel_7_1);
				PageBU pageBU=new PageBU(account,panel_7_1,panel_5_1);
				SwingUtilities.updateComponentTreeUI(panel_7_1);
	            try{
					Connection conn1=DBuitl.getConnection();
					String sqlsearchall="SELECT * from BookInfo ,ClassMember where ClassMember.ClassMemberName=? ORDER BY BookInfo.BookID OFFSET 0 ROWS  FETCH NEXT 5 ROWS ONLY";
						try (PreparedStatement pstmtCheckStudentId = conn1.prepareStatement(sqlsearchall)) {
							panel_5_1.removeAll();
							pstmtCheckStudentId.setString(1, account);  
							ResultSet rs1 = pstmtCheckStudentId.executeQuery();  
							while (rs1.next() ) {  
								String BookID=rs1.getString("BookID");
								String Bookname=rs1.getString("Title");
								String author=rs1.getString("Author");
								String category=rs1.getString("Category");
								int stocknumber=rs1.getInt("StockCount");
								System.out.println("qq");
                                StockPanl text=new StockPanl(BookID,Bookname,author,category,stocknumber,panel_5_1,account);
								SwingUtilities.updateComponentTreeUI(panel_5_1);
							    }
							}  
						}		
						catch(Exception exw){
							exw.printStackTrace();
							JOptionPane.showMessageDialog(frame, "数据库查询可借阅图书错误");  
						}
					}
			   else{
				    String searchbook=textField_21_1.getText();
					ResultSet rs2=null;	
					panel_7_1.removeAll();			
					SwingUtilities.updateComponentTreeUI(panel_7_1);
                    try{
						Connection conn9=DBuitl.getConnection();
						String sqlCheckBookname = "SELECT * from BookInfo inner join ClassMember on BookInfo.Bookclass = ClassMember.ClassMemberclass where ClassMember.ClassMemberName=? and Title =?";  
						try (PreparedStatement pstmtbookcheck = conn9.prepareStatement(sqlCheckBookname)) {  
							pstmtbookcheck.setString(1, account);  
							pstmtbookcheck.setString(2, searchbook);  
							rs2 = pstmtbookcheck.executeQuery();  
							if (!rs2.next()) {  
								JOptionPane.showMessageDialog(frame, "本班无此书籍");  
								return;  
							}  
							else{
								panel_5_1.removeAll();
								PageBU1 pageBU1=new PageBU1(account,panel_7_1,panel_5_1,searchbook);
				                SwingUtilities.updateComponentTreeUI(panel_7_1);
								SwingUtilities.updateComponentTreeUI(panel_1_1);
								while (rs2.next()) {  
								    String BookID=rs2.getString("BookID");
									String Bookname=rs2.getString("Title");
									String author=rs2.getString("Author");
									String category=rs2.getString("Category");
									int stocknumber=rs2.getInt("StockCount");
									StockPanl text=new StockPanl(BookID,Bookname,author,category,stocknumber,panel_5_1,account);
									SwingUtilities.updateComponentTreeUI(panel_5_1);								
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

	}

}
