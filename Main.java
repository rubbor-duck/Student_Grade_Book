import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner myObj = new Scanner(System.in);
      int input = 1;

      while (input != 0){
        System.out.println("1: ");
        System.out.println("2: ");
        System.out.println("3: ");
        System.out.println("0: Quit Program ");

        System.out.print("Select an option: ");
        
        input = myObj.nextInt();

        switch(input) {
          case 0:
            System.out.println("Have a good day!");
            break;
          case 1:
            System.out.println("Option 1 has been selected");
            break;
          case 2:
            System.out.println("Option 2 has been selected");
            break;
          case 3:
            System.out.println("Option 3 has been selected");
            break;
          default:
            System.out.println("Please select a valid option");
        }
      }  

  }

  void newStudent()
  {

  }
}
