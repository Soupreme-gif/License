package edu.wctc;

public class FloridaFormatter implements DriversLicenseFormatter{

    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {

        return String.format(driversLicense.getSSSS() +"-%03d" + "-%02d" + "-%03d" + "%01d",
                driversLicense.getFFF(),
                driversLicense.getYY(),
                driversLicense.getDDD(),
                driversLicense.getNN());
    }

}
