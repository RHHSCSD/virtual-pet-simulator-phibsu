/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.Scanner;
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
        
        // variables
        int menuChoice;
        boolean startMenu = false;
        int petChoice;
        
        // splash screen
        System.out.println("           boing         boing         boing              ");
        System.out.println(" o-o           . - .         . - .         . - .          ");
        System.out.println("(\\_/)\\       '       `.   ,'       `.   ,'       .        ");
        System.out.println(" `-'\\ `--.___,         . .           . .          .       ");
        System.out.println("    '\\( ,_.-'                                             ");
        System.out.println("       \\\\               \"             \"                   ");
        System.out.println("       ^'");
        System.out.println("WELCOME");
        
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
        
        // display start menu
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
        
        
    }
    
}
