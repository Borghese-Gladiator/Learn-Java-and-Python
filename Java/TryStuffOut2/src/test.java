
public class test 
{
	/*
	public static void main(String[] args)
	{
		String s = "holy";
		String t = s.substring(4);
		String x = s.substring(5);
		System.out.println(t);
		System.out.println(mixup("IDEAL"));
	}
	*/
	public static String prepare (String s)
	{
		int k = s.length() / 2;
		if (k <= 1)
		{
			return s;
		}
		return s.charAt(k - 1) + prepare(s.substring(0,  k - 1) + s.substring(k + 1, 2 * k)) + s.charAt(k);
	}
	public static boolean isValid(String word)
	{
		int n = word.length();
		return n <= 1 || (isValid(word.substring(0, n - 1)) && word.charAt(n - 1) == 'B') 
				|| (isValid(word.substring(0, n - 2)) && "BA".equals(word.substring(n - 2)));
	}
	static String mixup(String word)
	{
		int n = word.length();
		if (word.length() == 1)
		{
			return "";
		}
		else
			return mixup(word.substring(0, n - 1)) + word.charAt(n - 2);
	}
}
