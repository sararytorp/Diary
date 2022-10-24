import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryUtility {
    private static List<Entry> entriesFromJSON;
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Path path = Paths.get("src/main/resources/allWrittenEntries.json");

    static {
        try {
            entriesFromJSON = List.of(mapper.readValue(path.toFile(), Entry[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * användarens inlägg sparas till en json fil
     *
     * @throws IOException behövs för read och writeValue
     */
    public static void addEntryToJsonFile() throws IOException {
        entriesFromJSON = List.of(mapper.readValue(path.toFile(),
                Entry[].class));
        List<Entry> tempEntries = new ArrayList<>(entriesFromJSON);
        tempEntries.add(writeAnEntry());
        mapper.writerWithDefaultPrettyPrinter().writeValue
                (path.toFile(), tempEntries);
    }

    /**
     * Metod som tackar användaren och säger hejdå
     */
    public static void printGoodbyeMessage() {

        System.out.println("Thank you for using diary, hope to see you soon!");
    }

    /**
     * Metod som skriver ut menyval till användaren
     */
    public static void printMenuChoices() {
        System.out.println("1. Read your entries \n" +
                "2. Write a new entry \n" +
                "3. Turn off the program");
    }

    /**
     * @throws IOException behövs för readValue
     *                     denna metod läser upp inläggen från JSON-filen
     */
    public static void readAllEntries() throws IOException {

        List<Entry> allJsonEntries = List.of(mapper.readValue(path.toFile(), Entry[].class));

        for (Entry entry : allJsonEntries) {
            System.out.println("Title: " + entry.getTitleOfEntry());
            System.out.println("Entry: " + entry.getContentOfEntry());
            System.out.println("Date: " + entry.getDateOfEntry() + "\n");
        }
    }

    /**
     * Användaren skriver ett inlägg
     *
     * @return värdena på strängarna retuneras i som ett inlägg
     */
    private static Entry writeAnEntry() {

        System.out.println("Write a title:");
        String titleOfEntry = scanner.nextLine();
        System.out.println("Write an entry:");
        String contentOfEntry = scanner.nextLine();
        String dateOfEntry = LocalDate.now().toString();
        System.out.println("\n" + "Todays entry:");
        System.out.println(titleOfEntry + "\n" + contentOfEntry + "\n" + dateOfEntry + "\n");
        return new Entry(titleOfEntry, contentOfEntry, dateOfEntry);
    }
}
