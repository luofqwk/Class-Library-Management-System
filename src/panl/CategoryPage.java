package panl;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import uitl.DBuitl;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.JButton;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.SwingUtilities;
public class CategoryPage{
       private JPanel panel_7;
       private JPanel panel_5;
       String account;
       private int page=1;//定义当前页数
       String searchbook;
    public CategoryPage(String account,JPanel panel_7,JPanel panel_5){
        this.panel_7=panel_7;
        this.account=account;
        this.panel_5=panel_5;
        this.page=1;
        this.searchbook=searchbook;
        init();
    }

    void init(){
           String sql="Select count(*) from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ";
           Connection conn=null;
           ResultSet rst=null;
           PreparedStatement pst=null;
           panel_7.removeAll();
           try{
            conn=DBuitl.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, account); 
			rst = pst.executeQuery(); 
            if(rst.next()){
                //表示里面有东西
                int count=rst.getInt(1)/5+1;//表示页数
                if(count<=2){
                    JButton btnNewButton_4 = new JButton("1");
                    panel_7.add(btnNewButton_4);
                    btnNewButton_4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                String sql2="Select BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ORDER BY RecordID OFFSET 0 ROWS  FETCH NEXT 5 ROWS ONLY";                      
                                ResultSet rst2=null;
                                PreparedStatement pst2=null;
                                try{
                                Connection conn1=null;
                                conn1=DBuitl.getConnection();
                                pst2=conn1.prepareStatement(sql2);  
                                pst2.setString(1, account);                         
                                rst2=pst2.executeQuery();
                                upstock(rst2);
                                SwingUtilities.updateComponentTreeUI(panel_5);
                                page=1;
                                rst2.close();
                                }
                                catch(Exception ex1){
                                    ex1.printStackTrace();
                                   }
                        }
                    });
                    JButton btnNewButton_41 = new JButton("2");
                    btnNewButton_41.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                String sql22="Select BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ORDER BY RecordID OFFSET 5 ROWS  FETCH NEXT 5 ROWS ONLY";                     
                                ResultSet rst22=null;
                                PreparedStatement pst22=null;
                                try{
                                Connection conn1=null;
                                conn1=DBuitl.getConnection();
                                pst22=conn1.prepareStatement(sql22);  
                                pst22.setString(1, account);                                                    
                                rst22=pst22.executeQuery();
                                upstock(rst22);
                                SwingUtilities.updateComponentTreeUI(panel_5);
                                page=2;
                                rst22.close();
                                }
                                catch(Exception ex1){
                                    ex1.printStackTrace();
                                   }
                        }
                    });
                    panel_7.add(btnNewButton_41);
                }
                else{
                    JButton btnNewButton_6 = new JButton("上一页");
                    btnNewButton_6.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(page==1){
                            //如果当前页数为1则不能点击上一页
                            JOptionPane.showMessageDialog(null, "当前已为第一页");  
                            }
                            else{
                                page--;
                                int realline=(page-1)*5;
                                System.out.println(page);
                                String strline = String.valueOf(realline);
                                String sql2="Select BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ORDER BY RecordID OFFSET "+strline+" ROWS  FETCH NEXT 5 ROWS ONLY";                      
                                ResultSet rst2=null;
                                PreparedStatement pst2=null;
                                try{
                                Connection conn1=null;
                                conn1=DBuitl.getConnection();
                                pst2=conn1.prepareStatement(sql2);
                                pst2.setString(1, account);                                                         
                                rst2=pst2.executeQuery();
                                upstock(rst2);
                                SwingUtilities.updateComponentTreeUI(panel_5);
                              
                                }
                                catch(Exception ex1){
                                    ex1.printStackTrace();
                                   }

                            }
                        }
                    });
                    panel_7.add(btnNewButton_6);
                    JButton btnNewButton_4 = new JButton("1");
                    panel_7.add(btnNewButton_4);
                    btnNewButton_4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                String sql2="Select BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ORDER BY RecordID OFFSET 0 ROWS  FETCH NEXT 5 ROWS ONLY";                      
                                ResultSet rst2=null;
                                PreparedStatement pst2=null;
                                try{
                                Connection conn1=null;
                                conn1=DBuitl.getConnection();
                                pst2=conn1.prepareStatement(sql2);
                                pst2.setString(1, account);                                                       
                                rst2=pst2.executeQuery();
                                upstock(rst2);
                                SwingUtilities.updateComponentTreeUI(panel_5);
                                page=1;
                                rst2.close();
                                }
                                catch(Exception ex1){
                                    ex1.printStackTrace();
                                   }
                        }
                    });
                    JButton btnNewButton_41 = new JButton("2");
                    btnNewButton_41.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                String sql22="Select BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ORDER BY RecordID OFFSET 5 ROWS  FETCH NEXT 5 ROWS ONLY";                    
                                ResultSet rst22=null;
                                PreparedStatement pst22=null;
                                try{
                                Connection conn1=null;
                                conn1=DBuitl.getConnection();
                                pst22=conn1.prepareStatement(sql22);     
                                pst22.setString(1, account);                                                
                                rst22=pst22.executeQuery();
                                upstock(rst22);
                                SwingUtilities.updateComponentTreeUI(panel_5);
                                page=2;
                                rst22.close();
                                }
                                catch(Exception ex1){
                                    ex1.printStackTrace();
                                   }
                        }
                    });
                    panel_7.add(btnNewButton_41);
                    JButton btnNewButton_5 = new JButton("……");
                    panel_7.add(btnNewButton_5);
                    String strrs = String.valueOf(count); 
                    JButton btnNewButton_10 = new JButton(strrs);
                    btnNewButton_10.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                int realline1=(count-1)*5;
                                String strline1 = String.valueOf(realline1);
                                String sql2="Select BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ORDER BY RecordID OFFSET "+strline1+" ROWS  FETCH NEXT 5 ROWS ONLY";                      
                                ResultSet rst2=null;
                                PreparedStatement pst2=null;
                                try{
                                Connection conn1=null;
                                conn1=DBuitl.getConnection();
                                pst2=conn1.prepareStatement(sql2);  
                                pst2.setString(1, account);                                                  
                                rst2=pst2.executeQuery();
                                upstock(rst2);
                                SwingUtilities.updateComponentTreeUI(panel_5);
                                page=count-1;
                                }
                                catch(Exception ex1){
                                    ex1.printStackTrace();
                                   }
                        }
                    });
                    panel_7.add(btnNewButton_10);
                    JButton btnNewButton_13 = new JButton("下一页");
                    btnNewButton_13.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(page==count){
                            //如果当前页数为1则不能点击上一页
                            JOptionPane.showMessageDialog(null, "当前已为最后一页");  
                            }
                            else{
                                page++;
                                int realline=(page-1)*5;
                                System.out.println(page);
                                String strline = String.valueOf(realline);
                                String sql2="Select BorrowRecord.RecordID,BookInfo.Title,BookInfo.Author,BorrowRecord.ChangeReason,BorrowRecord.Score from BorrowRecord inner join BookInfo on BookInfo.BookID=BorrowRecord.BrrowbookID inner join ClassMember on ClassMember.ClassMemberID=BorrowRecord.BrrownumberID where ClassMember.ClassMemberName=? ORDER BY RecordID OFFSET "+strline+" ROWS  FETCH NEXT 5 ROWS ONLY";                                                
                                ResultSet rst2=null;
                                PreparedStatement pst2=null;
                                try{
                                Connection conn1=null;
                                conn1=DBuitl.getConnection();
                                pst2=conn1.prepareStatement(sql2);
                                pst2.setString(1, account);                       
                                rst2=pst2.executeQuery();
                                upstock(rst2);
                                SwingUtilities.updateComponentTreeUI(panel_5);
                                
                                }
                                catch(Exception ex1){
                                    ex1.printStackTrace();
                                   }
                            }
                        }
                    });
                    panel_7.add(btnNewButton_13);
                }
            } 
            
           }
           catch(Exception ex){
            ex.printStackTrace();
           }
    
    }
    public void upstock(ResultSet rs1){

                try  {
                    panel_5.removeAll();
                    while (rs1.next() ) {  
                        String BookID=rs1.getString("RecordID");
                        String Bookname=rs1.getString("Title");
                        String author=rs1.getString("Author");
                        String category=rs1.getString("ChangeReason");
                        int stocknumber=rs1.getInt("Score");
                        CategoryStock text=new CategoryStock(BookID,Bookname,author,category,stocknumber,panel_5,account);
                        SwingUtilities.updateComponentTreeUI(panel_5);
                        }
                        rs1.close();
                        JOptionPane.showMessageDialog(null, "查询图书成功");  
                    }  
                
        
                catch(Exception exw){
                    exw.printStackTrace();
                    JOptionPane.showMessageDialog(null, "数据库查询图书错误");  
                }
            }
    
}
