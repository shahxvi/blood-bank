//package com.bloodbank;

//import java.util.Scanner;

//import com.bloodbank.person.Donor;
//import com.bloodbank.recipient.Hospital;
//import com.bloodbank.transfusion.Bag;
//import com.bloodbank.transfusion.Blood;

//public class Mainn {
    //public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        //int choice = 0;

        //while (choice != 3) {

            //System.out.println("\n=== DATA INSERTION MENU ===");
            //System.out.println("1. Add New Hospital");
            //System.out.println("2. Add New Donor to Queue");
            //System.out.println("3. Process Blood Transfusion");
            //System.out.print("Choice (1-3) : ");

            //choice = sc.nextInt();
            //sc.nextLine();

            //if (choice == 1) {

                //System.out.println("\nInsert Hospital : ");
                //System.out.print("Name: ");
                //String name = sc.nextLine();

                //System.out.print("Address: ");
                //String address = sc.nextLine();

                //System.out.print("Contact: ");
                //int contact = sc.nextInt();
                //sc.nextLine();

                //Hospital h = new Hospital(name, address, contact);
                //hospitalList.insertAtBack(h);

                //System.out.println("Hospital successfully add.");

            //} else if (choice == 2) {

                //System.out.println("\nInsert Donor");
                //System.out.print("NRIC: ");
                //String ic = sc.nextLine();

                //System.out.print("Name: ");
                //String name = sc.nextLine();

                //System.out.print("Contact: ");
                //int contact = sc.nextInt();
                //sc.nextLine();

                //System.out.print("Blood Group (A/B/AB/O): ");
                //String bloodGroup = sc.nextLine();

                //System.out.print("Volume ML: ");
                //double volume = sc.nextDouble();
                //sc.nextLine();

                //Blood blood = new Blood(bloodGroup, volume);
                //Donor d = new Donor(ic, name, contact, blood);

                //donorQueue.enqueue(d);

                //System.out.println("Donor added to queue!");

            //} else if (choice == 3) {

                //System.out.println("Process Blood Transfusion.");

                //if (donorQueue.isEmpty()) {

                    //System.out.println("No donor to process.");

                //} else {

                    //Donor d = donorQueue.dequeue();
                    //System.out.println("Processing donor:");

                    //Bag bag = new Bag(d);

                    //String bg = d.getBlood();

                    //if (bg.equals("A")) {

                        //aBloodBagList.insertAtBack(bag);
                        //System.out.println("Added to Blood Group A list.");

                    //} else if (bg.equals("B")) {

                        //bBloodBagList.insertAtBack(bag);
                        //System.out.println("Added to Blood Group B list.");

                    //} else if (bg.equals("AB")) {

                        //abBloodBagList.insertAtBack(bag);
                        //System.out.println("Added to Blood Group AB list.");

                    //} else if (bg.equals("O")) {

                        //oBloodBagList.insertAtBack(bag);
                        //System.out.println("Added to Blood Group O list.");

                    //} else {

                        //System.out.println("Blood group invalid.");
                    //}
                //}
            //}
        //}

        //sc.close();
    //}
//}