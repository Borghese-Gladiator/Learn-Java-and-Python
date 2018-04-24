import BreezySwing.Format;

public class Company 
{
	//Holds array of employees who each have name, Q1, Q2, Q3, Q4, and total sales
	public Employee[] company;
	//Holds number of employees and will create an error when more than 25 employees
	private int count;
	//Initializes company to array length of 25 and count to 0 current employees
	public Company()
	{
		company = new Employee[25];
		count = 0;
	}
	//@param full set of employee data with name, Q1, Q2, Q3, Q4, and total sales
	public void addEmployee(Employee employee)
	{
		company[count] = employee;
		count++;
	}
	//Checks if the name has been inputted earlier so searching for an employee
	//will not create an error due to duplicate names
	//@param name of inputted employee
	//@return valid or invalid
	public boolean checkDuplicateNames(String name)
	{
		for (int i = 0; i < count; i++)
		{
			if (name.equals(company[i].getName()))
			{
				return true;
			}
		}
		return false;
	}
	//outputs all employees without headers
	//@return table
	public String outputTable()
	{
		String result = "";
		for (int i = 0; i < count; i++)
		{
			result += (company[i].toString());
		}
		result += '\n';
		return result;
	}
	//Searches database for employee with given name and
	//returns error message if not found
	//@param name of employee to be searched for
	//@return name and total sales of employee if found
	public String searchEmployee(String name)
	{
		String result = "Error: There is no employee under this name, "
				+ name + "." + '\n';
		for (int i = 0; i < count; i++)
		{
			if (company[i].getName().equals(name))
			{
				result = Format.justify('l', "Name", 20)
						+ "|  Quarter 1|  Quarter 2|  Quarter 3|"
						+ "  Quarter 4|    Total Sales" + '\n';
				result += company[i].toString();
				break;
			}
		}
		return result;
	}
	//Deletes employee from database
	//@param
	//@return output to user if successfully deleted or not
	public String deleteEmployee(String name)
	{
		String result = "Error: There is no employee under this name, "
				+ name + "." + '\n';
		for (int i = 0; i < count; i++)
		{
			if (company[i].getName().equals(name))
			{
				result = name + " has been successfully deleted from the database." + '\n';
				count--;
				for (int j = 1; j < count; j++)
				{
					company[i] = null;
					company[i + j] = company [i + j - 1];
				}
				break;
			}
		}
		return result;
	}
	public String findEmployee(double value)
	{
		String result = "" ;
		for (int i = 0; i < count; i++)
		{
			if (company[i].getTotalSales() == value)
			{
				if (result == "")
				{
					result += company[i].getName();
				}
				else
				{
					result += " and " + company[i].getName();
				}
			}
		}
		return result;
	}
	public double findHighestSales()
	{
		double result = 0;
		for (int i = 0; i < count; i++)
		{
			if (company[i].getTotalSales() > result)
			{
				result = company[i].getTotalSales();
			}
		}
		return result;
	}
	public double findLowestSales()
	{
		double result = 100000;
		for (int i = 0; i < count; i++)
		{
			if (company[i].getTotalSales() < result)
			{
				result = company[i].getTotalSales();
			}
		}
		return result;
	}
	public int getCount() {
		return count;
	}
}
