/* ###################################################
 CSCI 513   -- Spring 2020
 Programmers:  Venkata Sai Haswanth Gude (Z1862847)
 			   Sai Vinay Sayyapureddi (Z1861884)
 			   
 Purpose: Develop a performance critical task that requires concurrency to be finished 
  			in a reasonable time using ThreadPooling.

######################################################
*/

public class Main {  //Main class
 
    public static void main(String[] args) {
        
	Scheduler scheduler = new Scheduler(10);  //Creating an object for scheduler
	scheduler.run();
}
}