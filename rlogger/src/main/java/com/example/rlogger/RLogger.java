package com.example.rlogger;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by gurleen on 4/5/17.
 */

public class RLogger {
    private static AndroidLogger mAndroidLogger = new AndroidLogger();

    public static RLogger d(String tag, String message) {
        mAndroidLogger.d(tag, message);
        return new RLogger();
    }

    public static RLogger e(String tag, String message) {
        mAndroidLogger.e(tag, message);
        return new RLogger();
    }

    public static RLogger v(String tag, String message) {
        mAndroidLogger.v(tag, message);
        return new RLogger();
    }

    public static RLogger i(String tag, String message) {
        mAndroidLogger.i(tag, message);
        return new RLogger();
    }

    public static RLogger w(String tag, String message) {
        mAndroidLogger.w(tag, message);
        return new RLogger();
    }

    public static RLogger wtf(String tag, String message) {
        mAndroidLogger.wtf(tag, message);
        return new RLogger();
    }

    //Pretty print the json
    public static void json(String tag, String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String jsonString = jsonObject.toString(RLoggerConstants.JSON_INDENT_VALUE);
            Log.d(tag, jsonString);
        } catch (Exception e) {
            Exception exception = new Exception("Bad json format from '" + tag + "'");
            Log.e(tag, json, exception);
        }
    }

    public static RLogger d(Object obj, String message) {
        d(obj.getClass().getSimpleName(), message);
        return new RLogger();
    }

    public static RLogger e(Object obj, String message) {
        e(obj.getClass().getSimpleName(), message);
        return new RLogger();
    }

    public static RLogger v(Object obj, String message) {
        v(obj.getClass().getSimpleName(), message);
        return new RLogger();
    }

    public static RLogger i(Object obj, String message) {
        i(obj.getClass().getSimpleName(), message);
        return new RLogger();
    }

    public static RLogger w(Object obj, String message) {
        w(obj.getClass().getSimpleName(), message);
        return new RLogger();
    }

    public static RLogger wtf(Object obj, String message) {
        wtf(obj.getClass().getSimpleName(), message);
        return new RLogger();
    }

    public static void json(Object obj, String json) {
        json(obj.getClass().getSimpleName(), json);
    }


    public static void setJsonIndentValue(int value) {
        RLoggerConstants.JSON_INDENT_VALUE = value;
    }

    public static int getJsonIndentValue() {
        return RLoggerConstants.JSON_INDENT_VALUE;
    }

    /**
     * Print a box of character with the message inside it
     * Default character = '#'
     */
    public static void shout(final String tag, final String message) {
        String shoutString = LoggerUtilities.getShoutString(message);
        d(tag, shoutString);
    }

    public static void shout(Object obj, String message) {
        shout(obj.getClass().getSimpleName(), message);
    }

    public static RLoggerBuilder builder() {
        return new RLoggerBuilder();
    }
}
