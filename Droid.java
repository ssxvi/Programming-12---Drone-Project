//Droid Project
//Programming 12
//
//@Trevor Liu
//
//@December 5th
//

public class Droid {

  //Instance Fields
  String name; //Name of robot
  double batteryLevel; //Battery Level
  double droidHealth; //Droid health



  //Constructor methods
  //All instance fields are declared with parameters
  //
  public Droid(double startingBatteryLevel, double startingDroidHealth, String nameP){
    name = nameP;
    batteryLevel = startingBatteryLevel;
    droidHealth = startingDroidHealth;
  } //End of constructor function




  /* 
  Drain methods (back-end method)
  Drain battery from robot, gives user message based on if the robot had enough battery for action to run - drains battery regardless, lowering battery to a maximum of 0
  

  @para
    percent {double} - amount of battery drained
    
  @returns
    {boolean} - if robot is out of battery

  */
  public boolean drain(double percent){

    batteryLevel -= percent; //drains the percent in parameter

    //checks to see if drain was successful
    if (batteryLevel >= 0){

      System.out.println(name + " used " + percent + " battery.");
      return true;

    } else {

      batteryLevel = 0; //Sets battery level to 0 if not successful
      System.out.println(name + " OUT OF BATTERY - PLEASE CHARGE!");
      return false;

    } //END of if/else

  }//End of drain function
  


  

  /*
  Activation method
  Activates Droid - basically fancy ui and I even mentioned in class that you could have a seperate instance field that would require all actions to have the droid activated but that's so much effort I made so many methods already
 
  */
  public void activate(){


    //User Command Description
    System.out.println("COMMAND - ACTIVATE");
    System.out.println();

    //Since drain returns a boolean we can multitask, and have a function as a conditional -> This will run the UI for success and failing the drain, as well as the rest of the message. 
    if(drain(5)){

    System.out.println(name + " Activated. How can I help you?"); //also I made a seperate instance field refering to which droid the command is using otherwise multiple droids would made the commands confusing
    System.out.println();

    } else {

    System.out.println(name + " Cannot Activate!. Needs to charge!");
    System.out.println();

    }//END of if/else

  } //END of activation function






  /*
  Charge Battery method
  Charges battery 20% battery based on hour input
  
  @para
    hours {double} amount of time droid should charge

  */
  public void chargeBattery(double hours){


    batteryLevel += Math.abs(hours*20); //Adds battery based on hours and makes sure hours is positive

    //User Command Description
    System.out.println("COMMAND - CHARGE BATTERY BY HOUR");
    System.out.println();
    System.out.println(name + " Charging for " + hours);
    

    //IF ELSE STATEMENT - Checks to see how much extra charging was done

    if (batteryLevel == 100){    //Exact perfect charging

      batteryLevel = 100;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("Battery Max Charge!");

    } else if (batteryLevel > 100 && batteryLevel <= 120){      //Over by 101-120%

      batteryLevel = 110;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - DROID DAMAGED - Battery Overcharged by 10%");

    } else if (batteryLevel > 120){         //Over by >120%

      droidHealth += -25; //Oh haven't done this yet, if the user charges for too long the droid takes damage
      batteryLevel = 75;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - BATTERY OVERLOAD - 25 DAMAGE TAKEN - Battery at 75% capacity");

      checkHealth(); //Since the droid takes damage we need   to see if the droid is dead

    } else {  

      System.out.println("Current Battery Levels at " + batteryLevel); //If the charge ended up under 100% we just get this else statement. 

    } //END of if/else statement

    System.out.println(); //spacing D:

  }//END of charge battery function






