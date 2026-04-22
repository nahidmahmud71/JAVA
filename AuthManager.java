package AdmissionManagementSystem;
import java.io.File;
import java.util.Scanner;

public class AuthManager {

    // Defines the exact path to the credentials database file based on your folder structure
    private static final String CREDENTIALS_FILE = "src/AdmissionManagementSystem/admin_credentials.txt";

    // Validates the provided credentials against the stored records
    public boolean authenticate(String inputUsername, String inputPassword) {
        try {
            File file = new File(CREDENTIALS_FILE);

            if (!file.exists()) {
                System.out.println("[!] System Error: Database file not found at " + CREDENTIALS_FILE);
                return false;
            }

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] credentials = line.split(",");

                if (credentials.length == 2) {
                    String dbUser = credentials[0].trim();
                    String dbPass = credentials[1].trim();

                    if (dbUser.equals(inputUsername) && dbPass.equals(inputPassword)) {
                        fileScanner.close();
                        return true; // Authentication successful
                    }
                }
            }
            fileScanner.close();

        } catch (Exception e) {
            System.out.println("[!] System Error: " + e.getMessage());
        }

        return false; // Authentication failed
    }
}