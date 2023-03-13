package studentPackage;
import java.util.*;
public class StudentMain {

	   public static void main(String[] args) {
		
		   StudentInterface obj = new StudentImplement();
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("*********Welcome to Student Managment System*********");
		   
		   while(true)
		   {
			   System.out.println("\n 1. Add Student"
					             +"\n 2. Show All Students"
					             +"\n 3. Get The Stduent based on id"
					             +"\n 4. Delete the Student"
					             +"\n 5. Update Student"
					             +"\n 6 Exit");
			   System.out.println("Enter the Choice ");
			   int choice = sc.nextInt();
			   
			   switch(choice)
			   {
			   case 1 :System.out.println("Add Student");
			   System.out.println("Enter the Roll Number");
			   int rollNumber =sc.nextInt();
               System.out.println("Enter student name");
               String name=sc.next();
               System.out.println("Enter student clg name");
               String clgName=sc.next();
               System.out.println("Enter city");
               String city=sc.next();
               System.out.println("Enter Percentage");
               double percentage=sc.nextDouble();
                  Student st = new Student(rollNumber,name,clgName,city,percentage);
                  boolean ans =obj.insertStudent(st);
                  if(ans)
                  {
                	  System.out.println("Record inserted Succesfully");
                  }
                  else
                  {
                	  System.out.println("Something went Wrong....Please Try again");
                  }
				   break;
				   
				   
			   case 2 : System.out.println("Show All Student Details");
			           obj.showAllStudent();
				   break;
			   case 3 : System.out.println("Get Student Based On Roll Number");
			          System.out.println("Enter the Roll Number");
			          int roll = sc.nextInt();
			          boolean f =obj.showStudentById(roll);
			          if(!f)
			          {
			        	  System.out.println("Student Not Present with this roll number");
			          }
				   break;
			   case 4 : System.out.println("Delete an Element");
			          System.out.println("Enter the Roll number");
			           int rollNum =sc.nextInt();
			           boolean ff =obj.delete(rollNum);
			           if(!ff)
			           {
			        	   System.out.println("Entered roll number not present in database");
			           }
				   break;
			   case 5 : System.out.println("Update the Student Details");
			            System.out.println("Enter the Roll Number");
			            int number = sc.nextInt();
			            System.out.println("enter the name");
			            String newName =sc.next();
			             boolean b=obj.update(number, newName);
			             if(!b)
			             {
			            	 System.out.println("Something went wrong");
			             }
			             break;
			   case 6 :
				   System.out.println("Thank you for Using Student Managment Application");
				   System.exit(0);
				   
				   default :
					   System.out.println("Please enter valid Choice");
			   }
		   }
	}
}
