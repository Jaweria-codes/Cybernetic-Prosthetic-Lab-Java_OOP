import java.util.Stack;
import java.util.Scanner;

abstract class prostheticLimb {
    private String name;
    private int battery_level;
    private float neural_SyncScore;

     //Declare the privte stck.....
     private Stack <String> commandHistory;

    prostheticLimb( String name, int battery_level, float neural_SyncScore ) {
        this.name = name; 
        this.battery_level = battery_level;
        this.neural_SyncScore = neural_SyncScore;
        //initializing an empty stack for every new limb...
          this.commandHistory = new Stack<>();
    }      

// POLYMORPHISM
       public String getName() {
        return name;
    }

       public int getBatteryLevel() {
        return battery_level;
    }

       public float getNeuralSyncScore() {
        return neural_SyncScore;
    }

           public void chargeBattery() {
              System.out.println("battery level of limb is.....");
        }

           public  void checkStatus() {

        }

           public abstract void runStressTest(); 
           public abstract void showSpecificChar();

         //PUSH : RECORD A NEW MOTOR MOVEMENT....
         public void recordCommand(String command) {
            if (battery_level < 5 ) {
              System.out.println("Battery too low to move!!");  
            }
            else {
                commandHistory.push(command);
                battery_level -= 2; // small battery drain per move....
                System.out.println("Executed and logged: [" + command + "]");
            }      
        }  
        // POP: Undo the most recent command (LIFO)
        public void undoLastCommand (){
            if (commandHistory.isEmpty()){
                System.out.println("Limb is already in neural posture. Nothing to undo. (Note: To undo, first run *Record Motor Command* Test.");
            }
            else {
                String lastMove = commandHistory.pop();
                System.out.println("EMERGENCY UNDO : Reversing [" + lastMove + "]...");
            }
        }
}

class bionicArm extends prostheticLimb {
    private int gripStrength; 
    

public bionicArm (String name, int battery_level, float neural_SyncScore , int gripStrength) {
    super(name , battery_level, neural_SyncScore); 

    this.gripStrength = gripStrength;

}

      public int getGripStrength() {
          return gripStrength;
    }
       
@Override
       public void runStressTest() {
        System.out.println(" Great finger precision and amazing crushing force! ");
    } 

      public void chargeBattery() {
        System.out.println("Battery level of Arm is " + getBatteryLevel());
    }

      public void showSpecificChar() {
        System.out.println("Grip strength: " + gripStrength + "kg");
    }
}


class bionicLeg extends prostheticLimb {
    private float jumpHeight;
    private int shockAbsorption;

public bionicLeg(String name, int battery_level, float neural_SyncScore , float jumpHeight, int shockAbsorption) {
    super(name, battery_level, neural_SyncScore);
    this.jumpHeight = jumpHeight;
    this.shockAbsorption = shockAbsorption;
}

      public float getJumpHeight() {
         return jumpHeight;
    }

      public int getShockAbsorption() {
         return shockAbsorption;
    }
@Override
       public void runStressTest() {
          System.out.println("Stable heavy landing and Fast sprinting speed!");
    }   
       
       public void chargeBattery(){
        System.out.println("Battery level of Leg is " + getBatteryLevel());
    }

       public void showSpecificChar() {
        System.out.println("Jump Height: " + jumpHeight + "m");
        System.out.println("Shock absorption: " + shockAbsorption + "%");
    }    
        

}

class DignosticLab{
    // TEST 1: limb status.....
    public void showLimbStatus(prostheticLimb limb){
        System.out.println("Name of the limb: " + limb.getName());
        System.out.println("Battery of the limb: " + limb.getBatteryLevel());
        System.out.println("Neural sync score: " + limb.getNeuralSyncScore());
        limb.showSpecificChar();
    }

    // TEST 2: Calibration test....
    
