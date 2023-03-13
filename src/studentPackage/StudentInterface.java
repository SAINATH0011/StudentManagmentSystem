package studentPackage;

public interface StudentInterface {

	 public boolean insertStudent(Student s);
	 public boolean delete(int roll);
	 public boolean update(int roll,String name);
	 public void showAllStudent();
	 public boolean showStudentById(int roll);

}
