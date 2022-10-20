import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodsToUseInMainMenu {
    static List<Entry> entries;
    static List<Entry> tempEntries = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();
    static Scanner scanner = new Scanner(System.in);
    static Entry entry = new Entry();
    static String path = "src/main/resources/allWrittenEntries.json";

    /**
     *
     * @throws IOException det behövs när man har ett read eller writeValue
     */
    public static void writeAnEntryAndPlaceInJson() throws IOException {


        entries = List.of(mapper.readValue(Paths.get(path).toFile(),
                Entry[].class));

        tempEntries.addAll(entries);


        System.out.println("Write a title:");
        String titleOfEntry = scanner.nextLine();
        entry.setTitleOfEntry(titleOfEntry);


        System.out.println("Write an entry:");
        String contentOfEntry = scanner.nextLine();
        entry.setContentOfEntry(contentOfEntry);

        String dateOfEntry = LocalDate.now().toString();
        entry.setDateOfEntry(dateOfEntry);


        tempEntries.add(entry);


        mapper.writerWithDefaultPrettyPrinter().writeValue
                (Paths.get(path).toFile(), tempEntries);

        System.out.println("\n" + "Your most recent entry: " + "\n"
                + entry.getTitleOfEntry() + "\n"
                + entry.getContentOfEntry() + "\n"
                + entry.getDateOfEntry());
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
     *
     * @throws IOException behövs för readValue
     * denna metod läser upp inläggen från JSON-filen
     */
    public static void readAllEntries() throws IOException {

        ObjectMapper newMapper = new ObjectMapper();

        File jsonEntries = new File(path);
        List<Entry> allJsonEntries = newMapper.readValue(jsonEntries, new TypeReference<>() {});

            for (Entry e : allJsonEntries) {
                System.out.println("Title: " + e.getTitleOfEntry());
                System.out.println("Entry: " + e.getContentOfEntry());
                System.out.println("Date: " + e.getDateOfEntry() + "\n");
            }



    }
}
