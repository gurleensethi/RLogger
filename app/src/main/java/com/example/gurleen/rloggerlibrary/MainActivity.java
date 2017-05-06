package com.example.gurleen.rloggerlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rlogger.LogType;
import com.example.rlogger.RLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RLogger.e(this, "Error");
        RLogger.d(this, "Debug");
        RLogger.i(this, "Info");
        RLogger.w(this, "W");
        RLogger.wtf(this, "WTF");
        RLogger.shout(this, "Shouting this message\nThank You");

        RLogger.setJsonIndentValue(4);
        RLogger.json(this, "{akljf:sg,test:test,testing:ok,indent:{ok:fuckof}}");

        RLogger.builder()
                .messageAndTag(this, "{test:test,testing:{ok:ok, fuck:56},testok:testing, ok:12}")
                .setLogType(LogType.E)
                .json()
                .log();
    }
}
