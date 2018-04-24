
public class Date 
{
	//Number of days at month at each index
	private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	//Holds year
	private int year;
	//Holds month
	private int month;
	//Holds day
	private int day;
	//Initializes Date object
	//@param year, month, day
	public Date(int aMonth, int aDay, int aYear)
	{
		if (aYear <= 0)
		{
			throw new IllegalArgumentException("Enter a positive year");
		}
		year = aYear;
		if (aMonth <= 0 || aMonth > 12)
		{
			throw new IllegalArgumentException("Enter 1 - 12 for a month");
		}
		month = aMonth;
		//Leap year, 2/29 is valid
		if (isLeapYear(aYear) && aMonth == 2)
		{
			if (aDay <= 0 || aDay > DAYS_IN_MONTH[2] + 1)
			{
				throw new IllegalArgumentException("Enter a valid day for leap year");
			}
		}
		else
		{
			if (aDay <= 0 || aDay > DAYS_IN_MONTH[aMonth])
			{
				throw new IllegalArgumentException("Enter a valid day");
			}
		}
		day = aDay;
	}
	//Is leap year or not
	//@param a year
	//@return if leap year or not
	private static boolean isLeapYear(int year)
	{
		if (year % 4 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Determines if late or not
	//@return if late or not
	public boolean twoWeeksLate(Date date)
	{
		if (findDaysApart(date) > 14)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Finds number of days apart
	//@param a date
	//@return num of days apart
	private int findDaysApart(Date d)
	{
		int numOfDays = numOfDays();
		int numOfDays2 = d.numOfDays();
		return numOfDays2 - numOfDays;
	}
	//Finds number of days
	//@return number of days
	private int numOfDays()
	{
		int result = (int)(getYear() * 365 + getYear() * (0.25));
		for (int i = 1; i < getMonth(); i++)
		{
			result += DAYS_IN_MONTH[i];
		}
		result += getDay();
		return result;
	}
	//@return year
	public int getYear() {
		return year;
	}
	//@return month
	public int getMonth() {
		return month;
	}
	//@return day
	public int getDay() {
		return day;
	}
}
