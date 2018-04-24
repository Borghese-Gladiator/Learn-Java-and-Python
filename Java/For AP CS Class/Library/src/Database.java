public class Database 
{
	//Array max size is 10
	private static final int MAX_SIZE = 10;
	//Hold entered items
	private Item[] items;
	//Hold Number of items in database
	private int count;
	//Initialize database to have a max of 10 items
	public Database()
	{
		items = new Item[MAX_SIZE];
		count = 0;
	}
	//Add given item to database
	//@param any Item object (includes books and periodicals)
	public void addItem(Item aItem)
	{	
		if (count == items.length)
			increaseItemsLength();
		items[count] = aItem;
		count++;
	}
	//Assemble information of every item in database
	//@return information of every item in database
	public String printAll()
	{
		String result = "Items" + '\n'+ '\n';
		for (int i = 0; i < count; i++)
		{
			result += items[i].print() + '\n';
		}
		return result;
	}
	//Assemble information of every Book in database
	//@return information of every Book in database
	public String printBooks()
	{
		String result = "Books" + '\n'+ '\n';
		for (int i = 0; i < count; i++)
		{
			if (items[i] instanceof Book)
			{
				result += items[i].print() + '\n';
			}
		}
		return result;
	}
	//Assemble information of every periodical in database
	//@return information of every periodical in database
	public String printPeriodicals()
	{
		String result = "Periodicals" + '\n'+ '\n';
		for (int i = 0; i < count; i++)
		{
			if (items[i] instanceof Periodical)
			{
				result += items[i].print() + '\n';
			}
		}
		return result;
	}
	//Assemble information of multiple equivalence comparisons between inputted item
	// and every item in database
	//@param inputted item
	//@return equivalence comparisons of inputted item with every item in database
	public String printComparison(Item aItem)
	{
		String result = "Compare" + '\n' + '\n';
		for (int i = 0; i < count; i++)
		{
			result += items[i].findComparison(aItem);
		}
		return result;
	}
	//Increases the length of the array by 10
	private void increaseItemsLength()
	{
		Item[] newArray = new Item[items.length + MAX_SIZE];
		for (int i = 0; i < count; i++)
		{
			newArray[i] = items[i];
		}
		items = newArray;
	}
	//Resets database
	public void reset()
	{
		count = 0;
	}
}