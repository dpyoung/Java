//Name: Daniel Young
//Course: CS302
//Assignment: CPU Schedule Simulator
//Date Due: 3/19/2014 (MM/DD/YYYY)

/*"Team" Project:
* This file contains method for the class type "ScheduleSimulation"
* This project was daunting.
* However, due to my depressing past experiences with group projects in classwork, I have created this alone. 
* 
* Input is taken directly from the 'input_default.text' file provided. Any modifications to format must be accounted
*   for in the program. If NUMBER_OF_PROCESSES in CPU_Simulation does not match the first integer in the text document,
*   the discrepency should fix itself. If (number of lines in the file - 1) != first integer in the text document, the
*   program will fail to run. The array process_list will be populated incorrectly; resulting errors will vary.
* If the user decides to use his or her own input file, the name of the document must
*   be provided in the last method written to CPU_Simulation.java, and constants should be updated in that class 
*   accordingly. 
* If the user is so inclined, the time quantum for Round Robin may be modified in the CPU_Simulation file's list
*   of class variables. It defaults to a QUANTUM value of 10.
*/
import java.io.*;
import java.util.Scanner;

public class Sim
{

  /** Main Method. Can create a CPU_Simulation object and allows the user to select various options.
  */
  public static void main(String[] args)
  { 
   boolean nowExit = false;
   boolean userDetail = false;
   boolean userDefault = true;
   CPU_Simulation theSim = new CPU_Simulation();
   //This section of the code works for command-line arguments. I included a non-command-line user interface for
   // ease of use and user simplicity. If you desire file output as well ... just ask! =)
   if (args.length > 0)
   {
    String userSim = null;
    for (int indexI = 0; indexI < args.length; indexI++)
     {
       switch (args[indexI])
       {
         case "-d":
           userDetail = true;
           break;
         case "-a":
           userDefault = false;
           if(args[indexI+1].equals("RR"))
             {userSim = "RR";}
           else if (args[indexI+1].equals("FCFS"))
             {userSim = "FCFS";}
           else
           {
             System.out.println("User did not provide proper simulation title. Must select either RR or FCFS.");
           }
           break;
         default:
           {theSim.setInputFile(args[indexI]);}
           break;
       }
      }
      theSim.startSimulations(userDefault, userDetail, userSim); 
      nowExit = true;
    }
    
    
    String userString;
    //char userChar;
    //double userDouble;
    int userInt;
    char userChar;
    System.out.println("This program will give CPU scheduling simulations for FCFS and RR.");
    System.out.println("To process a new scheduling simulation, enter 'P'.");
    System.out.println("For help in using the program, please enter 'H'.");
    System.out.println("To exit, enter 'E'.");
    while (nowExit == false) //Main program loop for user input...
    {
      userDetail = false;
      userDefault = true;
      userString = getUserInput();
      //userChar = userString[0];
      switch (userString) 
      {
        case "e":
        case "E": 
        case "Exit":
        case "exit":
        case "quit":
        case "Quit":
        case "EXIT":
        case "QUIT":
          nowExit = true;
          break;
        case "H":
        case "h":
          helpfile();
          break;
        case "P":
        case "p":
           {
              System.out.println("Default option processes 2 simulations. Is this okay? (Y/N)");
              userString = getUserInput();
              switch(userString)
              {
                case "N":
                case "n":
                  userDefault = false;
                  System.out.println("1 Simulation shall be run; FCFS or RR.");
                  System.out.println("If you would like a detailed print-out of the processes, enter 'Y'."); 
                  System.out.println("Otherwise, enter 'N'.");
                  userString = getUserInput();
                  switch(userString)
                  {
                    case "Y":
                    case "y":
                      userDetail = true;
                      break;
                    default:
                      break;
                  }
                  break;
                default:
                  System.out.println("Default option selected. 2 Simulations shall be run; FCFS and RR.");
                  System.out.println("If you would like a detailed print-out of the processes, enter 'Y'."); 
                  System.out.println("Otherwise, enter 'N'.");
                  userString = getUserInput();
                  switch(userString)
                  {
                    case "Y":
                    case "y":
                      userDetail = true;
                      break;
                    default:
                      break;                    
                  }
                  break;
               }
              theSim.startSimulations(userDefault,userDetail,null); 
              System.out.println("Enter P to run another simulation, H for help, or E to exit.");
            }
          break; 
        default:
          System.out.println("Invalid entry. Please use 'H' for help.");
          break;
      }
    }
    //User exited loop with "E" or variant:
    System.out.println("Thank you! Have a nice day.");
    return;
  }
  
  
  //Precondition: user enters "h" or "H" into program's input.
  //Postcondition: user receives 'help', so to speak.
  public static void helpfile()
  { // el Danno was here
    System.out.println("To process an example of a CPU schedule, enter 'P'.");
    System.out.println("Default output will consist of total time required to execute, and CPU Utilization %.");
    System.out.println("Execute the default schedules by entering P, then Y, then N.");
    System.out.println("Arrival, Service, Waiting, and Turnaround Time is given with the 'detailed' output.");
    System.out.println("To receive detailed output for both simulations, enter P, then Y, then Y.");
    System.out.println("To view just one simulation, enter P, then N, then follow instructions.");
    System.out.println("To view this help again, enter 'H'.");
    System.out.println("To exit, enter 'E'.");
  }
  
  
  //Due to repetative nature of this code...
  public static String getUserInput()
  {
    String userStrng;
    Scanner keyboard = new Scanner(System.in);
    userStrng = keyboard.nextLine();
    return userStrng;
  }  

}