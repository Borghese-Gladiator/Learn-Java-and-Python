public class AllStudents
{
	//Holds all the students
	private StudentInfo[] aClass;
	//Holds number of students
	private int counter;
	//Initializes student database
	public AllStudents()
	{
		aClass = new StudentInfo[10];
		counter = 0;
	}
	//Adds student to database
	//@param the student
	public void addStudent(StudentInfo student)
	{
		if (counter > 10)
		{
			throw new IllegalArgumentException("There can only be 10 students");
		}
		aClass[counter] = student;
		counter++;
	}
	//Sorts the array by either name or average
	//@param true = grade sort, false = name sort
	public void sort(boolean isGradeSort)
	{
		for (int i = 0; i < counter; i++)
		{
			int minIndex;
			if (isGradeSort)
			{
				minIndex = sortByGrade(i);
			}
			else
			{
				minIndex = sortByName(i);
			}
			if (minIndex != i)
			{
				swap(i, minIndex);
			}
		}
	}
	//Finds next student with a lower average
	//@param the index of the previously switched student
	//@return index of student with lower average to switch with
	private int sortByGrade(int first)
{
		int minIndex = first;
		for (int i = first + 1; i < counter; i++)
		{
			if ((aClass[i].getFinalAverage())
					> ((aClass[minIndex]).getFinalAverage()))
			{
				minIndex = i;
			}
		}
		return minIndex;
	}
	//Finds next student with a name later in the alphabet
	//@param the index of the previously switched student
	//@return index of student with name later in alphabet to switch with
	private int sortByName(int first)
	{
		int minIndex = first;
		for (int i = first + 1; i < counter; i++)
		{
			if ((aClass[i].getName()).compareTo((aClass[minIndex]).getName()) < 0)
			{
				minIndex = i;
			}
		}
		return minIndex;
	}
	//Swaps the positions of two students
	//@param index 1, index 2
	private void swap(int x, int y)
	{
		StudentInfo temp = aClass[x];
		aClass[x] = aClass[y];
		aClass[y] = temp;
	}
	//Outputs all the students in the database
	//@return all the students in the databsse
	public String print()
	{
		String result = "Name	Average" + '\n';
		for (int i = 0; i < counter; i++)
		{
			result += aClass[i].print();
		}
		return result;
	}
}