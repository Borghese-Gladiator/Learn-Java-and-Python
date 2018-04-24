public class DVD 
{
	private String title;
	private String director;
	private int playingTime;
	private boolean gotIt;
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String toString()
	{
		String result = "";
		result += "Title: " + title + '\n';
		result += "Director: " + director + '\n';
		result += "Playing time: " + playingTime + '\n';
		result += "Have it: " + gotIt + '\n';
		result += "Comments: " + comment + '\n';
		return result;
	}
	public DVD(String t, String d, int p, boolean g, String c)
	{
		title = t;
		director = d;
		playingTime = p;
		gotIt = g;
		comment = c;
	}
}
