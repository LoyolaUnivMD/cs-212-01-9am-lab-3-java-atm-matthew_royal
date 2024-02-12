// Programmers:  Matthew and Royal
// Course: CS 212
// Due Date: 2/11/24
// Lab Assignment: 3
// Problem Statement: Coding an ATM to work for deposits, withdraws, and balance checks
// Data In: User's name, desired action, deposit/withdraw amount, type of receipt wanted
// Data Out: User's balance, total deposited/withdrawn, error message, etc...
// Credits: N/A

// Import all necessary utilities
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main 
{
  public static void main(String[] args) {

    // Set up the utilities to be used in the program
    Scanner input = new Scanner(System.in);
    DecimalFormat fmt = new DecimalFormat("#0.00");

    // Initialize the balance of the user
    double initial_balance = 212.90;
    double balance = initial_balance;

    // Output the program's purpose
    System.out.println("Welcome to the Smart ATM, where we're smart with money so you don't have to be!");

    // Ask and store user's name
    System.out.println("Esteemed user, please enter your name: ");
    String name = input.nextLine();

    // Initialize the value which controls the while loop
    String choice = "";

    // While loop which allows the user to deposit, withdraw, check balance, and end their session
      while (!choice.equals("L")){

        // Asks and stores user's desired action
        System.out.println("What would you like to do, " + name + ": D - Deposit, W - Withdraw, C - Check Balance, or L - Leave");
        choice = input.next().toUpperCase().trim();

        // If-statement which performs a certain task based on the inputted action
        if (choice.equals("D")){

          // Asks and stores user's deposit amount, updates and prints out balance
          double deposit = 0;
          boolean counter = true;

          // While loop which error checks users input
          while (counter) {
            System.out.println("How much would you like to deposit?");
            String deposit_string = input.next();

          // Try-catch used to ensure the program doesn't crash
            try {
              deposit = Double.parseDouble(deposit_string);

          // If-statement which ensures the speed is positive
              if (deposit<0){
                System.out.println("Invalid amount. Try again: ");
              } else {
                counter = false;
              }
            } catch (NumberFormatException ignored) {
              System.out.println("Invalid amount. Try again: ");
            }
          }
          balance += deposit;
          System.out.println("Your new balance is: " + balance);
        } else if (choice.equals("W")){

          // Asks and stores user's withdraw amount, updates and prints out balance
          double withdraw = 0;
          boolean counter = true;

          // While loop which error checks user's input
          while (counter) {
            System.out.println("How much would you like to withdrawal?");
            String withdraw_string = input.next();

          // Try-catch used to ensure the program doesn't crash
            try {
              withdraw = Double.parseDouble(withdraw_string);

          // If-statement which ensures the speed is positive
              if (withdraw<0){
                System.out.println("Invalid amount. Try again: ");
              } else {
                counter = false;
              }
            } catch (NumberFormatException ignored) {
              System.out.println("Invalid amount. Try again: ");
            }
          }
          if ((balance - withdraw)<0){
            System.out.println("You cannot take that amount of money as you have insufficient funds!");
            withdraw = 0;
          }
          balance -= withdraw;
          System.out.println("Your new balance is: " + balance);
        } else if (choice.equals("C")){

          // Outputs user's balance
          System.out.println("Your current balance is: " + balance);
        } else if (choice.equals("L")) {
          System.out.println("Thanks for using our services!");
        } else {

          // Error message to inform user of their invalid input
          System.out.println("That was not a valid option, please try again");
      }
      }

      // Asks and stores user's receipt choice
      System.out.println("Would you like a receipt (P - Printed, E - Emailed)");
      String receipt = input.next().toUpperCase().trim();

      // Calculates the total deposit/withdraw amount and outputs the user's balance
      if (balance < initial_balance) {
        System.out.println("You withdrew " + fmt.format((initial_balance - balance)) + " dollars!");
      } else if (balance > initial_balance) {
        System.out.println("You deposited " + fmt.format((balance - initial_balance)) + " dollars!");
      } else {
        System.out.println("You neither added nor took any money!");
      }

      // Ends the program with a statement regarding the user's receipt
      if (receipt.equals("P")){
        System.out.print("Please take the printed receipt. Have a great day!");
      }
      else if (receipt.equals("E")) {
        System.out.println("Please look at the emailed receipt! Have a great day!");
      } else {
        System.out.print("No receipt, no problem! Have a great day!");
      }

    
  }

  }
