package org.example;

import java.io.IOException;

public class UserNeeds {

    CustomerDetails custom = new CustomerDetails();

    public void credit(long amount,String name , double balance) throws IOException {
        System.out.println("Hello" + name);
        balance = balance + amount;
        custom.updatebalance(balance);
        System.out.print("  Amount has been credited");

    }

    public void debit(long amount , String name , double balance) throws IOException {
        System.out.println("Hello" + name);
        balance = balance - amount;
        custom.updatebalance(balance);
        System.out.println("debited");
    }

    public void balance(double balance ,String name ){
        System.out.println("Hello " + name);
        System.out.println("your balance "+balance);
    }
}
