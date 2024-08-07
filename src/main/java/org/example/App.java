package org.example;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Existing user type Login" +"\n"+
                "New user type Signup");
        String accNum;
        String pin;
        String in =input.next();

        CustomerDetails cus = new CustomerDetails();
        UserNeeds un = new UserNeeds();

        cus.create();
        switch (in) {
            case "Login": {
                System.out.println("Enter Account number");
                accNum = input.next();
                if (cus.name == null) {
                    System.out.println("No user found");
                    break;
                }
                System.out.println("Enter PIN");
                pin = input.next();
                cus.getDetails(accNum, pin);
                System.out.println("Enter your choice number\n  1.debit \n 2.credit \n 3.balance");
                int choice = input.nextInt();

                switch (choice){
                    case 1:{
                        System.out.println("enter the amount");
                        long deb = input.nextLong();
                        un.debit(deb , cus.name , cus.balance);
                        break;
                    }
                    case 2:{
                        System.out.println("enter the amount");
                        int cred = input.nextInt();
                        un.credit(cred , cus.name , cus.balance);
                        break;
                    }
                    case 3:{
                        un.balance(cus.balance, cus.name);
                        break;
                    }
                }

                break;
            }

            case "Signup": {
                System.out.println("Enter Your Name");
                String name = input.next();
                System.out.println("Enter your Account Number");
                accNum = input.next();
                System.out.println("Set 4 Digit PIN");
                pin = input.next();
                cus.putDetails(name, accNum, pin);
                break;
            }
            default:
                System.out.println("invalid input");
        }
    }
}
