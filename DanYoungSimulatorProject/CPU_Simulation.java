//Name: Daniel Young
//Course: CS302
//Assignment: CPU Schedule Simulator
//Date Due: 3/19/2014 (MM/DD/YYYY)
//
//This file contains methods and variables associated with the "CPU_Simulation" class and its objects.
//The majority of the magic takes place here.

import java.io.*;
import java.util.*;

public class CPU_Simulation
{
  public static String file = "input_default.txt"; //do not change, except through command line arguments.
  public static int NUMBER_OF_PROCESSES = 30; //In case of a change to input_default.txt! Originally a constant.
  public static final int QUANTUM = 10; //For Round Robin sheduling; for input_default.txt, value <=10 recommended.
  
  public static final int FIRST_COME_FIRST_SERVE = 0; // DO NOT CHANGE!
  public static final int ROUND_ROBIN = 1;  // DO NOT CHANGE!
  
  public static int context_switch_time = 5; //Assumed CST; updated by input_default.txt upon reading.
  public static Process_[] process_list; //Array of Processes_ to work with. DO NOT MODIFY
  public static int total_processing_time = 0; //Total time spent working with processes; not wait/CS time
  public static int clock = 0; //clocks. Keeps track of time. Should start at 0, like a stopwatch.
  
  CPU_Simulation() //constructor? I guess?
  {
    //intentionally left blank
  }
  
  //"startSimulations"
  //Precondition: User passes boolean values for whether the simulation runs twice and whether the output is detailed.
  //Postcondition: if the first parameter is false, an option of which simulation to run is provided.
  //               Otherwise, both simulations are run, with their answer to "detailed output" passed.
  public void startSimulations(boolean default_y_n, boolean detailed_y_n, String sim_to_run)
  {
    if (default_y_n == false)
    {
      if (sim_to_run != null && sim_to_run.equals("RR"))
      {
        System.out.println("Simulating Round-Robin");
        simulate(ROUND_ROBIN, detailed_y_n);
        sim_to_run = null;
      }
      else if (sim_to_run != null && sim_to_run.equals("FCFS"))
      {
        System.out.println("Simulating Default First-Come, First-Served");
        simulate(FIRST_COME_FIRST_SERVE, detailed_y_n);
        sim_to_run = null;
      }
      else
      {
       sim_to_run = null;
       System.out.println("Enter 'FCFS' or 'RR' to run a simulation. Enter any other string to cancel.");
       boolean nowContinue = false;    
       while (nowContinue == false) // I realize this is an unnecessary while loop; left in for adaptability.
       {
         Scanner keyboard = new Scanner(System.in);
         String userString = keyboard.nextLine();
         //userChar = userString[0];
         switch (userString) 
         {
         case "fcfs":
         case "FCFS": 
         case "first-come first-serve":
         case "FirstComeFirstServe":
         case "first come first serve":
           simulate(FIRST_COME_FIRST_SERVE, detailed_y_n);
           //execute following code for FCFS:
           nowContinue = true;
           break;
         case "RR":
         case "rr":
         case "round-robin":
         case "Round-Robin":
         case "Round Robin":
         case "round robin":
         case "roundrobin":
           simulate(ROUND_ROBIN, detailed_y_n);
           //execute following code for RR:
           nowContinue = true;
           break;
         default: //if the user fails to follow directions, give them an attitude.
           System.out.println("Invalid entry. Simulation aborted.");
           nowContinue = true;
           return;
//           break;
         }
       }//end while "loop" that doesn't loop for design reasons
      }//end else give user options
    }//end if default == false
    else //Assume default option of running both simulations is preferred.
    {
      simulate(FIRST_COME_FIRST_SERVE, detailed_y_n);
      simulate(ROUND_ROBIN, detailed_y_n);      
    }//end else
      
  }

  
  //"simulate" method:
  //Precondition: the simulation to run (0 for FCFS, 1 for RR) is provided, as well as a boolean value. 
  //              The boolean value, if true, provides the user with detailed information about each process.
  //Postcondition: A simulation of the given schedule is run, and information about the simulation provided.
    public void simulate(int simulation_to_run, boolean detailed_y_n)
    {
      if (simulation_to_run == 0) //run FCFS  
      {
        try
        {
          //create the new array; this might change upon reading the input file.
          process_list = new Process_[NUMBER_OF_PROCESSES];   
          //Get file input from input_default.txt
          file_input_time(file);
          //FCFS start:
          first_come_first_serve();
          System.out.println("First-Come, First-Served:");
          //Print the details, or lack thereof.
          print_results(detailed_y_n);
        }catch (IOException ioe) {System.out.println("Trouble reading from the file" + ioe.getMessage());}
      }
      else //run RR
      {
        try
        {
          //create the new array; this might change upon reading the input file.
          process_list = new Process_[NUMBER_OF_PROCESSES];   
          //Get file input from input_default.txt
          file_input_time(file);
          //RR start:
          round_robin();
          System.out.println("Round-Robin:");
          //Print the details, or lack thereof.
          print_results(detailed_y_n);
        }catch (IOException ioe) {System.out.println("Trouble reading from the file" + ioe.getMessage());}
      }   
      return;
    }

  
  
