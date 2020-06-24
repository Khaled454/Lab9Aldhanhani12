package edu.psu.abington.ist.ist242;

/*
Project: Lab 9
Purpose Details: Pizza ordering application
Course: IST 242
Author: Khaled Aldhanhani
Date Developed: 6/14/20
Last Date Changed: 6/21/20
Rev: 12
 */


import java.util.ArrayList;
import java.util.Scanner;

enum PaymentType {cash, credit}
public class Transaction {

    //Class Level Variables - Protect the data
    private int transactionId;
    private Order order;
    private PaymentType pType;

    //Constructor Method
    public Transaction(int _transactionId, Order _order, PaymentType _pType){
        this.transactionId = _transactionId;
        this.order = _order;
        this.pType = _pType;
    }

    //Setters and Getters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int _transactionId) {this.transactionId = _transactionId;}

    public Order getOrder() { return order; }
    public void setOrder(Order _order) {this.order = _order;}

    //public String getCustomerName() {

    // return customerName; }
    // public void setCustomerName(String _customerName) {this.customerName = _customerName;}


    public PaymentType getPaymentType() { return pType; }
    public void setPaymentType(PaymentType _pType) {this.pType = _pType;}

    public static void listTransactions(ArrayList<Transaction> tList,ArrayList<Order> oList ){
        for (Transaction trans: tList){
            Order order = trans.getOrder();

            System.out.println("Transaction ID: " + trans.getTransactionId());
            System.out.println("Customer: " +order.getCust());
            System.out.println("Subtotal:" +order.getSubTotal());
            System.out.println("Payment Type: " + trans.getPaymentType());
        }

        System.out.println("Choose your payment type. Enter 1 for Cash 2 for Credit");
        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();
        if(choice==1){
            System.out.println("You have selected Cash");
        }
        else if (choice==2){
            System.out.println("You selected Credit");
        }
        System.out.println("");
        System.out.println("Transaction made");
        System.out.println("Thanks and have a good one");

    }

}