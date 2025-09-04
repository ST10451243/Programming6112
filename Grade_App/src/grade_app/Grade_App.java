package grade_app;
import java.util.Scanner;

public class Grade_App {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many students do you want to enter? ");
        int numberOfStudents = input.nextInt();
        
        // Created an array where the students will be stored.
        Student[] students = new Student[numberOfStudents];
        
        // Where student info will be inputted
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("--- Enter details for Student " + (i + 1) + " ---");
            
            System.out.print("Enter student name: ");
            String name = input.next();
            
            System.out.print("Enter student surname: ");
            String surname = input.next();
            
            System.out.print("Enter student age: ");
            int age = input.nextInt();
            
            System.out.print("Enter student ID: ");
            String studentID = input.next();
            
            System.out.print("Enter student grade (e.g. Grade 11): ");
            input.nextLine(); // Clears
            String grade = input.nextLine();
            
            System.out.print("How many subjects does this student have? ");
            int numberOfSubjects = input.nextInt();
            
            // Created marks array for the students.
            int[] marks = new int[numberOfSubjects];
            
            // Inputting marks for each subject
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print("Enter mark for subject " + (j + 1) + " : ");
                marks[j] = input.nextInt();
            }
            
            // Created a student object and stored in array
            students[i] = new Student(name, surname, age, studentID, grade, marks);
        }
        
        System.out.println("========================================");
        System.out.println("Student Grade Report");
        System.out.println("========================================");
        System.out.println();
        
        // Displays all students information using method overloading and overriding
        System.out.println("Individual Student Report:");
        System.out.println("---------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + " : ");
            students[i].display();
            students[i].display(students[i].getMarks().length);
            System.out.println(students[i].getName() + " " + students[i].getSurname() + " : Average = " + String.format("%.2f", students[i].getAverage())); // GeeksforGeeks for Java String format() Method. Link in word doc.
            System.out.println();
        }
        
        System.out.println();
        System.out.println("========================================");
        System.out.println("Class Statistics");
        System.out.println("========================================");
        
        // This finds the student with highest average
        double highestAverage = students[0].getAverage();
        String topStudent = students[0].getName() + " " + students[0].getSurname();
        
        // This finds the student with lowest average
        double lowestAverage = students[0].getAverage();
        String bottomStudent = students[0].getName() + " " + students[0].getSurname();
        
        // Calculates the class average
        double totalClassAverage = 0;
        
        for (int i = 0; i < students.length; i++) {
            double currentAverage = students[i].getAverage();
            totalClassAverage = totalClassAverage + currentAverage;
            
            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                topStudent = students[i].getName() + " " + students[i].getSurname();
            }
            
            if (currentAverage < lowestAverage) {
                lowestAverage = currentAverage;
                bottomStudent = students[i].getName() + " " + students[i].getSurname();
            }
        }
        
        double classAverage = totalClassAverage / students.length;
        
        System.out.println("Total number of students: " + students.length);
        System.out.println("Class Average: " + String.format("%.2f", classAverage)); // // GeeksforGeeks for Java String format() Method. Link in word doc.
        System.out.println("Highest Individual Average: " + String.format("%.2f", highestAverage) + " (" + topStudent +")"); // GeeksforGeeks for Java String format() Method. Link in word doc.
        System.out.println("Lowest Individual Average: " + String.format("%.2f", lowestAverage) + " (" + bottomStudent +")"); // GeeksforGeeks for Java String format() Method. Link in word doc.
        
        // This sir is able to find the overall highest and lowest marks from all the students
        int overallHighest = students[0].getHighestMark();
        int overallLowest = students[0].getLowestMark();
        String highestMarkStudent = students[0].getName() + " " + students[0].getSurname();
        String lowestMarkStudent = students[0].getName() + " " + students[0].getSurname();
        
        for (int i = 0; i < students.length; i++) {
            int studentHighest = students[i].getHighestMark();
            int studentLowest = students[i].getLowestMark();
            
            if (studentHighest > overallHighest) {
                overallHighest = studentHighest;
                highestMarkStudent = students[i].getName() + " " + students[i].getSurname();
            }
            
            if (studentLowest < overallLowest) {
                overallLowest = studentLowest;
                lowestMarkStudent = students[i].getName() + " " + students[i].getSurname();
            }
        }
        
        System.out.println("Highest Mark in Class: " + overallHighest + " (" + highestMarkStudent + ")");
        System.out.println("Lowest Mark in Class: " + overallLowest + " (" + lowestMarkStudent + ")");
        
        System.out.println();
        System.out.println("========================================");
        System.out.println("END OF REPORT");
        System.out.println("========================================");
        
        input.close();
    }
}

