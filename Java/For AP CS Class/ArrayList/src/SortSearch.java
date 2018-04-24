import java.util.ArrayList;

public class SortSearch 
{
	//Sorts array
	//@param ArrayList to be sorted
	//@return sorted ArrayList
	public static ArrayList<Book> inSort(ArrayList<Book> items)
	{
		for (int k = 1; k < items.size(); k++)
		{
			Book itemToInsert = items.get(k);
			int j = k - 1;
  			boolean stillLooking = true;
			while (j >= 0 && stillLooking == true)
			{
				if ((itemToInsert.getTitle()).compareTo(items.get(j).getTitle()) < 0)
				{
					items.set(j + 1, items.get(j));
					j--;
				}
				else
				{
					stillLooking = false;
				}
			}
			items.set(j + 1, itemToInsert);
		}
		return items;
	}
	//Searches ArrayList for a book
	//@param ArrayList<Book>, book's title, start index
	//@return index of first occurrence of book with same title or -1
	public static int binarySearch(ArrayList<Book> items, String title, int beginIndex)
	{
		int end = items.size() - 1;
		int begin = beginIndex;
		int mid;
		while (end >= begin)
		{
			mid = (begin + end) / 2;
			int result = items.get(mid).getTitle().compareTo(title);
			if (result == 0)
			{
				return mid;
			}
			else if (result < 0)
			{
				begin = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}
		return -1;
	}
}
