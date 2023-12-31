package com.driver;

import java.util.ArrayList;
import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {
    }

    public BankAccount(String name, double balance, double minBalance) {
           this.name  = name;
           this.balance = balance;
           this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws java.lang.Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
         if(9*digits<sum  || sum<0)
         {
             throw new Exception("Account Number can not be generated");
         }
         else{

             int[] arr  = new int[digits];
             for(int i = 0;i<digits;i++){
                 arr[i]  = 9;
             }
             int index  = 0;
             while(sumOfArr(arr)>sum){
                 int diff  = arr[index]-1;
                 arr[index++] = Math.min(diff , sum-sumOfArr(arr)+diff);
             }

             return arr.toString();

         }


    }
    public int sumOfArr(int[] arr){
        int sum  = 0;
        for(int i : arr) sum  += i;
        return sum;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws java.lang.Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
         double remainingAmount  =  this.balance-amount;

         if(remainingAmount<minBalance){
             throw new Exception("Insufficient Balance");
         }

         this.balance  = remainingAmount;

    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    //useful
    public void setName(String name) {
        this.name = name;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}
