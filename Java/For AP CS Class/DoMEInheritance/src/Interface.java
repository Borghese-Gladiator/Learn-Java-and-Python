import java.util.Scanner;
public class Interface 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		Database database = new Database();
		boolean repeat = true;
		do
		{
			System.out.println("Input 1, 2, or 3 to enter a command");
			System.out.println("1: Add a CD\n2: Add a DVD\n3:Database Info");
			int x = in.nextInt();
			switch(x)
			{
			case 1:
				System.out.println("Enter title");
				String title = in.nextLine();
				System.out.println("Enter artist");
				String director = in.nextLine();
				System.out.println("Enter number of tracks");
				int numberOfTracks = in.nextInt();
				System.out.println("Enter playing time in minutes");
				int playingTime = in.nextInt();
				System.out.println("Enter 1 if got it or else if not");
				boolean gotIt = false;
				if (in.nextInt() == 1)
				{
					gotIt = true;
				}
				System.out.println("Comments?");
				String comments = in.nextLine();
				database.addDVD(title, director, playingTime, gotIt, comments);
				break;
			case 2:
				System.out.println("Enter title");
				String title1 = in.nextLine();
				System.out.println("Enter director");
				String director1 = in.nextLine();
				System.out.println("Enter playing time in minutes");
				int playingTime1 = in.nextInt();
				System.out.println("Enter 1 if got it or else if not");
				boolean gotIt1 = false;
				if (in.nextInt() == 1)
				{
					gotIt = true;
				}
				System.out.println("Comments?");
				String comments1 = in.nextLine();
				database.addDVD(title1, director1, playingTime1, gotIt1, comments1);
				break;
			case 3:
				System.out.println(database.listAll());
				break;
			}
			System.out.println("Exit? Enter 1 to exit");
			if (in.nextInt() == 1)
			{
				repeat = false;
			}
		} while (repeat == true);
	}
}
