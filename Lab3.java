// Programmers:  [your names here]
// Course:  CS 212
// Due Date:
// Lab Assignment:
// Problem Statement:
// Data In:
// Data Out:
// Credits: [Is your code based on an example in the book, in class, or something else?
//            Reminder: you should never take code from the Internet or another person

import java.util.Scanner;
public class Main 
{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double initial_balance = 212.90;
    double balance = initial_balance;
    System.out.println("Welcome to the Smart ATM, where we're smart with money so you don't have to be!");
    System.out.println("Esteemed user, please enter your name: ");
    String name = input.nextLine();
    String choice = "";
      while (choice != "L"){
        System.out.println("What would you like to do, " + name + ": D - Deposit, W - Withdraw, C - Check Balance, or L - Leave");
        choice = input.next().toUpperCase().trim(); 
        if (choice.equals("D")){
          System.out.println("How much would you like to deposit?");
          double deposit = input.nextDouble();
          balance += deposit;
          System.out.println("Your new balance is: " + balance);
        }
        else if (choice.equals("W")){
          System.out.println("How much would you like to withdraw?");
          double withdraw = input.nextDouble();
          balance -= withdraw;
          System.out.println("Your new balance is: " + balance);
        }
        else if (choice.equals("C")){
          System.out.println("Your current balance is: " + balance);
        }
        else {
          System.out.println("That was not a valid option, please try again");
      }
      }
      System.out.println("Would you like a receipt (P - Printed, E - Emailed)");
      String receipt = input.nextLine().toUpperCase().trim();
      if (balance < 0) {
        System.out.println("You deposited " + (balance - initial_balance) + " dollars!");
      }
      else if (balance > 0) {
        System.out.println("You deposited " + (initial_balance - balance) + " dollars!");
      }
      if (receipt == "P"){
        System.out.print("Please take the printed receipt. Have a great day!");
      }
      else{
        System.out.print("Please take the emailed receipt Have a great day!");
      }

    
  }

  }
