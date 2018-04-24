import BreezySwing.Format;
public class Employee 
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
	//Holds the number of employees in database
	public static int employeeCount = 0;
	//Sets the employee count to given value
	//@param number to set the employee count to
	public static void setEmployeeCount(int employeeCount) {
		Employee.employeeCount = employeeCount;
	}
	//@return current number of employees
	public static int getEmployeeCount() {
		return employeeCount;
	}
	//Ensures the data is valid before being added to the database
	//@param name of employee, age of employee
	//@return true if data is valid and exception if data is invalid
	public static void errorCheck(String name, int age)
	{
		if (name.isEmpty())
		{
			throw new IllegalArgumentException("Name cannot be blank");
		}
		else if (age < 16)
		{
			throw new IllegalArgumentException("Law requires employees to be 16 or older");
		}
	}
	//Creates an employee with given name and age
	//@param name, age
	Employee(String name, int age)
	{
		employeeCount++;
		this.name = name;
		this.age = age;
	}
	//Creates a header for a table of employees for greater legibility
	//@return header for table of employees
	public static String printHeader()
	{
		String result = "Employees\n";
		result += Format.justify('l',"Name", 20);
		result += Format.justify('l', "Age", 5) + '\n';
		return result;
	}
	//Condenses all information about an employee into one line
	//@return String containing name and age of employee
	public String toString()
	{
		String result = "";
		result += Format.justify('l', name, 20);
		result += Format.justify('l', age, 5)+ '\n';
		return result;
	}
	//Sets the name and age of the employee to null values
	public void clear()
	{
		name = "";
		age = 0;
	}
}