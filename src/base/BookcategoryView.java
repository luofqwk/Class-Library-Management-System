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
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

public class BookcategoryView {

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
	public BookcategoryView(String accout) {
		this.account=accout;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("每类图书阅读量-管理员");
		frame.setBounds(100, 100, 612, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("类别：");
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
		
		JLabel lblNewLabel_2 = new JLabel("书名");
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("作者");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("类别");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("借阅量");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		panel.add(lblNewLabel_1);

		
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
				String borrowbook=textField.getText();
				if(borrowbook.equals("")){	
					JOptionPane.showMessageDialog(frame, "类别不能为空");  
                    return;
					 }
				else{
					 String searchbook=textField.getText();
					 ResultSet rs2=null;	
					 panel_2.removeAll();			
					 SwingUtilities.updateComponentTreeUI(panel_2);
					 try{
						 Connection conn9=DBuitl.getConnection();
						 String sqlCheckBookname = "SELECT * from BookInfo  WHERE Category = ?";  
						 try (PreparedStatement pstmtbookcheck = conn9.prepareStatement(sqlCheckBookname)) {  
							 pstmtbookcheck.setString(1, searchbook);  
							 rs2 = pstmtbookcheck.executeQuery();  
							 if (!rs2.next()) {  
								 JOptionPane.showMessageDialog(frame, "没有此类书籍");  
								 return;  
							 }  
							 else{
								 panel_1.removeAll();
								 BookcategoryPage pageBU1=new BookcategoryPage(account,panel_2,panel_1,searchbook);
								 SwingUtilities.updateComponentTreeUI(panel_2);
								 SwingUtilities.updateComponentTreeUI(panel_1);
								 while (rs2.next()) {  
									 String BookID=rs2.getString("BookID");
									 String Bookname=rs2.getString("Title");
									 String author=rs2.getString("Author");
									 String category=rs2.getString("Category");
									 int Brrownumber=rs2.getInt("Borrowingvolume");
									 BookcategoryStock text=new BookcategoryStock(BookID,Bookname,author,category,Brrownumber,panel_1,searchbook);
									 SwingUtilities.updateComponentTreeUI(panel_1);								
									 }
									 JOptionPane.showMessageDialog(frame, "查询图书成功");						 
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