public class People 
{
	//Holds all the Student objects
	private Student[] students;
	//Holds all the Employee objects
	private Employee[] employees;
	//Initialize each array with space for 1 person
	public People()
	{
		students = new Student[1];
		employees = new Employee[1];
	}
	//Adds a student to the array with given information
	//@param name(any order), age (lower than 21), and grade level (lower than 12)
	public void addStudent(String name, int age, int gradeLevel)
	{
		if (students.length == Student.getStudentCount())
		{
			increaseStudentsSize();
		}
		Student student = new Student(name, age, gradeLevel);
		students[Student.getStudentCount() - 1] = student;
	}
	//Adds an employee to the array with given information
	//@param name(any order), age (higher than 16)
	public void addEmployee(String name, int age)
	{
		if (employees.length == Employee.getEmployeeCount())
		{
			increaseEmployeesSize();
		}
		Employee employee = new Employee(name, age);
		employees[Employee.getEmployeeCount() - 1] = employee;
	}
	//Outputs information of all previously inputted students
	//@return information about all students inputted in the form of a table
	public String outputStudents()
	{
		String result = Student.printHeader();
		for (int i = 0; i < Student.getStudentCount(); i++)
		{
			result += students[i].toString();
		}
		return result;
	}
	//Outputs information of all previously inputted employees
	//@return information about all employees inputted in the form of a table
	public String outputEmployees()
	{
		String result = Employee.printHeader();
		for (int i = 0; i < Employee.getEmployeeCount(); i++)
		{
			result += employees[i].toString();
		}
		return result;
	}
	//Output the names of all people with inputted age
	//@param age (years old)
	//@return names of people with that age
	public String outputNames(int age)
	{
		String result = "People with the age of " + age + '\n';
		boolean found = false;
		for (int i = 0; i < Student.getStudentCount(); i++)
		{
			if (students[i].getAge() == age)
			{
				result += "Student " + students[i].getName() + '\n';
				found = true;
			}
		}
		for (int i = 0; i < Employee.getEmployeeCount(); i++)
		{
			if (employees[i].getAge() == age)
			{
				result += "Employee " + employees[i].toString() + '\n';
				found = true;
			}
		}
		//Not found error if nobody has the given age
		if (found == false)
		{
			throw new IllegalStateException("Nobody has an age of " + age);
		}
		return result;
	}
	//Outputs the number of students and number of employees in the database
	//@return number of students and employees
	public String outputCounts()
	{
		String result = "There are " + Student.getStudentCount()
		+ " students and " + Employee.getEmployeeCount()
		+ " employees.";
		return result;
	}
	//Removes all students and employees from the database
	public void reset()
	{
		for (int i = 0; i < Student.getStudentCount(); i++)
		{
			students[i].clear();
		}
		for (int i = 0; i < Employee.getEmployeeCount(); i++)
		{
			employees[i].clear();
		}
		Student.setStudentCount(0);
		Employee.setEmployeeCount(0);
	}
	//Increases the size of the array containing the students by 1
	private void increaseStudentsSize()
	{
		Student[] x = new Student[students.length + 1];
		for (int i = 0; i < students.length; i++)
		{
			x[i] = students[i];
		}
		students = x;
	}
	//Increases the size of the array containing the employees by 1
	private void increaseEmployeesSize()
	{
		Employee[] x = new Employee[employees.length + 1];
		for (int i = 0; i < employees.length; i++)
		{
			x[i] = employees[i];
		}
		employees = x;
	}
	//Delete all people with an inputted name
	//@param name of people to be deleted
	//@return message of who was deleted
	public String delete(String name)
	{
		String result = "";
		boolean found = false;
		for (int i = 0; i < Student.getStudentCount(); i++)
		{
			if (students[i].getName().equals(name))
			{
				result += "Student " + students[i].getName() + " has been deleted\n";
				deleteStudentAtIndex(i);
				found = true;
			}
		}
		for (int i = 0; i < Employee.getEmployeeCount(); i++)
		{
			if (employees[i].getName().equals(name))
			{
				result += "Employee " + employees[i].getName()+ " has been deleted\n";
				deleteEmployeeAtIndex(i);
				found = true;
			}
		}
		//Not found error if nobody has the given name
		if (found == false)
		{
			throw new IllegalStateException("Person not found. Nobody has the name " + name);
		}
		return result;
	}
	//Creates a new array without the student that is to be deleted
	//@param index of student to be deleted
	private void deleteStudentAtIndex(int index)
	{
		Student[] x = new Student[students.length - 1];
		for (int i = 0; i < index; i++)
		{
			x[i] = students[i];
		}
		if (index != students.length - 1)
		{
			for (int i = index + 1; i < students.length; i++)
			{
				x[i - 1] = students[i];
			}
		}
		students = x;
		Student.setStudentCount(students.length);
	}
	//Creates a new array without the employee that is to be deleted
	//@param index of employee to be deleted
	private void deleteEmployeeAtIndex(int index)
	{
		Employee[] x = new Employee[employees.length - 1];
		employees[index] = null;
		for (int i = 0; i < index; i++)
		{
			x[i] = employees[i];
		}
		if (index != employees.length - 1)
		{
			for (int i = index + 1; i < employees.length; i++)
			{
				x[i - 1] = employees[i];
			}
		}
		employees = x;
		Employee.setEmployeeCount(employees.length);
	}
}