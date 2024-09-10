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
public class StockPanl {
	   private JPanel panel_5;
	   private String account;
      public StockPanl(String BookID,String Bookname,String author,String category,int stocknumber,JPanel panel_5,String account){
        //初始化	

		this.account=account;
		this.panel_5=panel_5;	
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(22, 159, 469, 400);

		panel_5.add(panel_6);
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel lblNewLabel_20 = new JLabel(Bookname);
		lblNewLabel_20.setFont(new Font("Arial", Font.PLAIN, 16));  
  
		panel_6.add(lblNewLabel_20);
		JLabel lblNewLabel_28 = new JLabel(author);
		lblNewLabel_28.setFont(new Font("Arial", Font.PLAIN, 16));  
		panel_6.add(lblNewLabel_28);
		JLabel lblNewLabel_29 = new JLabel(category);
		lblNewLabel_29.setFont(new Font("Arial", Font.PLAIN, 16));  
		panel_6.add(lblNewLabel_29);
		String stock=String.valueOf(stocknumber);
		JLabel lblNewLabel_30 = new JLabel(stock);

		lblNewLabel_30.setFont(new Font("Arial", Font.PLAIN, 16));  
		panel_6.add(lblNewLabel_30);
		JButton chckbxNewCheckBox_2 = new JButton("借阅");
		panel_6.add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="SELECT StockCount from BookInfo inner join ClassMember on BookInfo.Bookclass = ClassMember.ClassMemberclass where ClassMember.ClassMemberName=? and BookInfo.BookID=?";
				String sql2="SELECT BorrowRecords from ClassMember where  ClassMember.ClassMemberName=?";
				String sql3="UPDATE BookInfo SET StockCount = ? Where Title=?";
				String sql4="SELECT count(*) as a from BorrowRecord";
				String sql5="UPDATE ClassMember SET BookID = ?, BorrowRecords = 1 WHERE ClassMemberName = ?";
				Connection conn=null;
				ResultSet rst=null;
				PreparedStatement pst=null;
				Connection conn1=null;
				ResultSet rst1=null;
				PreparedStatement pst1=null;
				Connection conn3=null;
				ResultSet rst3=null;
				PreparedStatement pst3=null;
				ResultSet rst4=null;
				PreparedStatement pst4=null;
				ResultSet rst5=null;
				PreparedStatement pst5=null;
				int totalStockCount=0;
				int totalbroowcount=0;
				String strborrow;
				int a;
				try{
					conn=DBuitl.getConnection();
					pst = conn.prepareStatement(sql);
					pst.setString(1, account);  
					pst.setString(2,BookID);
					rst = pst.executeQuery(); 
                    pst1=conn.prepareStatement(sql2);
					pst1.setString(1, account);
					rst1 = pst1.executeQuery();
					pst4=conn.prepareStatement(sql4);
					rst4=pst4.executeQuery();
					pst5=conn.prepareStatement(sql5);
					pst5.setString(1, BookID);
					pst5.setString(2, account);
					while(rst4.next()){
					totalbroowcount=rst4.getInt("a")+1;
					}
                    strborrow = String.valueOf(totalbroowcount); 
					strborrow="P"+totalbroowcount;
					if(rst.next()){
						totalStockCount=rst.getInt("StockCount");
						System.out.println(totalStockCount);
					}
					if(rst1.next()){
                        a=rst1.getInt("BorrowRecords");
						if(a==1){
						JOptionPane.showMessageDialog(null, "只能借阅一本书"); 
						return;
						}
					}
                    if(totalStockCount==0){
						  JOptionPane.showMessageDialog(null, "库存不足，不可借阅");
						  return; 
					}
			        else{
						pst3=conn.prepareStatement(sql3);
						pst3.setInt(1,totalStockCount-1 );
						System.out.println(totalStockCount);
						pst3.setString(2,Bookname);
						int result3 = pst3.executeUpdate();  
						if(result3>0){
							String stock2=String.valueOf(totalStockCount-1 );
							lblNewLabel_30.setText(stock2);
							JOptionPane.showMessageDialog(null, "成功更新库存"); 
							SwingUtilities.updateComponentTreeUI(panel_5);
						}
						Date now = new Date();  
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
						String formattedDate = sdf.format(now);  
						java.util.Date utilDate = sdf.parse(formattedDate); // 将字符串解析回 java.util.Date  
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // 转换为 java.sql.Date 
						String sqladd="INSERT INTO BorrowRecord (BrrownumberID,BrrowbookID,RecordID,BorrowDate) values((Select ClassMemberID from ClassMember where ClassMemberName=?),?,?,?)";
						ResultSet rst3_2=null;
						PreparedStatement pst3_2=null;
						pst3_2=conn.prepareStatement(sqladd);
                        pst3_2.setString(1, account);
						pst3_2.setString(2, BookID);
						pst3_2.setString(3, strborrow);
						pst3_2.setDate(4, sqlDate);
                        int result3_2=pst3_2.executeUpdate();
						if(result3_2>0){
						pst5.executeUpdate();
						JOptionPane.showMessageDialog(null, "借书成功"); 
						}
					}
			}
			catch(Exception ex3){
				ex3.printStackTrace();
				JOptionPane.showMessageDialog(null, "数据库借书失败"); 
			}
		}
	  });
	  }
}
