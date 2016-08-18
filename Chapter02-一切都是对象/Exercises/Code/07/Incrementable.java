public class Incrementable {
	static void increment() { StaticTest.i++; }
	public static void main(String[] args) {
		System.out.println(StaticTest.i);
		Incrementable sf = new Incrementable();
		sf.increment();		
		System.out.println(StaticTest.i);
		Incrementable.increment();
		System.out.println(StaticTest.i);
	}
}
class StaticTest {
	static int i = 47;
}/* Output (100% match)
47
48
49
*///:~
