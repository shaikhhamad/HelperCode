package com.hamadshaikh.helpercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hamadshaikh.helpercodelib.DateParser;
import com.hamadshaikh.helpercodelib.Extractor.DateDifferenceExtractor;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DateParser dateParser=new DateParser();
        Log.i("Current Date: ",""+dateParser.getCalendar(new Date()).get(Calendar.DATE));
        Log.i("format Date: ",""+dateParser.FormatDateIntoSpecificFormat(new Date(),"MM/dd/yyyy HH:mm:ss"));
        Date date=null;
        try {
            date=dateParser.parseStringToDate("08/26/2017 08:48:10","MM/dd/yyyy HH:mm:ss");
            Log.i("Parsed Date ",""+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateDifferenceExtractor dateDifferenceExtractor=dateParser.getDateDifference( new Date(),
               date);
        Log.i("Date difference: ",dateDifferenceExtractor.getDays()+"days,"+dateDifferenceExtractor.getHours()
                +"hours, "+dateDifferenceExtractor.getMinutes()+"minutes, "+dateDifferenceExtractor.getSeconds()+"seconds");



    }
}
