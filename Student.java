
import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    
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

    ArrayList<Assignment> assignments = new ArrayList<Assignment>();

    


}
