//Name: Xander Thompson
//Date: 3/11/2020
//Desc: Final Project - Guess a random number that is generated 
//Import scanner, random, and file io objects
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class LetsGuess {

   public static int getInt() {
      //New Scanner Class
      Scanner keyboard = new Scanner (System.in);
      int keyboardInput = keyboard.nextInt();
      return keyboardInput;
   }

   public static void ArrayRandomizer (int SomeArray[]) {
      
      //Random number class
      Random randomNum = new Random();
      
      //Using the random number class in order to walk over an array, and insert random number in
      for (int i = 0; i < SomeArray.length; i++) {
           int RandomDigit;
           RandomDigit = randomNum.nextInt(10);
           SomeArray[i] = RandomDigit;
      }
   }
   
   public static void PrintTo(int SomeArray[], int g) throws IOException {
   
      //Creating a new file
      PrintWriter outputFile = new PrintWriter("GuessNumResults.txt");
      
      //Writing what numbers were correct
      for (int i = 0; i < SomeArray.length; i++) {
          outputFile.println("Number that should've been guessed: " + SomeArray[i]);
      }
      
      //Writes to file if the user was able/unable to correctly guess
      switch (g) {
         case 3:
            outputFile.println("You were unable to guess all the numbers");
            outputFile.println("Try guessing again in the future");
            break;
         default:
            outputFile.println("You were able to guess all the numbers! Congrats!!!");
            break;
      }
      
      outputFile.close();
   }

   public static void main(String Args[]) throws IOException {
   
      //Asking user how many numbers should be guessed
      System.out.print("How many numbers would you like to guess? ");
      
      //Returning Keyboard input into variable AmountNum
      int AmountNum = getInt();
       
      //pushing AmountNum into an Array
      int[] NumsRandomize = new int[AmountNum];
      
      //Invoke Method
      ArrayRandomizer(NumsRandomize);
      
      //Asking for the number
      System.out.println("Alright, the numbers have been randomized and chosen.");
      
      //Variable i assigned, meant to keep tally as to what number is guessed
      int i = 0;
      
      //Variable g assigned, meant to keep tally as to incorrect guesses
      //When it hits three the game is over
      int g = 0;
      
      //Loop for guessing numbers
      while (true) {
      
         //Checkup to see if all numbers have been guessed
         if (i == AmountNum) {
             System.out.println("Looks like you guessed each number correctly! Congrats!");
             break;      
         }else if (g == 3){
            System.out.println("Oops looks like you couldnt guess the number in 3 trys.");
            System.out.println("Try again later");
            break;
         }else{
             System.out.println("Lets guess what number " + (i+1) + " is");
         }
         System.out.println("Guess a number between 0-10");
         int GuessedNum = getInt();
         
         //Assigning the value of NumRandomize number to variable ChosenNum
         int ChosenNum = NumsRandomize[i];
         
         //Checking the number
            if (GuessedNum == ChosenNum) {
               //If i = AmountNum then stop the game, congrats user for guessing all numbers
               System.out.println("Congrats, " + GuessedNum + " was the right number!");
               System.out.println("On to the next number!");
               ++i;
               //Reset g to 0
               g = 0;
            }else if (GuessedNum > ChosenNum) {
               System.out.println("Hmm, i think that number is too big. Try again");
               ++g;
            }else if (GuessedNum < ChosenNum) {
               System.out.println("Hmmm, i think that number is too small. Try again");
               ++g;
            }else {
               System.out.println("Did you guess between 0 and 10? Try again");
            }
      }
      
      //Outputting the results of guessing the number to the file
      PrintTo(NumsRandomize, g);
      
   }
}