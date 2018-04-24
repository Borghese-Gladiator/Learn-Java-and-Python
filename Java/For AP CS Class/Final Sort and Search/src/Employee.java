
public class Employee implements Comparable<Employee>
{
	//Name of employee
	private String name;
	//Salary of employee
	private double salary;
	//Initializes Employee object
	//@param name, salary
	public Employee(String aName, double aSalary)
	{
		if (aName == null || aName.isEmpty())
		{
			throw new IllegalArgumentException("Blank name");
		}
		if (aSalary < 0)
		{
			throw new IllegalArgumentException("Salary must be positive");
		}
		name = aName;
		salary = aSalary;
	}
	//Compares this employee to another item
	//@param an item
	//@return comparison of employee's salary, else, -1
	//Order: Students, Employees, Widgets
	public int compareTo(Employee x)
	{
		return (int)(Math.round(getSalary() - ((Employee)x).getSalary()));
	}
	//@return information of this employee
	@Override
	public String toString()
	{
		return "Employee\nName: " + name + "\nSalary: " + salary + '\n';
	}
	//@return salary
	public double getSalary() {
		return salary;
	}
}