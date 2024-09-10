package uitl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
public class DBuitl {
    String password;//数据库密码
    String database;//数据库表名字
    public DBuitl(String database,String password){
       this.password=password;
       this.database=database;
       init(database,password);
    };
    void init(String user,String password){
      Connection conn1;
      //初始化数据库，加载驱动
      try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
        System.out.println("加载数据库成功");
      }
      catch(Exception e){
        System.out.println("加载数据库失败");
        e.printStackTrace();
      }
      //连接数据库
      String url = "jdbc:sqlserver://LUCKY;databaseName=schoolbook;integratedSecurity=false;encrypt=true;trustServerCertificate=true;";
      try{
        conn1 = DriverManager.getConnection(url,"sa","2003qwk1128");
        System.out.println("连接成功");
      }
      catch(Exception e){
        System.out.println("连接失败");
        e.printStackTrace();
      }

    }
    public static Connection getConnection() throws SQLException {  
      String url = "jdbc:sqlserver://LUCKY;databaseName=schoolbook;integratedSecurity=false;encrypt=true;trustServerCertificate=true;";
      return DriverManager.getConnection(url,"sa","2003qwk1128"); 
  } 
}
