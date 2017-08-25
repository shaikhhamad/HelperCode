package com.hamadshaikh.helpercodelib.Extractor;

import java.util.Date;

/**
 * Created by Fahad Sheikh on 8/25/2017.
 */

public class DateDifferenceExtractor {
    long days,hours,minutes,seconds;
    public DateDifferenceExtractor(long elapsedDays, long elapsedHours, long elapsedMinutes, long elapsedSeconds) {
        days=elapsedDays;
        hours=elapsedHours;
        minutes=elapsedMinutes;
        seconds=elapsedSeconds;
    }


    public long getDays() {
        return days;
    }

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }
}
