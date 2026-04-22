package AdmissionManagementSystem;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {

    private static final String STUDENT_FILE = "src/AdmissionManagementSystem/students_db.txt";
    private static final String COURSE_FILE = "src/AdmissionManagementSystem/courses_db.txt";

    public void saveStudent(Student student) {
        try {
            FileWriter writer = new FileWriter(STUDENT_FILE, true);
            String dataLine = student.getId() + "," + student.getName() + "," +
                    student.getProgram() + "," + student.getBatch() + "," +
                    student.getPassword() + "," + student.getCgpa() + "\n";
            writer.write(dataLine);
            writer.close();
            System.out.println("\n[SUCCESS] Student successfully saved to database!");
        } catch (Exception e) {
            System.out.println("\n[ERROR] Failed to save student: " + e.getMessage());
        }
    }

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

    public void assignCourse(String studentId, String courseName) {
        try {
            FileWriter writer = new FileWriter(COURSE_FILE, true);
            writer.write(studentId + "," + courseName + "\n");
            writer.close();
            System.out.println("\n[SUCCESS] Course '" + courseName + "' assigned to Student ID: " + studentId);
        } catch (Exception e) {
            System.out.println("\n[ERROR] Failed to assign course: " + e.getMessage());
        }
    }

    public void displayAdvisedCourses(String studentId) {
        try {
            File file = new File(COURSE_FILE);
            if (!file.exists()) {
                System.out.println("\n[-] No courses advised for this ID yet.");
                return;
            }
            Scanner scanner = new Scanner(file);
            boolean found = false;

            System.out.println("\n--- Advised Courses for ID: " + studentId + " ---");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 2 && data[0].equals(studentId)) {
                    System.out.println("📌 " + data[1]);
                    found = true;
                }
            }
            scanner.close();

            if (!found) {
                System.out.println("[-] No courses found for this student.");
            }
            System.out.println("---------------------------------------");
        } catch (Exception e) {
            System.out.println("\n[ERROR] Database read error: " + e.getMessage());
        }
    }
}