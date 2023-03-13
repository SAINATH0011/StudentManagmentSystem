package studentPackage;
import java.sql.*;
public class Database
{

	   static Connection con ;
	   
	   public static Connection createConnection() throws Exception
	   {
		   try
		   {
			   String driver ="oracle.jdbc.driver.OracleDriver";
				  String url ="jdbc:oracle:thin:localhost:1521:xe";
				  String username ="scott";
				  String password = "tiger";
			   Class.forName(driver);
			   con = DriverManager.getConnection(url,username,password);
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   
		   return con;
	   }
}
