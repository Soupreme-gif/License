package edu.wctc;

public class WisconsinFormatter implements DriversLicenseFormatter{

    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {

        String birthYear = String.valueOf(driversLicense.getYY());

        char tensPlace = birthYear.charAt(2);
        char onesPlace = birthYear.charAt(3);

        return String.format(driversLicense.getSSSS() + "-%03d%c" + "-%c%03d" + "-%02d",
                driversLicense.getFFF(),
                tensPlace,
                onesPlace,
                driversLicense.getDDD(),
                driversLicense.getNN());
    }

}
