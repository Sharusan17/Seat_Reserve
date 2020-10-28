package com.company;

import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

//todo: While loop
//todo: firstclass seats
//todo: If booking is no and reserving is no, it should exit the program

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("               Welcome To EasyJet!                  ");
        System.out.println("----------------------------------------------------");
        System.out.println("•Would you like to book a ticket?(Y/N)");
        String ticket = scanner.nextLine();
        boolean book_ticket = ticket.equals("Y") || ticket.equals("y");
        String seat_class = " ";
        if (book_ticket == true) {
            System.out.println("How many people do you want book?");
            int num_people = scanner.nextInt();
            String s = scanner.nextLine();
            System.out.println("First Class or Economy Class?");
            seat_class = scanner.nextLine();
            if (seat_class.equals("First Class") || seat_class.equals("first class")) {
                System.out.println("------------------------------------------------------");
                System.out.println("You have selected " + num_people + " First Class Ticket!");
                System.out.println("------------------------------------------------------");
            } else if (seat_class.equals("Economy Class") || seat_class.equals("economy class")) {
                System.out.println("------------------------------------------------------");
                System.out.println("You have selected " + num_people + " Economy Class Ticket!");
                System.out.println("------------------------------------------------------");
            }
        }else{
        }

        String firstclass = NumberFormat.getCurrencyInstance().format(200);
        String economyclass = NumberFormat.getCurrencyInstance().format(150);

        String firstclass_extraleg = NumberFormat.getCurrencyInstance().format(215);
        String economyclass_extraleg = NumberFormat.getCurrencyInstance().format(165);

        int rows = 40;
        int rowsleg = 15;
        int cols = 6;
        int floor = 2;

        System.out.println("Display of Seats(Y/N):");
        String display = scanner.nextLine();
        boolean displaySeats = display.equals("Y") || display.equals("y");
        if (displaySeats == true) {
            System.out.println("--------------------------------------------");
            System.out.println("                 Lower Deck                 ");
            System.out.println("--------------------------------------------");
            for (int f = 1; f <= floor; f++) {
                if (f == 2) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("--------------------------------------------");
                    System.out.println("                 Upper Deck                 ");
                    System.out.println("--------------------------------------------");
                }
                for (int i = 1; i <= rows; i++) {
                    System.out.println(" ");
                    if (f == 2 && i == 11) {
                        System.out.println("-------------------First Class--------------------");
                    }
                    if (f == 1 && i == 16) {
                        System.out.println("---------------------Leg Room---------------------");
                    }

                    for (int j = 1; j <= cols; j++) {
                        if (j == 4) {
                            System.out.print("  ");
                        }
                        System.out.print("[" + i + "," + j + "]");
                    }
                }
            }
            System.out.println(" ");
            System.out.println(" ");
        }


        if (seat_class.equals("First Class") || seat_class.equals("first class")) {

            System.out.println("•Would you like to reserve your seat?(Y/N)");
            String reserve_seat = scanner.nextLine();

            System.out.println("•Extra Leg Room?(Y/N)");
            String extralegs = scanner.nextLine();
            boolean legroom = extralegs.equals("Y") || extralegs.equals("y");

            if (reserve_seat.equals("Y") || reserve_seat.equals("y")) {
                if (legroom == true) {
                    System.out.println("Enter the row:(1-15)");
                    int selectrow = scanner.nextInt();
                    System.out.println("Enter the column:(1-6)");
                    int selectcol = scanner.nextInt();
                    while (true) {
                        if (selectrow < 1 || selectrow > 15 || selectcol < 1 || selectcol > 6) {
                            System.out.println("Choose from 1-15");
                            selectrow = scanner.nextInt();
                            System.out.println("Choose from 1-6");
                            selectcol = scanner.nextInt();
                            continue;
                        }
                        System.out.println("Your Selected Seat is [" + selectrow + "," + selectcol + "]");
                        break;
                    }
                } else {
                    System.out.println("Enter the row:(15-40)");
                    int selectrow = scanner.nextInt();
                    System.out.println("Enter the column:(1-6)");
                    int selectcol = scanner.nextInt();
                    while (true) {
                        if (selectrow < 15 || selectrow > 40 || selectcol < 1 || selectcol > 6) {
                            System.out.println("Choose from 15-40");
                            selectrow = scanner.nextInt();
                            System.out.println("Choose from 1-6");
                            selectcol = scanner.nextInt();
                            continue;
                        }
                        System.out.println("Your Selected Seat is [" + selectrow + "," + selectcol + "]");
                        break;
                    }
                }

            } else if (reserve_seat.equals("N") || (reserve_seat.equals("n"))) {
                if (legroom == true) {
                    Random random = new Random();
                    int randomrowslegs = random.nextInt(rowsleg);
                    int randomcols = random.nextInt(cols);
                    System.out.print("Your seat is [" + randomrowslegs + "," + randomcols + "]");
                    System.out.println(" ");
                } else {
                    Random random = new Random();
                    int randomrows = random.nextInt(rows);
                    int randomcols = random.nextInt(cols);
                    System.out.print("Your seat is [" + randomrows + "," + randomcols + "]");
                    System.out.println(" ");
                }
            }

            if (legroom == true) {
                System.out.println("---------------------------------------------");
                System.out.println("Price of ticket: " + firstclass_extraleg + "(inc.£15 for legroom)");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("------------------------");
                System.out.println("Price of ticket: " + firstclass);
                System.out.println("------------------------");
            }
        }

        else if (seat_class.equals("Economy Class") || seat_class.equals("economy class")) {

            System.out.println("•Extra Leg Room?(Y/N)");
            String extralegs = scanner.nextLine();
            boolean legroom = extralegs.equals("Y") || extralegs.equals("y");

            if (legroom == true) {
                Random random = new Random();
                int randomrowslegs = random.nextInt(rowsleg);
                int randomcols = random.nextInt(cols);
                System.out.print("Your seat is [" + randomrowslegs + "," + randomcols + "]");
                System.out.println(" ");
            } else {
                Random random = new Random();
                int randomrows = random.nextInt(rows);
                int randomcols = random.nextInt(cols);
                System.out.print("Your seat is [" + randomrows + "," + randomcols + "]");
                System.out.println(" ");
            }

            if (legroom == true) {
                System.out.println("---------------------------------------------");
                System.out.println("Price of ticket: " + economyclass_extraleg + "(inc.£15 for legroom)");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("------------------------");
                System.out.println("Price of ticket: " + economyclass);
                System.out.println("------------------------");
            }
        }
        System.out.println("Thanks For Visiting");
    }
}

