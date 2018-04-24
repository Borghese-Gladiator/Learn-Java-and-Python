public class Student extends Person
{
	//Holds ID of this student
	private int ID;
	//Error check ID
	//@param name, id of student
	public static void errorCheckID(String aName, int aID)
	{
		Person.errorCheckName(aName);
		if (aID <= 0)
		{
			throw new IllegalArgumentException("ID cannot be less than or equal to 0");
		}
	}
	//Initialize Student object
	//@param name, and ID of student
	public Student(String aName, int aID)
	{
		super(aName);
		ID = aID;
	}
	//Assemble student information
	//@return student information
	public String print()
	{
		String result = super.print();
		result += "ID: " + ID + '\n';
		return result;
	}
}