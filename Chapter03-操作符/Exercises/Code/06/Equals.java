public class Equals {
	public static void main(String[] args) {
		Dog d1 = new Dog();
		Dog d2 = new Dog();
	
		d1.name = "spot";
		d2.name = "scruffy";
	
		Dog d3 = d1;
		d3.name = "spot";

		System.out.println(d1 == d2);
		System.out.println(d1 == d3);
		System.out.println(d2 == d3);
	
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));
		System.out.println(d2.equals(d3));
	}
}
class Dog {
	String name;
}

