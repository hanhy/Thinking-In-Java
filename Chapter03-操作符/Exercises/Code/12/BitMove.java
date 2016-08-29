public class BitMove {
    public static void main(String[] args) {
        int a = 0xffffffff;
        for (int i = 0; i < 8; i ++) {
            a = a << 1;
            System.out.println(Integer.toBinaryString(a));
        }
        for (int i = 0; i < 32; i ++) {
            a = a >>> 1;
            System.out.println(Integer.toBinaryString(a));
        }
    }
}