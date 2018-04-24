import BreezySwing.Format;

public class Student 
{
	//Holds the name (can be any order)
	private String name;
	//@return name of employee
	public String getName() {
		return name;
	}
	//Holds age (years old)
	private int age;
	//@return age of employee
	public int getAge() {
		return age;
	}
	//Holds grade level (can be different from age since students
	// can skip grades or stay back grades)
	private int gradeLevel;
	//Holds the number of students in database
	private static int studentCount = 0;
	//Sets the student count to given value
	//@param number to set the student count to
	public static void setStudentCount(int studentCount) {
		Student.studentCount = studentCount;
	}
	//@return current number of students
	public static int getStudentCount() {
		return studentCount;
	}
	//Ensures the data is valid before being added to the database
	//@param name of student, age of student, grade level of student
	public static void errorCheck(String name, int age, int gradeLevel)
	{
		if (name == null && name.trim().isEmpty())
		{
			throw new IllegalArgumentException("Name cannot be blank");
		}
		else if (age <= 0)
		{
			throw new IllegalArgumentException("Age cannot be 0 or negative");
		}
		else if (age > 21)
		{
			throw new IllegalArgumentException("Students cannot be older than 21");
		}
		else if (gradeLevel > 12 || gradeLevel < 0)
		{
			throw new IllegalArgumentException("Grade levels must be between"
					+ " 0 (Kindergarten) and 12");
		}
	}
	//Creates a student with given name, age, and grade level
	//@param name, age, grade level
	Student(String name, int age, int gradeLevel)
	{
		studentCount++;
		this.name = name;
		this.age = age;
		this.gradeLevel = gradeLevel;
	}
	//Creates a header for a table of students for greater legibility
	//@return header for table of students
	public static String printHeader()
	{
		String result = "Students\n";
		result += Format.justify('l',"Name", 20);
		result += Format.justify('l', "Age", 5);
		result += Format.justify('l', "Grade Level", 11) + '\n';
		return result;
	}
	//Condenses all information about a student into one line
	//@return String containing name, age, and grade level of student
	public String toString()
	{
		String result = "";
		result += Format.justify('l', name, 20);
		result += Format.justify('l', age, 5);
		result += Format.justify('l', gradeLevel, 11) + '\n';
		return result;
	}
	//Sets the name, age, and grade level of the student to null values
	public void clear()
	{
		name = "";
		age = 0;
		gradeLevel = 0;
	}
}