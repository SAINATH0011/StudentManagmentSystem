package studentPackage;
import java.util.*;
import java.sql.*;

public class StudentImplement implements StudentInterface
{
     Scanner sc = new Scanner(System.in);
	@Override   //INSERT STUDENT
	public boolean insertStudent(Student s) {
		boolean flag = false;
		
		try
		{
			Connection con = Database.createConnection();
			String query ="insert into student_details(rollnum,sname,clgname,city,percentage)values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,s.getRollNum());
			pst.setString(2,s.getName());
			pst.setString(3,s.getClgName());
			pst.setString(4,s.getCity());
			pst.setDouble(5,s.getPercentage());
			pst.executeUpdate();
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	
	
	@Override   //DELETE STUDENT
	public boolean delete(int roll) {
		
		boolean flag = false;
		  try
		  {
			  Connection con = Database.createConnection();
			  String query = "delete from student_details where rollnum="+roll;
			  PreparedStatement pst =con.prepareStatement(query);
			  pst.executeUpdate();
			  System.out.println("Student detail deleted Succesfully");
			  flag = true;
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		return flag;
	}

	@Override  // UPDATE STUDENT
	public boolean update(int roll,String newName) {
		boolean flag = false;
	
		 try {
		Connection con =Database.createConnection();
		String query ="update student_details set sname=?  where rollnum=?";
		 PreparedStatement ps =con.prepareStatement(query);
		  ps.setString(1, newName);
		  ps.setInt(2, roll);
		 
		  ps.executeUpdate();
		  flag =true;
		  System.out.println("Updated Succesfully");

		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		 
		 String query ="";
		 
	  System.out.println("Updated Succesfully___________________________________________");
		     
		return flag;
	}

	@Override  //ALL STUDENTS DETAILS  
	public void showAllStudent() {
		try
		{
		Connection con = Database.createConnection();
		String query = "SELECT * FROM STUDENT_DETAILS";
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		 while(rs.next())
		 {
			 System.out.println("RollNum :"+rs.getInt(1)+"\n"+
					            "name :"+rs.getString(2)+"\n"+
					            "Clg name"+rs.getString(3)+"\n"+
		                         "City :"+rs.getString(4)+"\n"+
					             "Percentage "+rs.getDouble(5));
			 System.out.println("-----------------------------------------------");
		 }
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		}
	}

	@Override
	public boolean showStudentById(int roll) {
		boolean flag = false;
		try
		{
			Connection con = Database.createConnection();
			String query = "select * from student_details where rollnum= "+roll;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			 while(rs.next())
			 {
				 System.out.println("RollNumber :"+rs.getInt(1)+"\n"+
			                        "Name :"+rs.getString(2)+"\n"+
			                        "Clg Name :"+rs.getString(3)+"\n"+
			                         "City   :"+rs.getString(4)+"\n"+
			                         "Percentage :"+rs.getDouble(5));
				 flag = true;
				 System.out.println("Executed..........................");
			 }
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return flag;
	}
	

}
