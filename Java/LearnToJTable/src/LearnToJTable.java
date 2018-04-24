import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LearnToJTable {
	private static JFrame frame = new JFrame();
	 private static JTable table = new JTable(10, 10);
       private static JScrollPane scrollPane = new JScrollPane(table);
       

	public static void main(String[] args) {
		int [] x = new int[25];
		x[0] = 1;
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		table.setFillsViewportHeight(true);
		 frame.setSize(550, 200);
	        frame.setVisible(true);

	}
	public LearnToJTable()
	{
		
       
	}

}
