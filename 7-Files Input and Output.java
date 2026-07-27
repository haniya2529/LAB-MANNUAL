import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int marks;
}

public class StudentRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[3];

        System.out.println("Enter Details of 3 Students\n");

        for (int i = 0; i < 3; i++) {
            students[i] = new Student();

            System.out.println("Student " + (i + 1));

            System.out.print("Roll No : ");
            students[i].rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Name : ");
            students[i].name = sc.nextLine();

            System.out.print("Marks : ");
            students[i].marks = sc.nextInt();

            System.out.println();
        }

        System.out.println("Student records saved successfully.");
        System.out.println("----- Student Records -----");

        for (Student s : students) {
            System.out.println(s.rollNo + "," + s.name + "," + s.marks);
        }

        System.out.print("\nEnter Roll Number to Search : ");
        int searchRoll = sc.nextInt();

        boolean found = false;

        for (Student s : students) {
            if (s.rollNo == searchRoll) {
                System.out.println("\nStudent Found\n");
                System.out.println("Roll No : " + s.rollNo);
                System.out.println("Name : " + s.name);
                System.out.println("Marks : " + s.marks);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nStudent Not Found");
        }

        sc.close();
    }
}
