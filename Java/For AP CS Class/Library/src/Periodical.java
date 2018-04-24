public class Periodical extends Item
{
	//Holds issue number of this periodical
	private int issueNumber;
	//Error check issue number
	//@param title, issue number
	public static void errorCheckPeriodical(String aTitle, int aIssue)
	{
		errorCheckItem(aTitle);
		if (aIssue <= 0)
		{
			throw new IllegalArgumentException("Issue number cannot be less than 0");
		}
	}
	//Initializes Periodical object
	//@param title, issue number
	public Periodical(String aTitle, int aIssueNumber)
	{
		super(aTitle);
		issueNumber = aIssueNumber;
	}
	//Assemble periodical information
	//@return periodical information
	public String print()
	{
		String result = "Title: " + getTitle() + '\n';
		result += "Issue Number: " + issueNumber + '\n';
		return result;
	}
	//Compares this periodical with inputted periodical
	//@param inputted periodical
	//@return +# when input is earlier issue, 0 when input is same issue
	// -# when input is later issue
	@Override
	public int compareTo(Object x)
	{
		if (!(x instanceof Periodical))
		{
			throw new IllegalArgumentException(getTitle() + " is not of the same type");
		}
		return getIssueNumber() - ((Periodical)x).getIssueNumber();
	}
	//Accessor method
	//@return issue number
	public int getIssueNumber() {
		return issueNumber;
	}
	//Mutator method
	//@param issue number
	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}
}