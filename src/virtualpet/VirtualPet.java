/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
import java.io.*;
import java.lang.Exception;

/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

   
    final static int LOGIN_ATTEMPTS = 3;
    static int money = 0;
    //1. energy 2. food 3. health
    static int[] maxStats = new int[3];
    static int[] interactionCount = new int[3];
    static boolean inPlay = false;

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
        boolean startMenu = true;      // default true
        boolean mainMenu = true;        // default true
        boolean choosePet = false;      // default false
        boolean chooseName = true;      // default true
        boolean interactMenu = false;   // default false
        boolean actionMenu = false;     // default false
        boolean play = false;
        boolean feed = false;
        boolean groom = false;
        int actionMenuChoice;
        int interactMenuChoice;
        int gameMenuChoice;

        boolean gameMenu = false;   //default false
        int petChoice;
        int generateName;
        String petName = "";

        //minigames
        //1
        boolean minigame1 = false;
        final int MAX_GUESSES1 = 6;

        //2
        boolean minigame2 = false;
        final int SHUFFLED_LENGTH = 10;
        final int MAX_GUESSES2 = 10;

        // constants
        final String USER = "snoopy";
        final String PASSWORD = "toto";
        final String CONSONANT = "BCDFGHJKLMNPQRSTVWXYZ";
        final String VOWEL = "AEIOU";
        
         
        maxStats[0] = rn.nextInt(19) + 1;
        maxStats[1] = rn.nextInt(20 - maxStats[0]) + 1;
        maxStats[2] = 20 - maxStats[1] - maxStats[0];
        
        int[] currentStats = new int[3];
        
        // splash screen
        System.out.println("           boing         boing         boing              ");
        System.out.println(" o-o           . - .         . - .         . - .          ");
        System.out.println("(\\_/)\\       '       `.   ,'       `.   ,'       .        ");
        System.out.println(" `-'\\ `--.___,         . .           . .          .       ");
        System.out.println("    '\\( ,_.-'                                             ");
        System.out.println("       \\\\               \"             \"                   ");
        System.out.println("       ^'");
        System.out.println("WELCOME");

        //login
        String username = loginMenu();

        while (inPlay) {

            // start menu
            while (mainMenu == true) {
                if (startMenu) {
                    System.out.println("\n1. Start\n2. Instructions\n3. Exit");

                } else {
                    System.out.println("\n1. Play/Interact\n2. Instructions\n3. Exit");

                }
                menuChoice = kb.nextInt();
                kb.nextLine();

                switch (menuChoice) {
                    case 1:
                        if (startMenu) {
                            choosePet = true;
                            startMenu = false;
                        } else {
                            actionMenu = true;
                        }
                        mainMenu = false;
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
            while (choosePet) {
                System.out.println("Choose a pet:\n1. Dilong\n2. Corythosaurus\n3. Archaeopteryx");
                petChoice = kb.nextInt();
                switch (petChoice) {
                    case 1:
                        System.out.println("You chose the dilong!");
                        choosePet = false;
                        break;
                    case 2:
                        System.out.println("You chose the corythosaurus!");
                        choosePet = false;
                        break;
                    case 3:
                        System.out.println("You chose the archaeopteryx!");
                        choosePet = false;
                        break;
                    default:
                        System.out.println("Choose a valid pet!");
                }
            }

            // name choice
            if (chooseName) {
                generateName = JOptionPane.showConfirmDialog(null, "Would you like to generate a random name?", "almost there...", JOptionPane.YES_NO_OPTION);
                switch (generateName) {
                    case 1:
                        JOptionPane.showInputDialog("Enter a name: ");
                        petName = kb.nextLine();
                        break;

                    // generate random name
                    default:
                        int nameLength = rn.nextInt(3) + 4;
                        // pick randomly whether to start on vowel or consonant
                        int start = rn.nextInt(2);
                        for (int i = 0; i < nameLength; i++) {
                            int doubleLetter = rn.nextInt(5);
                            if (start == 0) {
                                if (i % 2 == 0) {
                                    petName += CONSONANT.charAt(rn.nextInt(CONSONANT.length()));
                                } else {
                                    petName += VOWEL.charAt(rn.nextInt(VOWEL.length()));
                                    if (doubleLetter == 0) {
                                        petName += petName.charAt(petName.length() - 1);
                                    }
                                }
                            } else {
                                if (i % 2 != 0) {
                                    petName += CONSONANT.charAt(rn.nextInt(CONSONANT.length()));
                                } else {
                                    petName += VOWEL.charAt(rn.nextInt(VOWEL.length()));
                                    if (doubleLetter == 0) {
                                        petName += petName.charAt(petName.length() - 1);
                                    }
                                }
                            }
                        }
                }
                JOptionPane.showMessageDialog(null, "Your pet, " + petName + ", has been born!", "the circle of life", JOptionPane.INFORMATION_MESSAGE);
                mainMenu = true;
                chooseName = false;

            }


            if (actionMenu) {
                System.out.println("\nWould you like to interact with your pet or play a game?\n1. Interact\n2. Game\n3. Back");
                actionMenuChoice = kb.nextInt();
                switch (actionMenuChoice) {
                    case 1:
                        interactMenu = true;
                        break;
                    case 2:
                        gameMenu = true;
                        break;
                    default:
                        mainMenu = true;
                }
                actionMenu = false;
            }

            if (interactMenu) {
                System.out.println("\nChoose an activity:\n1. Play\n2. Feed\n3. Groom\n4. Back");
                interactMenuChoice = kb.nextInt();
                switch (interactMenuChoice) {
                    case 1:
                        play = true;
                        mainMenu = true;
                        break;
                    case 2:
                        feed = true;
                        mainMenu = true;
                        break;
                    case 3:
                        groom = true;
                        mainMenu = true;
                        break;
                    default:
                        actionMenu = true;
                }
                interactMenu = false;
            }

            if (gameMenu) {
                System.out.println("\nChoose a game to play: \n1. Number guessing\n2. Matching\n3. Back");
                gameMenuChoice = kb.nextInt();
                switch (gameMenuChoice) {
                    case 1:
                        minigame1 = true;
                        mainMenu = true;
                        break;
                    case 2:
                        minigame2 = true;
                        mainMenu = true;
                        break;
                    default:
                        actionMenu = true;
                }
                gameMenu = false;
            }

            // first minigame
            if (minigame1) {
                money += guessingGame(MAX_GUESSES1);
                minigame1 = false;
                mainMenu = true;
            } else if (minigame2) {
                money = matchingGame(MAX_GUESSES2, SHUFFLED_LENGTH);
                minigame2 = false;
                mainMenu = true;
            }
            
            //interactions
            
            if (play) {
                play(currentStats);
                play = false;
            } else if (feed) {
                feed(currentStats);
                feed = false;
            } else if (groom) {
                groom(currentStats);
                groom = false;
            }
        }
    }

    public static void exit(String user){
        try{
        File info = new File(user+".dat");
        PrintWriter pw = new PrintWriter(info);
        pw.println(); 
        
        } catch(Exception e){
            System.out.println("uhoh");
        }
        System.exit(0);
        
    }
    
    public static String loginMenu() {
        String userInput;
        String passwordInput;
        String user = "";
        File info;
        PrintWriter pw;
        
        for (int i = 1; i <= LOGIN_ATTEMPTS; i++) {
            if (!user.equals("")) {
                i = LOGIN_ATTEMPTS + 1;
            } else {
                userInput = JOptionPane.showInputDialog("Username: ");
                userInput = userInput.toLowerCase();
                info = new File(userInput+".dat");
                
                //check if file exists
                if (info.exists()){
                    //if it does, check for password from the file
                    passwordInput = JOptionPane.showInputDialog("Password: ");
                    try{
                        Scanner s = new Scanner(info);

                        if (s.nextLine().equals(passwordInput)){
                            //upon login, load all the information
                            user = userInput;
                            inPlay = true;
                            JOptionPane.showMessageDialog(null, "Success!", ":)", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                        JOptionPane.showMessageDialog(null, "Invalid credentials!\n" + (LOGIN_ATTEMPTS - i) + " attempts remaining", ":(", JOptionPane.WARNING_MESSAGE);
                        System.out.println(LOGIN_ATTEMPTS - i + " attempts remaining");
                        }
                        s.close();
                    } catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Something went wrong...", ":(", JOptionPane.WARNING_MESSAGE);
                        return "";
                    }
                }
                //otherwise, make a new file
                else{
                    try{
                    pw = new PrintWriter(info);
                    passwordInput = JOptionPane.showInputDialog("Create a new password: ");
                    pw.println(passwordInput);
                    pw.close();
                    
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Something went wrong...", ":(", JOptionPane.WARNING_MESSAGE);
                        return "";
                    }
                }
                
                
            }
        }
        return user;
    }

    public static int guessingGame(int MAX_GUESSES) {
        Scanner kb = new Scanner(System.in);
        Random rn = new Random();
        int money = 0;
        int randomNum = rn.nextInt(100) + 1;
        boolean win = false;
        for (int i = MAX_GUESSES; i > 0; i--) {
            System.out.print("Guess a number: ");
            int playerGuess = kb.nextInt();
            if (playerGuess == randomNum) {
                money += i * 5;
                System.out.println("Correct! You won with " + (MAX_GUESSES) + " guesses!");
                i = 0;
                win = true;
            } else if (playerGuess < randomNum) {
                System.out.println("Too low");
                System.out.println("You have " + (i - 1) + " guesse(s) remaining");
            } else {
                System.out.println("Too high");
                System.out.println("You have " + (i - 1) + " guesse(s) remaining");
            }

        }
        if (!win) {
            System.out.println("You lose");
        }
        return money;
    }

    public static int matchingGame(int MAX_GUESSES, int SHUFFLED_LENGTH) {
        Random rn = new Random();
        Scanner kb = new Scanner(System.in);
        String shuffled = "";
        boolean win = false;
        char randomChar;
        int index1;
        int index2;
        String foundPairs = "";
        boolean repeated = false;
        int money = 0;
        String gameStatus = "";

        //generate the string
        for (int i = 0; i < SHUFFLED_LENGTH; i++) {
            randomChar = (char) (rn.nextInt(SHUFFLED_LENGTH / 2) + 'A');
            if (shuffled.indexOf(randomChar) == shuffled.lastIndexOf(randomChar)) {
                shuffled += randomChar;
            } else {
                i--;
            }
        }
        //the game
        for (int k = MAX_GUESSES; k > 0; k--) {
            if (!win) {
                //guessing
                System.out.print("\nGuess (seperate with space): ");
                index1 = kb.nextInt();
                index2 = kb.nextInt();

                //prevent invalid numbers
                if (index1 > 0 || index1 < SHUFFLED_LENGTH - 1 || index2 > 0 || index2 < SHUFFLED_LENGTH - 1) {
                    //check if correct
                    if (shuffled.charAt(index1) == shuffled.charAt(index2)) {
                        //prevent repetition
                        for (int i = 0; i < foundPairs.length(); i++) {
                            if (foundPairs.charAt(i) == shuffled.charAt(index1)) {
                                repeated = true;
                            }
                        }
                        if (!repeated) {
                            System.out.println("Correct!");
                            foundPairs += shuffled.charAt(index1);
                            money += 5;
                        } else {
                            System.out.println("You have already revealed this pair!");
                            ++k;
                        }
                        repeated = false;
                        System.out.println("You have " + (k - 1) + " guesse(s) remaining");
                    } else {
                        System.out.println("Incorrect!");
                        money -= 2;
                        System.out.println("You have " + (k - 1) + " guesse(s) remaining");
                    }
                } else {
                    System.out.println("enter valid input :(");
                }

                //print current status
                //check for any matches between the shuffled result and the found pairs
                for (int i = 0; i < shuffled.length(); i++) {
                    for (int j = 0; j < foundPairs.length(); j++) {
                        if (foundPairs.charAt(j) == shuffled.charAt(i)) {
                            gameStatus += shuffled.charAt(i);
                            System.out.println(gameStatus);
                        }
                    }

                    //print 'X' once for each letter not found
                    if (gameStatus.length() == i) {
                        if (i == index1 || i == index2) {
                            gameStatus += shuffled.charAt(i);
                        } else {
                            gameStatus += "X";
                        }
                    }
                }
                System.out.println(gameStatus);
                gameStatus = "";

                //win condition
                if (foundPairs.length() == 5) {
                    win = true;
                    System.out.println("you win");
                }
            }
        }
        System.out.println("");
        return money;
    }

    public static void play(int[] stats) {
        final int COST = 3;
        money -= COST;
        int energyGained = 0;
        if (stats[0] < maxStats[0] && money > COST) {
            energyGained = 1;
            stats[0] += 1;
            interactionCount[0] += 1;
            System.out.println("You buy your pet a toy!\n+" + energyGained + " Energy\n -" + COST + " coins");
        }
        else if (money < COST){
            System.out.println("ur too broke");
        }        
    }

    public static void feed(int[] stats) {
        final int COST = 3;
        money -= COST;
        int foodGained = 0;
        if (stats[1] < maxStats[1] && money > COST) {
            stats[1] += 1;
            interactionCount[1] += 1;
            System.out.println("You feed your pet!\n+" + foodGained + " Energy\n -" + COST + " coins");
        }
        else if (money < COST){
            System.out.println("ur too broke");
        }
    }

    public static void groom(int[] stats) {
        int healthGained = 0;
        if (stats[2] < maxStats[2]) {
            stats[2] += 1;
            interactionCount[2] += 1;
            healthGained = 1;
        }
        System.out.println("You groom your pet!\n+" + healthGained + " Health");
    }

    
}
