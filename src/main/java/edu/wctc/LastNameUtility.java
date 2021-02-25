package edu.wctc;

import org.apache.commons.codec.language.Soundex;

public class LastNameUtility {

    private Soundex soundex = new Soundex();

    public String encodeLastName(String lastname) throws MissingNameException
    {
        if(lastname.equals(""))
        {

            throw new MissingNameException(lastname);

        }
        else {

            return soundex.encode(lastname);

        }

    }

}
