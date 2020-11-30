import java.util.concurrent.TimeUnit;
import java.util.scanner;

public class Droid {

    //Instance Fields
    string name;
    double batteryLevel;
    double droidHealth;

    public static void main(String[] args){
   
        Droid botling1 = new Droid(100, 100);
        Droid botling2 = new Droid(100, 100);
        /*
        botling1.activate();
        botling1.chargeBattery(5);
        botling1.hover(3);
        botling1.hover(1);
        botling1.checkBatteryLevel();
        botling1.chargeBattery2(1);
        */

        //botling2.checkHealth();
        //botling1.attack(botling2);
        //botling2.checkHealth();
    }

    public Droid(double startingBatteryLevel, double startingDroidHealth){
        batteryLevel = startingBatteryLevel;
        droidHealth = startingDroidHealth;
    }

    public void drain(double percent){

        batteryLevel -= percent;
        System.out.println("Battery level is " + batteryLevel + " percent.");
    }
    
    public void activate(){
        System.out.println("Activated. How can I help you?");
        System.out.println();
        this.drain(5);

    } 

    public void chargeBattery(double hours){
        batteryLevel += hours*20;
        System.out.println("Droid Charging");
        
        if (batteryLevel >= 100 && batteryLevel <= 100){
            batteryLevel = 100;
            System.out.println("Current Battery Levels at " + batteryLevel);
            System.out.println("Battery Max Charge!");

        } else if (batteryLevel > 150 && batteryLevel <= 200){
            batteryLevel = 110;
            System.out.println("Current Battery Levels at " + batteryLevel);
            System.out.println("DANGER - DROID DAMAGED - Battery Overcharged by 10%");

        } else if (batteryLevel > 200){
            batteryLevel = 75;
            System.out.println("Current Battery Levels at " + batteryLevel);
            System.out.println("DANGER - SEVERE DROID DAMAGE - 75% capacity");
            droidHealth += -25;
        } else {
            System.out.println("Battery Levels at " + batteryLevel + " percent");
        }
        System.out.println();
    }


    public void chargeBattery2(int seconds){
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
    
        if (batteryLevel >= 100 && batteryLevel <= 100){
            batteryLevel = 100;
            System.out.println("Current Battery Levels at " + batteryLevel);
            System.out.println("Battery Max Charge!");

        } else if (batteryLevel > 150 && batteryLevel <= 200){
            batteryLevel = 110;
            System.out.println("Current Battery Levels at " + batteryLevel);
            System.out.println("DANGER - DROID DAMAGED - Battery Overcharged by 10%");

        } else if (batteryLevel > 200){
            batteryLevel = 75;
            System.out.println("Current Battery Levels at " + batteryLevel);
            System.out.println("DANGER - SEVERE DROID DAMAGE - 75% capacity");
            droidHealth += -25;
        } else {
            System.out.println("Battery Levels at " + batteryLevel);
        }
        System.out.println();

    }

    public void checkBatteryLevel(){
        this.drain(5);
        System.out.println();
    }

    public void checkHealth(){
        System.out.println("Droid health is " + droidHealth);
    }
    public void attack(Droid defender){
        defender.droidHealth -= 10;
        System.out.println("did 10 damage to " + defender);
    }

    public void hover(int feet){

    
        if (feet > 2) {

            if (feet == 69){
                System.out.println("Nice");
            }

            System.err.println("Error - Robot has a regulated max height of 2 feet -> height set to 2 feet");
            feet = 2;
            System.out.println("Hovering Activated!");

        } else {
            System.out.println("Hovering Activated!");
        }
    
        switch (feet){
        case 0:
            if (batteryLevel > 15){
                System.out.println("Robot is hovering just above the ground!");
                this.drain(15);
            } else {
                System.out.println("Insufficient Battery! Hovering failed!");
            }
            break;
            
        case 1:
            if (batteryLevel > 20){
                System.out.println("Robot is hovering one foot above the ground!");
                this.drain(20);
            } else {
                System.out.println("Insufficient Battery! Hovering failed!");
            }
            break;
        
        case 2:
            if (batteryLevel > 30){
                System.out.println("Robot is hovering two feet above the ground!");
                this.drain(30);
            } else {
                System.out.println("Insufficient Battery! Hovering failed!");
            }
            break;

        }

        System.out.println();
    }
    
}
