package AdmissionManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthManager authManager = new AuthManager();
        FileManager fileManager = new FileManager();

        boolean isAuthenticated = false;

        System.out.println("===================================================");
        System.out.println("       WELCOME TO ADMISSION MANAGEMENT SYSTEM      ");
        System.out.println("===================================================");

        while (!isAuthenticated) {
            System.out.println("\n[ Security Check ]");
            System.out.print("Enter Officer Username : ");
            String username = scanner.nextLine();

            System.out.print("Enter Officer Password : ");
            String password = scanner.nextLine();

            if (authManager.authenticate(username, password)) {
                System.out.println("\n[+] Access Granted! System Booting Up...\n");
                isAuthenticated = true;
            } else {
                System.out.println("\n[-] Access Denied! Incorrect credentials. Try again.");
            }
        }

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===================================================");
            System.out.println("               OFFICER DASHBOARD                   ");
            System.out.println("===================================================");
            System.out.println("1. Add New Student");
            System.out.println("2. Search Student Info");
            System.out.println("3. Assign Course to Student");
            System.out.println("4. View Advised Courses");
            System.out.println("5. Logout & Exit");
            System.out.print("\nSelect an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- ADD NEW STUDENT ---");
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Program: ");
                    String program = scanner.nextLine();
                    System.out.print("Enter Batch: ");
                    String batch = scanner.nextLine();
                    System.out.print("Enter Initial Password: ");
                    String pass = scanner.nextLine();
                    System.out.print("Enter CGPA: ");
                    double cgpa = scanner.nextDouble();
                    scanner.nextLine();

                    Student newStudent = new Student(id, name, program, batch, pass, cgpa);
                    fileManager.saveStudent(newStudent);
                    break;

                case 2:
                    System.out.println("\n--- SEARCH STUDENT ---");
                    System.out.print("Enter Student ID to Search: ");
                    String searchId = scanner.nextLine();

                    Student foundStudent = fileManager.searchStudentById(searchId);

                    if (foundStudent != null) {
                        System.out.println("\n[SUCCESS] Record Found!");
                        foundStudent.displayStudentInfo();
                    } else {
                        System.out.println("\n[ERROR] No student found with ID: " + searchId);
                    }
                    break;

                case 3:
                    System.out.println("\n--- ASSIGN COURSE ---");
                    System.out.print("Enter Student ID: ");
                    String assignId = scanner.nextLine();

                    if (fileManager.searchStudentById(assignId) != null) {
                        System.out.print("Enter Course Code/Name (e.g., MAT261, DSA): ");
                        String courseName = scanner.nextLine();
                        fileManager.assignCourse(assignId, courseName);
                    } else {
                        System.out.println("\n[ERROR] Cannot assign course. No student found with ID: " + assignId);
                    }
                    break;

                case 4:
                    System.out.println("\n--- VIEW ADVISED COURSES ---");
                    System.out.print("Enter Student ID to view courses: ");
                    String courseSearchId = scanner.nextLine();
                    fileManager.displayAdvisedCourses(courseSearchId);
                    break;

                case 5:
                    System.out.println("\nLogging out... Have a great day!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("\n[!] Invalid Option! Please choose a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
