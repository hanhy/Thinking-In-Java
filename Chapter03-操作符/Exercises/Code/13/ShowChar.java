public class ShowChar {

    static int print(char c) {
        int a[] = {1, 2, 4, 8, 16, 32, 64, 128};
        int sum = 0;
        for (int i = 0; i < 8; i ++) {
            a[i] = a[i] & c;
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(ShowChar.print('a')));
        System.out.println(Integer.toBinaryString(ShowChar.print('b')));
        System.out.println(Integer.toBinaryString(ShowChar.print('c')));
    }
}
