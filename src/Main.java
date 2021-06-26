import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите выражение");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String input = string.replaceAll(" ", "");
        String[] symbols = input.split("[-+*/]");
        int a = 0;
        int b = 0;
        boolean roman = false;
        int result = 0;
        if (Roman.isRoman(symbols[0]) && Roman.isRoman(symbols[1])) {
            a = Roman.romanToDecimal(symbols[0]);
            b = Roman.romanToDecimal(symbols[1]);
            roman = true;
        } else {
            try {
                a = Integer.parseInt(symbols[0]);
                b = Integer.parseInt(symbols[1]);
            } catch (Exception e) {
                System.out.println("Введенное число не подходит.");
            }
        }
        if (a < 1 || a > 10) {
            throw new IOException();
        }

        if (b < 1 || b > 10) {
            throw new IOException();
        }
        if (input.contains("-")) {
            result = Operations.substraction(a,b);
        }
        if (input.contains("+")) {
            result = Operations.summation(a,b);
        }
        if (input.contains("*")) {
            result = Operations.multiply(a,b);
        }
        if (input.contains("/")) {
            result = Operations.divide(a,b);
        }
        if(roman) {
            System.out.println(Roman.decimalToRoman(result));
        } else {
            System.out.println(result);
        }
    }
}
