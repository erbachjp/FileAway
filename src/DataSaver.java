import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean addMoreRecords = true;

        int idCounter = 1;

        while (addMoreRecords) {
            String firstName = SafeInput.getNonZeroLenString(scanner, "First Name: ");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Last Name: ");
            String idNumber = String.format("%06d", idCounter++);
            String email = SafeInput.getNonZeroLenString(scanner, " Email: ");
            int yearOfBirth = SafeInput.getRangedInt(scanner, " birth year: ", 1000, 9999);
            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);
            System.out.print("add another record? (yes/no): ");
            String response = scanner.nextLine();
            addMoreRecords = response.equalsIgnoreCase("yes");
        }

        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }

        scanner.close();
    }
}