  /*
  ChargeBattery method version 2.0!!
  Second version of charge battery which uses seconds instead of hours, and forces the user to actually wait all those seconds
  
  @para
    seconds {int} - seconds the droid is charging for

  */
  public void chargeBattery2(int seconds){
    
    //User Command description
    System.out.println("COMMAND - SUPERCHARGE BATTERY FOR " + seconds + " seconds");
    System.out.println();


    for (int i = seconds; i > 0; i--){    //loops for seconds

      batteryLevel += 2; //adds 2% to battery level

      System.out.println("BATTERY CHARGING. CURRENTLY AT " + batteryLevel + " percent! " + i + " seconds of charging left!");



      //program sleeps for 1000 ms
      try 
      {
        Thread.sleep(1000); 

      } catch(InterruptedException ex) {

        Thread.currentThread().interrupt();

      } //END of try/catch statement (no need for finally here D: )


    } //END of for loop


    System.out.println(); //cool spacing feature


    //IF ELSE STATEMENT - Checks to see how much extra charging was done


    if (batteryLevel == 100){    //Exact perfect charging

      batteryLevel = 100;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("Battery Max Charge!");

    } else if (batteryLevel > 100 && batteryLevel <= 120){      //Over by 101-120%

      batteryLevel = 110;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - DROID DAMAGED - Battery Overcharged by 10%");

    } else if (batteryLevel > 120){         //Over by >120%

      droidHealth += -25; //Oh haven't done this yet, if the user charges for too long the droid takes damage
      batteryLevel = 75; 
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - BATTERY OVERLOAD - 25 DAMAGE TAKEN - Battery at 75% capacity");

      checkHealth(); //Since the droid takes damage we need to see if the droid is dead

    } else {

      System.out.println("Current Battery Levels at " + batteryLevel); //If the charge ended up under 100% we just get this else statement. 

    } //END of if/else statement






    System.out.println("Charging Finished!");
    System.out.println();

  }//END of charge battery function version 2









  /*
  Check battery level method
  Kinda self explanatory ngl it just like checks the battery function and prints UI and everyhing and god I'm so tired but yeah abstraction actually love making wayy to many functions because it's easier to make more functions wowee this is confusing
  
  */
  public void checkBatteryLevel(){

    //idk man this is pretty simple, just used drain which already basically does this because it's easier but this tells the exact battery
    if(drain(5)){

      System.out.println(name + " battery level is " + batteryLevel + " percent.");
      System.out.println();

    }//END of if/else statement


  }//END of check battery level function






  /*
  checkHealth method (back-end method so no drain)
  Prints the health level of a droid 
  NOTE: NEEDS TO BE RUN AFTER EVERY TIME DAMAGE IS CALCULATED
 
  */
  public void checkHealth(){

    System.out.println(name + " health is " + droidHealth);

    if (droidHealth <= 0){ //if health is below 0 droid fcking kills itself

      kill(this); //Just kills itself casually which is fun, kill could also be a function but I wanted to reuse it so droids could kill other droids as an action

    }//END of if statement

  }//END of checkHealth function





  /*
  Kill method (backend method - no drain)
  "Kills" the droid, changes it's name to 'dead + name' and sets health and battery to 0.

  @para
    defender {Droid} - droid to get executed  
 
    */
  public void kill(Droid defender){

    System.out.println(defender.name + " has died!");

    //Sets instance fields of droid
    defender.droidHealth = 0;
    defender.batteryLevel = 0;
    defender.name = "dead" + defender.name; //I can't make an object delete another object javascript doesn't like that so instead I just do this I might you might be able to but I tried for a day and the program didn't like it so here is solution

    System.out.println();

  }//END of kill method





  /*
  Attack method
  Does damage to droid, energy cost is double the damage done

  @para
    defender {droid} - droid being attacked
    damage {damage} - damage being done
  
    */

  public void attack(Droid defender, double damage){

    //User Input Command 
    System.out.println("COMMAND - ATTACK " + defender.name);
    System.out.println();

    //Checks to see if there is enough energy for the attack
    if (drain(damage*2)){

      defender.droidHealth -= damage;   //damages defender health
      System.out.println(name +" did " + damage + " damage to " + defender.name);

      defender.checkHealth();   //runs health check on defender

    } else { //alternative is battery isn't high enough

      System.out.println("Insufficient Energy! " + name + " needs at least " + damage*2 + " battery level to do this much damage!");
      System.out.println("Battery at " + batteryLevel);
     
    }//END if else

  }//END Attack






