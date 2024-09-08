
import java.util.Map;
import java.util.Scanner;

public class UserInput {

    public static int getIntInput(String promptMessage, String errorMessage, int minNum, int maxNum) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(promptMessage);
                userInput = Integer.parseInt(scanner.nextLine());
                validInput = true;
                if (minNum < maxNum && (userInput > maxNum || userInput < minNum)) {
                    System.out.println(errorMessage);
                    validInput = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        } while (!validInput);

        return userInput;
    }

    public static boolean containsIgnoreCase(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }

    /*public static boolean containsIgnoreCaseMap(TelefonListe liste, String name) {
        boolean returnValue=false;
        for (Map.Entry<String, String> m : liste.entrySet()) {
            if(m.getKey().toLowerCase().contains(name.toLowerCase())){
                returnValue= true;
            }
        }
        return returnValue;
    }//end of containsIgnoreCaseMap*/

}

