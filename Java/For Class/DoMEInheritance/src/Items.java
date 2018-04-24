
public class Items 
{
	private String title;
	private int playingTime;
	private boolean gotIt;
	public boolean isGotIt() {
		return gotIt;
	}
	public void setGotIt(boolean gotIt) {
		this.gotIt = gotIt;
	}
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String print()
	{
		String result = "";
		result += "Title: " + title + '\n';
		result += "Playing time: " + playingTime + '\n';
		result += "Have it: " + gotIt + '\n';
		result += "Comments: " + comment + '\n';
		return result;
	}
	public Items()
	{
		title = null;
		playingTime = 0;
		gotIt = false;
		comment = "";
		
	}
	public Items(String t,int p, boolean g, String c)
	{
		title = t;
		playingTime = p;
		gotIt = g;
		comment = c;
	}
}
