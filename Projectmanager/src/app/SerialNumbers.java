package app;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Skrevet af Nicklas
class SerialNumbers{ 

    GregorianCalendar gcal = new GregorianCalendar();
    private static int counter = 1;


    // Creates a serialnumber for a project
    private String createProjectSN() {
        int year;
        String counter1 = "", SN;
        year = gcal.get(Calendar.YEAR);

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

        SN = year + "-" + counter1;
        counter++;
        return SN;
    }

    // Returns the found project S/N
    public String getProjectSN(){
        return createProjectSN();
    }
}