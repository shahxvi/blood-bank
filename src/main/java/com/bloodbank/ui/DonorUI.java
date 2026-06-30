package com.bloodbank.ui;

import javax.swing.JOptionPane;

import com.bloodbank.person.Donor;
import com.bloodbank.transfusion.Blood;
import com.bloodbank.util.Queue;

public class DonorUI {

    /**
     * Menu for donor operations
     * @author Shah
     */
    public static void menu(Queue donorQueue) {
        Object[] options = { "Check Donor Queue", "Search Donor", "Add Donor", "Remove Donor"};
        String str = "Please choose your option";

        int chosenOption = JOptionPane.showOptionDialog(null, str, "Manage Donors", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (chosenOption) {
            case 0:
                checkDonor();
                break;
            case 1:
                searchDonor();
                break;
            case 2:
                addDonor(donorQueue);
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
     * Menu for searchign for a donor
     * @author Marzell
     */
    public static void searchDonor() {
    }

    /**
     * Menu for adding new donor
     * @author Shah
     * @author Isya
     */
    public static void addDonor(Queue donorQueue) {
        String ic = JOptionPane.showInputDialog(null, "Enter Donor's IC");
        String name = JOptionPane.showInputDialog(null, "Enter Donor's Name");
        String contact = JOptionPane.showInputDialog(null, "Enter Donor's Contact");

        /* Blood Group */
        Object[] bloodG = { "A", "B","AB","O" };
        String str = "Please Choose Donor's Blood Group";

        int chosenOption = JOptionPane.showOptionDialog(null, str, "Donor's Blood Group", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, bloodG, bloodG[0]);

        String bloodGroup = null;

        switch (chosenOption) {
            case 0: bloodGroup = "A"; break;
            case 1: bloodGroup = "B"; break;
            case 2: bloodGroup = "AB"; break;
            case 3: bloodGroup = "O"; break;
        }
        /* Blood Group */

        /* Rh Group */
        Object[] rh = { "+", "-" };
        str = "Please Choose Donor's Blood Rh";

        chosenOption = JOptionPane.showOptionDialog(null, str, "Donor's Blood Group", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rh, rh[0]);

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
    }
}