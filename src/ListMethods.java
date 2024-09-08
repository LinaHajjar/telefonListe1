import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.FileHandler;

public class ListMethods {

    public static void addPerson(Scanner input, TelefonListe liste)throws IOException {
        System.out.print("Indtast navn: ");
        String navn = input.nextLine();
        System.out.print("Indtast telefonnummer: ");
        String nummer = input.nextLine();
        liste.addPerson(navn, nummer);
        FilHandler.writeToFile(liste);
        System.out.println("Do you want to add more persons/numbers? yes/no");
        String answer = input.nextLine();
        if(UserInput.containsIgnoreCase("yes", answer)) {
            addPerson(input, liste);
        }


    }//end of addPerson

    public static void printList(Scanner input, TelefonListe liste){
        System.out.println("Do you want to see the list in the ascending alphabetic order? yes/no");
        String answer = input.nextLine();
        if(UserInput.containsIgnoreCase("yes", answer)) {
        //I create a Treeset in sted of Mapset and copy the elements from Map to Tree so I have them sorted in ascending alphabetic order
            TreeMap<String, String> sortedListe = new TreeMap<>();
             for (Map.Entry<String, String> m: liste.entrySet()){
                 sortedListe.put(m.getKey(), m.getValue());
                }
             for (Map.Entry<String, String> m : sortedListe.entrySet()) {
                 System.out.println(m.getKey() + ": " + m.getValue());
             }

        }
        else {
            for (Map.Entry<String, String> m : liste.entrySet()) {
                System.out.println(m.getKey() + ": " + m.getValue());
            }
        }
    }//end of printList

    public static void searchNumber(Scanner input, TelefonListe liste){
        System.out.print("what is the name of the person you want to finde the telephone number: ");
        String name= input.nextLine();
        Map<String, String> matchingNames = new HashMap<>();
        for (Map.Entry<String, String> m : liste.entrySet()) {
            if (m.getKey().toLowerCase().contains(name.toLowerCase())) {
                matchingNames.put(m.getKey(),m.getValue());
            }
        }

        if (matchingNames.isEmpty()) {
            System.out.println("The name you are searching for was not found in your list.");
        } else if (matchingNames.size() == 1) {
            String nummer = matchingNames.values().iterator().next();
            System.out.println("The number of " + matchingNames.keySet().iterator().next() + " is: " + nummer);
        } else {
            System.out.println("Multiple matches found:");
            int i = 1;
            for (Map.Entry<String, String> entry : matchingNames.entrySet()) {
                System.out.println(i + ": " + entry.getKey() + ": " + entry.getValue());
                i++;
            }

            System.out.print("Choose the name you want to find the number for: ");
            String chosenName = input.nextLine();

            if (matchingNames.containsKey(chosenName)) {
                String nummer = matchingNames.get(chosenName);
                System.out.println("The number of " + chosenName + " is: " + nummer);
            } else {
                System.out.println("The chosen name was not found in the list.");
            }
        }
    }//end of searchNumber

    public static void deletePerson(Scanner input, TelefonListe liste) throws IOException{
        System.out.print("write the name you want to delete: ");
        String name = input.nextLine();
        liste.deletePerson(name);
        System.out.println("Personen blev slettet.");
        FilHandler.writeToFile(liste);

    }//end of deletePerson

    public static void searchPerson(Scanner input, TelefonListe liste) {
        System.out.print("Write the name you want to check: ");
        String name = input.nextLine();

        Map<String, String> matchingNames = new HashMap<>();
        for (Map.Entry<String, String> entry : liste.entrySet()) {
            if (entry.getKey().toLowerCase().contains(name.toLowerCase())) {
                matchingNames.put(entry.getKey(), entry.getValue());
            }
        }

        if (matchingNames.isEmpty()) {
            System.out.println("The name you are searching for was not found in your list.");
        } else if (matchingNames.size() == 1) {
            System.out.println("One match found: " + matchingNames.keySet().iterator().next());
        } else {
            System.out.println("Multiple matches found:");
            int i=1;
            for (Map.Entry<String, String> entry : matchingNames.entrySet()) {
                System.out.println(i + ": "+entry.getKey() + ": " + entry.getValue());
                i++;
            }

        }
    } // end of searchPerson

}