  //"print_results"
  //Precondition: The user provides a boolean value to determine if the results will have a detailed display.
  //Postcondition: The array of processes is stepped through and its appropriate data reported.
  public void print_results(boolean detailed_y_n)
  {
    if (detailed_y_n == true)
    {
      System.out.println("Total Time required is " + clock + " time units.");
      System.out.println("CPU Utilization for the schedule type is " 
                           + ((double)total_processing_time/(double)clock*100) + "%.");
      //print normal (Schedule Type,\n Total Time Units Required,\n %CPU utilization \n \n) 
      //print detailed as well 
           for (int i = 0; i < NUMBER_OF_PROCESSES; i++)
           { 
             System.out.println("Process" + (process_list[i].getProcessNumber() + 1)); 
             System.out.println("\t Arrival time: " + (process_list[i].getArrivalTime()) + " units"); 
             System.out.println("\t Service time: " + (process_list[i].getCPUBurstTime()) + " units");
             System.out.println("\t Finish time:  " + (process_list[i].getReleaseTime()) + " units");
             System.out.println("\t Turnaround time: " + (process_list[i].getTurnAroundTime()) + " units");
           }
    }
    else
    {
      System.out.println("Total Time required is " + clock + " time units.");
      System.out.println("CPU Utilization for the schedule type is " 
                           + ((double)total_processing_time/(double)clock*100) + "%.");
      //print normal (Schedule Type,\n Total Time Units Required,\n %CPU utilization \n \n) 
    }
    System.out.println("");
  }


