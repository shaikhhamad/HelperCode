package com.hamadshaikh.helpercodelib;

import com.hamadshaikh.helpercodelib.Extractor.DateDifferenceExtractor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Fahad Sheikh on 8/25/2017.
 */

public class DateParser {

    public Date parseStringToDate(String dateForParsing, String formatToParseIn) throws ParseException {
        String string = dateForParsing;
        DateFormat dateFormat = new SimpleDateFormat(formatToParseIn, Locale.ENGLISH);
        Date date = dateFormat.parse(string);
        return date;
    }
    public String FormatDateIntoSpecificFormat(Date date, String formatToParseIn) {
        Date date1 = date;
        DateFormat dateFormat = new SimpleDateFormat(formatToParseIn, Locale.ENGLISH);
        return dateFormat.format(date1);
    }

    public Calendar getCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    public DateDifferenceExtractor getDateDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();
        //1 minute = 60 seconds
        //1 hour = 60 x 60 = 3600
        //1 day = 3600 x 24 = 86400
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;
//        String difference="%d days, %d hours, %d minutes, %d seconds%n",
//                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds;
//        System.out.printf(
//                "%d days, %d hours, %d minutes, %d seconds%n",
//                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
        return new DateDifferenceExtractor(elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
    }

}
