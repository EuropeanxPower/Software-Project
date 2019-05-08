package app;

import java.util.Calendar;
import java.util.GregorianCalendar;

class SerialNumbers{

    GregorianCalendar gcal = new GregorianCalendar();
    private String SN;
    private int counter = 1;


    private String findProjectSN(){
        int year, month;
        String counter1 = "", month1;
        year = gcal.get(Calendar.YEAR)%100;
        month = gcal.get(Calendar.MONTH)-1;

        if(month < 10){
            month1 = "0"+month;
        } else {
            month1 = ""+month;
        }
        if (counter < 10){
            counter1 = "000"+counter;
        } else if (counter < 100){
            counter1 = "00"+counter;
        } else if (counter < 1000){
            counter1 = "0"+counter;
        } else if (counter < 10000){
            counter1 = ""+counter;
        } else {
            counter = 1;
        }
        SN = year+""+month1+"-"+counter1;
        updateCounter();
        return SN;
    }

    /*private void resetCounter(){
        int nextMonth = gcal.get(Calendar.MONTH)-1;
        if (nextMonth != month){
            month = nextMonth;
            counter = 1;
        }
    }*/

    private void updateCounter(){
        counter++;
    }

    public String getProjectSN(){
        return findProjectSN();
    }

    




}