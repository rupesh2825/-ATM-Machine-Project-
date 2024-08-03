package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'##,##,###.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                data.put(9876543, 9876);
                data.put(898989, 1890);
                data.put(89878898, 1891);

                System.out.println("Welcome to the ATM Project!");

                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\nInvalid Character(s). Only numbers.\n");
                menuInput.next();  // Clear the invalid input
                continue;
            }

            boolean validLogin = false;
            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    validLogin = true;
                    getAccountType();
                    break;
                }
            }

            if (!validLogin) {
                System.out.println("\nWrong Customer Number or Pin Number.\n");
            }
        } while (x == 1);
    }

    public void getAccountType() {
        int selection;
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this ATM, bye.");
                break;

            default:
                System.out.println("\nInvalid Choice.\n");
                getAccountType();
                break;
        }
    }

    public void getChecking() {
        int selection;
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;

            default:
                System.out.println("\nInvalid Choice.\n");
                getChecking();
                break;
        }
    }

    public void getSaving() {
        int selection;
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;

            default:
                System.out.println("\nInvalid Choice.\n");
                getSaving();
                break;
        }
    }
}
