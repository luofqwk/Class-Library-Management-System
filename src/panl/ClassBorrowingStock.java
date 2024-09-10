package panl;
import uitl.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingUtilities;
import java.util.Date;  
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
public class ClassBorrowingStock {
	   private JPanel panel_5;
	   private String account;
      public ClassBorrowingStock(String studentname,String Bookname,String author,int Bookwordcount,JPanel panel_5,String searchbook){
        //初始化	
        this.panel_5=panel_5;	
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(30, 135, 471, 231);
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
        JLabel lblNewLabel_29 = new JLabel(studentname);
        System.out.println(studentname);
        lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_29.setFont(new Font("微软雅黑", Font.PLAIN, 16));  
		panel_6.add(lblNewLabel_29);
		JLabel lblNewLabel_20 = new JLabel(Bookname);
		lblNewLabel_20.setFont(new Font("Arial", Font.PLAIN, 16));  
        lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_20);
		JLabel lblNewLabel_28 = new JLabel(author);
        lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setFont(new Font("Arial", Font.PLAIN, 16));  
		panel_6.add(lblNewLabel_28);
	
		String stock=String.valueOf(Bookwordcount);
		JLabel lblNewLabel_30 = new JLabel(stock);
        lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setFont(new Font("Arial", Font.PLAIN, 16));  
		panel_6.add(lblNewLabel_30);
		
	  }
}
