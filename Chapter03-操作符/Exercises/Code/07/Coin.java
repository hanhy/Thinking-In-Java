import java.util.*;
public class Coin {
	public static void main(String[] args) {
		Random rand = new Random();
		int i = 0;
		while(i < 10) {
			i ++;
			System.out.println(rand.nextInt(2) == 1?"正面":"反面");
		}
	}
}
