import java.util.Scanner;

public class HelloBoy {
    public static void main(String[] args) {
        String message="Hello World";
        System.out.println(message);

        System.out.println("Mi a neved?");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Hello " + name);
        System.out.println(name + " melyik évben születtél?");
        int szul = scan.nextInt();
        int kor = 2020-szul;
        System.out.println("Életkor " + kor);
    }
}
