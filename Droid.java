//import java.util.concurrent.TimeUnit;
//import java.util.scanner;

public class Droid {

  //Instance Fields
  String name; 
  double batteryLevel; 
  double droidHealth;

  public Droid(double startingBatteryLevel, double startingDroidHealth, String nameP){
    name = nameP;
    batteryLevel = startingBatteryLevel;
    droidHealth = startingDroidHealth;
  }

  public boolean drain(double percent){
    batteryLevel -= percent;


    if (batteryLevel > 0){
      System.out.println(name + " used " + percent + " battery.");
      return true;
    } else {
      batteryLevel = 0;
      return false;
    }
  }
  
  public void activate(){
    if (droidHealth < 0 ){
    System.out.println(name + "Droid has died!");
      return;
    }
    System.out.println("COMMAND - ACTIVATE");
    System.out.println();
    if(drain(5)){
    System.out.println(name + " Activated. How can I help you?");
    System.out.println();
    } else {
    System.out.println(name + " Cannot Activate!. Needs to charge!");
    System.out.println();
    }

  } 

  public void chargeBattery(double hours){
    batteryLevel += hours*20;    
    System.out.println("COMMAND - CHARGE BATTERY BY HOUR");
    System.out.println();
    System.out.println(name + " Charging");
    
    if (batteryLevel >= 100 && batteryLevel <= 100){
      batteryLevel = 100;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("Battery Max Charge!");

    } else if (batteryLevel > 100 && batteryLevel <= 120){
      batteryLevel = 110;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - DROID DAMAGED - Battery Overcharged by 10%");

    } else if (batteryLevel > 120){
      droidHealth += -25;
      checkHealth();
      batteryLevel = 75;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - BATTERY OVERLOAD - 25 DAMAGE TAKEN - Battery at 75% capacity");
      checkHealth();
    } else {
      System.out.println("Battery Levels at " + batteryLevel);
    }
    System.out.println();
  }


  public void chargeBattery2(int seconds){

    System.out.println("COMMAND - SUPERCHARGE BATTERY FOR " + seconds + " seconds");
    System.out.println();

    for (int i = seconds; i > 0; i--){

  
      batteryLevel += 2;

      System.out.println("BATTERY CHARGING. CURRENTLY AT " + batteryLevel + " percent! " + i + " seconds of charging left!");

      try
      {
        Thread.sleep(1000); 
      }

      catch(InterruptedException ex)
      {

        Thread.currentThread().interrupt();
      }


    }

      System.out.println();

    if (batteryLevel >= 100 && batteryLevel <= 100){
      batteryLevel = 100;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("Battery Max Charge!");

    } else if (batteryLevel > 100 && batteryLevel <= 120){
      batteryLevel = 110;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - DROID DAMAGED - Battery Overcharged by 10%");

    } else if (batteryLevel > 120){
      droidHealth += -25;
      checkHealth();
      batteryLevel = 75;
      System.out.println("Current Battery Levels at " + batteryLevel);
      System.out.println("DANGER - BATTERY OVERLOAD - 25 DAMAGE TAKEN - Battery at 75% capacity");
      checkHealth();
    } else {
      System.out.println("Battery Levels at " + batteryLevel);
    }

    System.out.println("Charging Finished!");
    System.out.println();

  }

  public void checkBatteryLevel(){
    drain(5);
    System.out.println(name + " battery level is " + batteryLevel + " percent.");
    System.out.println();
  }

  public void checkHealth(){
    if (drain(5)){
      
      System.out.println(name + " health is " + droidHealth);

      if (droidHealth <= 0){
        kill(this);
      }
    }
  }

  public void kill(Droid defender){
    System.out.println(defender.name + " has died!");
    defender.droidHealth = 0;
    defender.batteryLevel = 0;
    defender.name = "dead" + defender.name;
    System.out.println();
  }

  public void attack(Droid defender, double damage){
    System.out.println("COMMAND - ATTACK " + defender.name);
    System.out.println();

    if (drain(damage*2)){
      defender.droidHealth -= damage;
      System.out.println(name +" did " + damage + " damage to " + defender.name);
      defender.checkHealth();
    } else {
      System.out.println("Insufficient Energy! " + name + " needs at least " + damage*2 + " battery level to do this much damage!");
      System.out.println("Battery at " + batteryLevel);
     
    }

  }

  public void hover(int feet){
    System.out.println("COMMAND - HOVER UP " + feet + " FEET");
    System.out.println();
  
    if (feet > 2) {

      if (feet == 69){
        System.out.println("Nice");
      }

      System.err.println("ERROR - " + name + " has a regulated max height of 2 feet -> height set to 2 feet");
      feet = 2;
      System.out.println("Hovering Activated!");

    } else {
      System.out.println("Hovering Activated!");
    }

    switch (feet){
    case 0:
      if (batteryLevel > 15){
        System.out.println(name + " is hovering just above the ground!");
        this.drain(15);
      } else {
        System.out.println("Insufficient Battery! Hovering failed!");
        System.out.println("Battery at " + batteryLevel + " Needs 15 battery");
      }
      break;
        
    case 1:
        if (batteryLevel > 20){
          System.out.println(name + " is hovering one foot above the ground!");
          this.drain(20);
        } else {
          System.out.println("Insufficient Battery! Hovering failed!");
          System.out.println("Battery at " + batteryLevel + " Needs 20 battery");
        } 
        break;
    
    case 2:
      if (batteryLevel > 30){
        System.out.println(name + " is hovering two feet above the ground!");
        this.drain(30);
      } else {
        System.out.println("Insufficient Battery! Hovering failed!");
        System.out.println("Battery at " + batteryLevel + " Needs 30 battery");
      }
      break;

    }

  System.out.println();
  }

  public static void basicCommandList(Droid bot){
    bot.activate();
    bot.chargeBattery(5);
    bot.hover(3);
    bot.hover(1);
    bot.checkBatteryLevel();
  }


  //Main
  public static void main(String[] args){
  
    //Creates instance fields
    Droid botling1 = new Droid(100, 100, "Botling1");
    Droid botling2 = new Droid(100, 100, "Botling2");
    
    //Commands
    //basicCommandList(botling1);

    botling1.drain(1);
    botling1.chargeBattery(10000);
    botling1.chargeBattery(10000);
    botling1.chargeBattery(10000);
    botling1.chargeBattery(10000);
    botling1.chargeBattery(10000);
    botling1.activate();

  }

}
