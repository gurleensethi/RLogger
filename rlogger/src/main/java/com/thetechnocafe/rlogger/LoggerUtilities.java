package com.thetechnocafe.rlogger;

import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gurleen on 5/5/17.
 */

public class LoggerUtilities {

    /**
     * Return the json string if able to parse,
     * else show error and return the original message
     */
    public static String getJsonStringOrPrintError(String tag, String message) {
        try {
            JSONObject jsonObject = new JSONObject(message);
            String jsonString = jsonObject.toString(RLoggerConstants.JSON_INDENT_VALUE);
            return jsonString;
        } catch (Exception e) {
            Exception exception = new Exception("Bad json format from '" + tag + "'");
            Log.e(tag, message, exception);
            return message;
        }
    }

    public static String getShoutString(String message) {
        int messageLength = message.length();
        ArrayList<String> listOfStrings = new ArrayList<>();

        //Loop over the string and add to list
        int startPosition = 0;
        int largestSubstringLength = 0;
        for (int i = 0; i < messageLength; i++) {
            if (message.charAt(i) == '\n') {
                //Get the string to add
                String string = message.substring(startPosition, i);
                listOfStrings.add(string);

                //Update the largest length and start position
                startPosition = i + 1;
                if (string.length() >= largestSubstringLength) {
                    largestSubstringLength = string.length();
                }
            } else if (i == (messageLength - 1)) {
                String string = message.substring(startPosition);
                listOfStrings.add(string);

                //Update the largest length
                if (string.length() >= largestSubstringLength) {
                    largestSubstringLength = string.length();
                }
            }
        }

        int fullWidth = largestSubstringLength + 20;
        if (fullWidth % 2 != 0) {
            fullWidth++;
        }

        //Set up the strings for formatting the message
        String spaceString = "         ";
        String shoutString = "";
        for (int i = 0; i < fullWidth; i++) {
            shoutString += "#";
        }

        //Form the data string
        String dataString = "";
        for (int i = 0; i < listOfStrings.size(); i++) {
            String messageString = listOfStrings.get(i);
            int spaceToAddOnOneSide = ((fullWidth - messageString.length()) / 2) - 1;

            String spaceOnOneSide = "";
            for (int count = 0; count < spaceToAddOnOneSide; count++) {
                spaceOnOneSide += " ";
            }

            //Set the data string
            dataString += "#" + spaceOnOneSide + messageString;

            //Check if the length of string is not odd
            //if odd then add once extra space to keep the formatting right
            if (messageString.length() % 2 != 0) {
                dataString += spaceOnOneSide + " " + "#";
            } else {
                dataString += spaceOnOneSide + "#";
            }

            if (i != (listOfStrings.size() - 1)) {
                dataString += '\n';
            }
        }

        return shoutString + "\n" + dataString + "\n" + shoutString;
    }
}
