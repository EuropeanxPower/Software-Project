package app;

import java.util.Calendar;
import java.util.GregorianCalendar;

class SerialNumbers{

    private Model model;
    private int projectSN;



    //Constructor
    public SerialNumbers(Model model){
        this.model = model;

    }

    public void setprojectSN(int SN){
        this.projectSN = SN;
    }

    public int getprojectSN(){
        return projectSN;
    }

    public String findProjectSN(){
        int year, month, counter = 1;
        String counter1, month1;
        GregorianCalendar gcal = new GregorianCalendar();

        year = gcal.get(Calendar.YEAR)%100;
        month = gcal.get(Calendar.MONTH);

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
        } else {
            counter1 = ""+counter;
        }
        String SN = year +""+month1 + "-"+counter1;


        return SN;
    }

    




}