public class Sequence 
{
	public int[] series;
	private int length;
	private int recent;
	public Sequence()
	{
		series = new int[10];
		length = 0;
		recent = 0;
	}
	public void add(int number)
	{
		series[length] = number;
		recent = number;
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
		recent = 0;
	}
	public int getRecent() {
		return recent;
	}
	public int length()
	{
		return length;
	}
}