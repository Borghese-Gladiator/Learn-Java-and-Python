public class Database 
{
	private Items[] items;
	private int itemCount;
	public Database()
	{
		items = new Items[25];
		itemCount = 0;
	}
	public void addCD(String t, String a, int n,int p, boolean g, String c)
	{
		CD x = new CD(t, a, n, p, g, c);
		items[itemCount] = x;
		itemCount++;
	}
	public void addDVD(String t, String d, int p, boolean g, String c)
	{
		DVD dvd = new DVD(t, d, p, g, c);
		items[itemCount] = dvd;
		itemCount++;
	}
	public String listAll()
	{
		String result = "";
		for (int i = 0; i < itemCount; i++)
		{
			result += items[i].toString();
		}
		return result;
	}
}
