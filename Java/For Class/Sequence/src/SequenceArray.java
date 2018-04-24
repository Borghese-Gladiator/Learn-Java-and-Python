public class SequenceArray 
{
	//Array to hold sequence objects
	private Sequence[] sequence;
	//Hold current number of sequence objects
	private int count;
	//Check if first iteration to automatically input the first value into the array
	private boolean firstIteration = false;
	//Hold the previously inputted value of user to compare
	private int recent;
	public SequenceArray()
	{
		sequence = new Sequence[25];
		count = 0;
		recent = 0;
	}
	//Removes all values from the array
	//@return message if successfully reset
	public String reset()
	{
		for (int i = 0; i <= count; i++)
		{
			sequence[i].clear();
		}
		count = 0;
		recent = 0;
		return "The sequence has been reset";
	}
	//Inputs the value into the Sequence object or creates
	//a new Sequence object if not large enough
	//@param the value inputted by the user
	public void inputNumber(int number)
	{
		if (firstIteration == false)
		{
			sequence[count] = new Sequence();
			sequence[count].add(number);
			firstIteration = true;
			recent = number;
		}
		else
		{
			//Compare previously inputted value to current value
			if (recent < number)
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
			recent = number;
		}
	}
	//Increases the size of sequence if there are more than 25 Sequence objects
	//@return a new array of Sequence objects with an additional null space
	private Sequence[] increaseSize()
	{
		Sequence[] newArray = new Sequence[sequence.length + 1];
		for (int i = 0; i < sequence.length; i++)
		{
			newArray[i] = sequence[i];
		}
		return newArray;
	}
	//Returns the continuously increasing sequences as a string
	//@param determine if the shortest or the longest 
	//continuously increasing sequence is wanted
	//@return sequence string with "and" to separate if there
	//are multiple sequences
	public String output(boolean isLongest)
	{
		String result = "";
		int length = 0;
		if (isLongest == true)
			length = findLongestLength();
		else
			length = findShortestLength();
		result = findArray(length);
		return result;
	}
	//Finds the array with the longest length
	//@return length of the longest array
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
	//Finds the array with the shortest length
	//@return length of the shortest array
	private int findShortestLength()
	{
		int arrayLength = sequence[0].length();
		for (int i = 1; i <= count; i++)
		{
			if (arrayLength > sequence[i].length())
			{
				arrayLength = sequence[i].length();
			}
		}
		return arrayLength;
	}
	//Finds all arrays with a certain length
	//@return contents of each array as a string with "and" separating sequences
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
	/*
	public String deleteValue(int index)
	{
		String result = "";
		if (errorCheckIndex(index))
		{
			result = "Error: Negative index";
		}
		else
		{
			int sum = 0;
			for (int i = 0; i < sequence.length; i++)
			{
				sum+= sequence[i].length();
			}
			for (int i = 0; i < sum; i++)
			{
				if (i == index)
				{
					result += + " has been deleted";
					break;
				}
			}
		}
		return result;
	}
	private boolean errorCheckIndex(int index) 
	{
		if (index < 0)
		{
			return true;
		}
		return false;
	}
	*/
	//@return count, the number of Sequence objects
	public int getCount() {
		return count;
	}
}