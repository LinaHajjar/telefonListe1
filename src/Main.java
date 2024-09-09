import java.io.IOException;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args)throws IOException {
            TelefonListe liste = FilHandler.readFromFile();
            Scanner input = new Scanner(System.in);
            hovedMenu(input, liste);
        }

        public static void hovedMenu(Scanner input, TelefonListe liste )throws IOException {

            System.out.println("   this is your menu: ");
            System.out.println("        1. Add a person and telephone number");
            System.out.println("        2. Print all the list.");
            System.out.println("        3. Find a person's number");
            System.out.println("        4. Delete a peron");
            System.out.println("        5. Search if a person is in the list");
            System.out.println("        6. End the program");


            int choice = UserInput.getIntInput("choose an option: ", "wrong input, only integers between 1 and 6", 1, 6);

            switch (choice){
                case 1: //done
                    System.out.println("you chose option 1: add a person:");
                    ListMethods.addPerson(input, liste);
                    hovedMenu(input, liste);
                    break;
                case 2: //done
                    System.out.println("you chose option 2: print all the list: ");
                    ListMethods.printList(input, liste);
                    hovedMenu(input, liste);
                case 3: //done
                    System.out.println("you chose option 3: Find a person's number");
                    ListMethods.searchNumber(input, liste);
                    hovedMenu(input, liste);
                    break;
                case 4:
                    System.out.println("you chose option 4: Delete a person: ");
                    ListMethods.deletePerson(input, liste);
                    hovedMenu(input, liste);
                    break;
                case 5:
                    System.out.println("you chose option 5: Search if a person is in the list" );
                    ListMethods.searchPerson(input, liste);
                    hovedMenu(input, liste);
                case 6: //done
                    System.exit(0);
                    break;
                default:
                    System.out.println("wrong input. only integers between 1 and 3");
                    break;

            }
        }//end of hovedMenu

    }

