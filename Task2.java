import java.util.*;
//STUDENT RECORD MANAGEMENT SYSTEM CREATED BY RISHIRAAM GOPINATH
//BY CALLING METHODS FOR CRUD OPERATIONS ON THE STUDENT DATABASE
class Student {
    int id;
    String name;
    int marks;

    public Student(int id, String name, int  marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

public class Task2 {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    //CREATE
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student "+ id + "\'s Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student "+ id + "\'s  Marks: ");
        int marks = sc.nextInt();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student "+ id +" added successfully!");
    }

    //READ
    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("Displaying Student List: ");
        System.out.println("Student ID\tStudent Name\tStudent Marks");
        for (Student s : studentList) {
            System.out.println(+ s.id + "\t\t"+ s.name + "\t\t" + s.marks);
        }
    }

    //UPDATE
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                name = name.trim();
                if (!name.isEmpty()) {
                    s.setName(name);
                }

                System.out.print("Enter new marks (Enter -1 to skip): ");
                int marks = sc.nextInt();
                if (marks >= 0) {
                    s.setMarks(marks);
                }
                System.out.println("Student "+ id + " updated!");
                return;
            }
        }
        System.out.println("Student "+ id +" not found!");
    }

    //DELETE
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Student "+ id +" deleted!");
                return;
            }
        }
        System.out.println("Student "+ id +" not found!");
    }

    //MAIN
    public static void main(String[] args) {

        System.out.println("Welcome to Student Record Management System using JAVA");

        while (true) {
            
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your option (1-5): ");
            int option = sc.nextInt();
            
            if (option == 5) {
                System.out.println("Exiting Student Record Management System");
                break;
            }
            if(option > 5 || option < 1 ){
                System.out.println("Invalid Option. Select again\n\n");
                continue;
            }

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
            }
            System.out.println();
        }
    }
}

