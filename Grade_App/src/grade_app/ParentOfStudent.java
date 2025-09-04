package grade_app;

public class ParentOfStudent {
    String name;
    String surname;
    int age;
    String studentID;
    
    // Constructor
    public ParentOfStudent(String name, String surname, int age, String studentID) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.studentID = studentID;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    // Method to display --- Method Overloading
    public void display() {
        System.out.println("This is from Parent");
    }
    
    public void display(int subjects) {
        System.out.println("I have " + subjects + " subjects");
    }
}

