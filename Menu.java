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

public class Menu {

    //Class Level Variables - Protect the data
    private int menuId;
    private double price;
    private String menuItem;

    //Constructor Method
    public Menu(int _menuId, String _menuItem, double _price){
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this.price = _price;
    }

    //Setters and Getters
    public int getmenuId() { return menuId; }
    public void setmenuId(int _menuId) {this.menuId = _menuId;}

    public double getprice() { return price; }

    public void setprice(double _price) {this.price = _price;}

    public String getmenuItem() { return menuItem; }
    public void setmenuItem(String _menuItem) {this.menuItem = _menuItem;}

    public double getPrice() { return price; }
    public void setPrice(double _menuPrice) {this.price = price;}

    public static void listMenu(ArrayList<Menu> mList){
        System.out.println("Please press 'O' to add your order after you see the menu");
        System.out.println("");
        for (Menu menu: mList) {
            System.out.println(menu.getmenuItem());
        }


    }

    public static boolean getmenuItem(ArrayList<Menu> mList, int menuId){
        for (Menu menu: mList) {
            if (menuId == menu.getmenuId()){
                return true;
            }
        }
        return false;
    }

}
