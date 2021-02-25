package edu.wctc;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String lastnameHolder = "";
        int firstNameUtilityCode;
        int monthDayGenderUtilityCode;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Last name: ");
        String lastName = keyboard.nextLine();

        System.out.print("First name: ");
        String firstname = keyboard.nextLine().toUpperCase(Locale.ROOT);

        System.out.print("Middle Initial: ");
        String middleInitial = keyboard.nextLine().toUpperCase();

        System.out.print("Month of birth (1-12): ");
        int month = Integer.parseInt(keyboard.nextLine());

        System.out.print("Day of birth (1-31): ");
        int day = Integer.parseInt(keyboard.nextLine());

        System.out.print("Year of birth (YYYY): ");
        int year = Integer.parseInt(keyboard.nextLine());

        System.out.print("Gender: (M/F): ");
        char genderCode = keyboard.nextLine().toUpperCase().charAt(0);

        try{

            DriversLicense driversLicense = new DriversLicense();
            LastNameUtility lastNameCode = new LastNameUtility();
            FirstNameUtility firstAndMiddleCode = new FirstNameUtility();
            MonthDayGenderUtility monthDayGenderCode = new MonthDayGenderUtility();
            WisconsinFormatter wisconsinFormat = new WisconsinFormatter();
            FloridaFormatter floridaFormat = new FloridaFormatter();

            driversLicense.setYY(year);

            driversLicense.setNN(0);

           lastnameHolder = lastNameCode.encodeLastName(lastName);
           driversLicense.setSSSS(lastnameHolder);

           firstNameUtilityCode = firstAndMiddleCode.encodeFirstName(firstname, middleInitial);
           driversLicense.setFFF(firstNameUtilityCode);

           monthDayGenderUtilityCode = monthDayGenderCode.encodeMonthDayGender(year, month, day, genderCode);
           driversLicense.setDDD(monthDayGenderUtilityCode);

           System.out.println(wisconsinFormat.formatLicenseNumber(driversLicense));
           System.out.println(floridaFormat.formatLicenseNumber(driversLicense));

        } catch (MissingNameException | UnknownGenderCodeException | InvalidBirthdayException e)
        {

            e.getMessage();
            System.out.println("Program has now exited");
            System.exit(0);

        }

    }

}
