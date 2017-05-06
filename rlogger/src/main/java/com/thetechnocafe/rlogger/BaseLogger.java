package com.thetechnocafe.rlogger;

/**
 * Created by gurleen on 5/5/17.
 */

public interface BaseLogger {
    void d(String tag, String message);

    void e(String tag, String message) ;

    void v(String tag, String message) ;

    void i(String tag, String message);

    void w(String tag, String message);

    void wtf(String tag, String message) ;
}
