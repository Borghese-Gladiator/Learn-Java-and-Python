public class CD extends Items
{
	private String artist;
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}
	private int numberOfTracks;
	public String print()
	{
		String result = super.print();
		result += "Artist: " + artist + '\n';
		result += "Number of tracks: " + numberOfTracks + '\n';
		return result;
	}
	public CD(String t, String a, int n,int p, boolean g, String c)
	{
		super(t, p, g, c);
		artist = a;
		numberOfTracks = n;
	}
}
