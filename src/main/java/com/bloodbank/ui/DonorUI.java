package com.bloodbank.ui;

import javax.swing.JOptionPane;

import com.bloodbank.person.Donor;
import com.bloodbank.transfusion.Blood;
import com.bloodbank.util.Queue;

public class DonorUI {
    public static Queue donorQueue = new Queue();

    /**
     * Menu for donor operations
     * @author Shah
     */
    public static void menu() {
        Object[] options = { "Check Donor Queue", "Search Donor", "Add Donor", "Remove Donor" };
        int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your option", "Manage Donors", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (chosenOption) {
            case 0:
                checkDonor();
                break;
            case 1:
                searchDonor();
                break;
            case 2:
                addDonor();
                break;
            case 3:
                removeDonor();
                break;
        }
    }

    /**
     * Menu for checking donor queue
     * @author Shah
     */
    public static void checkDonor() {
    }

    /**
     * Menu for searching for a donor
     * @author Marzell
     */
    public static void searchDonor() {
        Object[] searchOption = { "Search by IC", "Search by name" };
        int chosenOption = JOptionPane.showOptionDialog(null, "Please choose your search method", "Search Donor", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, searchOption, searchOption[0]);

        if(chosenOption == -1){
            return;
        }

        String keyword;

        if(chosenOption == 0){
            keyword = JOptionPane.showInputDialog(null, "Enter Donor's IC");
        }
        else {
            keyword = JOptionPane.showInputDialog(null, "Enter Donor's name");
        }

        if(keyword == null || keyword.isEmpty()){
            return;
        }

        Donor foundDonor = null;
        Donor current = (Donor) DonorUI.donorQueue.getFirst();

        while (current != null) {
            boolean matches;
            if (chosenOption == 0) {
                matches = current.getNRIC().equalsIgnoreCase(keyword);
            } else {
                matches = current.getName().equalsIgnoreCase(keyword);
            }

            if (matches) {
                foundDonor = current;
                break;
            }

            current = (Donor) DonorUI.donorQueue.getNext();
        }

        if (foundDonor != null) {
            JOptionPane.showMessageDialog(null, "Donor Found:\n" + foundDonor);
        } else {
            JOptionPane.showMessageDialog(null, "\nNo donor matching" + keyword + "was found in the queue.");
        }
    }

    /**
     * Menu for adding new donor
     * @author Shah
     * @author Isya
     */
    public static void addDonor() {
        String ic = JOptionPane.showInputDialog(null, "Enter Donor's IC");
        String name = JOptionPane.showInputDialog(null, "Enter Donor's Name");
        String contact = JOptionPane.showInputDialog(null, "Enter Donor's Contact");

        /* Blood Group */
        String bloodGroup = null;

        Object[] bloodG = { "A", "B","AB","O" };
        int chosenOption = JOptionPane.showOptionDialog(null, "Please Choose Donor's Blood Group", "Donor's Blood Group", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, bloodG, bloodG[0]);
        switch (chosenOption) {
            case 0: bloodGroup = "A"; break;
            case 1: bloodGroup = "B"; break;
            case 2: bloodGroup = "AB"; break;
            case 3: bloodGroup = "O"; break;
        }
        /* Blood Group */

        /* Rh Group */
        Object[] rh = { "+", "-" };
        chosenOption = JOptionPane.showOptionDialog(null, "Please Choose Donor's Blood Rh", "Donor's Blood Group", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rh, rh[0]);
        switch (chosenOption) {
            case 0: bloodGroup += "+"; break;
            case 1: bloodGroup += "-"; break;
        }
        /* Blood Group */

        String volumeStr = JOptionPane.showInputDialog(null, "Enter Donor's Blood Volume (mL)");
        double volume = Double.parseDouble(volumeStr);

        Blood blood = new Blood(bloodGroup, volume);

        Donor d = new Donor(ic, name, contact, blood);

        System.out.println(d);

        donorQueue.enqueue(d);

        JOptionPane.showMessageDialog(null, "Donor Added to Queue");
    }

    /**
     * Menu for removing existing donor
     * @author Iqbal
     */
    public static void removeDonor() {
    }

    /**
     * Menu for editing existing donor
     * @author Maya
     */

    public static void editDonor() {
    	
    	java.util.Scanner scanner = new java.util.Scanner(System.in);
    	int choice = 0;
    	
    	System.out.println("\n=================================");
        System.out.println("   DATA UPDATING MENU    ");
        System.out.println("=================================");
        System.out.println("1. Update data in hospitalList");
        System.out.println("2. Update blood bag lists");
        System.out.println("3. Update data in staffList");
        System.out.println("4. Cancel");
        System.out.print("Select an option (1-4): ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
            
            // OPTION 1: Update Hospital Data
            if (choice == 1) {
                System.out.print("\nEnter Hospital Name to update: ");
                String name = scanner.nextLine();
                
                Hospital hospital = hospitalList.searchHospitalByNAME(name);
                
                if (hospital != null) {
                	System.out.print("Enter new Hospital Name: ");
                    String newName = scanner.nextLine();
                	System.out.print("Enter new Address Details: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new Distance: ");
                    String newDistance = scanner.nextLine();
                    System.out.print("Enter new Contact Number: ");
                    String newContact = scanner.nextLine();
                    
                    hospital.setContactNumber(newContact);
                    hospital.setAddress(newAddress);
                    System.out.println("Hospital details updated successfully!");
                } 
                	else {
                    System.out.println("Error: Hospital Name not found.");
                }
                
            // OPTION 2: Update Blood Bag Data
            } else if (choice == 2) {
                System.out.print("\nEnter the blood type of the bag (A, B, AB, O): ");
                String type = scanner.nextLine().toUpperCase().trim();
                
                LinkedList targetList = null;
                if (type.equals("A")) {
                    targetList = aBloodBagList;
                } else if (type.equals("B")) {
                    targetList = bBloodBagList;
                } else if (type.equals("AB")) {
                    targetList = abBloodBagList;
                } else if (type.equals("O")) {
                    targetList = oBloodBagList;
                }
                
                if (targetList != null) {
                    System.out.print("Enter Blood Bag ID to update: ");
                    String bagId = scanner.nextLine();
                    
                    // to search for specific blood bag
                    BloodBag bag = targetList.searchBloodBagByID(bagId);
                    
                    if (bag != null) {
                        System.out.print("Enter corrected Donor Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter updated Status (Available/Reserved): ");
                        String newStatus = scanner.nextLine();
                         
                        bag.setDonorName(newName);
                        bag.setStatus(newStatus);
                        System.out.println("Blood bag information updated successfully!");
                    } else {
                        System.out.println("Error: Blood Bag ID not found.");
                    }
                } else {
                    System.out.println("Error: Invalid blood type selected.");
                }
                
            // OPTION 3: Update Staff Data
            } else if (choice == 3) {
                System.out.print("\nEnter Staff ID to update: ");
                String staffId = scanner.nextLine();

                Staff staff = staffList.searchStaffByID(staffId);
                
                if (staff != null) {
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Contact Number: ");
                    String newContact = scanner.nextLine();
                    
                    staff.setPosition(newPosition);
                    staff.setContactInfo(newContact);
                    System.out.println("Staff record updated successfully!");
                } else {
                    System.out.println("Error: Staff member not found.");
                }
                
            // OPTION 4: For Cancelling (cancel update data)
            } else if (choice == 4) {
                System.out.println("Returning to main application...");
            } else {
                System.out.println("Invalid selection. Returning to menu.");
            }
        } else {
            System.out.println("Invalid input format. Please enter numbers only."); //dont close scanner
        }
    }
}