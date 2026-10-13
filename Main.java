import java.util.*;

public class Main {

  ArrayList<Student> studentList = new ArrayList<Student>();

  Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
      Main app = new Main();
      
      int input = -1;

      while (input != 0){
        System.out.println("1: Select a student");
        System.out.println("2: Add a new student");
        System.out.println("3: Create a new assignment");
        System.out.println("4: Update an existing assignment");
        System.out.println("5: Update a Student's Grade");
        System.out.println("0: Quit Program ");

        System.out.print("Select an option: ");
        
        input = app.userInput.nextInt();

        switch(input) {
          case 0:
            System.out.println("Have a good day!");
            break;
          case 1:
            // Select a Student
            app.selectStudent();
            break;
          case 2:
            // Add a new student
            app.newStudent();
            break;
          case 3:
            // Create a new assignment
            break;
          case 4:
            // Update an existing assignment
            break;
          case 5:
            // Update a student's grade
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
        System.out.println("1: Get Student Info");
        System.out.println("2: Change Student Name");
        System.out.println("3: Change Student Age");
        System.out.println("4: Student's GPA");
        System.out.println("5: Grade on Specific Assignment");
        System.out.println("0: Go Back to Main Menu");

        System.out.print("Select an option: ");
        
        input = userInput.nextInt();

        switch(input) {
          case 0:
            System.out.println("Have a good day!");
            break;
          case 1:
            System.out.println(selectedStudent.getFirstName() + " " + selectedStudent.getLastName() + ": Age" + selectedStudent.getAge());
            break;
          case 2:
            System.out.print("What is the new first name: ");
            String firstname = userInput.nextLine();

            System.out.print("What is the new last name: ");
            String lastname = userInput.nextLine();

            selectedStudent.setName(firstname, lastname);
            System.out.println("Name has been changed");
            break;
          case 3:
            System.out.print("What is the new age: ");
            int age = userInput.nextInt();

            selectedStudent.setAge(age);
            break;
          case 4:
            //TODO: Add way to calculate student GPA
            break;
          case 5:
            System.out.print("What is the assignment name: ");
            String assignmentQuery = userInput.nextLine();

            for(int i = 0; i < selectedStudent.assignments.size(); i++)
            {
              Assignment assignment = selectedStudent.assignments.get(i);

              if (assignment.getName().equalsIgnoreCase(assignmentQuery))
              {
                System.out.println("The assignment is worth " + assignment.getTotalPointsWorth());
                System.out.print("How many points did the student earn: ");
                int pointsStudentEarned = userInput.nextInt();

                assignment.setPointsEarned(pointsStudentEarned);
              }
            }
            break;
          default:
            System.out.println("Please select a valid option");
          }
        }
    }
  }
