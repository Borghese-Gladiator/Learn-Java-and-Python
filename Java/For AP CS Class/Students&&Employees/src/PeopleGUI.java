import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
public class PeopleGUI extends GBFrame
{
	//Enter a new student with inputted name, age, and grade level
	JButton inputStudent = addButton("Input Student", 5, 2, 1, 1);
	//Enter a new employee with inputted name and age
	JButton inputEmployee = addButton("Input Employee", 4, 3, 1, 1);
	//Output all students with their name, age, and grade level
	JButton outputStudents = addButton("Output students", 2, 4, 1, 1);
	//Output all employees with both their name and age
	JButton outputEmployees = addButton("Output employees" , 3, 4, 1, 1);
	//Output number of students and number of employees
	JButton outputCounts = addButton("Output counts", 4, 4, 1, 1 );
	//Output names of all people with a given age from the field givenAge
	JButton outputNames = addButton("Output names", 6, 4, 1, 1);
	//Clear the database of previous inputs
	JButton reset = addButton("Reset", 7, 4, 1, 1);
	//Direct user where to enter age to search for people with given age
	JLabel givenAgeLabel = addLabel("Search for people with age below", 5, 4, 1, 1);
	//Hold user input of given age to search for people
	IntegerField givenAge = addIntegerField(0, 6, 4, 1, 1);
	//Hold user input of information about a student and an employee
	JTextField studentName = addTextField("", 2, 2, 1, 1);
	JTextField employeeName = addTextField("", 2, 3, 1, 1);
	IntegerField studentAge = addIntegerField (0, 3, 2, 1, 1);
	IntegerField employeeAge = addIntegerField(0, 3, 3, 1, 1);
	IntegerField studentGradeLevel = addIntegerField(0, 4, 2, 1, 1);
	//Direct user where to enter student name, age, and grade level
	//and employee name and age
	JLabel student = addLabel("Student information", 1, 2, 1, 1);
	JLabel employee = addLabel("Employee information", 1, 3, 1, 1);
	JLabel name = addLabel("Names", 2, 1, 1, 1);
	JLabel age = addLabel("Ages", 3, 1 ,1, 1);
	JLabel gradeLevel = addLabel("Grade Level", 4, 1, 1, 1);
	//Hold output for user to see
	JTextArea output = addTextArea("", 6, 1, 3, 3);
	//Create database to hold students and employees
	People people = new People();
	//Prevent users from outputting all students when there are no students
	boolean studentEntered = false;
	//Prevent users from outputting all employees when there are no employees
	boolean employeeEntered = false;
	//Let users delete particular people from the database by entering their name
	JLabel deleteLabel = addLabel("Enter name of person below", 1, 5, 1, 1);
	JTextField deleteField = addTextField("", 2, 5, 1, 1);
	JButton delete = addButton("Delete person", 3, 5, 1, 1);
	public void buttonClicked(JButton button)
	{
		if (button == inputStudent)
		{
			if (studentName.isValid() && studentAge.isValid() &&
					studentGradeLevel.isValid())
			{
				try
				{
					Student.errorCheck(studentName.getText(),
							studentAge.getNumber(), studentGradeLevel.getNumber());
				}
				catch(Exception e)
				{
					output.setText(e.getMessage());;
				}
				people.addStudent(studentName.getText(), studentAge.getNumber(),
						studentGradeLevel.getNumber());
				if (studentEntered == false)
				{
					studentEntered = true;
					outputStudents.setEnabled(true);
					outputNames.setEnabled(true);
					outputCounts.setEnabled(true);
				}
			}
			else
			{
				output.setText("Improper input for a name, age, or grade level");
			}
		}
		if (button == inputEmployee)
		{
			if (employeeName.isValid() && employeeAge.isValid())
			{
				try
				{
					Employee.errorCheck(employeeName.getText(),employeeAge.getNumber());
				}
				catch (Exception e)
				{
					output.setText(e.getMessage());
					}
				people.addEmployee(employeeName.getText(),employeeAge.getNumber());
				if (employeeEntered == false)
				{
					employeeEntered = true;
					outputEmployees.setEnabled(true);
					outputNames.setEnabled(true);
					outputCounts.setEnabled(true);
				}	
			}
			else
			{
				output.setText("Improper input for a name and age");
			}
		}
		if (button == outputStudents)
		{
			output.setText(people.outputStudents());
		}
		if (button == outputEmployees)
		{
			output.setText(people.outputEmployees());
		}
		if (button == outputNames)
		{
			if (givenAge.getNumber() >= 0)
			{
				output.setText(people.outputNames(givenAge.getNumber()));
			}
			else
			{
				output.setText("Ages cannot be 0 or negative");
			}
		}
		if (button == outputCounts)
		{
			output.setText(people.outputCounts());
		}
		if (button == reset)
		{
			messageBox("The database has been reset");
			people.reset();
			studentEntered = false;
			employeeEntered = false;
			outputEmployees.setEnabled(false);
			outputStudents.setEnabled(false);
			outputNames.setEnabled(false);
		}
		if (button == delete)
		{
			if (deleteField.isValid())
			{
				output.setText(people.delete(deleteField.getText()));
			}
			else
			{
				output.setText("Name must be a word");
			}
		}
	}
	public PeopleGUI()
	{
		outputEmployees.setEnabled(false);
		outputStudents.setEnabled(false);
		outputNames.setEnabled(false);
		outputCounts.setEnabled(false);
		inputStudent.setEnabled(true);
		inputEmployee.setEnabled(true);
	}
	public static void main(String [] args)
	{
		PeopleGUI GUI = new PeopleGUI();
		GUI.setTitle("People Database");
		GUI.setSize(1100, 500);
		GUI.setVisible(true);
	}
}