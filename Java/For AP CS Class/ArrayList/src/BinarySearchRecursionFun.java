import java.util.ArrayList;

public class BinarySearchRecursionFun 
{
	public static int binarySearch(ArrayList<Book> library, String title, int end, int begin)
	{
		int mid;
		while (end >= begin)
		{
			mid = (begin + end) / 2;
			int result = library.get(mid).getTitle().compareTo(title);
			if (result == 0)
			{
				return mid;
			}
			else if (result < 0)
			{
				return binarySearch(library, title, end, mid + 1);
			}
			else
			{
				return binarySearch(library, title, mid - 1, begin);
			}
		}
		return -1;
	}
}
