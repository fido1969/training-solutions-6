package literals;

public class LiteralsMain {
    public static void main(String[] args) {
        String aString;
        aString = "1" + 2;
        aString = "12";
        double quotient = 3/4f;
        System.out.println(quotient);
        long big = 3_244_444_444L;
        System.out.println(big);
        aString = "árvíztűrőtükörfúrógép";
        System.out.println(aString);
        String word;
        int i = 0b1101;
        word= "title".toUpperCase();
        System.out.println(Integer.toBinaryString(1) + " " + Integer.toString(1,2) );
        System.out.println(Integer.toBinaryString(-2)  + " " + Integer.toString(-2,2));
    }
}
