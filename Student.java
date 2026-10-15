
import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private int age;

    // assignment list for each student to store their individual grades
    ArrayList<Assignment> assignments = new ArrayList<Assignment>();

    public Student (String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int newAge){
        age = newAge;
    }

    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    }

    public String gpa()
    {
        // Calculates the grade into a gpa, then spits out the correct grade letter
        float totalgpa = 0;
        for (Assignment assignment : assignments)
        {
            totalgpa += assignment.calcuatedGrade();
        }

        totalgpa = (totalgpa / assignments.size());
        String gpaLetterAssignment;

        if (totalgpa < 1)
        {
            gpaLetterAssignment = (firstName + " has an F: GPA = " + totalgpa);
            return gpaLetterAssignment;
        }

        if (totalgpa < 2)
        {
            gpaLetterAssignment = (firstName + " has a D: GPA = " + totalgpa);
            return gpaLetterAssignment;
        }

        if (totalgpa < 3)
        {
            gpaLetterAssignment = (firstName + " has a C: GPA = " + totalgpa);
            return gpaLetterAssignment;
        }

        if (totalgpa < 3.5)
        {
            gpaLetterAssignment = (firstName + " has a B: GPA = " + totalgpa);
            return gpaLetterAssignment;
        }

        if (totalgpa <= 4)
        {
            gpaLetterAssignment = (firstName + " has an A: GPA = " + totalgpa);
            return gpaLetterAssignment;
        }

        String errorMessage = "You shouldn't have gotten this message. Something went wrong with the GPA function for Student.java";
        return errorMessage;
    }

}
