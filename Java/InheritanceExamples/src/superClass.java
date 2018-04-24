public class superClass 
{
	private static int staticVariable = 5;
	private int superA = 1;
	public int getInstanceVariable() {
		return superA;
	}
	public superClass()
	{
		superA = 2; 
	}
	public static void main(String[]args)
	{
		int x = 3;
		subClass s = new subClass(x);
		subClass t = new subClass(x);
		staticVariable = 3;
		int z = s.getInstanceVariable();
		System.out.println("x: " + x + "\nStatic: " + staticVariable + "\nz: " + z);
		System.out.println(subClass.staticVariable2);
	}
}