  /*
  Hover function
  Allows to droid to hover up to 2 feet in the air, any integers above 2 get set to 2, and any under are set to 0

  @para
    feet {int} - How high the droid should hover in feet
  
    */
  public void hover(int feet){
    System.out.println("COMMAND - HOVER UP " + feet + " FEET");
    System.out.println();
  
    //Checks to make sure that feet is between 0 and 2

    if (feet > 2) {       //If feet is over 2


      if (feet == 69){                                                                                                  //Nice
        System.out.println("Nice");
      }//END of if

      //Error message

      System.err.println("ERROR - " + name + " has a regulated max height of 2 feet -> height set to 2 feet");  //error message
      System.out.println("Hovering Activated!");

      feet = 2; //Sets feet to 2


    } else if (feet < 0){     //If feet is under 0

      feet = 0;
      System.err.println("ERROR - " + name + " has a regulated minimum height of 0 feet -> height set to 0 feet");  //error message
      System.err.println("To travel underground, drill DLC must be purchased");

    } else {    //Defualt

      System.out.println("Hovering Activated!");

    } //END of if/else


    //We need to use a switch statement which is honestly really a pain I could have just used more if/else statements then use a double instead of an integer because we need full values for switch statements but that's ok I guess D:
    switch (feet){

    case 0: //case for 0 feet

      if (batteryLevel > 15){ //checks to see if battery can handle operation
        System.out.println(name + " is hovering just above the ground!");
        this.drain(15);
      } else { //if battery cannot then error runs
        System.out.println("Insufficient Battery! Hovering failed!");
        System.out.println("Battery at " + batteryLevel + " Needs 15 battery");
      } //End of if/else

      break;
        

    case 1: //case for 1 foot - same code as above but battery level is 20

        if (batteryLevel > 20){
          System.out.println(name + " is hovering one foot above the ground!");
          this.drain(20);
        } else {
          System.out.println("Insufficient Battery! Hovering failed!");
          System.out.println("Battery at " + batteryLevel + " Needs 20 battery");
        }  //End of if/else

        break;
    

    case 2: //case for 2 feet - same code as above but battery level is 30

      if (batteryLevel > 30){ 
        System.out.println(name + " is hovering two feet above the ground!");
        this.drain(30);
      } else { 
        System.out.println("Insufficient Battery! Hovering failed!");
        System.out.println("Battery at " + batteryLevel + " Needs 30 battery");
      } //End of if/else

      break;


    default: //default

      System.err.println("HOVER ERROR - PLEASE TRY AGAIN"); //Just an error message

      break;


    }//END of switch

  System.out.println();   //Spacing
  }//End of hover program





  /*
  **basicCommandList Function**
  runs the set of commands we need to run in the program -> (hey I can use a function and also fun abstraction)

  @para
    bot {Droid} - object that will run the commands
  
  */
  public static void basicCommandList(Droid bot){

    bot.activate();
    bot.chargeBattery(5);
    bot.hover(3);
    bot.hover(1);
    bot.checkBatteryLevel();

  } //END of basicCommandList function





  //frontUI function
  /*
  Prints UI for the beginning the program
  
  */
  public static void frontUI(){

    System.out.println("Welcome to our robot testing site!");
    System.out.println();
    System.out.println("Since this is a testing site, user interface will be updated!");
    System.out.println();
    System.out.println("List of commands!");
    System.out.println();
    System.out.println("droid.activate(); - energy: 5- Does nothing currently but 'activates' the droid");
    System.out.println("droid.hover(feet); - energy: 5 - Makes the droid hover!");
    System.out.println("droid.attack(defending droid, damage); - energy: damage*2 - makes the droid attack another droid, energy costs double the damage");
    System.out.println("droid.chargeBattery(hours); - energy: 0 - charges droid for x amount of hours, 20% per hour");
    System.out.println("droid.chargeBattery2(seconds);- energy: 0 - Big brother of the first charge battery 2% per second but must wait irl seconds");
    System.out.println("droid.checkBatteryHealth(); - energy: 5 -  checks the batteryhealth");
    System.out.println();
    System.out.println();

  
  } //end of frontUI function






  //Main
  public static void main(String[] args){
    
    //calls UI function bc abstraction
    frontUI();

    //Creates objects and assigns instance fields
    Droid botling1 = new Droid(100, 100, "Botling1");
    Droid botling2 = new Droid(100, 100, "Botling2");
    
    //Commands

    basicCommandList(botling1);

    botling1.drain(1);
    botling1.chargeBattery2(5);
    botling1.checkHealth();

    botling2.attack(botling1, 75);
    botling1.checkHealth();

    botling1.chargeBattery2(10);
    botling1.checkHealth();

    botling1.chargeBattery(1000);
    

    botling1.attack(botling2, 50);
    botling2.checkBatteryLevel();
    botling1.chargeBattery2(-100);
    
    System.out.println();
    System.out.println("Thank you for using our droid program!!");
  } //END of Main

}//END of class




/*
**Notes!**
UI is built into the functions!
User input maybe with jframe later idk didn't have time to implement it but you'll probably see it on the car loan project

**Test Code**
  botling1.drain(-1); will drain 1
  botling2.attack(botling2, 75); will hurt itself
  botling1.hover(-103); will hover at 0
  botling1.chargeBattery(-100);

*/

