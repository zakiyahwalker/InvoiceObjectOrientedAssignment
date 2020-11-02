package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Store> inventory = new ArrayList<Store>();

        Store st = new Store();
        st.setProducts("Bison Sweater");
        st.setPrices(55.99);
        inventory.add(st);

        st = new Store();
        st.setProducts("Bison Tee");
        st.setPrices(14.99);
        inventory.add(st);

        st = new Store();
        st.setProducts("Bison Hoodie");
        st.setPrices(23.99);
        inventory.add(st);

        st = new Store();
        st.setProducts("Bison Bumpersticker");
        st.setPrices(4.99);
        inventory.add(st);

        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getProducts()+ ": $" + inventory.get(i).getPrices());

        }

        String answer = "";
        Order order = new Order();
        ArrayList<Order> orderedInv = new ArrayList<Order>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("What do you want to do?");
            System.out.println("1) Add purchase 2) Change purchase 3) Show purchases 4) Finish transaction");
            answer = input.nextLine();
//
            if (answer.equals("1")) {
                for (int i = 0; i < inventory.size(); i++) {
                    System.out.println(inventory.get(i).getProducts()+ ": $" + inventory.get(i).getPrices()); }
                System.out.println();
                System.out.println("What item do you want to add?");
                String prod = input.nextLine();
                int index = -1;
                for (int i = 0; i < inventory.size(); i++) {
                    if (inventory.get(i).getProducts().equals(prod)) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Sorry, we don't sell that item");
                } else {
                    String purProd = inventory.get(index).getProducts();
                    Double purPrice = inventory.get(index).getPrices();
                    order = new Order();
                    order.setOrdProd(purProd);
                    order.setOrdPrice(purPrice);
                    orderedInv.add(order);
                }
//
            } else if (answer.equals("2")) {
                System.out.println("Current items in purchase:");

                for (int i = 0; i < orderedInv.size(); i++) {
                    System.out.println(orderedInv.get(i).getOrdProd() + " : $" + orderedInv.get(i).getOrdPrice());
                }
                System.out.println("What item do you want to remove from purchase?");
                String prod = input.nextLine();
                int index = -1;
                for (int i = 0; i < orderedInv.size(); i++) {
                    if (orderedInv.get(i).getOrdProd().equals(prod)) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Sorry, you never added that item to your purchase");
                } else {
                    orderedInv.remove(index);
                }
            } else if (answer.equals("3")) {
                 for (int i = 0; i < orderedInv.size(); i++) {
            System.out.println(orderedInv.get(i).getOrdProd()+ ": $" + orderedInv.get(i).getOrdPrice()); }
            }
        } while (! answer.equals("4"));
        
        float total = 0f;
        for (int i = 0; i < orderedInv.size(); i++) {
            double item = orderedInv.get(i).getOrdPrice();
            total += item;
        }
        System.out.println("Your order total is: $" + total);
        System.out.println("Thank you for ordering!");
    }
    }
