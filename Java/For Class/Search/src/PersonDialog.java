import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;
import BreezySwing.IntegerField;
//Dialog box opened if individual is found in database
public class PersonDialog extends GBDialog
{
	//Found individual
	private People person;
	JLabel nameLabel = addLabel("Name",  1, 1, 1, 1);
	JTextField nameField;
	JLabel ageLabel = addLabel("Age", 3, 1, 1, 1);
	IntegerField ageField;
	JButton modify = addButton("Modify", 1, 2, 1, 1);
	JButton delete = addButton("Delete", 1, 3, 1, 1);
	public PersonDialog(JFrame parent, People aPerson)
	{
		super(parent);
        setTitle("Edit Person");
        setDlgCloseIndicator("Ok");                
        setSize(300, 200);
        person = aPerson;
        nameField = addTextField(person.getName(), 2, 1, 1, 1);
		ageField = addIntegerField(person.getAge(), 4, 1, 1, 1);
	}
	public void buttonClicked(JButton button)
	{
		if (button == delete)
		{
			setDlgCloseIndicator("DELETE");
		}
		if (button == modify)
		{
			person.setName(nameField.getText());
			person.setAge(ageField.getNumber());
			setDlgCloseIndicator ("MODIFY");
		}
		
		dispose();
	}
}