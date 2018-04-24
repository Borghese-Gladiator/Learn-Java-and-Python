
public class SortSearch 
{
	//binary search objects
	//@param array, size, search target, starting index
	//@return index of next occurrence of target, -1 if not found
	public static int binarySearch(Comparable[] items, int counter, Comparable target, int beginIndex)
	{
		int end = counter - 1;
		int begin = beginIndex;
		int mid;
		while (end >= begin)
		{
			mid =  (begin + end) / 2;
			if (items[mid].compareTo(target) == 0)
			{
				return mid;
			}
			else if (items[mid].compareTo(target) < 0)
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
	//sequential search objects
	//@param array, size, search target, starting index
	//@return index of next occurrence of target, -1 if not found
	public static int sequentialSearch(Comparable[] items, int counter, Comparable target, int beginIndex)
	{
		for (int i = beginIndex; i < counter; i++)
		{
			if (items[i].compareTo(target) == 0)
			{
				return i;
			}
		}
		return -1;
	}
	//Order: Students, Employees, Widgets
	//Insertion sort
	//@param array, size
	//@return sorted array
	public static Comparable[] inSort(Comparable[] items, int counter)
	{
		for (int k = 1; k < counter; k++)
		{
			Comparable itemToInsert = items[k];
			int j = k - 1;
  			boolean stillLooking = true;
			while (j >= 0 && stillLooking == true)
			{
				if (itemToInsert.compareTo(items[j]) < 0)
				{
					items[j + 1] = items[j];
					j--;
				}
				else
				{
					stillLooking = false;
				}
			}
			items[j + 1] = itemToInsert;
		}
		return items;
	}
	//Selection sort
	//@param array, size
	//@return sorted array
	public static Comparable[] seSort(Comparable[] items, int counter)
	{
		for (int i = 0; i < counter; i++)
		{
			int minIndex = i;
			minIndex = findLowest(items, counter, i);
			if (minIndex != i)
			{
				Comparable temp = items[i];
				items[i] = items[minIndex];
				items[minIndex] = temp;
			}
		}
		return items;
	}
	//Finds next item with an earlier place
	//@param the index of the previously switched item
	//@return index of item with an earlier place to switch with
	private static int findLowest(Comparable[] items, int counter, int first)
	{
		int minIndex = first;
		for (int i = first + 1; i < counter; i++)
		{
			if (items[i].compareTo(items[minIndex]) < 0)
			{
				minIndex = i;
			}
		}
		return minIndex;
	}
}