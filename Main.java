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



public class Main {
    int cCount = 1;
    int oCount = 1;

    public static void main(String[] args) {

        Main main = new Main();

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char ORDE_PRNT = 'Y';
        //final char HELP_CODE = '?';
        char userAction;
        final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder,'Y' to print Order, or  type 'T' to list Transactions,or 'E'xit: ";
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();
        //ArrayList<Help> hList = new ArrayList<>();

        //Order order1 = new Order(1);

        //Transaction trans1 = new Transaction(1, , PaymentType.cash);
        //Transaction trans2 = new Transaction(2, , PaymentType.credit);


        Menu menu1 = new Menu(1, "1.Plain", 2.00f);
        Menu menu2 = new Menu(2, " 2.Meat", 2.50f);
        Menu menu3 = new Menu(3, " 3.Cheese ", 1.00f);
        Menu menu4 = new Menu(4, " 4.Veg", 4.00f);
        Menu menu5 = new Menu(5, " 5.Peperoni", 3.00f);

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);
        mList.add(menu5);

        //oList.add(order1);


        //tList.add(trans1);
        //tList.add(trans2);

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE:
                    cList.add(main.addCustomer());
                    break;
                case CUST_PRNT:
                    Customer.printCustomer(cList);
                    break;
                case MENU_CODE:
                    Menu.listMenu(mList);
                    break;
                case ORDE_CODE:
                    oList.add(main.addOrders(mList, cList));
                    break;
                case ORDE_PRNT:
                    Order.printOrders(oList);
                    break;
                case TRAN_CODE:
                    Transaction.listTransactions(tList,oList);
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
    }

    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    public Customer addCustomer() {
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        return cust;
    }

    public Order addOrders(ArrayList<Menu> mlist, ArrayList<Customer> cList) {
        Order order = new Order(oCount++);
        Scanner scnr = new Scanner(System.in);
        Scanner scnr2 = new Scanner(System.in);
        ArrayList<Menu> menuItems = new ArrayList<>();
        boolean isOnMenu = false;

        do {
            System.out.println("Enter the menu ID");
            //int answer = order.setorderId(scnr.nextInt());
            int answer = scnr.nextInt();
            for (Menu menuItem : mlist) {
                if (answer == menuItem.getmenuId()) {
                    order.setMenuItem(menuItem);
                    menuItems.add(menuItem);
                    isOnMenu = true;
                    break;
                }
            }
            if (!isOnMenu) {
                System.out.println("Item is not on the menu. ");
            }
        } while (isOnMenu == false);
        System.out.println("How many would you like to order?");
        order.setOrderQuantity(scnr.nextInt());
        boolean isCustomer = false;
        do {
            System.out.println("Who is ordering?");
            String an = scnr2.nextLine();
            for (Customer currentCust : cList) {
                if (an.equals(currentCust.getCustomerName())) {
                    order.setCust(an);
                    isCustomer = true;
                    break;
                }
            }
            if (!isCustomer) {
                System.out.println("Customer does not exist.");
            }
        } while (isCustomer == false);
        return order;


    }

}












