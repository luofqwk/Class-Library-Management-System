package base;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.Panel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;
import panl.PageBU;
import panl.PageBU1;
import panl.StockPanl;
import uitl.DBuitl;
import view.ManagerView;
import panl.BookcategoryPage;
import panl.BookcategoryStock;
import panl.ClassBorrowingPage;
import panl.ClassBorrowingStock;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ClassBorrowingView {

	JFrame frame;
	private JTextField textField;
   

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookcategoryView window = new BookcategoryView("刘毅");
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
	public ClassBorrowingView(String accout) {
		this.account=accout;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("每个班级阅读量-管理员");
		frame.setBounds(100, 100, 612, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("班级：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(35, 25, 108, 45);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(91, 25, 220, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");

		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(335, 25, 97, 45);
		frame.getContentPane().add(btnNewButton);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(32, 76, 469, 55);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("借阅人");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("书名");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 12));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("作者");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 12));
		panel.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_5 = new JLabel("字数");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 12));
		panel.add(lblNewLabel_5);

		
		JButton btnNewButton_1 = new JButton("返回应用界面>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  ManagerView ManagerView = new ManagerView(account);
				  frame.dispose();
				  ManagerView.setVisible1();
			}

		});
		btnNewButton_1.setBounds(473, 438, 122, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		panel_1.setBounds(30, 135, 471, 251);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_2.setBounds(30, 376, 471, 45);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		

	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs2=null;	
				panel_2.removeAll();			
				SwingUtilities.updateComponentTreeUI(panel_2);
				int clas=0;
		try{
			Connection conn9=DBuitl.getConnection();
			String sqlCheckBookname = "Select ClassAdminclass from Class where Class.ClassAdminUsername=?";  
						 try (PreparedStatement pstmtbookcheck = conn9.prepareStatement(sqlCheckBookname)) {  
							 pstmtbookcheck.setString(1, account);  
							 rs2 = pstmtbookcheck.executeQuery();  
							 if (rs2.next()) {  
					            clas=rs2.getInt("ClassAdminclass");
								String string = String.valueOf(clas);  
								textField.setText(string);
							 }  
							 panel_1.removeAll();
							 ClassBorrowingPage pageBU1=new ClassBorrowingPage(account,panel_2,panel_1);
							 SwingUtilities.updateComponentTreeUI(panel_2);
							 SwingUtilities.updateComponentTreeUI(panel_1);
							 String sql3="SELECT ClassMemberName,Title,Author,Bookwordcount from BorrowRecord inner join ClassMember on ClassMember.ClassMemberID=BrrownumberID inner join BookInfo on BookInfo.BookID=BrrowbookID where ClassMember.ClassMemberclass=(Select ClassAdminclass from Class where ClassAdminUsername=?) ORDER BY RecordID OFFSET 0 ROWS  FETCH NEXT 5 ROWS ONLY;";
							 ResultSet rst3=null;
							 PreparedStatement pst3=null;
							 Connection conn2=DBuitl.getConnection();
							 pst3=conn2.prepareStatement(sql3); 
							 System.out.println(account);
							 pst3.setString(1, account);
							 System.out.println(sql3);                           
							 rst3=pst3.executeQuery();
							 while(rst3.next()){
								 String BookID=rst3.getString("ClassMemberName");
								 String Bookname=rst3.getString("Title");
								 String author=rst3.getString("Author");
								 int Brrownumber=rst3.getInt("Bookwordcount");
								 
								 ClassBorrowingStock text=new ClassBorrowingStock(BookID,Bookname,author,Brrownumber,panel_1,account);
								 SwingUtilities.updateComponentTreeUI(panel_1);								
							 }
								 JOptionPane.showMessageDialog(frame, "查询图书成功");		
						 }
					 catch(Exception exw){
						 exw.printStackTrace();
						 JOptionPane.showMessageDialog(frame, "数据库查询可借阅图书错误");  
					 }
	}
	catch(Exception exw){
		exw.printStackTrace();
		JOptionPane.showMessageDialog(frame, "数据库查询可借阅图书错误");  
	}
}
});
}
}