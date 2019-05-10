package app;

import java.util.Calendar;
import java.util.GregorianCalendar;

class SerialNumbers{

    GregorianCalendar gcal = new GregorianCalendar();
    private static int counter = 1;

    private String createProjectSN() {
        int year, month;
        String counter1 = "", month1, SN;
        year = gcal.get(Calendar.YEAR) % 100;
        month = gcal.get(Calendar.MONTH) ;

        if (month < 10) {
            month1 = "0" + month;
        } else {
            month1 = "" + month;
        }
        if (counter < 10) {
            counter1 = "000" + counter;
        } else if (counter < 100) {
            counter1 = "00" + counter;
        } else if (counter < 1000) {
            counter1 = "0" + counter;
        } else if (counter < 10000) {
            counter1 = "" + counter;
        } else{
            counter = 1;
        }

        SN = year + "" + month1 + "-" + counter1;
        counter++;
        return SN;
    }

    public String getProjectSN(){
        return createProjectSN();
    }

    




}