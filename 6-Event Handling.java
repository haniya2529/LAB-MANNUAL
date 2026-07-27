import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("          Simple Calculator");
        System.out.println("----------------------------------------");

        System.out.print("First Number : ");
        double num1 = sc.nextDouble();

        System.out.print("Second Number : ");
        double num2 = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Click : ");
        String operation = sc.nextLine();

        System.out.print("Result : ");

        switch (operation.toLowerCase()) {
            case "add":
                System.out.println(num1 + num2);
                break;

            case "subtract":
                System.out.println(num1 - num2);
                break;

            case "multiply":
                System.out.println(num1 * num2);
                break;

            case "divide":
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println(num1 / num2);
                }
                break;

            default:
                System.out.println("Invalid Operation");
        }

        sc.close();
    }
}
