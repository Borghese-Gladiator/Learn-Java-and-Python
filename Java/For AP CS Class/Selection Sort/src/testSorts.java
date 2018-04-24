import static org.junit.Assert.*;

import org.junit.Test;

public class testSorts {

	@Test
	public void testGradeSort() 
	{
		int[] tests = new int[2];
		tests[0] = 100;
		tests[1] = 100;
		int[] quizzes = new int[2];
		quizzes[0] = 100;
		quizzes[1] = 100;
		StudentInfo first = new StudentInfo("Alex", tests, 2, quizzes, 2, 100);
		int[] tests2 = new int[2];
		tests2[0] = 90;
		tests2[1] = 90;
		int[] quizzes2 = new int[2];
		quizzes2[0] = 90;
		quizzes2[1] = 90;
		StudentInfo second = new StudentInfo("John", tests2, 2, quizzes2, 2, 90);
		int[] tests3 = new int[2];
		tests3[0] = 100;
		tests3[1] = 100;
		int[] quizzes3 = new int[2];
		quizzes3[0] = 100;
		quizzes3[1] = 100;
		StudentInfo third = new StudentInfo("Nick", tests3, 2, quizzes3, 2, 100);
		AllStudents aClass = new AllStudents();
		aClass.addStudent(first);
		aClass.addStudent(second);
		aClass.addStudent(third);
		aClass.sort(true);
		String x = aClass.print(); //Keeps printing 98
		assertEquals("Name	Average" + '\n' + "Alex	100\nNick	100\nJohn	90\n",aClass.print());
	}
	@Test
	public void testNameSort()
	{
		int[] tests = new int[2];
		tests[0] = 100;
		tests[1] = 100;
		int[] quizzes = new int[2];
		quizzes[0] = 100;
		quizzes[1] = 100;
		StudentInfo first = new StudentInfo("Alex", tests, 2, quizzes, 2, 100);
		int[] tests2 = new int[2];
		tests2[0] = 90;
		tests2[1] = 90;
		int[] quizzes2 = new int[2];
		quizzes2[0] = 90;
		quizzes2[1] = 90;
		StudentInfo second = new StudentInfo("John", tests2, 2, quizzes2, 2, 90);
		int[] tests3 = new int[2];
		tests3[0] = 100;
		tests3[1] = 100;
		int[] quizzes3 = new int[2];
		quizzes3[0] = 100;
		quizzes3[1] = 100;
		StudentInfo third = new StudentInfo("Nick", tests3, 2, quizzes3, 2, 100);
		AllStudents aClass = new AllStudents();
		aClass.addStudent(first);
		aClass.addStudent(second);
		aClass.addStudent(third);
		aClass.sort(false);
		String x = aClass.print();
		assertEquals("Name	Average\nAlex	100\nJohn	90\nNick	100\n",aClass.print());
	}
}