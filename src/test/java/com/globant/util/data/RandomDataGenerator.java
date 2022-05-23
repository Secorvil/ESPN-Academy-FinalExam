package com.globant.util.data;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class RandomDataGenerator {

    @DataProvider(name = "randomUserInfo")
    public Object[][] generateUserInfo() {
        return new Object[][] {{generateRandomAlphabeticalString(8), generateRandomNumericalString()}};
    }

    /**
     * @author Sebastián Correa
     *
     * Given an int, this method generates a random alphabetical String, which size is the same as the specified number.
     * Note that the method uses only ASCII characters of lower case letters.
     * @param stringLength Desired alphabetical string length
     * @return Random alphabetical string
     */
    public String generateRandomAlphabeticalString(int stringLength) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        for(int i = 0; i < stringLength; i++){
            randomString.append((char)(random.nextInt(122 - 97) + 97));
        }
        return randomString.toString();
    }

    /**
     * @author Sebastián Correa
     *
     * This method generates a random number of 8 digits.
     * @return Random 4 digit number as String
     */
    public String generateRandomNumericalString() {
        Random random = new Random();
        return "" + (random.nextInt(9999 - 1111) + 1111);
    }
}
