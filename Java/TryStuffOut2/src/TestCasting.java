import java.util.ArrayList;

public class TestCasting 
{
public void method1() {}
static public class TestCastingSub extends TestCasting
{
}
public static void main(String arg[])
{
ArrayList list = new ArrayList();
list.add(new TestCastingSub());
for (TestCasting c : list)
{
c.method1();
}
}
}
