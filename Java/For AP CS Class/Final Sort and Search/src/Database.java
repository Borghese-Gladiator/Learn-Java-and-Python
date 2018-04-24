
public class Database 
{
	//array of items
	private Comparable[] employees;
	private int ecounter;
	private Comparable[] students;
	private int scounter;
	private Comparable[] widgets;
	private int wcounter;
	public Database()
	{
		employees = new Employee[25];
		ecounter = 0;
		students = new Student[25];
		scounter = 0;
		widgets = new Widget[25];
		wcounter = 0;
	}
	public void addE(Employee e)
	{
		employees[ecounter] = e;
		ecounter++;
	}
	public void addS(Student s)
	{
		students[scounter] = s;
		scounter++;
	}
	public void addW(Widget w)
	{
		widgets[wcounter] = w;
		wcounter++;
	}
	//Outputs sorted database information
	//@param if insertion or selection sort is to used
	//@return sorted database information
	public String outputE(boolean isInsertion)
	{
		if (isInsertion)
			employees = SortSearch.inSort(employees, ecounter);
		else
			employees = SortSearch.seSort(employees, ecounter);
		String result = "";
		for (int i = 0; i < ecounter; i++)
		{
			result += employees[i].toString() + '\n';
		}
		return result;
	}
	public String outputS(boolean isInsertion)
	{
		if (isInsertion)
			students = SortSearch.inSort(students, scounter);
		else
			students = SortSearch.seSort(students, scounter);
		String result = "";
		for (int i = 0; i < scounter; i++)
		{
			result += students[i].toString() + '\n';
		}
		return result;
	}
	public String outputW(boolean isInsertion)
	{
		if (isInsertion)
			widgets = SortSearch.inSort(widgets, wcounter);
		else
			widgets = SortSearch.seSort(widgets, wcounter);
		String result = "";
		for (int i = 0; i < wcounter; i++)
		{
			result += widgets[i].toString() + '\n';
		}
		return result;
	}
	public String searchE(boolean isBinary, Employee target)
	{
		String result = "Search Employees\n";
		int beginIndex = 0;
		if (isBinary)
		{
			employees = SortSearch.inSort(employees, ecounter);
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.binarySearch(employees, ecounter, target, beginIndex);
				if (beginIndex != -1)
				{
					result += employees[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}
		}
		else
		{
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.sequentialSearch(employees, ecounter, target, beginIndex);
				if (beginIndex != -1)
				{
					result += employees[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}	
		}
		if (result.equals(""))
		{
			throw new IllegalArgumentException("404 Error: Not Found");
		}
		return result;
	}
	public String searchS(boolean isBinary, Student target)
	{
		String result = "Search Students\n";
		int beginIndex = 0;
		if (isBinary)
		{
			students = SortSearch.inSort(students, scounter);
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.binarySearch(students, scounter, target, beginIndex);
				if (beginIndex != -1)
				{
					result += students[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}
		}
		else
		{
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.sequentialSearch(students, scounter, target, beginIndex);
				if (beginIndex != -1)
				{
					result += students[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}	
		}
		if (result.equals(""))
		{
			throw new IllegalArgumentException("404 Error: Not Found");
		}
		return result;
	}
	public String searchW(boolean isBinary, Widget target)
	{
		String result = "Search Widgets\n";
		int beginIndex = 0;
		if (isBinary)
		{
			widgets = SortSearch.inSort(widgets, wcounter);
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.binarySearch(widgets, wcounter, target, beginIndex);
				if (beginIndex != -1)
				{
					result += widgets[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}
		}
		else
		{
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.sequentialSearch(widgets, wcounter, target, beginIndex);
				if (beginIndex != -1)
				{
					result += widgets[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}	
		}
		if (result.equals(""))
		{
			throw new IllegalArgumentException("404 Error: Not Found");
		}
		return result;
	}
}