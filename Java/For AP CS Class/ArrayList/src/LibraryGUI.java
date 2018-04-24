import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class LibraryGUI extends GBFrame
{
	JLabel titleLabel = addLabel("Title", 1, 1, 1, 1);
	JTextField title = addTextField("", 2, 1, 1, 1);
	JLabel authorLabel = addLabel("Author", 1, 2, 1, 1);
	JTextField author = addTextField("", 2, 2, 1, 1);
	JLabel borrowerLabel = addLabel("Borrower", 3, 1, 1, 1);
	JTextField borrower = addTextField("", 4, 1, 1, 1);
	JLabel monthLabel = addLabel("Month", 3, 2, 1, 1);
	IntegerField month = addIntegerField(0, 4, 2, 1, 1);
	JLabel dayLabel = addLabel("Day", 3, 3, 1, 1);
	IntegerField day = addIntegerField(0, 4, 3, 1, 1);
	JLabel yearLabel = addLabel("Year", 3, 4, 1, 1);
	IntegerField year = addIntegerField(0, 4, 4, 1, 1);
	JRadioButton all = addRadioButton("All", 7, 1, 1, 1);
	JRadioButton borrowed = addRadioButton("Borrowed", 7, 2, 1, 1);
	JRadioButton late = addRadioButton("Late", 7, 3, 1, 1);
	JButton add = addButton("Add book", 1, 3, 1, 1);
	JButton print = addButton("Output", 7, 1, 1, 1);
	JButton loan = addButton("Loan", 4, 1, 1, 1);
	JButton returnBook = addButton("Return", 5, 1, 1, 1);
	JTextArea output = addTextArea("", 1, 5, 2, 5);
	Library library = new Library();
	public LibraryGUI()
	{
		ButtonGroup outputType = new ButtonGroup();
		outputType.add(all);
		outputType.add(borrowed);
		outputType.add(late);
	}
	public void buttonClicked(JButton button)
	{
		if (button == add)
		{
			Book book = new Book(title.getText(), author.getText());
			library.addBook(book);
		}
		try
		{
			if (button == print)
			{
				InformationAssembler format = new InformationAssembler();
				if (all.isSelected()) 
				{
					output.setText(format.outputAll(library));
				}
				else if (borrowed.isSelected())
				{
					output.setText(format.outputBorrowed(library));
				}
				else if (late.isSelected())
				{
					if (year.getNumber() == 0)
					{
						messageBox("Please enter today's date");
					}
					else
					{
						Date date = new Date(month.getNumber(), day.getNumber(), year.getNumber());
						output.setText(format.outputLate(library, date));
					}
				}
				else
				{
					throw new IllegalArgumentException("Select an output type");
				}
			}
			if (button == loan)
			{
				//Check book has been added to library
				if (library.inLibrary(title.getText()))
				{
					if (borrower.getText().equals(""))
					{
						messageBox("Please enter borrower's name");
					}
					else if (month.getNumber() == 0 || day.getNumber() == 0 || year.getNumber() == 0)
					{
						messageBox("Please enter today's date");
					}
					else
					{
						Date date = new Date(month.getNumber(), day.getNumber(), year.getNumber());
						library.loan(title.getText(), borrower.getText(), date);
					}
				}
				else
				{
					output.setText(title.getText() + " has not been added to the library");
				}
			}
			if (button == returnBook)
			{
				if (library.inLibrary(title.getText()))
				{
					library.returnBook(title.getText());
				}
				else
				{
					output.setText(title.getText() + " has not been added to the library");
				}
			}
		}
		catch (Exception e)
		{
			messageBox(e.getMessage());
		}
	}
	public static void main(String[] args) 
	{
		LibraryGUI GUI = new LibraryGUI();
		GUI.setTitle("Make a classroom");
		GUI.setSize(800, 800);
		GUI.setVisible(true);
	}
}
