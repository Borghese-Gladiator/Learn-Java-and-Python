public class Graduate extends Student
{
	//Holds major of graduate
	private String major;
	//Error check major
	//@param name, id, and major of graduate
	public static void errorCheckMajor(String aName, int aID, String aMajor)
	{
		Student.errorCheckID(aName, aID);
		if (aMajor == null || aMajor.isEmpty())
		{
			throw new IllegalArgumentException("No major entered");
		}
		for (char c : aMajor.toCharArray()) 
		{
            if (Character.isDigit(c)) 
            {
                throw new IllegalArgumentException("Major contains number(s)");
            }
        }
	}
	//Initialize Graduate object
	//@param name, ID, and major of Graduate
	public Graduate(String aName, int aID, String aMajor)
	{
		super(aName, aID);
		major = aMajor;
	}
	//Assemble graduate information
	//@return graduate information
	public String print()
	{
		String result = super.print();
		result += "Major: " + major + '\n';
		return result;
	}
	//Determine if person is a Graduate and they are equal (same major)
	//@param inputted person
	//@return true if equal and false if not equal
	@Override
	public boolean equals (Object x)
	{
		if (!(x instanceof Graduate))
		{
			throw new IllegalArgumentException(((Person)x).getName() + " is not the same type");
		}
		else if (((Graduate)x).getMajor().equals(major))
		{
			return true;
		}
		return false;
	}
	//Accessor method for major
	//@return major 
	public String getMajor() {
		return major;
	}
}