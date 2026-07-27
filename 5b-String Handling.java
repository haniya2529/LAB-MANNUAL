import java.util.Scanner;

public class StringAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int special = 0;

        String vowelChars = "";
        String consonantChars = "";
        String digitChars = "";
        String specialChars = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);

                if (lower == 'a' || lower == 'e' || lower == 'i' ||
                    lower == 'o' || lower == 'u') {
                    vowels++;
                    vowelChars += ch + ", ";
                } else {
                    consonants++;
                    consonantChars += ch + ", ";
                }
            } else if (Character.isDigit(ch)) {
                digits++;
                digitChars += ch + ", ";
            } else if (!Character.isWhitespace(ch)) {
                special++;
                specialChars += ch + ", ";
            }
        }

        // Remove trailing comma and space
        if (!vowelChars.isEmpty())
            vowelChars = vowelChars.substring(0, vowelChars.length() - 2);

        if (!consonantChars.isEmpty())
            consonantChars = consonantChars.substring(0, consonantChars.length() - 2);

        if (!digitChars.isEmpty())
            digitChars = digitChars.substring(0, digitChars.length() - 2);

        if (!specialChars.isEmpty())
            specialChars = specialChars.substring(0, specialChars.length() - 2);

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + special);

        System.out.println("\nBreakdown for \"" + str + "\":");
        System.out.println("● Vowels: " + vowelChars + " → " + vowels);
        System.out.println("● Consonants: " + consonantChars + " → " + consonants);
        System.out.println("● Digits: " + digitChars + " → " + digits);
        System.out.println("● Special Characters: " + specialChars + " → " + special);

        sc.close();
    }
}
