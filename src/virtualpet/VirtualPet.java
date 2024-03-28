/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // initialize scanner
        Scanner kb = new Scanner(System.in);
        Random rn = new Random();
        
        // variables
        int menuChoice;
        boolean startMenu = false;
        boolean login = false;
        int petChoice;
        String userChoice;
        String passwordChoice;
        String generateName;
        String petName = "";
       
        // constants
        final String USER = "snoopy";
        final String PASSWORD = "toto";
        final String CONSONANT = "BCDFGHJKLMNPQRSTVWXZ";
        final String VOWEL = "AEIOUY";
        final int MAXHEALTH = rn.nextInt(19)+1;
        final int MAXFOOD = rn.nextInt(19-MAXHEALTH)+1;
        final int MAXENERGY = 20-MAXHEALTH-MAXFOOD;
        
        // splash screen
        System.out.println("           boing         boing         boing              ");
        System.out.println(" o-o           . - .         . - .         . - .          ");
        System.out.println("(\\_/)\\       '       `.   ,'       `.   ,'       .        ");
        System.out.println(" `-'\\ `--.___,         . .           . .          .       ");
        System.out.println("    '\\( ,_.-'                                             ");
        System.out.println("       \\\\               \"             \"                   ");
        System.out.println("       ^'");
        System.out.println("WELCOME");
        
        // login
        System.out.print("Username: ");
        userChoice = kb.nextLine();
        System.out.print("Password: ");
        passwordChoice = kb.nextLine();
        
        switch (userChoice){
            case USER: 
                switch (passwordChoice){
                    case PASSWORD:
                        login = true;
                        break;
                    default:
                        System.out.println("Invalid credentials!");
                        System.exit(0);
                }
                break;
            default:
                System.out.println("Invalid credentials!");
                System.exit(0);
            
        }
        
        // start menu
        if (login==true){
            System.out.println("1. Start\n2. Instructions\n3. Exit");
            menuChoice = kb.nextInt();
            kb.nextLine();
        
            switch (menuChoice){
                case 1:
                    startMenu = true;
                    break;
                case 2:
                    System.out.println("instructions go here");
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("that is not a choice");
                    break;
            }      
        }
        
        // pet choice
        if (startMenu == true){
            System.out.println("Choose a pet:\n1. Dilong\n2. Corythosaurus\n3. Archaeopteryx");
            petChoice = kb.nextInt();
            System.out.print("You chose ");
            switch (petChoice){
                case 1: 
                    System.out.println("the dilong!");
                    break;
                case 2: 
                    System.out.println("the corythosaurus!");
                    break;
                case 3: 
                    System.out.println("the archaeopteryx!");
                    break;
            }
        }
        
        // name choice
        System.out.println("Would you like to generate a random name? y/n ");
        kb.nextLine();
        generateName = kb.nextLine();
        switch (generateName){
            case "n":
                System.out.println("Enter a name: ");
                petName = kb.nextLine();
                break;
                
            // generate random name
            default:
                int nameLength = rn.nextInt(3) + 4;
                // pick randomly whether to start on vowel or consonant
                int start = rn.nextInt(2);
                for (int i=0; i < nameLength; i++){
                    int doubleLetter = rn.nextInt(5);
                    if (start == 0){
                        if (i%2==0){
                            petName += CONSONANT.charAt(rn.nextInt(CONSONANT.length()));
                        }
                        else{
                            petName += VOWEL.charAt(rn.nextInt(VOWEL.length()));
                        }
                    }
                    else {
                        if (i%2!=0){
                            petName += CONSONANT.charAt(rn.nextInt(CONSONANT.length()));
                        }
                        else{
                            petName += VOWEL.charAt(rn.nextInt(VOWEL.length()));
                        }
                    }
                    if (doubleLetter == 0){
                        petName += petName.charAt(petName.length()-1);
                    }
                    
                }
                System.out.println("Your pet, " + petName + " has been born!");
               
        }
        
    }
    
}
