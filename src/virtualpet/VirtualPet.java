/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

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
        boolean startMenu = true;      // default true
        boolean mainMenu = true;        // default true
        boolean choosePet = false;      // default false
        boolean chooseName = true;      // default true
        boolean inPlay = false;          // default false
        boolean interactMenu = false;   // default false
        int petChoice;
        int generateName;
        String petName = "";
        int money = 0;

        //minigames
        int interactMenuChoice;

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
        final int MAXHEALTH = rn.nextInt(19) + 1;
        final int MAXFOOD = rn.nextInt(20 - MAXHEALTH) + 1;
        final int MAXENERGY = 20 - MAXHEALTH - MAXFOOD;
        final int LOGIN_ATTEMPTS = 3;

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
        inPlay = loginMenu(USER, PASSWORD, LOGIN_ATTEMPTS);
        
        while (inPlay) {

            // start menu
            while (mainMenu == true) {
                if (startMenu) {
                    System.out.println("1. Start\n2. Instructions\n3. Exit");

                } else {
                    System.out.println("1. Play/Interact\n2. Instructions\n3. Exit");

                }
                menuChoice = kb.nextInt();
                kb.nextLine();

                switch (menuChoice) {
                    case 1:
                        if (startMenu) {
                            choosePet = true;
                            startMenu = false;
                        } else {
                            interactMenu = true;
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
                System.out.println("Would you like to generate a random name? y/n ");
                kb.nextLine();
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

            while (interactMenu) {
                System.out.println("Choose a game to play: \n1. Number guessing\n2. Matching\n3. Exit");
                interactMenuChoice = kb.nextInt();
                switch (interactMenuChoice) {
                    case 1:
                        minigame1 = true;
                        break;
                    case 2:
                        minigame2 = true;
                        break;
                    default:
                        mainMenu = true;
                }
                interactMenu = false;
            }

            // first minigame
            if (minigame1) {
                money += guessingGame(MAX_GUESSES1);
                minigame1 = false;
                mainMenu = true;
            }

            if (minigame2) {
                money = matchingGame(MAX_GUESSES2, SHUFFLED_LENGTH);
                minigame2 = false;
                mainMenu = true;
            }
        }
    }

    public static boolean loginMenu(String USER, String PASSWORD, int LOGIN_ATTEMPTS) {
        String userInput;
        String passwordInput;
        boolean login = false;

        for (int i = 1; i <= LOGIN_ATTEMPTS; i++) {
            if (login) {
                i = LOGIN_ATTEMPTS + 1;
            } else {
                userInput = JOptionPane.showInputDialog("Username: ");
                passwordInput = JOptionPane.showInputDialog("Password: ");
                if (userInput.equals(USER) && passwordInput.equals(PASSWORD)) {
                    login = true;
                    JOptionPane.showMessageDialog(null, "Success!", ":)", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials!\n" + (LOGIN_ATTEMPTS - i) + " attempts remaining", ":(", JOptionPane.WARNING_MESSAGE);
                    System.out.println(LOGIN_ATTEMPTS - i + " attempts remaining");

                }
            }
        }
        return login;
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
        for (int k = MAX_GUESSES; k > 0 ; k--) {
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
                        if (i == index1 || i == index2){
                        gameStatus += shuffled.charAt(i);
                    }
                        else{
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

        return money;
    }
}
