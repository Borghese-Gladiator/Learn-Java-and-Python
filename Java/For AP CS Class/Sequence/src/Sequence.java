public class Sequence 
{
	//Array to hold the values entered by user 
	public int[] series;
	//Hold current number of values in series
	private int length;
	public Sequence()
	{
		series = new int[10];
		length = 0;
	}
	public void add(int number)
	{
		if (length > 10)
		{
			series = increaseSize();
		}
		series[length] = number;
		length++;
	}
	public String toString()
	{
		String result = "";
		for (int i = 0; i < length - 1; i++)
		{
			result += series[i] + ", ";
		}
		result += series[length - 1] + ".";
		return result;
	}
	public void clear()
	{
		for (int i = 0; i < length; i++)
		{
			series[i] = 0;
		}
		length = 0;
	}
	private int[] increaseSize()
	{
		int[] newArray = new int[series.length + 1];
		for (int i = 0; i < series.length; i++)
		{
			newArray[i] = series[i];
		}
		return newArray;
	}
	/*
	public int getValueFromSeries(int index)
	{
		return series[index];
	}
	*/
	public int length()
	{
		return length;
	}
}