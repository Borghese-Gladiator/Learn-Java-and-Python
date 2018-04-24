/* Timothy Shee
 * September 22, 2017
 * Purpose: Keep track of sales employees by allowing the input
 * of employees and outputting of all employees, a specific employee,
 * or the best/worst employees.
 */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.Format;
import BreezySwing.GBFrame;

public class EmployeeGUI extends GBFrame
{
	//Adds employee to Company with given name, Q1, Q2, Q3, and Q4 from user
	private JButton input = addButton("Input Employee", 7, 5, 3, 1);
	//Output the name and total sales of the employee with the highest sales
	private JButton highestSales = addButton("Highest Sales", 1, 5, 1, 1);
	//Output the name and total sales of the employee with the lowest sales
	private JButton lowestSales = addButton("Lowest Sales", 2, 5, 1, 1);
	//Output the name, Q1, Q2, Q3, Q4, and total sales of each employee in a table
	private JButton table = addButton ("Table", 3, 5, 1, 1);
	//Searches Company for employee with the same name as the given inside the search box
	private JButton searchEmployee = addButton("Search for Employee", 5, 5, 1, 1);
	private JButton deleteEmployee = addButton("Delete employee", 6, 5, 1, 1);
	//Holds user input of employee name to search for employees
	private JTextField searchField = addTextField("", 5, 5, 1, 1);
	//Holds user input for employee name in any order, but when searching,
	//all parts entered including commas must be included
	private JTextField nameField = addTextField("", 2, 1, 3, 1);
	//Holds user input for the sales of each quarter where
	//the default set value is $0
	private DoubleField Q1Field = addDoubleField(0.0, 4, 1, 3, 1);
	private DoubleField Q2Field = addDoubleField (0.0, 5, 1, 3, 1);
	private DoubleField Q3Field = addDoubleField(0.0, 6, 1, 3, 1);
	private DoubleField Q4Field = addDoubleField(0.0, 7, 1, 3, 1);
	//Labels to indicate where the user should input which information
	private JLabel nameLabel = addLabel("Name", 1, 1, 1, 1);
	private JLabel salesLabel = addLabel("Quarterly Sales", 3, 1, 1, 1);
	private JLabel searchLabel = addLabel("Give Employee Name Below", 4, 5, 1, 1);
	//Holds output for user to see
	private JTextArea output = addTextArea("", 1, 7, 14, 10);
	//Creates new company with a maximum of 25 employees
	private Company company = new Company();
	//Determine which button was clicked by user and corresponding action
	//@param button clicked
	public void buttonClicked(JButton button)
	{
		if (button == input)
		{
			if (errorCheck() == false)
			{
				double Q1 = Double.parseDouble(Q1Field.getText()), Q2 = Double.parseDouble(Q2Field.getText()),
						Q3 = Double.parseDouble(Q3Field.getText()), Q4 = Double.parseDouble(Q4Field.getText());
				String name = nameField.getText();
				Employee employee = new Employee(name, Q1, Q2, Q3, Q4);
				if (company.getCount() == 0)
				{
					highestSales.setEnabled(true);
					lowestSales.setEnabled(true);
					table.setEnabled(true);
					searchEmployee.setEnabled(true);
					searchField.setEnabled(true);
					deleteEmployee.setEnabled(true);
					output.setEnabled(true);
				}
				if (company.checkDuplicateNames(employee.getName()) == false)
				{
					company.addEmployee(employee);
					output.append(name + " has been added to the database." + '\n');
				}
				else
				{
					messageBox("Error: This name has already been used");
				}
			}
		}
		if (button == highestSales)
		{
			double x = company.findHighestSales();
			output.append(company.findEmployee(x)
						+ " have the highest sales of " + x + '\n');
		}
		if (button == lowestSales)
		{
			double x = company.findLowestSales();
			output.append(company.findEmployee(x)
					+ " have the lowest sales of " + x + '\n');
		}
		if (button == table)
		{
			columnHeadings();
			output.append(company.outputTable());
		}
		if (button == searchEmployee)
		{
			output.append(company.searchEmployee(searchField.getText()));
		}
		if (button == deleteEmployee)
		{
			output.append(company.deleteEmployee(searchField.getText()));
		}
	}
	//Checks if data is valid and if an employee can be added to the array
	//@return valid or invalid
	private boolean errorCheck()
	{
		if (nameField.getText().isEmpty())
		{
			messageBox("Error: The name has not been inputted");
			return true;
		}
		try
		{
			if (Double.parseDouble(Q1Field.getText()) < 0 || Double.parseDouble(Q2Field.getText()) < 0 || 
					Double.parseDouble(Q3Field.getText()) < 0 || Double.parseDouble(Q4Field.getText()) < 0)
			{
				messageBox("Error: Quarterly sales must be positive");
				return true;
			}
		}
		catch (Exception e)
		{
			messageBox("Error: Quareterly sales must be numbers");
			return true;
		}
		if (company.getCount() > 25)
		{
			messageBox("Error: There are more than 25 employees. You cannot input anymore");
			input.setEnabled(false);
			return true;
		}
		return false;
	}
	//Initializes GUI and disables all buttons except input since there is no entered data yet
	public EmployeeGUI()
	{
		input.setEnabled(true);
		highestSales.setEnabled(false);
		lowestSales.setEnabled(false);
		table.setEnabled(false);
		searchEmployee.setEnabled(false);
		output.setEnabled(false);
		searchField.setEnabled(false);
		deleteEmployee.setEnabled(false);
	}
	//Outputs the column headings with names formatted to 20 spaces left-justified
	//and sales to 12 spaces, right-justified
	private void columnHeadings()
	{
		String result = Format.justify('l', "Name", 20);
		result += "|  Quarter 1|  Quarter 2|  Quarter 3|  Quarter 4|    Total Sales" + '\n';
		output.append(result);
	}
	public static void main(String[] args) 
	{
		EmployeeGUI GUI = new EmployeeGUI();
		GUI.setTitle("Create A Company");
		GUI.setSize(1100, 500);
		GUI.setVisible(true);
	}
}
