
public class Database 
{
	//array of items
	private Comparable items[];
	//number of items
	private int counter;
	//Initializes Database object
	public Database()
	{
		items = new Comparable[10];
		counter = 0;
	}
	//Adds an item to the database
	//@param a item
	public void add(Comparable item)
	{
		items[counter] = item;
		counter++;
	}
	//Outputs sorted database information
	//@param if insertion or selection sort is to used
	//@return sorted database information
	public String output(boolean isInsertion, String className)
	{
		if (isInsertion)
			items = SortSearch.inSort(items, counter);
		else
			items = SortSearch.seSort(items, counter);
		String result = "";
		for (int i = 0; i < counter; i++)
		{
			if (items[i].getClass().getSimpleName().equals(className))
				result += items[i].toString() + '\n';
		}
		return result;
	}
	//Searches for target item
	//@param if binary or sequential, item to be searched for
	//@return information of items that are equal
	public String search(boolean isBinary, Comparable target)
	{
		String output = "Items with same values as\n" + target.toString() + '\n';
		int beginIndex = 0;
		if (isBinary)
		{
			items = SortSearch.inSort(items, counter);
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.binarySearch(items, counter, target, beginIndex);
				if (beginIndex != -1)
				{
					output += items[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}
		}
		else
		{
			while (beginIndex != -1)
			{
				beginIndex = SortSearch.sequentialSearch(items, counter, target, beginIndex);
				if (beginIndex != -1)
				{
					output += items[beginIndex].toString() + '\n';
					beginIndex++;
				}
			}	
		}
		if (output.equals(""))
		{
			throw new IllegalArgumentException("404 Error: Not Found");
		}
		return output;
	}
}