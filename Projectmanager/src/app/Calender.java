package app;

import java.util.GregorianCalendar;
import java.util.Calendar;


public class Calender{

    public GregorianCalendar createCalendar(int year, int month, int day){
        GregorianCalendar calendar = new GregorianCalendar(0,0,0);
        calendar.set(GregorianCalendar.YEAR, year);
        calendar.set(GregorianCalendar.MONTH, month);
        calendar.set(GregorianCalendar.DAY_OF_MONTH, day);

        return calendar;
    }
}
