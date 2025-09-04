package grade_app;

public class Handler {
    private String Name;
    private String Surname;
    private String Grade;
    private int Age;
    private int Marks;
    private String StudentID;
   
 // Constructors
    public Handler(String Name, String Surname, String Grade, int Age, int Marks, String StudentID) {
        this.Name = Name;
        this.Surname = Surname;
        this.Grade = Grade;
        this.Age = Age;
        this.Marks = Marks;
        this.StudentID = StudentID;
    }
    
    //Getters
    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getGrade() {
        return Grade;
    }

    public int getAge() {
        return Age;
    }

    public int getMarks() {
        return Marks;
    }

    public String getStudentID() {
        return StudentID;
    }
    
    //Setters
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setMarks(int Marks) {
        this.Marks = Marks;
    }
      
}

