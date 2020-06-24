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



public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private String cust;
    private int orderQuantity;
    private ArrayList<Menu> menuItems;

    //Constructor Method

    public Order(int _orderId) {
        this.orderId = _orderId;

        menuItems = new ArrayList<>();
    }

    public Order() {
        orderId++;
    }

    //Setters and Getters
    public int getorderId() {
        return orderId;
    }

    public int setorderId(int _orderId) {
        this.orderId = _orderId;
        return _orderId;
    }

    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public int getorderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int _orderQuantity) {
        this.orderQuantity = _orderQuantity;
    }

    public ArrayList<Menu> getMenuItem() {
        return menuItems;
    }

    public void setMenuItem(Menu menuItem) {
        menuItems.add(menuItem);
    }


    public double getSubTotal(){
        double sum = 0;
        for(Menu item : this.menuItems){
            sum += item.getPrice();
        }
        return sum;
    }




    public static void printOrders(ArrayList<Order> oList) {

        for (Order order : oList) {
            System.out.println("Customer name: " + order.getCust() + " Order Id: " + order.getorderId() + " Orders made: " + order.getorderQuantity());

            Menu.listMenu((order.getMenuItem()));


        }

    }
}





