public class CD 
{
	private String title;
	private String artist;
	private int numberOfTracks;
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
		result += "Artist: " + artist + '\n';
		result += "Number of tracks: " + numberOfTracks + '\n';
		result += "Playing time: " + playingTime + '\n';
		result += "Have it: " + gotIt + '\n';
		result += "Comments: " + comment + '\n';
		return result;
	}
	public CD(String t, String a, int n,int p, boolean g, String c)
	{
		title = t;
		artist = a;
		numberOfTracks = n;
		playingTime = p;
		gotIt = g;
		comment = c;
	}
}
