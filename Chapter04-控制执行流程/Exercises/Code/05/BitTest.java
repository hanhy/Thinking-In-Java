public class BitTest {
	
	static void printBinary(int i) {
		if (i == 0) {
			System.out.print(0);
		} else {
			int nlz = Integer.numberOfLeadingZeros(i);
			i <<= nlz;
			for (int k = 0; k < 32 - nlz; k ++) {
				System.out.print((Integer.numberOfLeadingZeros(i) == 0)?1:0);
				i <<= 1;
			}
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int a = 1 + 4 + 16 + 64;
		int b = 2 + 8 + 32 + 128;
		
		System.out.println("Using binary string:");
		System.out.println("a = " + Integer.toBinaryString(a));
		System.out.println("b = " + Integer.toBinaryString(b));
		System.out.println("a & b = " + Integer.toBinaryString(a & b));
		System.out.println("a | b = " + Integer.toBinaryString(a | b));
		System.out.println("a ^ b = " + Integer.toBinaryString(a ^ b));
		System.out.println("~a = " + Integer.toBinaryString(~a));
		System.out.println("~b = " + Integer.toBinaryString(~b));
		
		System.out.println("Using binary string:");
		System.out.print("a = ");
		printBinary(a);
		System.out.print("b = ");
		printBinary(b);
		System.out.print("a & b = ");
		printBinary(a & b);
		System.out.print("a | b = ");
		printBinary(a | b);
		System.out.print("a ^ b = ");
		printBinary(a ^ b);
		System.out.print("~a = ");
		printBinary(~a);
		System.out.print("~b = ");
		printBinary(~b);
	}
}