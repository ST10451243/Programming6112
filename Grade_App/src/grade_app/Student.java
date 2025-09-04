package grade_app;

public class Student extends ParentOfStudent {
    private String grade;
    private int[] marks;  // Array to store marks in different subjects
    private double average;
    
    // Constructor
    public Student(String name, String surname, int age, String studentID, String grade, int[] marks) {
        // Calls the parent constructor
        super(name, surname, age, studentID);
        this.grade = grade;
        this.marks = marks;
        this.average = calculateAverage();
    }
    
    // Method to calculate average
    public double calculateAverage() {
        // this will return 0 if there are no marks
        if (marks == null || marks.length == 0) {
            return 0;
        }
        
        int total = 0;
        // this adds up all the marks.
        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }
        return (double) total / marks.length;
    }
    
    public int getHighestMark() {
        // this will rturn 0 if there are no marks.
        if (marks == null || marks.length == 0) {
            return 0;
        }
        
        int highest = marks[0]; // Starts with the first mark.
        // what this will do sir, is that it will compare each mark with the highest mark
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }
    
    // Method to find the lowest mark
    public int getLowestMark() {
        if (marks == null || marks.length == 0) {
            return 0;
        }
        
        int lowest = marks[0]; 
        // Same as the comparison of the highest, only difference here is that it is comparing with the lowest.
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        return lowest;
    }
    
    // Getters
    public String getGrade() {
        return grade;
    }
    
    public int[] getMarks() {
        return marks;
    }
    
    public double getAverage() {
        return average;
    }
    
    // Setters
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public void setMarks(int[] marks) {
        this.marks = marks;
        this.average = calculateAverage(); // Recalculate average when marks change
    }
    
    // Method Overriding
    @Override
    public void display() {
        super.display();
        System.out.println("This is from the Child.");
        System.out.println("Name: " + name + " " + surname);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentID);
        System.out.println("Grade: " + grade);
        System.out.print("Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i]);
            if (i < marks.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        // Obviously prints average, highest and lowest marks.
        System.out.println("Average: " + String.format(" %.2f ", average)); // GeeksforGeeks for Java String format() Method. Link in word doc.
        System.out.println("Highest Mark: " + getHighestMark());
        System.out.println("Lowest Mark: " + getLowestMark());
        System.out.println("------------------------");
    }
}

