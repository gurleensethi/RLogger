package com.thetechnocafe.rlogger;

/**
 * Created by gurleen on 5/5/17.
 */

public class RLoggerBuilder {
    private BaseLogger mBaseLogger;
    private String logMessage = "Please provide a logMessage";
    private String logTag = "RLoggerBuilder";
    private LogType logtype = LogType.D;
    private boolean isShoutingEnabled = false;
    private boolean isJson = false;

    public RLoggerBuilder() {
        mBaseLogger = new AndroidLogger();
    }

    public RLoggerBuilder message(String message) {
        this.logMessage = message;
        return this;
    }

    public RLoggerBuilder tag(String tag) {
        this.logTag = tag;
        return this;
    }

    public RLoggerBuilder tag(Object obj) {
        this.logTag = obj.getClass().getSimpleName();
        return this;
    }

    public RLoggerBuilder messageAndTag(String tag, String message) {
        this.logTag = tag;
        this.logMessage = message;
        return this;
    }

    public RLoggerBuilder messageAndTag(Object obj, String message) {
        this.logTag = obj.getClass().getSimpleName();
        this.logMessage = message;
        return this;
    }

    public RLoggerBuilder setLogType(LogType logType) {
        this.logtype = logType;
        return this;
    }

    public RLoggerBuilder shout() {
        this.isShoutingEnabled = true;
        this.isJson = false;
        return this;
    }

    public RLoggerBuilder json() {
        this.isJson = true;
        this.isShoutingEnabled = false;
        return this;
    }

    /**
     * Check all the conditions and log the message appropriately
     * Steps :
     * - Check if message is json type, if yes then convert it to json
     * - Check if shout is enabled, get the shout string
     * - Check the log type and log accordingly
     */
    public void log() {
        //Check if json
        if (isJson) {
            logMessage = LoggerUtilities.getJsonStringOrPrintError(logTag, logMessage);
        }

        //Check if shout enabled
        if (isShoutingEnabled) {
            logMessage = LoggerUtilities.getShoutString(logMessage);
        }

        //Check the log type and log accordingly
        switch (logtype) {
            case D: {
                mBaseLogger.d(logTag, logMessage);
                break;
            }
            case E: {
                mBaseLogger.e(logTag, logMessage);
                break;
            }
            case I: {
                mBaseLogger.i(logTag, logMessage);
                break;
            }
            case V: {
                mBaseLogger.v(logTag, logMessage);
                break;
            }
            case W: {
                mBaseLogger.w(logTag, logMessage);
                break;
            }
            case WTF: {
                mBaseLogger.wtf(logTag, logMessage);
                break;
            }
        }
    }
}
