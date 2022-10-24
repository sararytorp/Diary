import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Welcome to your diary, please choose one of the options between 1-3:");
            EntryUtility.printMenuChoices();
            option = scanner.nextInt();
            switch (option) {
                case 1:

                    EntryUtility.readAllEntries();

                break;
                case 2:
                    EntryUtility.addEntryToJsonFile();
                    break;

                case 3: //Stänger av programmet!
                    break;

                case 4:
                default:
                    System.out.println("Wrong choice, pick a number between 1-3!");

            }
        } while (option != 3);

        EntryUtility.printGoodbyeMessage();


    }
}
