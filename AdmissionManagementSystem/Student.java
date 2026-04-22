package AdmissionManagementSystem;
public class Student {

    private String id;
    private String name;
    private String program;
    private String batch;
    private String password;
    private double cgpa;

    public Student(String id, String name, String program, String batch, String password, double cgpa) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.batch = batch;
        this.password = password;
        this.cgpa = cgpa;
    }

    // Getter Methods
    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getProgram() { return this.program; }
    public String getBatch() { return this.batch; }
    public String getPassword() { return this.password; }
    public double getCgpa() { return this.cgpa; }

    // Displays student information excluding the password
    public void displayStudentInfo() {
        System.out.println("---------------------------------------------------");
        System.out.println("Student ID    : " + this.id);
        System.out.println("Student Name  : " + this.name);
        System.out.println("Program       : " + this.program);
        System.out.println("Batch         : " + this.batch);
        System.out.println("CGPA          : " + this.cgpa);
        System.out.println("---------------------------------------------------");
    }
}