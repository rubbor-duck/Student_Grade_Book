import java.util.*;

public class Main {

  ArrayList<Student> studentList = new ArrayList<Student>();

  Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      
      int input = -1;

      while (input != 0){
        System.out.println("1: Select a student");
        System.out.println("2: Add a new student");
        System.out.println("3: Create a new assignment");
        System.out.println("4: Update an existing assignment");
        System.out.println("0: Quit Program ");

        System.out.print("Select an option: ");
        
        input = userInput.nextInt();

        switch(input) {
          case 0:
            System.out.println("Have a good day!");
            break;
          case 1:
            // Select a Student
            selectStudent();
            break;
          case 2:
            // Add a new student
            newStudent();
            break;
          case 3:
            // Create a new assignment
            break;
          case 4:
            // Update an existing assignment
            break;
          default:
            System.out.println("Please select a valid option");
        }
      }  

  }

  void newStudent()
  {
    System.out.print("What is the student's first name: ");

    String firstname = userInput.nextLine();

    System.out.print("What is the student's last name: ");

    String lastname = userInput.nextLine();

    System.out.print("What is the student's age: ");

    int age = userInput.nextInt();

    Student studentnew = new Student(firstname, lastname, age);

    studentList.add(studentnew);

    // Sorts students by their last name, then by their first name 
    studentList.sort(
      Comparator.comparing(Student::getLastName, String.CASE_INSENSITIVE_ORDER)
      .thenComparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER));
  }

  void selectStudent()
  {
    System.out.print("What is the last name of the Student you want to see: ");
    
    String lastName = userInput.nextLine();

    for(int i = 0; i < studentList.size(); i++)
    {
      String studentLastName = studentList.get(i).getLastName();
      if (studentLastName.equalsIgnoreCase(lastName))
      {
        menuStudent(studentList.get(i));
        break;
      }
    }
  }

  void menuStudent(Student selectedStudent)
  {
    int input = -1;

    while (input != 0){
        System.out.println("1: Select a student");
        System.out.println("2: Add a new student");
        System.out.println("3: Create a new assignment");
        System.out.println("4: Update an existing assignment");
        System.out.println("0: Quit Program ");

        System.out.print("Select an option: ");
        
        input = userInput.nextInt();

        switch(input) {
          case 0:
            System.out.println("Have a good day!");
            break;
          case 1:
            // Select a Student
            selectStudent();
            break;
          case 2:
            // Add a new student
            newStudent();
            break;
          case 3:
            // Create a new assignment
            break;
          case 4:
            // Update an existing assignment
            break;
          default:
            System.out.println("Please select a valid option");
        }
  }
  
}
