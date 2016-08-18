public class Method {
	int storage(String s) {
		return s.length() * 2;
	}
	public static void main(String[] args) {
		Method m = new Method();
		System.out.println(m.storage("Howie"));
	}
}
