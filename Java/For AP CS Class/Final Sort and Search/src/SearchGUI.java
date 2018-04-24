import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class SearchGUI extends GBFrame
{
	//Employee
	JLabel enameLabel = addLabel("Name", 2, 1, 1, 1);
	JTextField ename = addTextField("", 3, 1, 1, 1);
	JLabel salaryLabel = addLabel("Salary", 4, 1, 1, 1);
	IntegerField salary = addIntegerField(0, 5, 1, 1, 1);
	//Student
	JLabel snameLabel = addLabel("Name", 2, 2, 1, 1);
	JTextField sname = addTextField("", 3, 2, 1, 1);
	JLabel scoreLabel = addLabel("GPA", 4, 2, 1, 1);
	DoubleField score = addDoubleField(0.0, 5, 2, 1, 1);
	//Widget
	JLabel productLabel = addLabel("Product #", 2, 3, 1, 1);
	JTextField product = addTextField("", 3, 3, 1, 1);
	JLabel soldLabel = addLabel("Sold", 4, 3, 1, 1);
	IntegerField sold = addIntegerField(0, 5, 3, 1, 1);
	//Choose item type
	JRadioButton employee = addRadioButton("Employee", 1, 1, 1, 1);
	JRadioButton student = addRadioButton("Student", 1, 2, 1, 1);
	JRadioButton widget = addRadioButton("Widget", 1, 3, 1, 1);
	//Searches
	JLabel searchesLabel = addLabel("Searches", 6, 3, 1, 1);
	JRadioButton sequential = addRadioButton("Sequential", 8, 3, 1, 1);
	JRadioButton binary = addRadioButton("Binary", 7, 3, 1, 1);
	JLabel sortsLabel = addLabel("Sorts", 6, 1, 1, 1);
	//Sorts
	JRadioButton insertion = addRadioButton("Insertion", 7, 1, 1, 1);
	JRadioButton selection = addRadioButton("Selection", 8, 1, 1, 1);
	//Buttons
	JButton add = addButton("Add item", 1, 4, 1, 1);
	JButton outputButton = addButton("Output", 3, 4, 1, 1);
	JButton search = addButton("Search", 6, 4, 1, 1);
	JTextArea output = addTextArea("", 9, 2, 2, 1);
	Database items = new Database();
	public SearchGUI()
	{
		ButtonGroup search = new ButtonGroup();
		search.add(sequential);
		search.add(binary);
		ButtonGroup items = new ButtonGroup();
		items.add(employee);
		items.add(student);
		items.add(widget);
		ButtonGroup sorts = new ButtonGroup();
		sorts.add(insertion);
		sorts.add(selection);
	}
	public void buttonClicked(JButton button)
	{
		//Catch when user does not pick a type of input
		try
		{
			if (button == add)
			{
				if (employee.isSelected())
				{
					items.addE(new Employee(ename.getText(), salary.getNumber()));
				}
				else if (student.isSelected())
				{
					items.addS(new Student(sname.getText(), score.getNumber()));
				}
				else if (widget.isSelected()) 
				{
					items.addW(new Widget(product.getText(), sold.getNumber()));
				}
				else
				{
					throw new IllegalArgumentException("Select a type of item");
				}
			}
			if (button == outputButton)
			{
				boolean isInsertion;
				if (insertion.isSelected())
				{
					isInsertion = true;
				}
				else if (selection.isSelected())
				{
					isInsertion = false;
				}
				else
				{
					throw new IllegalArgumentException("Select a sort");
				}
				if (employee.isSelected())
				{
					output.setText(items.outputE(isInsertion));
				}
				else if (student.isSelected())
				{
					output.setText(items.outputS(isInsertion));
				}
				else if (widget.isSelected()) 
				{
					output.setText(items.outputW(isInsertion));
				}
			}
			if (button == search)
			{
				boolean isBinary;
				if (binary.isSelected())
				{
					isBinary = true;
				}
				else if (selection.isSelected())
				{
					isBinary = false;
				}
				else
				{
					throw new IllegalArgumentException("Select a search");
				}
				if (employee.isSelected())
				{
					output.setText(items.searchE(isBinary, new Employee(ename.getText(), salary.getNumber())));
				}
				else if (student.isSelected())
				{
					output.setText(items.searchS(isBinary, new Student(sname.getText(), score.getNumber())));
				}
				else if (widget.isSelected()) 
				{
					output.setText(items.searchW(isBinary,new Widget(product.getText(), sold.getNumber())));
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
		SearchGUI GUI = new SearchGUI();
		GUI.setTitle("Make a classroom");
		GUI.setSize(500, 500);
		GUI.setVisible(true);
	}
}