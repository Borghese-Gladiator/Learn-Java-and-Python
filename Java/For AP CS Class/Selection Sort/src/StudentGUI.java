import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class StudentGUI extends GBFrame
{
	JLabel instructions = addLabel("Enter last name, first name", 4, 4, 1, 1);
	JButton addStudent = addButton("Add student", 1, 5, 1, 1);
	JButton sortName = addButton("Sort by name", 2, 5, 1, 1);
	JButton sortAverage = addButton("Sort by average", 3, 5, 1, 1);
	JLabel testLabel = addLabel("Test", 1, 1, 1, 1);
	JLabel quizLabel = addLabel("Quiz", 1, 2, 1, 1);
	JLabel hwLabel = addLabel("Homework", 1, 4, 1, 1);
	JLabel nameLabel = addLabel("Name", 5, 4, 1, 1);
	IntegerField tests[] = new IntegerField[5];
	IntegerField quizzes[] = new IntegerField[8];
	IntegerField hwAverage = addIntegerField(0, 2, 4, 1, 1);
	JTextField nameField = addTextField("", 6, 4, 1, 1);
	JTextArea output = addTextArea("", 1, 6, 1, 1);
	AllStudents theClass = new AllStudents();
	public void buttonClicked(JButton button)
	{
		if (button == addStudent)
		{
			try
			{
				int[] theTests = new int[5];
				int testCounter = 0;
				int[] theQuizzes = new int[8];
				int quizCounter = 0;
				checkBlankGrades();
				//Find number of test grades
				for (int i = 0; i < theTests.length; i++)
				{
					if (tests[i].getText().isEmpty())
					{
						testCounter = i;
						break;
					}
					theTests[i] = tests[i].getNumber();
				}
				//Find number of quiz grades
				for (int i = 0; i < theTests.length; i++)
				{
					if (quizzes[i].getText().isEmpty())
					{
						quizCounter = i;
						break;
					}
					theQuizzes[i] = quizzes[i].getNumber();
				}
				StudentInfo x = new StudentInfo(nameField.getText(), theTests, testCounter, theQuizzes, quizCounter, hwAverage.getNumber());
				theClass.addStudent(x);
			}
			catch (Exception e)
			{
				messageBox(e.getMessage());
			}
		}
		if (button == sortName)
		{
			theClass.sort(false);
			output.setText(theClass.print());
		}
		if (button == sortAverage)
		{
			theClass.sort(true);
			output.setText(theClass.print());
		}
	}
	private void checkBlankGrades()
	{
		if (tests[0].getText().isEmpty())
		{
			throw new IllegalArgumentException("Please enter 1 test grade");
		}
		if (quizzes[0].getText().isEmpty())
		{
			throw new IllegalArgumentException("Please enter 1 quiz grade");
		}
		if (hwAverage.getText().isEmpty())
		{
			throw new IllegalArgumentException("No homework average");
		}
	}
	public StudentGUI()
	{
		for (int i = 0; i < 5; i++)
		{
			tests[i] = addIntegerField(0, i + 2, 1, 1, 1);
			tests[i].setText("");
		}
		for (int i = 0; i < 8; i++)
		{
			quizzes[i] = addIntegerField(0, i + 2, 2, 1, 1);
			quizzes[i].setText("");
		}
		hwAverage.setText("");
	}
	public static void main(String[] args) 
	{
		StudentGUI GUI = new StudentGUI();
		GUI.setTitle("Enter a classroom");
		GUI.setSize(500, 500);
		GUI.setVisible(true);
	}
}
