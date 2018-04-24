
public class Widget implements Comparable<Widget>
{
	//product number of this widget
	private String productNum;
	//number sold of this widget
	private int numSold;
	//Initializes Widget object
	//@param product number, number sold
	public Widget(String theProduct, int theNum)
	{
		if (theProduct.length() != 3)
		{
			throw new IllegalArgumentException("Product number must be three digits");
		}
		if (theNum < 0)
		{
			throw new IllegalArgumentException("Number sold cannot be negative");
		}
		productNum = theProduct;
		numSold = theNum;
	}
	//Compares this student to an item
	//@param an item
	//@return comparison of widget's number sold, else, 1
	//Order: Students, Employees, Widgets
	public int compareTo(Widget x)
	{
		return getNumSold() - ((Widget)x).getNumSold();
	}
	//@return information of this widget
	@Override
	public String toString()
	{
		return "Widget\nProduct Number: " + productNum + "\nNumber sold: " + numSold + '\n';
	}
	//@return number sold of this widget
	public int getNumSold() {
		return numSold;
	}
}