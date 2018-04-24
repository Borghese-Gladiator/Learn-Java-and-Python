public abstract class Item implements Comparable
{
	//Holds title of this item
	private String title;
	//Error check title
	//@param title of item
	public static void errorCheckItem(String aTitle)
	{
		if (aTitle == null || aTitle.isEmpty())
		{
			throw new IllegalArgumentException("Title cannot be blank");
		}
	}
	//Initializes Item object
	//@param title of Item
	public Item(String aTitle)
	{
		title = aTitle;
	}
	//Assemble equivalence information between inputted item (can be a book or periodical)
	//and this item
	//@param inputted item
	//@return equivalence information between inputted item and this item
	public String findComparison(Item aItem)
	{
		String result = "";
		try
		{
			if (this.compareTo(aItem) > 0)
			{
				result += getTitle() + " is after " + aItem.getTitle();
			}
			else if (this.compareTo(aItem) == 0)
			{
				result +=  getTitle() + " is equal to " + aItem.getTitle() + '\n';
			}
			else
			{
				result +=  getTitle() + " is before " +aItem.getTitle() + '\n';
			}
		}
		catch (Exception e)
		{
			result += e.getMessage() + '\n';
		}
		return result;
	}
	//Assemble item information
	public abstract String print();
	//Accessor method
	//@return title
	public String getTitle() {
		return title;
	}
	//Mutator method
	//@param title
	public void setTitle(String title) {
		this.title = title;
	}
}