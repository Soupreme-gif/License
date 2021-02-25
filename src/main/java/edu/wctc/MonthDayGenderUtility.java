package edu.wctc;

import java.time.DateTimeException;
import java.time.LocalDate;

public class MonthDayGenderUtility {

    private final int MOD_MALE = 0;
    private final int MOD_FEMALE = 500;
    private final char CODE_MALE = 'M';
    private final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode) throws UnknownGenderCodeException, InvalidBirthdayException {

        int genderCodeModifier = 0;

        if(genderCode == CODE_MALE)
        {

            genderCodeModifier = MOD_MALE;

        }
        else if(genderCode == CODE_FEMALE)
        {

            genderCodeModifier = MOD_FEMALE;

        }
        else{

            throw new UnknownGenderCodeException(genderCode);

        }

        try {
            LocalDate inputtedDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e)
        {

            throw new InvalidBirthdayException(year, month, day);

        }



       return  (month - 1) * 40 + day + genderCodeModifier;

    }


}
