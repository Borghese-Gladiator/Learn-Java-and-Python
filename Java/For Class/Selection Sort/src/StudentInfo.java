public class StudentInfo //implements Comparable<StudentInfo>
{
	//Holds name of student
	private String name;
	//Holds grade averages of student
	private int testAverage;
	private int quizzesAverage;
	private int hwAverage;
	private int finalAverage;
	//Initializes Student object
	//@param name, tests, number of tests, quizzes, number of quizzes, homework
	public StudentInfo(String aName, int[] tests, int testCounter, int[] quizzes, int quizCounter, int theHWAverage)
	{
		//Checks for invalid data members
		checkName(aName);
		checkGrade(tests, testCounter);
		checkGrade(quizzes, quizCounter);
		//Finds average of grades, so an array AND counter do not have to be held
		testAverage = findMeanGrade(tests, testCounter);
		quizzesAverage = findMeanGrade(quizzes, quizCounter);
		name = aName;
		hwAverage = theHWAverage;
		finalAverage = calcFinalAvg();
	}
	//Checks for invalid name
	//@param name
	private void checkName(String aName)
	{
		if (aName == null || aName.isEmpty())
		{
			throw new IllegalArgumentException("No name");
		}
	}
	//Checks for an invalid grade
	//@param grades, number of grades
	private boolean checkGrade(int[] grades, int counter)
	{
		for (int i = 0; i < counter; i++)
		{
			if (grades[i] > 100 || grades[i] < 0)
			{
				throw new IllegalArgumentException(grades[i] + " is an invalid grade");
			}
		}
		return true;
	}
	//Finds the mean of a given set of grades
	//@param grades, number of grades
	private int findMeanGrade(int[] arr, int counter)
	{
		int result = 0;
		for (int i = 0; i < counter; i++)
		{
			result += arr[i];
		}
		return result / counter;
	}
	//Finds final average with formula
	//@return final average
	private int calcFinalAvg()
	{
		return (int)(0.5 * testAverage + 0.3 * quizzesAverage + 0.2 * hwAverage);
	}
	//Outputs student's info (name and average)
	//@return name and average with tab in between
	public String print()
	{
		return String.format(name + '\t' + finalAverage+ '\n');	
	}
	//@return name
	public String getName() {
		return name;
	}
	//@return final average
	public int getFinalAverage() {
		return finalAverage;
	}
}