  //First-come, first serviced:
  //Precondition: the process_list[] array exists, and is populated.
  //Postcondition: the process_list[] is stepped through, its data processed and updated according to FCFS scheduling.
  public static void first_come_first_serve()
  {
    boolean ending_condition_all_processes_served = false;
    int number_of_remaining_processes = process_list.length;
    int index_of_process = 0;
    total_processing_time = 0;
    clock = 0;
    //Considering the simplicity of FCFS, it can be implemented as a few 'while', 'if/else', and 'for' statements.
    while (ending_condition_all_processes_served == false)
    {
      if (number_of_remaining_processes <= 0)
      {
        ending_condition_all_processes_served = true;
      }
      else if (index_of_process > process_list.length - 1)
      {
        index_of_process = 0;
      }      
      else 
      {
        if (process_list[index_of_process].getArrivalTime() <= clock)
        {
          if (process_list[index_of_process].getCompletedTime() < process_list[index_of_process].getCPUBurstTime())
          {
            clock += process_list[index_of_process].getCPUBurstTime(); 
            total_processing_time += process_list[index_of_process].getCPUBurstTime();
            // advance clock # of ticks = process burst time and finish the process; this is first-come, first-serve.
            process_list[index_of_process].setCompletedTime(process_list[index_of_process].getCPUBurstTime()); 
            process_list[index_of_process].setReleaseTime(clock);
            process_list[index_of_process].setTurnAroundTime();
          }
          else 
          {
            number_of_remaining_processes--;
            index_of_process++;
            if (number_of_remaining_processes > 0)
            {
               clock += context_switch_time; //only add context switch time if there's some process to switch to.
            }            
          }
        }
        else
        {
          index_of_process++;
          number_of_remaining_processes--;
          clock += 5; //context switch used to prevent infinite loop and assume we need to *find* a process to execute
        }
      }
      
    }
    
  }
  
  
  //Round Robin:
  //Precondition: the process_list[] array exists, is populated. Arrival times < completion time of previous processes.
  //Postcondition: the process_list[] is stepped through, its data processed and updated according to RR scheduling.
  public static void round_robin()
  {
    boolean ending_condition_all_processes_served = false;
    int number_of_remaining_processes = process_list.length;
    int index_of_process = 0;
    total_processing_time = 0;
    clock = 0;
    //Check that the first process arrives at time 0; otherwise, we might have a problem with this solution.
    Queue<Integer> process_queue = new LinkedList<Integer>();
    for(int index = 0; index < number_of_remaining_processes; index++)
    {
      process_queue.add(process_list[index].getProcessNumber());
    }
    //System.out.println("Queue Size initially, Dan: " + process_queue.size());
    //QUANTUM == 10;// fyi
    while (!process_queue.isEmpty())
    {
      if ((process_list[process_queue.peek()].getCPUBurstTime() 
             - process_list[process_queue.peek()].getCompletedTime()) <= QUANTUM
          && (process_list[process_queue.peek()].getArrivalTime() <= clock))
      {
        total_processing_time += process_list[process_queue.peek()].getCPUBurstTime() 
                                   - process_list[process_queue.peek()].getCompletedTime();//ERROR?
        clock += process_list[process_queue.peek()].getCPUBurstTime() 
                   - process_list[process_queue.peek()].getCompletedTime(); 
        process_list[process_queue.peek()].setCompletedTime(process_list[process_queue.peek()].getCPUBurstTime() 
                                                              - process_list[process_queue.peek()].getCompletedTime());
        process_list[process_queue.peek()].setReleaseTime(clock);
        process_list[process_queue.poll()].setTurnAroundTime();
      }
      else if ((process_list[process_queue.peek()].getCPUBurstTime() 
                  - process_list[process_queue.peek()].getCompletedTime()) > QUANTUM
               && (process_list[process_queue.peek()].getArrivalTime() <= clock))
      {
        clock += QUANTUM; 
        total_processing_time += QUANTUM;
        process_list[process_queue.peek()].setCompletedTime(QUANTUM);
        if (process_queue.size() > 1) // if there's only 1 item, no context switch in queue.
        {
          clock += context_switch_time;
        }
        process_queue.add(process_queue.peek());
        process_queue.remove();
      }
      else
      {
        process_queue.add(process_queue.peek());
        process_queue.remove(); //move whatever's in the front of the queue to the back for whatever unknown reason. 
      }
    }
  }
  

   //"file_input_time"
   //Precondition: an array array_list[] exists in this class
   //Postcondition: The array is populated with data from the text document "input_default.txt", provided it's in
   //               the proper format. See description.txt for details.
   public static void file_input_time(String file) throws IOException
   {
        // writer.close();//to be called, or not to be called; that is the question.
     {
        //links to file object
        int number_o_processes;
        System.out.println("Opening file...");
        try ( Scanner f_scanner = new Scanner(new FileInputStream( file ) ); )
         {
          {
             number_o_processes = f_scanner.nextInt();
             if (number_o_processes == NUMBER_OF_PROCESSES)
             {
             //DEBUG// System.out.println("The number of processes matched; program proceeding as expected ...");
             }
             else
             {
                System.out.println("The Number of Processes does not match the CPU Simulation's expected number...");
                process_list = new Process_[number_o_processes];
                NUMBER_OF_PROCESSES = number_o_processes;
             }
             context_switch_time = f_scanner.nextInt();
             
             for (int j = 0; j < number_o_processes; j++)
             {
                int one = f_scanner.nextInt();
                int two = f_scanner.nextInt();
                int three = f_scanner.nextInt();
                process_list[j] = new Process_(one, two, three);
                //System.out.println("Process " + j + ": " + process_list[j].getArrivalTime());
             }  
           }
         }
           //while ( f_scanner.hasNextInt() ) {String line = scanner.nextLine();System.out.println( line );}
        }
   }
   
   //for passing the file name to future arguments
   public static void setInputFile(String inputFile)
   {
     file = inputFile;
   }
   
}