package com.hamadshaikh.helpercode;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hamadshaikh.helpercodelib.DateParser;
import com.hamadshaikh.helpercodelib.Extractor.DateDifferenceExtractor;
import com.hamadshaikh.helpercodelib.NetworkUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
        new AsyncTask<String,String,String>(){

            @Override
            protected String doInBackground(String... params) {
                // Perform your network operation.
                // Get JSON or XML string from the server.
                // Store in a local variable (say response) and return.
                Log.i("internet","returned :" +new NetworkUtils().isDomainUp("www.mycart.pk"));
                return "";
            }

            protected void onPostExecute(String results){
                // Response returned by doInBackGround() will be received
                // by onPostExecute(String results).
                // Now manipulate your jason/xml String(results).
            }

        }.execute();

    }
}
