import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class FinderGUI extends GBFrame
{
	JButton add = addButton("Add person", 1, 5, 1, 1);
	JButton outputPeople = addButton("Output", 2, 5, 1, 1);
	JLabel nameSearchLabel = addLabel("Search for person here", 3, 5, 1, 1);
	JTextField nameSearch = addTextField("", 4, 5, 1, 1);
	JButton search = addButton("Search", 5, 5, 1, 1);
	JButton binarySearch = addButton("Sequential search", 6, 5, 1, 1);
	JButton sequentialSearch = addButton("Other Binary Search", 7, 5, 1, 1);
	JLabel nameLabel = addLabel("Name", 1, 1, 1, 1);
	JTextField name = addTextField("", 2, 1, 1, 1);
	JLabel ageLabel = addLabel("Age", 3, 1, 1, 1);
	IntegerField age = addIntegerField(0, 4, 1, 1, 1);
	JLabel outputLabel = addLabel("Output", 5, 1, 1, 1);
	JTextArea output = addTextArea("", 6, 1, 1, 1);
	Database people = new Database();
	public void buttonClicked(JButton button)
	{
		if (button == add)
		{
			try
			{
				People person = new People(name.getText(), age.getNumber());
				people.addPerson(person);
			}
			catch(Exception e)
			{
				messageBox(e.getMessage());
			}
		}
		if (button == outputPeople)
		{
			output.setText(people.print());
		}
		//Searches for name, if found, reveals a dialog box to modify or delete person
		//if not found, throws exception
		if (button == search)
		{
			try
			{
				int index = people.findPerson(nameSearch.getText());
				People person = people.getPerson(index);
				PersonDialog dlg = new PersonDialog(this, person);
				dlg.setVisible(true);
				if (dlg.getDlgCloseIndicator().equals("MODIFY"))
					output.setText(nameSearch.getText() + " has been changed to "  + '\n' + person.print());
				else if (dlg.getDlgCloseIndicator().equals("DELETE"))
				{
					people.delete(index);
					output.setText(nameSearch.getText() + " has been deleted");
				}
					
			}
			catch(Exception e)
			{
				messageBox(e.getMessage());
			}
		}
		if (button == binarySearch)
		{
			try
			{
				int index = people.findPerson2(nameSearch.getText());
				People person = people.getPerson(index);
				PersonDialog dlg = new PersonDialog(this, person);
				dlg.setVisible(true);
				if (dlg.getDlgCloseIndicator().equals("MODIFY"))
					output.setText(nameSearch.getText() + " has been changed to "  + '\n' + person.print());
				else if (dlg.getDlgCloseIndicator().equals("DELETE"))
				{
					people.delete(index);
					output.setText(nameSearch.getText() + " has been deleted");
				}
			}
			catch(Exception e)
			{
				messageBox(e.getMessage());
			}
		}
		if (button == sequentialSearch)
		{
			try
			{
				int index = people.findPerson3(nameSearch.getText());
				People person = people.getPerson(index);
				PersonDialog dlg = new PersonDialog(this, person);
				dlg.setVisible(true);
				if (dlg.getDlgCloseIndicator().equals("MODIFY"))
					output.setText(nameSearch.getText() + " has been changed to "  + '\n' + person.print());
				else if (dlg.getDlgCloseIndicator().equals("DELETE"))
				{
					people.delete(index);
					output.setText(nameSearch.getText() + " has been deleted");
				}
			}
			catch(Exception e)
			{
				messageBox(e.getMessage());
			}
		}
	}
	public static void main(String[] args)
	{
		FinderGUI GUI = new FinderGUI();
		GUI.setTitle("Make a classroom");
		GUI.setSize(500, 500);
		GUI.setVisible(true);
	}
}