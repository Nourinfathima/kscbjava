
import java.util.Scanner;

public class Kscb {
    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("select an option");
            System.out.println("1.add consumer");
            System.out.println("2.search consumer");
            System.out.println("3.delete consumer");
            System.out.println("4.update consumer");
            System.out.println("5.view consumer");
            System.out.println("6.genarate consumerbill");
            System.out.println("7.view consumerbill");
            System.out.println("8.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("add consumer");
                    break;
                case 2:
                    System.out.println("search consumer");
                    break;
                case 3:
                    System.out.println("delete consumer");
                    break;
                case 4:
                    System.out.println("update consumer");
                    break;
                case 5:
                    System.out.println("update student selected");
                    break;
                case 6:
                    System.out.println("genarate consumerbill");
                    break;
                case 7:
                    System.out.println("view consumerbill");
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
