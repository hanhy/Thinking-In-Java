public class InitTwoString{
    String str1 = "init";
    String str2;
    public InitTwoString() {
        System.out.println(str1);
        System.out.println(str2);
        str2 = "init in contructor";
        System.out.println(str1);
        System.out.println(str2);
    }
    public static void main(String[] args) {
        InitTwoString its = new InitTwoString();
    }
}