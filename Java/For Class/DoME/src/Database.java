public class Database 
{
	private CD[] cdArray;
	private int cdCount;
	private DVD[] dvdArray;
	private int dvdCount;
	public Database()
	{
		cdArray = new CD[1];
		dvdArray = new DVD[1];
		cdCount = 0;
		dvdCount = 0;
	}
	public void addCD(String t, String a, int n,int p, boolean g, String c)
	{
		CD cd = new CD(t, a, n, p, g, c);
		cdArray[cdCount] = cd;
		cdCount++;
	}
	public void addDVD(String t, String d, int p, boolean g, String c)
	{
		DVD dvd = new DVD(t, d, p, g, c);
		dvdArray[dvdCount] = dvd;
		dvdCount++;
	}
	public String listAll()
	{
		String result = "";
		for (int i = 0; i < cdCount; i++)
		{
			result += cdArray[i].toString();
		}
		for (int i = 0; i < dvdCount; i++)
		{
			result += dvdArray[i].toString();
		}
		return result;
	}
	private void increaseCDSize()
	{
		CD[] x = new CD[cdArray.length + 1];
		for (int i = 0; i < cdArray.length; i++)
		{
			x[i] = cdArray[i];
		}
		cdArray = x;
	}
	private void increaseDVDSize()
	{
		DVD[] x = new DVD[dvdArray.length + 1];
		for (int i = 0; i < dvdArray.length; i++)
		{
			x[i] = dvdArray[i];
		}
		dvdArray = x;
	}
}
