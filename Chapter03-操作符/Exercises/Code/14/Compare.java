public class Compare {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str1="hello";
        String str2="word";
        String str3=new String("hello");
        testStr(str1, str2);
        System.out.println("--------------------------");
        testStr(str1, str3);
    }

    public static void testStr(String s1,String s2){
        //boolean b1=s1>s2;
        //boolean b2=s1<s2;
        boolean b3=s1==s2;
        System.out.println(s1+"=="+s2+":\t"+b3);
        boolean b4=s1.equals(s2);
        System.out.println(s1+".equals("+s2+"):\t"+b4);
        boolean b5=s1!=s2;
        System.out.println(s1+"!="+s2+":\t"+b5);
        /**result
         *
         *  hello==word:	false
         hello.equals(word):	false
         hello!=word:	true
         --------------------------
         hello==hello:	false
         hello.equals(hello):	true
         hello!=hello:	true
         */
    }
}