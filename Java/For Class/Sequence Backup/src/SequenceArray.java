public class SequenceArray 
{
	private Sequence[] sequence;
	private int count;
	private boolean firstIteration = false;
	public SequenceArray()
	{
		sequence = new Sequence[25];
		count = 0;
	}
	public String reset()
	{
		for (int i = 0; i <= count; i++)
		{
			sequence[i].clear();
		}
		count = 0;
		return "The sequence has been reset";
	}
	public void inputNumber(int number)
	{
		if (firstIteration == false)
		{
			sequence[count] = new Sequence();
			sequence[count].add(number);
			firstIteration = true;
		}
		else
		{
			//Compare previously inputted value to current value
			if (sequence[count].getRecent() < number)
			{
				sequence[count].add(number);
			}
			//If not greater, move to next Sequence object
			else
			{
				if (count > 25)
				{
					sequence = increaseSize();
				}
				count++;
				sequence[count] = new Sequence();
				sequence[count].add(number);
			}
		}
	}
	public Sequence[] increaseSize()
	{
		Sequence[] newArray = new Sequence[sequence.length + 1];
		for (int i = 0; i < sequence.length; i++)
		{
			newArray[i] = sequence[i];
		}
		return newArray;
	}
	public String output()
	{
		String result = "";
		int length = findLongestLength();
		result = findArray(length);
		return result;
	}
	private int findLongestLength()
	{
		int arrayLength = sequence[0].length();
		for (int i = 1; i <= count; i++)
		{
			if (arrayLength < sequence[i].length())
			{
				arrayLength = sequence[i].length();
			}
		}
		return arrayLength;
	}
	private String findArray(int length)
	{
		String result = "";
		for (int i = 0; i <= count; i++)
		{
			if (sequence[i].length() == length)
			{
				if (result == "")
				{
					result = sequence[i].toString();
				}
				else
				{
					result += " and " + sequence[i].toString();
				}
			}
		}
		return result;
	}
	public int getCount() {
		return count;
	}
}