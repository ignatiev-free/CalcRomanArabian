import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine().toUpperCase();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Не верный формат ввода (только АРАБСКИЕ или только РИМСКИЕ цифры)");
        }
    }

    public static String calc(String input) throws Exception {
        String[] words = input.split("");
        boolean isRoman = false;
        int a1, b1;

        try {
            a1 = Integer.parseInt(words[0]);
            b1 = Integer.parseInt(words[2]);
        } catch (NumberFormatException e) {
            isRoman = true;
            a1 = RomanToArabic.convert(words[0]);
            b1 = RomanToArabic.convert(words[2]);
        }

        String operator = words[1];
        Calculator calculator = new Calculator();
        int result = calculator.calculate(a1, b1, operator);

        if (isRoman) {
            return ArabicToRoman.convert(result);
        } else {
            return String.valueOf(result);
        }
    }
}