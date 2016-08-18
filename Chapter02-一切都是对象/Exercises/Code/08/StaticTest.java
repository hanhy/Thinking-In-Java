public class StaticTest {
	static int i = 1;
	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		System.out.println(st1.i);
		System.out.println(st2.i);
		st1.i ++;
		System.out.println(st1.i);
		System.out.println(st2.i);
		st2.i ++;
		System.out.println(st1.i);
		System.out.println(st2.i);
	}	
}/* Output (100% match)
1
1
2
2
3
3
*///:~
