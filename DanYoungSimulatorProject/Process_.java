//Name: Daniel Young
//Course: CS302
//Assignment: CPU Schedule Simulator
//Date Due: 3/19/2014 (MM/DD/YYYY)
//
//This file contains methods and variables required for the "Process_" class objects.
//Around 30 of these objects are slated for creation in a CPU_Simulation object.

public class Process_
{
  public int process_number;
  public int process_arrival_time;
  public int process_completed_time; // Total time process has been worked on.
  public int process_waiting_time; // TurnAround_Time - Service_or_Burst_Time
  public int process_turnaround_time; // Release_Time - Arrival_Time
  public int process_cpu_burst_time; // This should be service time; time required to complete process.
  public int process_release_time; //whenever the cpu's done with it. -1 unless set.
  
  //Constructor: will be used in by a file scanner, in theory
  Process_(int num, int time, int burst)
  {
    process_number = num;
    process_arrival_time = time;
    process_completed_time = 0;
    process_waiting_time = 0;
    process_turnaround_time = -1;
    process_cpu_burst_time = burst;
    process_release_time = -1;
  }
  
  //Back-up constructor, in case a line of "burst time" integers is missing in the input for whatever reason.
  Process_(int num, int time)
  {
    process_number = num;
    process_arrival_time = time;
    process_completed_time = 0;
    process_waiting_time = 0;
    process_turnaround_time = -1;
    process_cpu_burst_time = 20;
    process_release_time = -1;
  }

  public int getWaitingTime()
  {
    return process_waiting_time;
  }  
  
  public int getReleaseTime()
  {
    return process_release_time;
  }
  
  public void setReleaseTime(int someNumber)
  {
    process_release_time = someNumber;
  }
  
  //Precondition: The caller sends the process's release time to the function.
  //Postcondition: the total wait time for the process is calculated and set as Waiting_Time.
  // NOTE: this function only works **after** completion of a process.
  //       It passes the release time to the function "getTurnAroundTime()" to get total waiting time for the process.
  public void setWaitingTime()
  {
    process_waiting_time = (this.getTurnAroundTime() - process_cpu_burst_time);
  }
  
  public int getCompletedTime()
  {
    return process_completed_time;
  }  

  //Precondition: the calling object supplies the time it has been "worked on"
  //Postcondition: simply put, the time is added to the total processing time.
  public void setCompletedTime(int someTime)
  {
    process_completed_time += someTime;
  }

  public int getProcessNumber()
  {
    return process_number;
  }
  
  public int getArrivalTime()
  {
    return process_arrival_time;
  }

  public int getCPUBurstTime()
  {
    return process_cpu_burst_time;
  }
  
  public void setTurnAroundTime()
  {
    if (process_release_time != -1)
    {
    process_turnaround_time = process_release_time - process_arrival_time;
    }
    else 
    {
      process_turnaround_time = (-1);
    }
  }

  //Precondition: calling object supplies a "release time" of completion.
  //Postcondition: the Turnaround Time for the process/calling object is provided as an integer value.
  public int getTurnAroundTime()
  {
    return process_turnaround_time;
  }
  
}