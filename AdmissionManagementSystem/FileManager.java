package AdmissionManagementSystem;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {

    // Defines the exact path to the students database file based on your folder structure
    private static final String STUDENT_FILE = "src/AdmissionManagementSystem/students_db.txt";

    // Appends a new student record to the database file
    public void saveStudent(Student student) {
        try {
            FileWriter writer = new FileWriter(STUDENT_FILE, true); // 'true' enables append mode

            String dataLine = student.getId() + "," +
                    student.getName() + "," +
                    student.getProgram() + "," +
                    student.getBatch() + "," +
                    student.getPassword() + "," +
                    student.getCgpa() + "\n";

            writer.write(dataLine);
            writer.close();

            System.out.println("\n[SUCCESS] Student successfully saved to database!");

        } catch (Exception e) {
            System.out.println("\n[ERROR] Failed to save student: " + e.getMessage());
        }
    }

    // Searches for a student by ID and returns a Student object if found
    public Student searchStudentById(String searchId) {
        try {
            File file = new File(STUDENT_FILE);
            if (!file.exists()) return null;

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 6 && data[0].equals(searchId)) {
                    scanner.close();
                    return new Student(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]));
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("\n[ERROR] Database read error: " + e.getMessage());
        }
        return null;
    }
}