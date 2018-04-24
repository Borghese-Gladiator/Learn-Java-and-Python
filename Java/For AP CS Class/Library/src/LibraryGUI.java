import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
public class LibraryGUI extends GBFrame
{
	//Label each input field
	JLabel itemLabel = addLabel("Enter information for an item below", 1, 2, 1, 1);
	JLabel titleLabel = addLabel("Title", 2, 1, 1, 1);
	JLabel authorLabel = addLabel("Author", 3, 1, 1, 1);
	JLabel issueLabel = addLabel("Issue number", 4, 1, 1, 1);
	//Label the output field
	JLabel outputLabel = addLabel("Output", 1, 5, 1, 1);
	//Input data
	JTextField titleField = addTextField("", 2, 2, 1, 1);
	JTextField authorField = addTextField("", 3, 2, 1, 1);
	IntegerField issueField = addIntegerField(0, 4, 2, 1, 1);
	//Input people
	JButton inputBook = addButton("Create Book", 1, 3, 1, 1);
	JButton inputPeriodical = addButton("Create Periodical", 2, 3, 1, 1);
	//Output data
	JButton printItems = addButton("Print all Items", 1, 4, 1, 1);
	JButton printBooks = addButton("Print all Books", 2, 4, 1, 1);
	JButton printPeriodicals = addButton("Print all Periodicals", 3, 4, 1, 1);
	JButton printCompareBooks = addButton("Print order of books", 4, 4, 1, 1);
	JButton printComparePeriodicals = addButton("Print order of periodicals", 5, 4, 1, 1);
	JButton reset = addButton("Reset", 4, 4, 1, 1);
	//Hold output for user to see
	JTextArea output = addTextArea("", 2, 5, 3, 8);
	//true if there are people created in Database
	boolean peopleEntered = false;
	//Database holds all entered information and assembles information
	Database database = new Database();
    public LibraryGUI()
    {
    	printItems.setEnabled(false);
    	printBooks.setEnabled(false);
    	printPeriodicals.setEnabled(false);
    	printCompareBooks.setEnabled(false);
    	printComparePeriodicals.setEnabled(false);
    	reset.setEnabled(false);
    }
    public void buttonClicked(JButton button)
    {
    	if (button == inputBook)
    	{
    		try
    		{
        		Book.errorCheckBook(titleField.getText(), authorField.getText());
        		Book aBook = new Book(titleField.getText(), authorField.getText());
        		database.addItem(aBook);
        		if(peopleEntered == false)
        		{
        			enableButtons();
        		}
    		}
    		catch(Exception e)
    		{
    			messageBox(e.getMessage());
    		}
    	}
    	else if (button == inputPeriodical)
    	{
    		try
    		{
        		Periodical.errorCheckPeriodical(titleField.getText(), issueField.getNumber());
        		Periodical aPeriodical = new Periodical(titleField.getText(), issueField.getNumber());
        		database.addItem(aPeriodical);
        		if(peopleEntered == false)
        		{
        			enableButtons();
        		}
    		}
    		catch(Exception e)
    		{
    			messageBox(e.getMessage());
    		}
    	}
    	else if (button == printItems)
    	{
    		output.setText(database.printAll());
    	}
    	else if (button == printBooks)
    	{
    		output.setText(database.printBooks());
    	}
    	else if (button == printPeriodicals)
    	{
    		output.setText(database.printPeriodicals());
    	}
    	else if (button == printCompareBooks)
    	{
    		try
    		{
        		Book.errorCheckBook(titleField.getText(), authorField.getText());
        		Book aBook = new Book(titleField.getText(), authorField.getText());
        		output.setText(database.printComparison(aBook));
        		if(peopleEntered == false)
        		{
        			enableButtons();
        		}
    		}
    		catch(Exception e)
    		{
    			messageBox(e.getMessage());
    		}
    		
    	}
    	else if (button == printComparePeriodicals)
    	{
    		try
    		{
        		Periodical.errorCheckPeriodical(titleField.getText(), issueField.getNumber());
        		Periodical aPeriodical = new Periodical(titleField.getText(), issueField.getNumber());
        		output.setText(database.printComparison(aPeriodical));
        		if(peopleEntered == false)
        		{
        			enableButtons();
        		}
    		}
    		catch(Exception e)
    		{
    			messageBox(e.getMessage());
    		}
    	}
    	else if (button == reset)
    	{
    		database.reset();
    		peopleEntered = false;
        	printItems.setEnabled(false);
        	printBooks.setEnabled(false);
        	printPeriodicals.setEnabled(false);
        	printCompareBooks.setEnabled(false);
        	printComparePeriodicals.setEnabled(false);
        	output.setText("");
    	}
    }
    //Enables output buttons after a person is entered into database
    private void enableButtons()
    {
    	peopleEntered = true;
    	printItems.setEnabled(true);
    	printBooks.setEnabled(true);
    	printPeriodicals.setEnabled(true);
    	printCompareBooks.setEnabled(true);
    	printComparePeriodicals.setEnabled(true);
    	reset.setEnabled(true);
    }
    public static void main(String[] args)
    {
    	LibraryGUI GUI= new LibraryGUI();
		GUI.setTitle("Items Database");
		GUI.setSize(1500, 500);
		GUI.setVisible(true);
    }
}