    // Method overloading
    public void neuralCalibration(prostheticLimb limb){
        System.out.println("Running Auto-Calibration at default 60HZ...... Neural sync stabilized at 90/100!!..");
    }
    //TEST 3: manual calibration....
    public void neuralCalibration(prostheticLimb limb, int targetFrequency) {
        if (targetFrequency >= 80 && targetFrequency <= 120) {
            System.out.println("High precision tunning (" + targetFrequency + "HZ)! Sync Boosted.");
        }
        else if (targetFrequency > 120){
            System.out.println("WARNING: " + targetFrequency + "HZ caused neural feedback unstable due to overloaded freuency!!");
        }
        else System.out.println("Low Signal. (Atleast 85 0r above frequency required.)");
    }
    // TEST: 4 executing stress test.....
    // Dynamic method Dispatching
    public void biomechanicStressTest(prostheticLimb limb) {
        System.out.println("---- INITIIATING LAB STRESS TEST ----");
        limb.runStressTest(); // POLYMORPHISM
        System.out.println("\n---- STRESS TEST COMPLETE ----");
    }
    //TEST: 5 and 6 (in parent class)
}

class simulationTest{
    public static void main(String[] args) {
        System.out.println("**********************************************************");
        System.out.println("===========================================================");
        System.out.println("<<< CYBERNETIC PROSTHETIC AND BIOMECHANICS DIAGNOSTIC ENGINE >>>");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("WELCOME TO ROBOTICS SIMULATION TESTING!!");
        System.out.println("===========================================================");
        System.out.println("**********************************************************");

        bionicArm Arm = new bionicArm("Aegis_neuro_Arm", 85, 65.0f, 140 ) ;
        bionicLeg Leg = new bionicLeg("Zephyr_Leg", 90, 60.0f, 2.4f, 92);
        DignosticLab lab = new DignosticLab();
        // parent refrence variable (polymorphism)
        prostheticLimb choosenLimb;

        System.out.println("Select prosthetic device to test:");
        System.out.println(" 1. BIONIC ARM ");
        System.out.println("2. BIONIC LEG");
        System.out.println("Enter choice: ");
        //user input
        Scanner sc = new Scanner(System.in);
        int deviceChoice = sc.nextInt();
         if (deviceChoice == 1){
            choosenLimb = Arm;
         } else if (deviceChoice == 2){
            choosenLimb = Leg;
         } else {
            System.out.println("Invalid choice! Defaulting to Bionic arm.");
            choosenLimb = Arm;
         }
         System.out.println();

         boolean running = true; 
         while (running) {
            System.out.println("'What test you want to run? ");
            System.out.println("1: Show limb status");
            System.out.println("2: Auto calibration");
            System.out.println("3: Manual calibration");
            System.out.println("4: Biomechanical stress test");
            System.out.println("5: Record motor command");
            System.out.println("6: Emergency undo");
            System.out.println("7: Exit test session!");  
            System.out.println("type 1/2/3/....");
            // user choice 
            //Scanner input = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
         switch(choice) {
            case 1: lab.showLimbStatus(choosenLimb); break;

            case 2: lab.neuralCalibration(choosenLimb); break; // overloading 1

            case 3: System.out.println("Enter target frequency...");
            int trgFreq = sc.nextInt();
            sc.nextLine();
            lab.neuralCalibration(choosenLimb, trgFreq);  break;// overloading 2

            case 4: lab.biomechanicStressTest(choosenLimb); break;

            case 5: System.out.println("Enter command. e.g: Rotate wrist/ Clench Fist/ Extend Forearm/ Flex knee joint/ Bend knee/ Grip object...");
            String yourCommand = sc.nextLine();
            choosenLimb.recordCommand(yourCommand); break;

            case 6: choosenLimb.undoLastCommand(); break;

            case 7: System.out.println("Shutting down Dignostic lab. Good Bye!!");
            running = false;
            break;

            default : System.out.println("ALERT: Test unable!! Please choose 1-7.");
         }  
         System.out.println();
         System.out.println("----------------------------------------------");
             
         }
         sc.close();

    }
}
   