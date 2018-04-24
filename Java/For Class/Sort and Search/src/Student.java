
public class Student implements Comparable<Comparable>
{
	//Name of Student
	private String name;
	//GPA of student
	private double score;
	//Initializes Student object
	//@param name, score
	public Student(String aName, double aScore)
	{
		if (aName == null || aName.isEmpty())
		{
			throw new IllegalArgumentException("Blank name");
		}
		else if (aScore < 0 || aScore > 5)
		{
			throw new IllegalArgumentException("GPA is between 0 and 5");
		}
		name = aName;
		score = aScore;
	}
	//Compares this student to an item
	//@param an item
	//@return comparison of student's names, if widget, -1, if employee, 1
	//Order: Students, Employees, Widgets
	public int compareTo(Comparable x)
	{
		if (x instanceof Student)
		{
			return getName().compareTo(((Student)x).getName());
		}
		else if (x instanceof Widget)
		{
			//Students come before Widgets
			return -1;
		}
		else
		{
			//Students come after Employees
			return 1;
		}
	}
	//@return information of this student
	@Override
	public String toString()
	{
		return "Student\nName: " + name + "\nGPA: " + score + '\n';
	}
	//@return name of this student
	public String getName() {
		return name;
	}
}
