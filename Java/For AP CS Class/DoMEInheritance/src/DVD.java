public class DVD extends Items
{
	private String director;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String print()
	{
		String result = super.print();
		result += "Director: " + director + '\n';
		return result;
	}
	public DVD(String t, String d, int p, boolean g, String c)
	{
		super(t, p, g, c);
		director = d;
	}
}
