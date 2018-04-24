import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
public class PeopleGUI extends GBFrame
{
	//Label each input field
	JLabel personLabel = addLabel("Enter information for a person below", 1, 2, 1, 1);
	JLabel nameLabel = addLabel("Name", 2, 1, 1, 1);
	JLabel idLabel = addLabel("ID", 3, 1, 1, 1);
	JLabel majorLabel = addLabel("Major", 4, 1, 1, 1);
	JLabel gradeLabel = addLabel("Grade level", 5, 1, 1, 1);
	JLabel printIfEqualLabel = addLabel("Compare people to college student", 5, 3, 1, 1);
	//Label the output field
	JLabel outputLabel = addLabel("Output", 1, 8, 1, 1);
	//Input data
	JTextField nameField = addTextField("", 2, 2, 1, 1);
	IntegerField idField = addIntegerField(0, 3, 2, 1, 1);
	JTextField majorField = addTextField("", 4, 2, 1, 1);
	//Set up radio buttons
	JRadioButton freshman = addRadioButton("Freshman", 5, 2, 1, 1);
	JRadioButton sophomore = addRadioButton("Sohphomore", 6, 2, 1, 1);
	JRadioButton junior = addRadioButton("Junior", 7, 2, 1, 1);
	JRadioButton senior = addRadioButton("Senior", 8, 2, 1, 1);
	//Input people
	JButton inputPerson = addButton("Create Person", 1, 3, 1, 1);
	JButton inputStudent = addButton("Create Student", 2, 3, 1, 1);
	JButton inputUndergraduate = addButton("Create Undergraduate", 3, 3, 1, 1);
	JButton inputGraduate = addButton("Create Graduate", 4, 3, 1, 1);
	//Output data
	JButton printPeople = addButton("Print all Persons", 1, 4, 1, 1);
	JButton printStudents = addButton("Print all Students", 2, 4, 1, 1);
	JButton printUndergraduates = addButton("Print all Undergraduates", 3, 4, 1, 1);
	JButton printGraduates = addButton("Print all Graduates", 4, 4, 1, 1);
	JButton reset = addButton("Reset", 5, 4, 1, 1);
	JButton printGradEqual = addButton("Print Graduates with the same major", 6, 3, 1, 1);
	JButton printUnderEqual = addButton("Print Undergraduates in the same grade level", 7, 3, 1, 1);
	//Hold output for user to see
	JTextArea output = addTextArea("", 2, 7, 3, 8);
	//true if there are people created in Database
	boolean peopleEntered = false;
	//Database holds all entered information and assembles information
	Database database = new Database();
    public PeopleGUI()
    {
    	//Group radio buttons together
    	ButtonGroup x = new ButtonGroup();
    	x.add(freshman);
    	x.add(sophomore);
    	x.add(junior);
    	x.add(senior);
    	printPeople.setEnabled(false);
    	printStudents.setEnabled(false);
    	printUndergraduates.setEnabled(false);
    	printGraduates.setEnabled(false);
    	printGradEqual.setEnabled(false);
    	printUnderEqual.setEnabled(false);
    	reset.setEnabled(false);
    }
    public void buttonClicked(JButton button)
    {
    	if (button == inputPerson)
    	{
    		try
    		{
        		Person.errorCheckName(nameField.getText());
        		Person person = new Person(nameField.getText());
        		database.addPerson(person);
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
    	else if (button == inputStudent)
    	{
    		try
    		{
        		Student.errorCheckID(nameField.getText(), idField.getNumber());
        		Student student = new Student(nameField.getText(), idField.getNumber());
        		database.addPerson(student);
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
    	else if (button == inputGraduate)
    	{
    		try
    		{
        		Graduate.errorCheckMajor(nameField.getText(), idField.getNumber(), majorField.getText());
        		Graduate graduate = new Graduate(nameField.getText(), idField.getNumber(), majorField.getText());
        		database.addPerson(graduate);
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
    	else if (button == inputUndergraduate)
    	{
    		int gradeLevel = 0;
    		if (freshman.isSelected())
    		{
    			gradeLevel = 1;
    		}
    		else if (sophomore.isSelected())
    		{
    			gradeLevel = 2;
    		}
    		else if (junior.isSelected())
    		{
    			gradeLevel = 3;
    		}
    		else if (senior.isSelected())
    		{
    			gradeLevel = 4;
    		}
    		try
    		{
        		Undergraduate.errorCheckGrade(nameField.getText(), idField.getNumber(), gradeLevel);
        		Undergraduate undergrad = new Undergraduate(nameField.getText(), idField.getNumber(), gradeLevel);
        		database.addPerson(undergrad);
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
    	else if (button == printPeople)
    	{
    		output.setText(database.assemblePeople());
    	}
    	else if (button == printStudents)
    	{
    		output.setText(database.assembleStudents());
    	}
    	else if (button == printUndergraduates)
    	{
    		output.setText(database.assembleUndergraduates());
    	}
    	else if (button == printGraduates)
    	{
    		output.setText(database.assembleGraduates());
    	}
    	else if (button == printGradEqual)
    	{
    		try
    		{
        		Graduate.errorCheckMajor(nameField.getText(), idField.getNumber(), majorField.getText());
        		Graduate graduate = new Graduate(nameField.getText(), idField.getNumber(), majorField.getText());
        		output.setText(database.findCollegeStudent(graduate, "major"));
    		}
    		catch(Exception e)
    		{
    			messageBox(e.getMessage());
    		}
    	}
    	else if (button == printUnderEqual)
    	{
    		int gradeLevel = 0;
    		if (freshman.isSelected())
    		{
    			gradeLevel = 1;
    		}
    		else if (sophomore.isSelected())
    		{
    			gradeLevel = 2;
    		}
    		else if (junior.isSelected())
    		{
    			gradeLevel = 3;
    		}
    		else if (senior.isSelected())
    		{
    			gradeLevel = 4;
    		}
    		try
    		{
        		Undergraduate.errorCheckGrade(nameField.getText(), idField.getNumber(), gradeLevel);
        		Undergraduate undergrad = new Undergraduate(nameField.getText(), idField.getNumber(), gradeLevel);
        		output.setText(database.findCollegeStudent(undergrad, "grade"));
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
        	printPeople.setEnabled(false);
        	printStudents.setEnabled(false);
        	printUndergraduates.setEnabled(false);
        	printGraduates.setEnabled(false);
        	printUnderEqual.setEnabled(false);
        	printGradEqual.setEnabled(false);
        	output.setText("");
    	}
    }
    //Enables output buttons after a person is entered into database
    private void enableButtons()
    {
    	peopleEntered = true;
    	printPeople.setEnabled(true);
    	printStudents.setEnabled(true);
    	printUndergraduates.setEnabled(true);
    	printGraduates.setEnabled(true);
    	printUnderEqual.setEnabled(true);
    	printGradEqual.setEnabled(true);
    	reset.setEnabled(true);
    }
    public static void main(String[] args)
    {
    	PeopleGUI GUI = new PeopleGUI();
		GUI.setTitle("People Database");
		GUI.setSize(1500, 500);
		GUI.setVisible(true);
    }
}