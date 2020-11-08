package com.company;

import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        int num_people = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("               Welcome To EasyJet!                  ");
        System.out.println("----------------------------------------------------");
        System.out.println("•Would you like to book a ticket?(Y/N)");
        String ticket = scanner.nextLine();
        boolean book_ticket = ticket.equals("Y") || ticket.equals("y");
        String seat_class = " ";
        if (book_ticket == true) {
            System.out.println("How many people do you want book?");
            num_people = scanner.nextInt();
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
        }

        String firstclass = NumberFormat.getCurrencyInstance().format(900 * num_people);
        String economyclass = NumberFormat.getCurrencyInstance().format(400 * num_people);

        String firstclass_extraleg = NumberFormat.getCurrencyInstance().format(915 * num_people);
        String economyclass_extraleg = NumberFormat.getCurrencyInstance().format(415 * num_people);

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
                for (int b = 1; b<=num_people; b++) {
                    if (legroom == true) {
                        System.out.println("Enter the row for ticket "+b+":(1-15)");
                        int selectrow = scanner.nextInt();
                        System.out.println("Enter the column for ticket "+b+":(1-6)");
                        int selectcol = scanner.nextInt();
                        while (true) {
                            if (selectrow < 1 || selectrow > 15 || selectcol < 1 || selectcol > 6) {
                                System.out.println("Choose from 1-15");
                                selectrow = scanner.nextInt();
                                System.out.println("Choose from 1-6");
                                selectcol = scanner.nextInt();
                                continue;
                            }
                            System.out.print("Your seat for ticket " + b + ": [" + selectrow + "," + selectcol + "]");
                            System.out.println(" ");
                            break;
                        }
                    } else {
                        for (b = 1; b<=num_people; b++) {
                            System.out.println("Enter the row for ticket " + b + ":(15-40)");
                            int selectrow = scanner.nextInt();
                            System.out.println("Enter the column for ticket " + b + ":(1-6)");
                            int selectcol = scanner.nextInt();
                            while (true) {
                                if (selectrow < 15 || selectrow > 40 || selectcol < 1 || selectcol > 6) {
                                    System.out.println("Choose from 15-40");
                                    selectrow = scanner.nextInt();
                                    System.out.println("Choose from 1-6");
                                    selectcol = scanner.nextInt();
                                    continue;
                                }
                                System.out.print("Your seat for ticket " + b + ": [" + selectrow + "," + selectcol + "]");
                                System.out.println(" ");
                                break;
                            }
                        }
                    }
                }


            }else if (reserve_seat.equals("N") || (reserve_seat.equals("n"))) {
                for (int b = 1; b<=num_people; b++) {
                    if (legroom == true) {
                        Random random = new Random();
                        int randomrowslegs = random.nextInt(rowsleg);
                        int randomcols = random.nextInt(cols);
                        System.out.print("Your seat for ticket " + b + ": [" + randomrowslegs + "," + randomcols + "]");
                        System.out.println(" ");
                    } else {
                        Random random = new Random();
                        int randomrows = random.nextInt(rows);
                        int randomcols = random.nextInt(cols);
                        System.out.print("Your seat for ticket " + b + ": [" + randomrows + "," + randomcols + "]");
                        System.out.println(" ");
                    }
                }
            }


            if (legroom == true) {
                System.out.println("---------------------------------------------");
                System.out.println("Price of ticket for "+num_people+" people : "+ firstclass_extraleg + "(inc.£15 for legroom)");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("------------------------");
                System.out.println("Price of ticket for " +num_people+" people : " + firstclass);
                System.out.println("------------------------");
            }
        }

        else if (seat_class.equals("Economy Class") || seat_class.equals("economy class")) {
            System.out.println("•Extra Leg Room?(Y/N)");
            String extralegs = scanner.nextLine();
            boolean legroom = extralegs.equals("Y") || extralegs.equals("y");

            for (int b = 1; b<=num_people; b++) {
                if (legroom == true) {
                    Random random = new Random();
                    int randomrowslegs = random.nextInt(rowsleg);
                    int randomcols = random.nextInt(cols);
                    System.out.print("Your seat for ticket " + b + ": [" + randomrowslegs + "," + randomcols + "]");
                    System.out.println(" ");
                } else {
                    Random random = new Random();
                    int randomrows = random.nextInt(rows);
                    int randomcols = random.nextInt(cols);
                    System.out.print("Your seat for ticket " + b + ": [" + randomrows + "," + randomcols + "]");
                    System.out.println(" ");
                }
            }

            if (legroom == true) {
                System.out.println("---------------------------------------------");
                System.out.println("Price of ticket for "+num_people+" people : "+ economyclass_extraleg + "(inc.£15 for legroom)");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("------------------------");
                System.out.println("Price of ticket for " +num_people+" people: " + economyclass);
                System.out.println("------------------------");
            }
        }
        System.out.println("Thanks For Visiting");
    }
}
