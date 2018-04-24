import java.text.NumberFormat;
import BreezySwing.Format;
public class Employee 
{
	//Holds name of employee with no given order
	private String name;
	//Holds each quarterly sale of employee
	private double Q1;
	private double Q2;
	private double Q3;
	private double Q4;
	//Holds the sum of Q1, Q2, Q3, and Q4
	private double totalSales;
	//Initializes an employee with given name, Q1, Q2, Q3, and Q4
	//@param name of employee, Q1, Q2, Q3, and Q4
	public Employee(String nm, double q1, double q2, double q3, double q4)
	{
		name = nm;
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		Q4 = q4;
		totalSales = Q1 + Q2 + Q3 + Q4;
	}
	//Format name, Q1, Q2, Q3, Q4, and total sales into one row to fit table
	//@return one row of all of an employee's data
	public String toString()
	{
		String result = "";
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		result += Format.justify('l', name, 20);
		result += Format.justify('r', formatter.format(Q1), 12);
		result += Format.justify('r', formatter.format(Q2), 12);
		result += Format.justify('r', formatter.format(Q3), 12);
		result += Format.justify('r', formatter.format(Q4), 12);
		result += Format.justify('r', formatter.format(totalSales), 16);
		result += '\n';
		return result;
	}
	public String getName() {
		return name;
	}
	public double getTotalSales() {
		return totalSales;
	}
}



