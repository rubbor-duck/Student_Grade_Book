import java.util.*;

public class Main {

  // master student list
  ArrayList<Student> studentList = new ArrayList<>();
  // master assignment list
  ArrayList<Assignment> assignmentList = new ArrayList<>();

  Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
      Main app = new Main();
      
      int input = -1;

      while (input != 0){
        System.out.println("1: Select a student");
        System.out.println("2: Add a new student");
        System.out.println("3: Create a new assignment");
        System.out.println("4: Update an existing assignment");
        //TODO: Add a 5th optionn to delete an assignment
        System.out.println("0: Quit Program ");

        System.out.print("Select an option: ");
        
        input = app.userInput.nextInt();
        app.userInput.nextLine(); // Consume the leftover Enter key

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
            app.newAssignment();
            break;
          case 4:
            // Update an existing assignment
            app.updateAssignment();
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
    userInput.nextLine(); // Consume the leftover Enter key

    Student studentnew = new Student(firstname, lastname, age);

    studentList.add(studentnew);

    // Adds previous assignments to the new student
    for (Assignment assignment : assignmentList)
    {
      String name = assignment.getName();
      String desciption = assignment.getDescription();
      int totalpoints = assignment.getTotalPointsWorth();
      Assignment studentAssignment =
        new Assignment(name, desciption, totalpoints);
      studentnew.addAssignment(studentAssignment);
    }

    // Sorts students by their last name, then by their first name 
    studentList.sort(
      Comparator.comparing(Student::getLastName, String.CASE_INSENSITIVE_ORDER)
      .thenComparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER));
  }

  void selectStudent()
  {
    System.out.println("-- Student List --");
    for(Student student : studentList)
    {
      System.out.println(student.getFirstName() + " " + student.getLastName());
    }

    System.out.println("-- Student List --");

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

      //TODO: Add a line that says if they aren't able to find the student they are searching for
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
        System.out.println("5: Grade a Specific Assignment");
        System.out.println("0: Go Back to Main Menu");

        System.out.print("Select an option: ");
        
        input = userInput.nextInt();
        userInput.nextLine(); // Consume the leftover Enter key
        
        switch(input) {
          case 0:
            break;
          case 1:
            // Get student info
            System.out.println(selectedStudent.getFirstName() + " " + selectedStudent.getLastName() + ": Age " + selectedStudent.getAge());
            break;
          case 2:
            // Change student name
            System.out.print("What is the new first name: ");
            String firstname = userInput.nextLine();

            System.out.print("What is the new last name: ");
            String lastname = userInput.nextLine();

            selectedStudent.setName(firstname, lastname);
            System.out.println("Name has been changed");
            break;
          case 3:
            // Change student age
            System.out.print("What is the new age: ");
            int age = userInput.nextInt();
            userInput.nextLine(); // Consume the leftover Enter key

            selectedStudent.setAge(age);
            break;
          case 4:
            // Get student GPA
            System.out.println(selectedStudent.gpa());
            break;
          case 5:
            // Grade an assignment
            System.out.println("-- Assignment List --");
            for(Assignment assignment : assignmentList)
            {
              System.out.println(assignment.getName() + ": " + assignment.getPointsEarned() + "/" + assignment.getTotalPointsWorth());
            }
            
            System.out.println("-- Assignment List --");
            
            System.out.print("What is the assignment name: ");
            String assignmentQuery = userInput.nextLine();

            //searches for the assignment in the list
            for(int i = 0; i < selectedStudent.assignments.size(); i++)
            {
              Assignment assignment = selectedStudent.assignments.get(i);

              if (assignment.getName().equalsIgnoreCase(assignmentQuery))
              {
                System.out.println("The assignment is worth " + assignment.getTotalPointsWorth());
                System.out.print("How many points did the student earn: ");
                int pointsStudentEarned = userInput.nextInt();
                userInput.nextLine(); // Consume the leftover Enter key

                assignment.setPointsEarned(pointsStudentEarned);
              }
            }
            break;
          default:
            System.out.println("Please select a valid option");
          }
        }
    }
  
  void newAssignment()
  {
    System.out.print("Assignment name: ");
    
    String name = userInput.nextLine();

    System.out.print("Assignment description: ");
    
    String desciption = userInput.nextLine();

    System.out.print("Total points worth (ex. 40): ");
    
    int totalpoints = userInput.nextInt();
    userInput.nextLine(); // Consume the leftover Enter key

    Assignment newassignment = new Assignment(name, desciption ,totalpoints);

    // Adds the assignment to the master assignment list
    assignmentList.add(newassignment);
    
    for (Student student : studentList)
    {
      //Creates a specific assignment for the students, so that the points earned don't transfer to other students
      Assignment studentAssignment =
        new Assignment(name, desciption, totalpoints);

      student.addAssignment(studentAssignment);
    }
  }

  void updateAssignment()
  {
    System.out.println("-- Assignment List --");
    for(Assignment assignment : assignmentList)
    {
      System.out.println(assignment.getName() + ": " + assignment.getDescription());
    }
    
    System.out.println("-- Assignment List --");

    System.out.print("Assignment name to be updated: ");

    String name = userInput.nextLine();

    // For loop to check the name of every assignment to find a match
    for(int i = 0; i < assignmentList.size(); i++)
    {
      String assignmentName = assignmentList.get(i).getName();
      if (assignmentName.equalsIgnoreCase(name))
      {
        System.out.print("New name for assignment: ");
        String newName = userInput.nextLine();

        System.out.print("New description for assignment: ");
        String newDescription = userInput.nextLine();

        System.out.print("New total points: ");
        int newTotalPoints = userInput.nextInt();
        userInput.nextLine(); // Consume the leftover Enter key

        assignmentList.get(i).setName(newName);
        assignmentList.get(i).setDescription(newDescription);
        assignmentList.get(i).setTotalPointsWorth(newTotalPoints);

        System.out.println("Assignment Updated!");
        break;
      }

    }
  }
}
